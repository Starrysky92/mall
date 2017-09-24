<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="commodity_datagrid"></div>
<div id="window_addcommodity" class="easyui-window" data-options="closed:true,modal:true" style="width: 80%;height: 600px;padding:30px 30px">
    <form id="form_commodity" method="post" action="addcommodity.do">
        <input type="hidden" name="id" id="commoid" value="0">
        <input type="hidden" id="commo_content" name="content">
        <div style="margin-bottom: 20px">
            <input name="name" class="easyui-textbox" data-options="prompt:'请输入名称'" style="width: 100%;height: 30px">
        </div>
        <div>
            <div style="margin-bottom: 20px">
                <input name="categoryid" class="easyui-combotree" style="width: 100%;height: 30px;" data-options="url:'findAllCategory2.do',promt:'请选择类别'"/>
            </div>
        </div>
    </form>
    <textarea name="commodity_content" class="ckeditor" style="width: 100%;height: 400px" rows="3" cols="3" ></textarea>
    <div>
        <button class="btn btn-success btn-block" onclick="commodaity_sava()">保存</button>
    </div>
</div>
<div id="uploadimgs" class="easyui-window" data-options="closed:true,modal:true">
    <div style="width: 400px;height: 300px;margin: 10px 100px">
        <form id="form_imges" method="post" enctype="multipart/form-data" multiple="multiple">
            <input type="file" name="file" multiple="multiple">
        </form>
        <button onclick="saveimges()" class="btn btn-success btn-block">上传</button>
    </div>
</div>
    <script>
        function comm_init() {
            $("#commodity_datagrid").datagrid({
                //开启分页
                pagination:true,
                title:"商品管理",
                columns:[[
                    {field:"id",checkbox:true},
                    {field:"name",title:"名称",width:100},
                    {field:"categoryname",title:"类别",width:100}
                ]],
                toolbar:[
                    {text:"添加",iconCls:"icon-add",handler:function(){addcommodity();}},
                    {text:"删除",iconCls:"icon-edit",handler:function(){delcommodity();}},
                    {text:"修改",iconCls:"icon-edit",handler:function () {updatecommo();}},
                    {text:"上传图片",iconCls:"icon-save",handler:function(){uploadimgs();}},
                    {text:"上架",iconCls:"icon-search",handler:function(){uploadCommo();}}
                ]
            });
            //初始化编辑器
            CKEDITOR.replace("commodity_content");
            commopaging(1,2)
        }
       $(comm_init);
        function commopaging(page,size) {
            $.get("findallcommodity.do",{page:page,size:size},function (data) {
                var parse = JSON.parse(data);
                //填充数据
                $("#commodity_datagrid").datagrid("loadData",parse);
                //获取分页组件
                var pager=$("#commodity_datagrid").datagrid("getPager");
                var num="";
                $.ajax({
                    url:"getcommototal.do",
                    async:false,
                    success:function (data) {
                        num=data;
                    }
                });
                pager.pagination({
                    total:num,
                    pageSize:size,
                    pageNumber:page,
                    pageList:[1,2,3],
                    //翻页时调用
                    onSelectPage:function (page,size) {
                        commopaging(page,size);
                    }
                });
            });
        }
        function addcommodity() {
            $("#window_addcommodity").form("clear")
            $("#commoid").val("0")
            $("#window_addcommodity").window("open");
        }
        function commodaity_sava() {
            var data = CKEDITOR.instances.commodity_content.getData();
            $("#commo_content").val(data);
            $("#form_commodity").form("submit",{
                success:function (b) {
                    commopaging(1,2)
                    $("#window_addcommodity").window("close")
            }
            })
        }
        function uploadimgs() {
            $("#uploadimgs").window("open")
        }
        function saveimges() {
            var data = new FormData(document.getElementById("form_imges"));
            var commodity = $("#commodity_datagrid").datagrid("getSelected");
            //给图片添加商品id
            data.append("commodityId",commodity.id);
            $.ajax({
                url:"addimges.do",
                method:"post",
                data:data,
                contentType:false,
                processData:false,
                success:function (b) {
                    $("#uploadimgs").window("close")
                    $.messager.alert("系统提示",b)
                }
            })

        }
        function delcommodity() {
            //返回选中多行
            var data = $("#commodity_datagrid").datagrid("getSelections")
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
                        url: "delcommodity.do",//服务接口地址
                        method: "post",       //请求的方法
                        data: json,           //提交的数据
                        contentType: "application/json",
                        success: function (d) {
                            $.messager.alert("系统提示",d);
                            commopaging(1,2)
                        }
                    });
                }
            }
        }
        function updatecommo() {
            var row = $('#commodity_datagrid').datagrid('getSelected');
            if (row == null)
            {
                $.messager.alert("系统提示", "请选择您要修改的数据！");
                return;
            }
            $("#window_addcommodity").window("open")
            if(row){
                $("#window_addcommodity").form("load",{
                    name:row.name,
                })
            }
        }
        function uploadCommo() {
            var data = $("#commodity_datagrid").datagrid("getSelected");
            if (data.length == 0) {
                $.messager.alert("提示", "请选择上传的商品！");
                return;
            }
            alert(data.id)
            $.ajax({
                url:"http://localhost:8082/creatcomm.do?collback=creatHTML&sku="+data.id,
                method:"post",
                dataType:"jsonp"
            })
        }
        function creatHTML(d) {
            $.messager.alert("系统提示",d);
        }

    </script>




