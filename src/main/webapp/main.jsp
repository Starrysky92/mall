
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/icon.css"/>
    <link rel="stylesheet" href="css/easyui.css"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <script src="js/jquery.js"></script>
    <script type="text/javascript" src="js/easyui.js"></script>
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
    <script>
        function init(){
            $("#tree-left").tree({

                onClick:function(mode){
                    var is=$("#work").tabs("exists",mode.text);
                    if(is){
                       $("#work").tabs("select",mode.text);
                    }else {
                        $("#work").tabs("add",{
                            title:mode.text,
                            closable:true,
                            href:mode.url

                        });
                    }
            }
            });
        }
        $(init)
    </script>
</head>
<body>
    <div class="easyui-layout" style="width: 100%;height: 100%">
        <div style="display: flex;align-items: flex-end;justify-content: flex-end;width: 100%;height: 150px;background-color: #666" data-options="region:'north'">
            <a href="outLogin.do"><span style="color: white;font-size: 17px">退出</span></a>
        </div>
        <div id="tree" style="height: 100%;width: 20%" data-options="region:'west'">
            <div id="tree-left" class="easyui-tree" data-options="url:'findRes.do'">
            </div>
        </div>
        <div id="work" data-options="region:'center'" style="height: 100%;width: 100%" class="easyui-tabs"></div>
    </div>
</body>
</html>
