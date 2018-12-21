<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>教师信息管理</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="stylesheet" href="assets/css/app.css">
    <script>
        function myReset(account) {
            if (confirm('您确定要重置该账号的密码吗？'))
                window.location.href="/reset-teacher?admin_account=${admin.getAccount()}&account="+account;
        }

        function checkAll() {
            var all = document.getElementById('del'); //获取到点击全选的那个复选框的id
            var one = document.getElementsByName('check'); //获取到复选框的名称
            if (all.checked == true) { //因为获得的是数组，所以要循环 为每一个checked赋值
                for (var i = 0; i < one.length; i++) {
                    one[i].checked = true;
                }

            } else {
                for (var j = 0; j < one.length; j++) {
                    one[j].checked = false;
                }
            }
        }

        function checkdel() {

            var obj = document.getElementsByName("check");
            var check_val = "";
            var flag=false;
            for(var i = 0; i < obj.length; i++){
                if(obj[i].checked){
                    flag=true;
                    check_val+=obj[i].value+",";
                }
            }
            if (!flag) {
                alert("Please Choose Records To Delete ！");
                return false;
            } else {
                if (confirm("Are you Sure To Delete？")) {
                    window.location.href = "/delete-teacher?admin_account=${admin.getAccount()}&delid=" + check_val;
                }
            }
        }

        function confirmdel(numstring) {
            if (confirm("Are you Sure To Delete？")) {
                window.location.href = "/delete-a-teacher?admin_account=${admin.getAccount()}&delid=" + numstring;
            }
        }

        function modify(account,id)
        {
            window.location.href="/modify-teacher?admin_account=${admin.getAccount()}&tid="+id;
        }
    </script>
</head>

<body data-type="generalComponents">
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right" style="padding-left:1%">

    </div>
    <div class="am-topbar-brand">
        <h2>翻转课堂管理系统</h2>
    </div>
    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}">
        <span class="am-sr-only">导航切换</span>
        <span class="am-icon-bars"></span>
    </button>


    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="tpl-header-list-user-nick">${admin.getAccount()}</span>
                </a>
                <ul class="am-dropdown-content" id="topbat-content">
                    <li><a href="../../index.html"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>

            </li>
        </ul>
    </div>
</header>
<div class="tpl-page-container tpl-page-header-fixed">
    <div class="tpl-left-nav tpl-left-nav-hover" style="margin-top:1%">
        <div class="tpl-left-nav-list">
            <ul class="tpl-left-nav-menu">
                <li class="tpl-left-nav-item">
                    <!-- 打开状态 a 标签添加 active 即可   -->
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list active">
                        <i class="am-icon-table"></i>
                        <span>信息管理</span>
                        <!-- 列表打开状态的i标签添加 tpl-left-nav-more-ico-rotate 图表即90°旋转  -->
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display:block">
                        <li>
                            <!-- 打开状态 a 标签添加 active 即可   -->
                            <a href="/admin-teacher?admin_account=${admin.getAccount()}" class="active">
                                <i class="am-icon-angle-right"></i>
                                <span>管理教师信息</span>
                            </a>
                            <a href="/admin-student?admin_account=${admin.getAccount()}">
                                <i class="am-icon-angle-right"></i>
                                <span>管理学生信息</span>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="tpl-content-wrapper">
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption bold">
                    教师信息管理
                </div>
                <div class="tpl-portlet-input">
                    <div class="portlet-input input-small input-inline">
                        <div class="input-icon right">
                            <form action="/search-teacher" method="get">
                                <input  type="text" hidden="hidden" name="admin_account" value="${admin.getAccount()}">
                                <input type="text" class="form-control form-control-solid" name="info" placeholder="搜索...">
                                <input type="submit"   class="formSubmit" style="margin-top: -5rem;margin-left:10rem" value="">
                            </form>
                        </div>
                    </div>
                </div>

            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12 am-u-md-6">
                        <div class="am-btn-toolbar">
                            <div class="am-btn-group am-btn-group-xs">
                                <a type="button" class="am-btn am-btn-default am-btn-success" href="/create-teacher?admin_account=${admin.getAccount()}"><span class="am-icon-plus"></span> 新增</a>
                                <button type="button" class="am-btn am-btn-default am-btn-danger" onclick="checkdel()"><span class="am-icon-trash-o" ></span> 删除</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="am-g">
                    <div class="am-u-sm-12">
                        <form class="am-form">
                            <table class="am-table am-table-striped am-table-hover table-main">
                                <thead>
                                <tr>
                                    <th class="table-check"><input id="del" type="checkbox" class="tpl-table-fz-check" onclick="checkAll()"></th>
                                    <th class="table-title" >教工号</th>
                                    <th class="table-author am-hide-sm-only">姓名</th>
                                    <th class="table-date am-hide-sm-only">电子邮箱</th>
                                    <th class="table-set">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                               <#if teacherList?exists>
                                      <#list teacherList as item>
                                    <tr>
                                        <td class="table-check"><input type="checkbox" class="tpl-table-fz-check" name="check" value="${item.getAccount()}"></td>
                                        <td class="table-title" >${item.getAccount()?if_exists}</td>
                                        <td class="table-author am-hide-sm-only"><a href="#">${item.getTeacher_name()?if_exists}</a></td>
                                        <td class="table-date am-hide-sm-only">${item.getEmail()?if_exists}</td>
                                        <td>
                                            <div class="am-btn-toolbar">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary" ><a href="/modify-teacher?admin_account=${admin.getAccount()}&tid=${item.getId()}&account=${item.getAccount()}&name=${item.getTeacher_name()}&email=${item.getEmail()}">编辑</a></button>
                                                    <button class="am-btn am-btn-default am-btn-xs am-hide-sm-only" type="button" onclick="myReset('${item.getAccount()}')"> 重置</button>
                                                    <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" type="button" onclick="confirmdel('${item.getAccount()?if_exists}')"> 删除</button>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                      </#list>
                               </#if>
                                </tbody>
                            </table>
                            <div class="am-cf">
                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination">
                                        <li class="am-disabled">
                                            <a href="#">
                                                &lt;
                                            </a>
                                        </li>
                                        <li class="am-active"><a href="#">1</a></li>
                                        <li><a href="#">&gt;</a></li>
                                    </ul>
                                </div>
                            </div>
                            <hr>
                        </form>
                    </div>
                </div>
            </div>
            <div class="tpl-alert"></div>
        </div>
    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>
</html>