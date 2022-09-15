<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラーページ</title>
</head>
<body>
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
			 <script>
				alert("※URLの直接記入は無効です※")
				window.location.href = 'login.html'
			</script>
		 <%}
	%>
</body>
</html>