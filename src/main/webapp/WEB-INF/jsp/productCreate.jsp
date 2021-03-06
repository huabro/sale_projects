﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图友网</title>
<link href="common/css/globle.css" rel="stylesheet" type="text/css"/>
<link href="common/css/base.css" rel="stylesheet" type="text/css">
<link href="common/css/toefl.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="common/easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="common/easyUI/themes/icon.css">
<link rel="stylesheet" type="text/css" href="common/easyUI/demo/demo.css">
<script type="text/javascript" src="common/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="common/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="common/js/validate.js"></script>
</head>

<body>
	<div class="longbox w1003">
		<div class="camTitle"></div>
		<div class="longConCam">
			<div class="camZp">

					<table width="100%" cellpadding="0" cellspacing="0"
						class="norTable register">
						<tr>
							<th width="100">作品名称<span class="cf30">*</span>
							</th>
							<td><input type="text" 
								maxlength="50" value=""  class="newTxt w640" /><span
								class="ml10 c999 pt5 f12">可以输入<b class="cf30 abc">50</b>
									字符/汉字</span></td>
						</tr>

						<tr>
							<th width="100">作品分类<span class="cf30">*</span>
							</th>
							<td><span class="selectBox"> 
								<select>
										<option value="1">原创</option>
										<option value="2">素材</option>
										<option value="3">转载</option>
										<option value="4">欣赏</option>


								</select> 
								</span>
							</td>
						</tr>
						<tr>
							<th width="100">作品说明<span class="cf30">*</span>
							</th>
							<td><textarea  cols="" rows="" class="newArea at_input w810 h140"></textarea>

								<p class="c999 pt5 f12">
									可以输入 <b class="cf30 abc">2000</b> 字符/汉字
								</p>
							</td>
						</tr>
						<tr>
							<th width="100">上传图片<span class="cf30">*</span><br />
							<span class="infor" popId="upload_pops"></span>
							</th>
							<td>
								<div id="images">
									<input type="file" name="image" id="image">
								</div></td>
						</tr>
						<tr>
							<th width="100">图片信息说明</th>
							<td><font color="red">图片建议宽度为900像素，其他像素图片会同比例放大缩小</font></td>
						</tr>
						<tr>
							<th width="100" class="c999">创作时间<span class="cf30">*</span><br />
							<span class="infor" popId="time_pops"></span>
							</th>
							<td><input type="text" name="product.createDate" value=""
								id="createDate" class="easyui-datebox" /></td>
						</tr>


						<tr class="last">
							<th></th>
							<td><input type="submit"  value="确定" class="lBtn" /></td>
						</tr>
					</table>

			</div>
		</div>
	</div>
	<!--logbox-->


</body>
</html>
