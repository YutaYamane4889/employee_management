<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集画面</title>
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
	<h1>従業員情報編集</h1>
	<%
		EmployeeBean employee = (EmployeeBean)request.getAttribute("employee");
	%>
	<form action="edit-confirm-servlet" method="POST">
		<table align="center" >
			<tr><td>従業員コード：</td><td><input type="text" name="employee_code" pattern="[E][0-9][0-9][0-9][0-9]" value=<%=employee.getEmployee_code() %> required="required"></td></tr>
			<tr><td>氏：</td><td><input type="text" name="lname" value=<%=employee.getLast_name() %> required="required">
			<td>名：</td><td><input type="text" name="fname" value=<%=employee.getFirst_name() %> required="required"></td></tr>
			<tr><td>氏かな：</td><td><input type="text" name="lname_kana" value=<%=employee.getLast_kana_name() %> required="required">
			<td>名かな：</td><td><input type="text" name="fname_kana" value=<%=employee.getFirst_kana_name() %> required="required"></td></tr>
			<tr><td>性別：</td><td>
			<%
				if (employee.getGender() == 1) {
			%>
					<input type="radio" name="gender"  value=1 checked>男
					<input type="radio" name="gender"  value=2 >女
			<%
				} else {
			%>
					<input type="radio" name="gender"  value=1 >男
					<input type="radio" name="gender"  value=2 checked>女
			<%
				}
			%></td></tr>

		<tr><td>生年月日：</td><td><input type="date" name="birthday" min ="1900-01-01" max="9999-12-31" value=<%=employee.getBirth_day() %> required="required"></td></tr>
		<tr><td>所属部署：</td><td><select name="section" id="section" size="1">
			<option value="S000"selected>所属部署未定</option>
			<option value="S110">総務部</option>
			<option value="S130">人事部</option>
			<option value="S150">経理部</option>
			<option value="S210">企画部</option>
			<option value="S230">営業部</option>
			</select><br>
			<%--プルダウンメニューの初期値を決めるスクリプト --%>
			<script>
				document.getElementById('section').value = '<%=employee.getSection_code()%>';
			</script></td></tr>
		<tr><td>入社日：</td><td><input type="date" name="hire_date" min ="1900-01-01" max="9999-12-31" value=<%=employee.getHire_date()%> required="required"></td></tr>
		</table><br>
		<table align="center">
		<tr><td></td><td><input  type="submit" value="編集確認画面へ"></td><td>
		</form>
	<form action="employee-list-servlet" method="POST" align="center">
		<input type="submit" value="戻る"></td></tr>
	</form>
	</table>

<%}%>
</body>
</html>