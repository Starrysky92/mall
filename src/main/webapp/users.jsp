<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div id="user"></div>
<div id="window_adduser" style="width: 400px;height: 300px;display: flex;justify-content: center;align-items: center" class="easyui-window" data-options="closed:true,modal:true" >

    <form id="form_adduser" action="adduser.do" >
        <input name="id" type="hidden" id="id" value="0">
        <div style="margin-bottom: 20px;">账户:<input name="name" type="text" class="easyui-textbox" style="width: 300px;height: 30px;" placeholder="请输入账户"></div>
        <div style="margin-bottom: 20px;">密码:<input name="pwd" type="password" class="easyui-textbox" style="width: 300px;height: 30px" placeholder="请输入密码"></div>
        <div style="text-align: center;">
            <a href="javascript:save()" class="easyui-linkbutton btn-block">保存</a>
        </div>
    </form>
    <div/>
    <div id="window_permission" class="easyui-window" style="width: 400px;height: 400px" data-options="closed:true,modal:true">
        <div id="tree_res"></div>
        <button onclick="userRes_sava()" class="btn btn-success btn-block" style="margin-top: 10px">保存</button>
    </div>
    <script>
        function show() {
            $("#user").datagrid({
                //开启分页
                pagination:true,
                title:"用户管理",
               
                columns:[[
                    {field:"id",checkbox:true,width:100,},
                    {field:"name",title:"账户",width:100},
                    {field:"pwd",title:"密码",width:100}
                ]],
                toolbar:[
                    <shiro:hasPermission name="user:create">
                    {text:"添加",iconCls:"icon-add",handler:function () {openadd();}},
                    </shiro:hasPermission>
                    <shiro:hasPermission name="user:edit">
                    {text:"修改",iconCls:"icon-edit",handler:function () {update();}},
                    </shiro:hasPermission>
                    <shiro:hasPermission name="user:delete">
                    {text:"删除",iconCls:"icon-remove",handler:function () {del();}},
                    </shiro:hasPermission>
                    <shiro:hasPermission name="user:fenp">
                    {text:"分配权限",iconCls:"icon-search",handler:function () {fenpei();}}
                    </shiro:hasPermission>
                ]
            });
            paging(1,5);
        }
        $(show);
        function fenpei() {
            var user=$("#user").datagrid("getSelected");
            if(user.length>1){
                $.messager.alert("系统提示","请选择一行");
                return;
            }
            $("#tree_res").treegrid({
                idField:"id",
                treeField:"text",
                singleSelect: false,
                columns:[[
                    {field:"id",title:"id",checkbox:true,width:50},
                    {field:"text",title:"名称",width:140},
                    {field:"url",title:"资源路径",width:100}
                ]]
            });
            $.get("findAllResForpem.do",function (d) {
                var data=d.replace(/\"_parentId\":0/g,"\"root\":0");
                var data2="{\"rows\":"+data+"}";
                var x=JSON.parse(data2);
                $("#tree_res").treegrid("loadData",x);
                $("#window_permission").window("open");
            });
        }
        function userRes_sava() {
            var data = $("#tree_res").treegrid("getSelections");
            var user=$("#user").datagrid("getSelected");
            if(data.length==0){
                $.messager.alert("提示", "请选择要添加的权限！", "info");
                return;
            }else {
                var ids=new Array();
                ids[0]=user.id;
                for (i = 0; i < data.length; i++) {
                    ids[i+1]=data[i].id
                }
                var json=JSON.stringify(ids);
                $.ajax({
                    url: "adduserRes.do",//服务接口地址
                    method: "post",       //请求的方法
                    data: json,           //提交的数据
                    contentType: "application/json",
                    success: function (d) {
                        $.messager.alert("系统提示",d);
                        $("#window_permission").window("close")
                    }
                })
            }
        }

        function paging(page,size) {
            $.get("findAllUser.do",{page:page,size:size},function (data) {
                var parse = JSON.parse(data);
                //填充数据
                $("#user").datagrid("loadData",parse);
                //获取分页组件
                var pager=$("#user").datagrid("getPager");
                var num="";
               $.ajax({
                   url:"getusertotal.do",
                   async:false,
                   success:function (data) {
                       num=data;
                   }
               });
                pager.pagination({
                    total:num,
                    pageSize:size,
                    pageNumber:page,
                    pageList:[5,10,20,30],
                    //翻页时调用
                    onSelectPage:function (page,size) {
                        paging(page,size);
                    }
                });
            });
        }
        function openadd() {
            $("#form_adduser").form("clear");
            $("#id").val("0")
            $("#window_adduser").window("open")
        }
        function save() {
            $("#form_adduser").form("submit",{
                success:function (d) {
                    //刷新
                   // $("#first").datagrid("reload");
                     paging(1,2);
                    //关闭
                    $("#window_adduser").window("close")
                }
            })
        }
        function del() {
            //返回选中多行
            var data = $("#user").datagrid("getSelections")
            //判断是否选中行
            if (data.length == 0) {
                $.messager.alert("提示", "请选择要删除的行！", "info");
                return;
            } else {
                var ids =new Array() ;
                //批量获取选中行的评估模板ID
                for (i = 0; i < data.length; i++) {
                    ids[i]=data[i].id
                }
                //包装为json
                var json=JSON.stringify(ids);
                if(confirm("是否删除所选行")) {
                    $.ajax({
                        url: "deluser.do",//服务接口地址
                        method: "post",       //请求的方法
                        data: json,           //提交的数据
                        contentType: "application/json",
                        success: function (d) {
                            //刷新
                           // $("#first").datagrid("reload");
                            paging(1,5);
                        }
                    });
                }
            }
        }
        function update() {
            var row = $('#user').datagrid('getSelected');
            if (row == null)
            {
                $.messager.alert("系统提示", "请选择您要修改的数据！");
                return;
            }
            $("#window_adduser").window("open")
            if(row){
                $("#window_adduser").form("load",{
                    id:row.id,
                    name:row.name,
                    pwd:row.pwd
                })
            }
        }
    </script>

