<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<meta charset="utf-8">
<title>用户首页</title>
	<link href="common/css/base.css" rel="stylesheet" type="text/css">
	<link href="common/css/toefl.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="common/js/jquery.min.js"></script>
	<script type="text/javascript" src="common/js/validate.js"></script>
</head>
<script type="text/javascript">
function showUserDetail() {
	document.getElementById("mainframe").src='userDetail.html';
}
function showProduct() {
	document.getElementById("mainframe").src='productByUser.html';
}
function showProductBySort(sortId) {
	document.getElementById("mainframe").src='productBySort.html';
}
function showMain() {
	document.getElementById("mainframe").src='main.html';
}
</script>
<body>
<div class="doc1180">

</div>
<div class="menu">
	<div class="doc1180">
		<div style="float: left; width:100px; height:50px;"><img style="height:50px"  src="http://localhost:80/picturefriend1//common/image/logo.png"></div>
   	  <div class="menuLink">
   	  		
        	<ul class="fn-clear">
                <li><a href="###" onclick="showMain()">首页</a></li>
                
                	<li><a href='##' onclick='showProductBySort()'>原创</a></li>
                
                	<li><a href='##' onclick='showProductBySort()'>素材</a></li>
                
                	<li><a href='##' onclick='showProductBySort()'>转载</a></li>
                
                	<li><a href='##' onclick='showProductBySort()'>欣赏</a></li>
                
                <li><a href="###" onclick="showUserDetail()">个人信息</a></li>
                <li><a href="###" onclick="showProduct()" >作品发布</a></li>
            </ul>
        </div>
        
	
         <div class="menuLink" style="margin-left: 150px">
        	<ul class="fn-clear">
            	<li><a href="login.html" >退出登陆</a></li>
            </ul>
        </div>
        <div class="menuLink" style="margin-left: 40px">
        	<ul class="fn-clear">
            	<li><a href="###">欢迎乔丹访问</a></li>
            </ul>
        </div>
        
    </div>
</div>
<iframe height="590px" src="main.html" scrolling="yes" id="mainframe"  width="99%" name="mainframe" onchange="" ></iframe>
</body>
</html>
