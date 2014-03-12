<%@page import="java.util.ArrayList"%>
<%@page import="serv.User"%>
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
<h1>利用者情報編集画面</h1>

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
User user = (User)request.getAttribute("users");
%>

<form action="user_edit_result" method="post">
	<input type="hidden" name="uid" value="<%= user.getUid() %>">
	<div class="form_text">氏名：</div>
	<input type="text" name="uname" class="form_textbox" value="<%= user.getUname() %>">
	<div class="clearFloat"></div>
	<div class="form_text">住所：</div>
	<input type="text" name="address" class="form_textbox" value="<%= user.getAddress() %>">
	<div class="clearFloat"></div>
	<div class="form_text">TEL：</div>
	<input type="text" name="tel" class="form_textbox" value="<%= user.getTel() %>">
	<div class="clearFloat"></div>
	<!-- 変更 -->
	<input type="submit" value="変更" class="form_submit_button_yoko">
</form>
<form action="user_edit_result" method="post">
	<input type="hidden" name="uid" value="<%= user.getUid() %>">
	<!-- 削除 -->
	<input type="submit" value="削除" class="form_submit_button_yoko">
</form>


</body>
</html>