<html>
<head>
    <title>测试页面</title>
    <script src="${request.contextPath}/static/js/jquery-1.11.1.min.js"></script>
    <link href="${request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        .pageDetail {
            display: none;
        }

        .show {
            display: table-row;
        }
    </style>
    <script>
        $(function () {
            $('#list').click(function () {
                $('.pageDetail').toggleClass('show');
            });
        });

    </script>
</head>
<body>
 welcome............ ${testStr}
 
  <table class="gridtable" style="width:100%;">
            <thead>
            <tr>
                <th>ID</th>
                <th>名称</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
                <#list listInfo as item>
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.state}</td>
                    <td style="text-align:center;">[<a
                            href="${request.contextPath}/countries/view/${item.id}">修改</a>] -
                        [<a href="${request.contextPath}/demo/delete/${item.id}">删除</a>]
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
</body>
</html>