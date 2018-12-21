<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible">
    <title>翻转课堂管理系统</title>
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" />
    <link rel="stylesheet" type="text/css" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" type="text/css" href="assets/css/admin.css">
    <link rel="stylesheet" type="text/css" href="assets/css/app.css">
    <style type="text/css">
        ul {
            float: right;
            margin: 10px 0
        }

        ul li {
            display: inline;
            padding: 5px;
        }
    </style>
</head>

<body data-type="login">
<div class="am-g myapp-login">
    <div class="myapp-login-logo-block  tpl-login-max">
        <div class="myapp-login-logo-text">
            <div class="myapp-login-logo-text">
                翻转课堂管理系统
            </div>
        </div>
    </div>
    <div class="am-u-sm-10 login-am-center">
        <form class="am-form" action="/index" method="post">
            <fieldset>
                <div class="am-form-group">
                    <input type="text" name="user_account" placeholder="输入学工号/教工号">
                </div>
                <div class="am-form-group">
                    <input type="password" name="password" placeholder="密码">
                </div>
                <p><button type="submit" class="am-btn am-btn-default">登录</button></p>
            </fieldset>
        </form>
    </div>
</div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>

</html>