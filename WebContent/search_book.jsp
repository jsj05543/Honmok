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

<!-- タイトル -->
<h1>本の情報表示画面</h1>

<!-- コンテンツ -->
<form action="show_book" method="post">
	<div class="form_text">書籍番号で検索：</div>
	<input type="text" name="search_id" class="form_textbox">
	<input type="submit" value="検索" class="form_submit_button_yoko">
</form>

<form action="show_book" method="post">
	<div class="form_text">書籍名で検索：</div>
	<input type="text" name="search_name" class="form_textbox">
	<input type="submit" value="検索" class="form_submit_button_yoko">
</form>


</body>
</html>