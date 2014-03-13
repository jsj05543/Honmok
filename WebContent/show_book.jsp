<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="serv.LibraryBook" %>
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
<h1>本の検索結果画面</h1>

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
@SuppressWarnings("unchecked")
ArrayList<LibraryBook> libbook = (ArrayList<LibraryBook>)request.getAttribute("libbooks");
%>

<table border=1 class="booktable">
<tr><td>テーブルのデバッグ</td></tr>
<tr><td>テーブルのデバッグ</td></tr>
<tr><td>テーブルのデバッグ</td></tr>
<tr><td>テーブルのデバッグ</td></tr>
<tr><td>テーブルのデバッグ</td></tr>
</table>

</body>
</html>