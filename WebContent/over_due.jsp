<%@page import="serv.Circulation"%>
<%@page import="serv.User"%>
<%@page import="serv.LibraryBook"%>
<%@page import="java.util.ArrayList"%>
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
<h1>延滞リスト表示画面</h1>

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
ArrayList<Circulation> list = (ArrayList<Circulation>)request.getAttribute("list");
%>

<table border=1 class="overduetable">
<thead><tr><th>貸し出し日</th><th>氏名</th><th>書籍名</th><th>著者名</th></tr></thead>
<%
	for (Circulation cir : list) {
		User user = cir.getUser();
		LibraryBook lbook = cir.getLibraryBook();
%>
	<tr>
		<td><%= cir.getIssueDay() %></td>
		<td><a href="user_info?uid=<%= user.getUid() %>"><%= user.getUname() %></a></td>
		<td><%= lbook.getBname() %></td>
		<td><%= lbook.getAuthor() %></td>
	</tr>
<%	} %>
</table>

</body>
</html>