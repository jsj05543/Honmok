<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Timestamp"%>
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
<h1>貸し出し結果画面</h1>

<!-- コンテンツ -->
<%
// エラー判定
@SuppressWarnings("unchecked")
ArrayList<String> error_message = (ArrayList<String>)request.getAttribute("error_message");
if ( ! error_message.isEmpty() ) {
	for (String string : error_message) {
		out.println( "<div class=\"error_message\">" + string + "</div>");
	}

	// 未返却のリスト表示行う（未実装）
// 	@SuppressWarnings("unchecked")
// 	ArrayList<Circulation> overDueList = (ArrayList<Circulation>)request.getAttribute("overDueList");
// 	if( overDueList != null && ! overDueList.isEmpty() ){
// 		for( Circulation c : overDueList ){
// 			out.println( c.getLibraryBook().getBname() + "<br>");
// 			out.println( c.getUser().getUserNo() + "<br>");
// 		}
// 	}
	return;
}
Circulation circulation = (Circulation)request.getAttribute("circulation");
%>

<h2>貸出し手続きが完了しました。</h2>
<table class="rentresulttable">
<tr>
<td>貸出し日時：</td>
<td> <%= circulation.getIssueDay() %> </td>
</tr>
<tr>
<tr>
<td>返却予定日：</td>
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