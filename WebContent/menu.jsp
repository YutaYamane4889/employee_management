<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> メニュー</title>
<link rel="stylesheet" type="text/css" href="employee_management.css">
</head>
<body>
	<%session.removeAttribute("section"); %>
	<%!String flg;%>
	<%flg = (String) session.getAttribute("userid");%>
<%
		if (flg==null) {
	%>

	<script>
		alert("ログインしてください。")
		window.location.href = 'login.html'
	</script>
	<%
		 }else{
	%>
	<jsp:include page="header.jsp">
		<jsp:param value="" name="code" />
	</jsp:include>

	<h1 >メニュー画面</h1>
	<form class="submit_align"  action="registration.jsp" method="POST">
		<input class="submit_design" style="margin-top:90px;" type="submit" value="従業員情報登録">
	</form>
	<form class="submit_align" action="employee-list-servlet" method="POST">
		<input class="submit_design"
			type="submit" value="従業員情報一覧表示">
	</form>
	<form class="submit_align" action="logout-servlet" method="POST">
		<input class="submit_design" type="submit" value="ログアウト">
	</form>
</body>
</html>
<%} %>
