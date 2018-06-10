<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/common/common.jsp"%>
<html>
<head>
<meta charset="utf-8">
<title>注册页</title>
<link href="${ctx}/static/css/base.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/toefl.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/user.js"></script>

</head>

<body  onload="init()">
<div class="doc1180">
	<div class="header">
    	<div class="logo"><a href="####"><img src="${ctx}/static/image/logo.png"></a></div>
    </div>
</div>
<div class="doc1180">
	<div class="login">
    	<div class="login_left">
       	  <h3 class="login_h3">新用户注册</h3>
       	  	        
				<form action="${ctx}/user/register" method="post">
					<font id="msg" color="red">${msg}</font>
       	  		<div class="login_sr">账号：<input type="text" id="loginName" name="loginName" class="login_inputYhm"/></div>
	            <div class="login_sr">密码：<input type="password" name="password" class="login_inputMm"/></div>
	            <div class="login_sr">邮箱：<input type="text" name="email" class="login_inputEmail"/></div>
	            <div>
	            <button type="submit"  value="注册" style="height:30px;width:50px">注册 </button>
				</div>
				</form>




      </div>
      <div class="login_right">
      	<div class="login_rightH3">您也可以使用以下方式登录：</div>
        <div class="login_sanfang"><a href="###"><img src="${ctx}/static/image/login_wb.png">新浪微博</a></div>
        <div class="login_sanfang"><a href="###"><img src="${ctx}/static/image/login_qq.png">QQ登录</a></div>
        <div class="login_sanfang"><a href="###"><img src="${ctx}/static/image/login_qw.png">腾讯微博</a></div>
        <div class="login_sanfang"><a href="###"><img src="${ctx}/static/image/login_rr.png">人人网</a></div>
      </div>
    </div>
</div>





<iframe src="${ctx}/bottom.jsp" width="100%" name="bottomframe" ></iframe>

</body>







</html>
