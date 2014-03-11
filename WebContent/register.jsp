<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Honmok</title>
</head>
<body>
<%	boolean isAdmin = (request.getAttribute("admin") != null); %>

<!-- 利用者ヘッダ -->
<%	if (isAdmin) { %>
		<jsp:include page="header_admin.jsp" flush="true" />
<%	} else { %>
		<jsp:include page="header.jsp" flush="true" />
<%	} %>

<!-- タイトル -->
<h1>利用者登録画面</h1>

<!-- コンテンツ -->

<form action="register_result" method="post">
<%	if (isAdmin) { %>
	<input type="hidden" name="admin">
<%	} %>
	<div class="form_text">氏名：</div>
	<input type="text" name="uname" class="form_textbox">
	<div class="clearFloat"></div>
	<div class="form_text">住所：</div>
	<input type="text" name="address" class="form_textbox">
	<div class="clearFloat"></div>
	<div class="form_text">TEL：</div>
	<input type="text" name="tel" class="form_textbox">
	<div class="clearFloat"></div>
	<input type="submit" value="登録" class="form_submit_button">
</form>


</body>
</html>