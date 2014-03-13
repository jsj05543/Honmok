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
<h1>管理者トップ画面</h1>

<!-- コンテンツ -->

<table border="1" class="toppage_list">
<tbody>
	<tr>
		<td><a href="over_due">延滞リスト表示</a></td>
		<td class="setsumei">←延滞中の貸し出し情報（利用者／書籍）を一覧表示します</td>
	</tr>
	<tr>
		<td><a href="user_search">利用者情報表示</a></td>
		<td class="setsumei">←図書館の利用者情報検索画面を表示します</td>
	</tr>
	<tr>
		<td><a href="register?admin">利用者登録</a></td>
		<td class="setsumei">←図書館の利用者登録画面を表示します</td>
	</tr>
</tbody>
</table>

</body>
</html>