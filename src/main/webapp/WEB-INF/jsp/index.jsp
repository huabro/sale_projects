<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="utf-8">
<title>图友网首页</title>
	<link href="common/css/base.css" rel="stylesheet" type="text/css">
	<link href="common/css/toefl.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="common/js/jquery.min.js"></script>
	<script type="text/javascript" src="common/js/validate.js"></script>
</head>
<script type="text/javascript">
function showProductBySort() {
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
		<div style="float: left; width:100px; height:50px;"><img style="height:50px"  src="common/image/logo.png"></div>
   	  <div class="menuLink">
   	  		
        	<ul class="fn-clear">
                <li><a href="###" onclick="showMain()">首页</a></li>
                
                	<li><a href='##' onclick='showProductBySort()'>原创</a></li>
                
                	<li><a href='##' onclick='showProductBySort()'>素材</a></li>
                
                	<li><a href='##' onclick='showProductBySort()'>转载</a></li>
                
                	<li><a href='##' onclick='showProductBySort()'>欣赏</a></li>
                
            </ul>
        </div>
        
        <div class="menuLink" style="margin-left: 450px">
        	<ul class="fn-clear">
            	<li><a target="_blank" href="login.html" >登陆</a></li>
            	<li><a target="_blank" href="register.html" >注册</a></li>
            </ul>
        </div>
	
         
        
    </div>
</div>
<iframe height="590px" src="main.html" scrolling="yes" id="mainframe"  width="99%" name="mainframe" onchange="" ></iframe>
</body>
</html>
