<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error_page.jsp"
    import="model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認画面</title>
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
	<h1>登録確認画面</h1>
	<h2 style="text-align: center;">以下の従業員情報を登録します。</h2>
	<table align="center" >
		<%
		request.setCharacterEncoding("UTF-8");
		EmployeeBean employee = (EmployeeBean) session.getAttribute("employee");
		%>
		<tr><td>従業員コード：</td><td><%=request.getParameter("employee_code") %></td></tr>

		<%String lname = request.getParameter("lname");%>
		<%String fname = request.getParameter("fname");%>
		<%String name = lname + fname;%>
		<tr><td>氏名：</td><td><%=name%></td></tr>

		<%String kanalname = request.getParameter("lname_kana");%>
		<%String kanafname = request.getParameter("fname_kana");%>
		<%String kananame = kanalname + kanafname;%>
		<tr><td>氏名かな：</td><td><%=kananame%></td></tr>
		<tr><td>性別:<%byte g=employee.getGender();%>
			<%if(g==1){ %>
				<td>男
			<%}else{ %>
				<td>女
			<%} %></td></tr>
		<tr><td>生年月日：</td><td><%=request.getParameter("birthday") %></td></tr>
		<tr><td>所属部署：</td><td><%=employee.getSection_name()%></td></tr>
		<tr><td>入社日：</td><td><%=request.getParameter("hire_date") %></td></tr>
	</table><br>
	<table align="center" >
		<form action="insert-servlet" method="POST" >
			<tr><td><input type="submit"value="登録する"></td><td>
		</form>
		<form>
			<input type="button" value="戻る" onClick="history.go(-1)" >
		</form></td></tr>
	</table>

</body>
</html>
<%}%>