<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了画面</title>
<link rel="stylesheet" href="employee_management.css">
</head>
<body>
	<h1>削除完了画面</h1>
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
	<%
		int res = 0;
	%>
	<%
		res = (int) request.getAttribute("deleteres");
	%>
	<%
		if (res == 0) {
	%>
	<h2 style="text-align: center;">以下の従業員情報を削除できませんでした。</h2>
	<%
		} else {
	%>
	<h2 style="text-align: center;">以下の従業員情報を削除しました。</h2><br>
	<%
		}
	%>

	<%
	request.setCharacterEncoding("UTF-8");
	EmployeeBean employee = (EmployeeBean) session.getAttribute("employee");
	%>
	<table class="delete_confirm">
		<tr><td>従業員コード：</td><td><%=employee.getEmployee_code() %></td> </tr>
		<tr><td>氏名：</td><td><%=employee.getLast_name() %><%=employee.getFirst_name() %></td></tr>
		<tr><td>氏名かな：</td><td><%=employee.getLast_kana_name() %><%=employee.getFirst_kana_name() %></td></tr>
		<tr><td>性別：</td><td><%byte g=employee.getGender();%>
		<%if(g==1){ %>
			男
		<%}else{ %>
			女
		<%} %><br> </td></tr>
		<tr><td>生年月日：</td><td><%=employee.getBirth_day() %></td></tr>
		<tr><td>所属部署：</td><td><%=employee.getSection_name() %></td></tr>
		<tr><td>入社日：</td><td><%=employee.getHire_date() %></td></tr>
	</table><br>
	<form action = "employee-list-servlet" method="POST" style="text-align: center;">
		<input type ="submit" value="一覧表示画面に戻る">
	</form>

</body>
</html>
<%}%>