<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員情報登録画面</title>
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
	<h1>従業員情報登録</h1>
	<form action="registration-confirm-servlet" method="post">
		<table align="center" >
			<tr><td>従業員コード：</td><td><input type="text" name="employee_code" pattern="[E][0-9][0-9][0-9][0-9]" required="required"></td></tr>
			<tr><td>氏：</td><td><input type="text" name="lname" required="required"></td>
			<td>名：</td><td><input type="text" name="fname" required="required"></td></tr>
			<tr><td>氏かな：</td><td><input type="text" name="lname_kana" required="required"></td>
			<td>名かな：</td><td><input type="text" name="fname_kana" required="required"></td></tr>
			<tr><td>性別：</td><td><input type="radio" name="gender" value=1 required="required">男
					<input type="radio" name="gender" value=2 required="required">女</td></tr>
			<tr><td>生年月日：</td><td><input type="date" name="birthday" min ="1900-01-01" max="9999-12-31" required="required"></td></tr>
			<tr><td>所属部署：</td><td><select name="section" size="1">
				<option value="S000">所属部署未定</option>
				<option value="S110">総務部</option>
				<option value="S130">人事部</option>
				<option value="S150">経理部</option>
				<option value="S210">企画部</option>
				<option value="S230">営業部</option>
				</select>
			<tr><td>入社日：</td><td><input type="date" name="hire_date" min ="1900-01-01" max="9999-12-31" required="required"></td></tr><br>
		</table><br>
	<table align="center" >
			<tr><td></td><td><input type="submit" value="登録確認画面へ"></td><td>
	</form>
		<form action="menu.jsp">
			<input type="submit" value="戻る" ></td></tr>
		</form>
	</table>
</body>
</html>
<%}%>