<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Honmok</title>
</head>
<body>
<!-- 利用者ヘッダ -->
<jsp:include page="header.jsp" flush="true" />
↑管理者もアクセスするけど？

<!-- タイトル -->
<h1>利用者登録画面</h1>

<!-- コンテンツ -->
ここにコンテンツを書く

<form action="register_result" method="post">
	<div class="form_text">氏名：</div>
	<input type="text" name="uname" class="form_textbox">
	<div class="form_text">住所：</div>
	<input type="text" name="address" class="form_textbox">
	<div class="form_text">TEL：</div>
	<input type="text" name="tel" class="form_textbox">
	<input type="submit" value="登録" class="form_submit_button">
</form>


</body>
</html>