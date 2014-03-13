<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="serv.User" import="serv.LibraryBook" import="serv.Circulation" %>
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
<h1>返却結果画面</h1>

<!-- コンテンツ -->
<%
// エラー判定
@SuppressWarnings("unchecked")
ArrayList<String> error_message = (ArrayList<String>)request.getAttribute("error_message");
if ( ! error_message.isEmpty() ) {
	for (String string : error_message) {
		out.println( "<div class=\"error_message\">" + string + "</div>");
	}
	return;
}
Circulation circulation = (Circulation)request.getAttribute("circulation");
%>

<h2>返却手続きが完了しました。ありがとうございました。</h2>
<table>
<tr>
<td>返却日：</td>
<td> <%= circulation.getIssueDay() %> </td>
</tr>
<tr>
<td>利用者：</td>
<td> <%= circulation.getUser().getUname()  %> </td>
</tr>
<tr>
<td>書籍名：</td>
<td> <%= circulation.getLibraryBook().getBname()  %> </td>
</tr>
</table>

</body>
</html>