<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=tis-620">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css" type="text/css">
</head>
<body>
	<div id="header">
		<div class="logo">
			<img src="./images/logo.png"/>
		</div>
		<div class="userdetail">
			<label for="UserDetail">นายสมชาย สมหญิง</label>
			|
			<label for="UserLogout">ออกจากระบบ</label>
		</div>
	</div>
	<div class="clr">		
	</div>
	<div id="content">
		<div class="sidebar">
			<div class="box-txt">
				<h3>Category</h3>
				<div class="bottom">
					<textarea name="tbxCategory" rows="5" style="width: 100%;">Category Name?</textarea>
					<input type="submit" value="Create" class="btn">
				</div>
			</div>
		</div>
		<div class="article">
			<div class="box-txt">
				<h2>To-do List Item</h2>
				<div class="bottom">
					<textarea name="tbxSubject" rows="5" style="width: 100%;">What To Do?</textarea>
					<input type="submit" value="Create" class="btn">
				</div>
			</div>
		</div>
	</div>
	<div class="clr">		
	</div>
	<div id="footer">
		<div class="box-txt">
			Copyright 2013 - 2013 TooDoo.COM
		</div>
	</div>
</body>
</html>