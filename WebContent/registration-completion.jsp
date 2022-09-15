<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了画面</title>
<link rel="stylesheet" href="employee_management.css">
</head>
<body>
<%!String flg;%>
	<%flg = (String) session.getAttribute("userid");%>
<%
		if (flg==null) {
	%>

	<script>
		alert("ログインしてください")
		window.location.href = 'login.html'
	</script>
	<%
		 }else{
	%>
	<h1>登録完了画面</h1>
	<h2 style="text-align: center;">以下の従業員情報を登録しました。</h2>
	<table align="center" >
		<% request.setCharacterEncoding("UTF-8"); %>
		<%EmployeeBean employee=(EmployeeBean)session.getAttribute("employee"); %>
		<tr><td>従業員コード:</td><td><%=employee.getEmployee_code() %></td></tr>

		<%String lname = employee.getLast_name();%>
		<%String fname = employee.getFirst_name();%>
		<%String name = lname + fname;%>
		<tr><td>氏名:</td><td><%=name %></td></tr>

		<%String kanalname = employee.getLast_kana_name();%>
		<%String kanafname = employee.getFirst_kana_name();%>
		<%String kananame = kanalname + kanafname;%>
		<tr><td>氏名かな:</td><td><%=kananame%></td></tr>

		<tr><td>性別:</td><td><%byte g=employee.getGender();%>
		<%if(g==1){ %>
			男
		<%}else{ %>
			女
		<%} %></td></tr>
		<tr><td>生年月日:</td><td><%=employee.getBirth_day() %></td></tr>
		<tr><td>所属部署:</td><td><%=employee.getSection_name()%></td></tr>
		<tr><td>入社日:</td><td><%=employee.getHire_date() %></td></tr>
	</table><br>
	<form action = "registration.jsp" style="text-align: center;">
		<input type="submit" value="登録画面へ戻る">
	</form>
</body>
</html>
<%}%>