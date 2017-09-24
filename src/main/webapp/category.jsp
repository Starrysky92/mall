
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="cata_category"></div>
<div id="window_addcategory" class="easyui-window" data-options="closed:true,modal:true" style="width: 300px;height: 300px">
    <form id="form_addcategory" class="form-group">
        <div class="input-group">
            <span class="input-group-addon">类别名称</span>
            <input name="text" class="form-control" id="form_text">
        </div>
    </form>
    <div>
        <button onclick="category_sava()" class="btn btn-success btn-block">保存</button>
    </div>
</div>
<div id="update_addcategory" class="easyui-window" data-options="closed:true,modal:true" style="width: 300px;height: 300px">
    <form id="update_category" class="form-group">
        <div class="input-group">
            <span class="input-group-addon">类别名称</span>
            <input name="text" class="form-control" id="update_text">
        </div>
    </form>
    <div>
        <button onclick="category_update()" class="btn btn-success btn-block">保存</button>
    </div>
</div>
    <script>
        function init_dategory() {
            $("#cata_category").treegrid({
                title:"分类管理",
                idField:"id",
                treeField:"text",
                columns:[[
                    {field:"id",title:"id",width:100},
                    {field:"text",title:"名称",width:100}
                ]],
                toolbar:[
                    {text:"添加",iconCls:"icon-add",handler:function () {addcategory()}},
                    {text:"修改",iconCls:"icon-edit",handler:function () {updatecategory()}},
                    {text:"删除",iconCls:"icon-remove",handler:function () {delcategory()}}
                ]
            });
            cata_load()
        }
       function updatecategory() {
           $("#update_addcategory").window("open")

       }
       function category_update() {
           var text = $("#update_text").val();
           var category = $("#cata_category").treegrid("getSelected");
           $.post("updatecategory.do",{text:text,id:category.id},function (d) {
               $("#update_addcategory").window("close");
               cata_load()
               $.messager.alert("系统提示",d)
           })
       }
        $(init_dategory);
        function cata_load() {
            $.get("finAllCategory.do",function (data) {
                var s=data.replace(/pid/g,"_parentId");
                var y=s.replace(/\"_parentId\":0/g,"\"root\":0");
                var json = JSON.parse(y);
                $("#cata_category").treegrid("loadData",json);
            })
        }
        function addcategory() {
            $("#window_addcategory").window("open")
        }
        function category_sava() {
            var text = $("#form_text").val();
            var data = $("#cata_category").treegrid("getSelected");
            var id;
            if(data==null){
                id=0;
            }else {
                id=data.id
            }
            $.post("addcategory.do",{text:text,pid:id},function (d) {
                $("#window_addcategory").window("close");
                cata_load()
            })
        }
    </script>


