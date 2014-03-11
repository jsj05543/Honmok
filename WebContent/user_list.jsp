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
<h1>利用者情報一覧表示画面</h1>

<!-- コンテンツ -->
ここにコンテンツを書く

<table border=1 class="userlisttable">
<tr>
<td>利用者情報一覧のテーブル</td>
<td><a href="user_info?uid=0">名前：利用者情報表示画面へのリンク</a></td>
<td><a href="user_edit?uid=0">編集ボタン：編集画面へのリンク</a></td>
</tr>
</table>

</body>
</html>