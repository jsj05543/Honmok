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
<jsp:include page="header_admin.jsp" flush="true" />

<!-- タイトル -->
<h1>利用者情報編集画面</h1>

<!-- コンテンツ -->
<form action="user_edit_result" method="post">
	<input type="hidden" name="uid">
	<div class="form_text">氏名：</div>
	<input type="text" name="uname" class="form_textbox" value="デフォルト値">
	<div class="clearFloat"></div>
	<div class="form_text">住所：</div>
	<input type="text" name="address" class="form_textbox" value="デフォルト値">
	<div class="clearFloat"></div>
	<div class="form_text">TEL：</div>
	<input type="text" name="tel" class="form_textbox" value="デフォルト値">
	<div class="clearFloat"></div>
	<!-- 変更 -->
	<input type="submit" value="変更" class="form_submit_button_yoko">
</form>
<form action="user_edit_result" method="post">
	<input type="hidden" name="uid">
	<!-- 削除 -->
	<input type="submit" value="削除" class="form_submit_button_yoko">
</form>


</body>
</html>