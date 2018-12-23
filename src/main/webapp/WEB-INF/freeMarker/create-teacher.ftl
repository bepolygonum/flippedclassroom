<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>创建教师用户</title>
    <link rel="icon" type="image/png" href="../../assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="../../assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="../../assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="../../assets/css/admin.css">
    <link rel="stylesheet" href="../../assets/css/app.css">
    <script>
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
                    <li><a href="../../index.index.ftl"><span class="am-icon-power-off"></span> 退出</a></li>
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
                            <a href="/admin-teacher?adminAccount=${admin.getAccount()}" class="active">
                                <i class="am-icon-angle-right"></i>
                                <span>管理教师信息</span>
                            </a>
                            <a href="/admin-student?adminAccount=${admin.getAccount()}">
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
                    创建教师用户
                </div>
            </div>
            <div class="tpl-block ">

                <div class="am-g tpl-amazeui-form">


                    <div class="am-u-sm-12 am-u-md-9">
                        <form class="am-form am-form-horizontal" action="/create-a-teacher" method="post" onsubmit="return test();" >
                            <div class="am-form-group">
                                <input value="${admin.getAccount()}" name="adminAccount" hidden="hidden">
                                <label for="user-account" class="am-u-sm-3 am-form-label">教工号 / ID</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="user-account" placeholder="教工号" name="userAccount">
                                </div>
                            </div>
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">姓名 / Name</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="user-name" placeholder="教师姓名" name="userName">
                                </div>
                            </div>
                            <div class="am-form-group">
                                <label for="user-password" class="am-u-sm-3 am-form-label">密码 / Password</label>
                                <div class="am-u-sm-9">
                                    <input type="password" id="user-password" placeholder="教师密码" name="userPassword">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="user-email" class="am-u-sm-3 am-form-label">电子邮件 / Email</label>
                                <div class="am-u-sm-9">
                                    <input type="email" id="user-email" placeholder="电子邮件" name="userEmail">
                                </div>
                            </div>
                            <div class="am-form-group">
                                <div class="am-u-sm-9">
                                </div>
                            </div>
                            <div class="am-form-group">
                                <div class="am-u-sm-9 am-u-sm-push-3">
                                    <button type="submit" class="am-btn am-btn-primary" >确认</button>
                                    <a href="/admin-teacher?adminAccount=${admin.getAccount()}">
                                        <button type="button" class="am-btn am-btn-primary">取消</button></a>
                                </div>
                            </div>
                        </form>
                        <script>
                            function test() {
                                var account = document.getElementById('user-account');
                                var name = document.getElementById('user-name');
                                var password = document.getElementById('user-password');
                                var email = document.getElementById('user-email');
                                if (account.value == ''|name.value == ''|password.value == ''|email.value == '') {
                                    alert("These items cannot be empty!");
                                    return false;
                                }
                                return true;
                            }
                        </script>

                    </div>
                </div>
            </div>

        </div>
    </div>
  <!--  <div id="alert" class="myAlert">
        <p class="text1" style="margin-top: 10%;">您已成功创建一个账号!</p>
        <button class="button button-action button-square" style="margin-left: 60%;margin-top: 25%;width:10rem;border-radius: 1rem;" onclick="myClose()">关闭</button>
    </div> -->
</div>

<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/js/amazeui.min.js"></script>
<script src="../../assets/js/app.js"></script>
</body>

</html>