<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 従業員一覧表示画面</title>
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
	<jsp:include page="header.jsp">
		<jsp:param value="" name="code" />
	</jsp:include>
	<h1>従業員情報一覧</h1>
	<form action = "menu.jsp" align="right">
		<input type ="submit" value="戻る">
	</form>

	<%
		List<EmployeeBean> employeeList = (List<EmployeeBean>) request.getAttribute("employeeList");
	%>
	<%if (employeeList.size()==0){ %>
			<h3 align="center">該当する従業員はいません</h3>
			<% }%>
	<table border="1" align="center" rules="all">
		<tr><th width="100">従業員コード<form action ="employee-list-servlet" method ="POST">
		<button type="submit" name="order" value="employee_code">▼</button>
		</form></th>
		<th width="100">氏名<form action ="employee-list-servlet" method ="POST">
		<button type="submit" name="order" value="last_kana_name">▼</button>
		</form></th>
		<th width="150">氏名かな</th><th>性別</th>
		<th width="130">生年月日<form action ="employee-list-servlet" method ="POST">
		<button type="submit" name="order" value="birth_day">▼</button>
		</form></th>
		<th width="150">所属部署<form action ="employee-list-servlet" method ="POST">
		<select name="section" size="1">
			<option value="all">全て</option>
			<option value="S000">所属部署未定</option>
			<option value="S110">総務部</option>
			<option value="S130">人事部</option>
			<option value="S150">経理部</option>
			<option value="S210">企画部</option>
			<option value="S230">営業部</option>
			</select><input type ="submit" value="部署で抽出">
		</form></th>
		<th width="130">入社日<form action ="employee-list-servlet" method ="POST">
		<button type="submit" name="order" value="hire_date">▼</button>
		</form></th>
		</tr>

		<%
			for (EmployeeBean employee : employeeList) {

		%>

		<%
			String employeeCode = employee.getEmployee_code();
		%>
		<tr><td><%=employeeCode%></td>
		<td><%=employee.getLast_name()%>
			<%=employee.getFirst_name()%></td>
		<td><%=employee.getLast_kana_name()%>
			<%=employee.getFirst_kana_name()%></td>
		<td width="50"><%
			byte gender = employee.getGender();
		%>
		<%
			if (gender == 1) {
		%>
		男
		<%
			} else if (gender == 2) {
		%>
		女
		<%
			}else{
		%>
		不明
		<%} %></td>
		<td><%=employee.getBirth_day() %></td>
		<td width="130"><%=employee.getSection_name()%></td>
		<td><%=employee.getHire_date() %></td>


		<td><form action="edit-display" method="POST">
			<button type="submit" name="employeeCode" value=<%=employeeCode%>>編集</button>
		</form></td>
		<td><form action="delete-confirm-servlet" method="POST">
			<button type="submit" name="employeeCode" value=<%=employeeCode%>>削除</button>
		</form></td></tr>
		<%
			}
		%>

<%}%>
</body>
</html>
