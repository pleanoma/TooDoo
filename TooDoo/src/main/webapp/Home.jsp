<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=tis-620">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css" type="text/css">
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
</head>
		<script type='text/javascript'>
			$(document).ready(function()
			{
				$.ajax
				({
					type : "GET",
					url : "./TooDooServlet2",
					dataType : "json",
					success : function(data) {
						if (data.length > 0) {
							var strTable = "<table cellspacing='0' cellpadding='2' style='margin-bottom: 10px; width:100%; border: 1px solid #e1e1e1;'>"
							+ "	<tr>"
							+ "		<td style='width:80%; font-weight: 900; border: 1px solid #e1e1e1; text-align:center;'>Subject</td>"
							+ "		<td style='width:20%; font-weight: 900; border: 1px solid #e1e1e1; text-align:center;'>Due Date</td>"
							+ "	</tr>";
							$.each(data, function(i, data) {
								//alert(data.subject);
								strTable += "<tr  style='width:100%;'><td style='width:85%; border: 1px solid #e1e1e1;'>" + data.subject +"</td><td style='width:15%; border: 1px solid #e1e1e1; text-align:center;'>" + data.due_date + "</td></tr>";
							});
							strTable += "</table>";
							$("#result_toodoo").append(strTable);
						} else {
							$("#content").html("No Results");
						}
					}
				});
				$('#UpdateButton').click(function() {
					// Previous Post
				});
				return false;
			});
		</script>
<body>
	<div id="header">
		<div class="logo">
			<img src="./images/logo.png" />
		</div>
		<div class="userdetail">
			<label for="UserDetail">นายสมชาย สมหญิง</label> | <label
				for="UserLogout">ออกจากระบบ</label>
		</div>
	</div>
	<div class="clr"></div>
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
					<div id="result_toodoo"></div>
					<textarea name="tbxSubject" rows="5" style="width: 100%;">What To Do?</textarea>
					<input type="submit" value="Create" class="btn">
				</div>
			</div>
		</div>
	</div>
	<div class="clr"></div>
	<div id="footer">
		<div class="box-txt">Copyright 2013 - 2013 TooDoo.COM</div>
	</div>
</body>
</html>