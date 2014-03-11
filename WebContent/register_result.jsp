<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Honmok</title>
</head>
<body>
<%	boolean isAdmin = (request.getAttribute("admin") != null); %>

<!-- 利用者ヘッダ -->
<%	if (isAdmin) { %>
		<jsp:include page="header_admin.jsp" flush="true" />
<%	} else { %>
		<jsp:include page="header.jsp" flush="true" />
<%	} %>

<!-- タイトル -->
<h1>利用者番号表示画面</h1>

<!-- コンテンツ -->
ここにコンテンツを書く


</body>
</html>