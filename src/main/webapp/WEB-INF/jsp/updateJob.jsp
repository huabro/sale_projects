<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="utf-8">
<title>用户列表</title>

<link href="common/css/base.css" rel="stylesheet" type="text/css">
<link href="common/css/toefl.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="common/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="common/js/validate.js"></script>
</head>

<body onload="init()">
	<div align="center" style="text-align: center;">
		<a href="###" style="font-size:24">职业信息</a>
	</div>

		<div align="center" style="margin-top: 30px">
			<table>
				<tr>
					<td>职位名称：</td>
					<td><input type="text"  value="" /><font color="red" size="5">*</font></td>
				</tr>
				<tr>
					<td>职位描述：</td>
					<td><textarea  cols="50" rows="10" ></textarea> <font color="red" size="5">*</font>
					</td>
				</tr>
				<tr>
					<td colspan="2"><font color="red" size="3">*为必输项 </font>
					</td>
				</tr>
				<tr>
					<td><input type="submit"  value="提交" style="height:30px;width:60px" /></td>
					<td><input type="reset" value="重置" style="height:30px;width:60px" /></td>
				</tr>
			</table>
		</div>


</body>

</html>
