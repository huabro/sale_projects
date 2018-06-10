<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="/WEB-INF/common/common.jsp"%>
<html>
<head>
<title>系统登录</title>
<link href="${ctx}/static/css/base.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/toefl.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/validate.js"></script>
<script type="text/javascript" src="${ctx}/static/js/user.js"></script>
</head>
<body>
	<div class="doc1180">
		<div class="header">
			<div class="logo">
				<a href="####"><img src="${ctx}/static/image/logo.png">
				</a>
			</div>
		</div>
	</div>
	<div class="doc1180">
		<div class="login">
			<div class="login_left">
				<h3 class="login_h3">欢迎登录图友网</h3>
				<form action="${ctx}/user/login.html" method="post" onsubmit="return login()">
					<font color="red">${msg}</font>
				<div class="login_sr">
					用户名： <input type="text" id="loginName" name="loginName"  class="login_inputYhm" />
				</div>
					<font color="red">${msg1}</font>
				<div class="login_sr">
					密码： &nbsp;&nbsp;&nbsp;<input type="password" id="password" name="password" class="login_inputMm" />
				</div>
				<div class="login_sr">
					<div style="float:left">验证码</div>
					&nbsp;&nbsp; <input type="text" name="validateCode" maxlength="4" class="login_inputYzm" style="float:left;" />
					<div class="login_inputYzmPic" style="float:left">
						<img src="${ctx}/static/image/yzm.png">
					</div>
					<span class="login_inputYzmH" onclick="changeCode()">换一张</span>
				</div>
				<div>
					<button type="submit" value="登录"
						style="height:30px;width:50px">登录</button>
				</div>
				<div class="login_zcymm">
					<a href="${ctx}/user/register.html">注册帐号</a>
				</div>
				</form>
			</div>






			<div class="login_right">
				<div class="login_rightH3">您也可以使用以下方式登录：</div>
				<div class="login_sanfang">
					<a href="###"><img src="${ctx}/static/image/login_wb.png">新浪微博</a>
				</div>
				<div class="login_sanfang">
					<a href="###"><img src="${ctx}/static/image/login_qq.png">QQ登录</a>
				</div>
				<div class="login_sanfang">
					<a href="###"><img src="${ctx}/static/image/login_qw.png">腾讯微博</a>
				</div>
				<div class="login_sanfang">
					<a href="###"><img src="${ctx}/static/image/login_rr.png">人人网</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
