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
<h1>トップ画面</h1>

<!-- コンテンツ -->

<table border="1" class="toppage_list">
<tbody>
	<tr>
		<td><a href="rent">貸し出し</a></td>
		<td class="setsumei">←本を借りる方は</td>
	</tr>
	<tr>
		<td><a href="search_book">本の情報表示</a></td>
		<td class="setsumei">←蔵書を検索したい方は</td>
	</tr>
	<tr>
		<td><a href="return">返却</a></td>
		<td class="setsumei">←本を返却する方は</td>
	</tr>
	<tr>
		<td><a href="register">利用者登録</a></td>
		<td class="setsumei">←利用者登録をしたい方は</td>
	</tr>
</tbody>
</table>



</body>
</html>