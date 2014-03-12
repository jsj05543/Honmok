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
<h1>返却画面</h1>

<!-- コンテンツ -->
<form action="return_result" method="post">
	<div class="form_text">書籍番号：</div>
	<input type="text" name="bookNo" class="form_textbox">
	<input type="submit" value="返却" class="form_submit_button">
</form>


</body>
</html>