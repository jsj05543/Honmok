<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="serv.User" %>
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
<%
// エラー判定
ArrayList<String> error_message = (ArrayList<String>)request.getAttribute("error_message");
if ( ! error_message.isEmpty() ) {
	for (String string : error_message) {
		out.println( "<div class=\"error_message\">" + string + "</div>");
	}
	return;
}
ArrayList<User> list = (ArrayList<User>)request.getAttribute("list");
%>

<table border=1 class="userlisttable">
<thead><tr><th>利用者番号</th><th>氏名</th><th>住所</th><th>TEL</th><th>削除済</th><th>編集</th><tr></thead>
<%
	for (User user : list) {
%>
	<tr>
		<td><%= user.getUserNo() %></td>
		<td><a href="user_info?uid=<%= user.getUid() %>"><%= user.getUname() %></a></td>
		<td><%= user.getAddress() %></td>
		<td><%= user.getTel() %></td>
		<td><%= (user.getDeleteFlag()) ? "削除済" : "" %></td>
		<td><a href="user_edit?uid=<%= user.getUid() %>">編集</a></td>
	</tr>
<%	} %>
</table>

</body>
</html>