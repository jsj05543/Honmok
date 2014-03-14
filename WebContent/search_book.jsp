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
<form action="search_book_result" method="post">
	<div class="form_text">書籍番号で検索：</div>
	<input type="text" name="search_bookNo" class="form_textbox">
	<input type="submit" value="検索" class="form_submit_button_yoko">
	<div class="clearFloat"></div>
</form>
※ 書籍番号が完全一致する書籍を検索します<br><br>

<form action="search_book_result" method="post">
	<div class="form_text">書籍名で検索：</div>
	<input type="text" name="search_bookName" class="form_textbox">
	<input type="submit" value="検索" class="form_submit_button_yoko">
	<div class="clearFloat"></div>
</form>
※ AND検索など2語以上の検索には未対応です


</body>
</html>