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
<h1>利用者情報表示画面</h1>

<!-- コンテンツ -->

<table border=1 class="userinfotable">
<tr><td>利用者情報のテーブル</td></tr>
</table>

<form action="user_edit" method="get">
	<input type="hidden" name="uid">
	<input type="submit" value="変更" class="form_submit_button">
</form>


<h2>今借りている本のリスト</h2>
<table border=1 class="userbooktable">
<tr><td>今借りている本のリストテーブル</td></tr>
</table>


</body>
</html>