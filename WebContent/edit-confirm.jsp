<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error_page.jsp"
    import="model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集確認画面</title>
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
<h1>編集確認画面</h1>
</body>
	<h2 style="text-align: center;">以下の従業員情報を編集します。</h2>
	<table align="center" >
		<%
		EmployeeBean employeemae = (EmployeeBean) session.getAttribute("employeemae");
		EmployeeBean employee = (EmployeeBean) session.getAttribute("employee");
		%>
		<%String employeecode = employee.getEmployee_code();%>
		<%String maeemployeecode = employeemae.getEmployee_code(); %>
		<tr><td>従業員コード：</td><td>
		<%if (!employeecode.equals(maeemployeecode)) { %>
			<font><%=employeemae.getEmployee_code() %></font></td><td>　→　</td><td><font><%=employee.getEmployee_code()%></font>
		<% }else{%>
		<%=employeemae.getEmployee_code() %></td><td>　→　</td><td><%=employee.getEmployee_code()%>
		<%} %></td></tr><%--コード比較--%>
		<%String lname = employee.getLast_name();%>
		<%String fname = employee.getFirst_name();%>
		<%String name = lname + fname;%>

		<%String maelname = employeemae.getLast_name();%>
		<%String maefname = employeemae.getFirst_name();%>
		<%String maename = maelname + maefname;%>
		<tr><td>氏名：</td><td>
		<%if(!maename.equals(name)){ %>
			<font><%=maename%></font></td><td>　→　</td><td><font><%=name%></font>
		<% }else{%>
			<%=maename%></td><td>　→　</td><td><%=name%>
		<%} %></td></tr>

		<%String kanalname = employee.getLast_kana_name();%>
		<%String kanafname = employee.getFirst_kana_name();%>
		<%String kananame = kanalname + kanafname;%>

		<%String maekanalname = employeemae.getLast_kana_name();%>
		<%String maekanafname = employeemae.getFirst_kana_name();%>
		<%String maekananame = maekanalname + maekanafname;%>
		<tr><td>氏名かな：</td><td>
		<%if(!maekananame.equals(kananame)){ %>
			<font><%=maekananame%></font></td><td>　→　</td><td><font><%=kananame%></font>
		<% }else{%>
			<%=maekananame%></td><td>　→　</td><td><%=kananame%>
		<%} %></td></tr>

		<%byte maeg = employeemae.getGender();%>
		<%byte g = employee.getGender();%>
		<tr><td>性別：</td><td>
		<%if (maeg!= g){ %>
		<font>
			<%if(maeg == 1){ %>
				男
				<%}else{ %>
				女
				<%} %></font></td><td>　→　</td><td><font>
			<%if(g == 1){ %>
				男
			<%}else{ %>
				女
			<%} %></font>
		<%}else{%>
		<%if(maeg == 1){ %>
				男
			<%}else{ %>
				女
			<%} %></td><td>　→　</td><td>
			<%if(g == 1){ %>
				男
			<%}else{ %>
				女
			<%} %>
		<%} %></td></tr>
		<%String maebirth = String.valueOf(employeemae.getBirth_day());%>
		<%String birth = String.valueOf(employee.getBirth_day());%>
		<tr><td>生年月日：</td><td>
		<%if(!maebirth.equals(birth)){ %>
		<font>
		<%=employeemae.getBirth_day() %></font></td><td>　→　</td><td><font><%=employee.getBirth_day() %>
		</font>
		<%}else{ %>
		<%=employeemae.getBirth_day() %></td><td>　→　</td><td><%=employee.getBirth_day() %>
		<%} %></td></tr>

		<%String maesection = employeemae.getSection_code();%>
		<%String section = employee.getSection_code();%>
		<tr><td>所属部署：</td><td>
		<% if(!maesection.equals(section)){%>
		<font>
		<%=employeemae.getSection_name() %></font></td><td>　→　</td><td><font><%=employee.getSection_name() %>
		<%}else{ %>
		<%=employeemae.getSection_name() %></td><td>　→　</td><td><%=employee.getSection_name() %>
		<%} %></td></tr>
		<%String maehire = String.valueOf(employeemae.getHire_date());%>
		<%String hire = String.valueOf(employee.getHire_date());%>
		<tr><td>入社日：</td><td>
		<%if(!maehire.equals(hire)){ %>
		<font>
		<%=employeemae.getHire_date() %></font></td><td>　→　</td><td><font><%=employee.getHire_date() %>
		</font>
		<%}else{ %>
		<%=employeemae.getHire_date() %></td><td>　→　</td><td><%=employee.getHire_date() %>
		<%} %></td></tr>

		<tr><td></td><td><form action="edit-servlet"method="POST">
			<input type="submit"value="編集する">
		</form></td>

		<td><form>
			<input type="button" value="戻る" onClick="history.go(-1)">
		</form></td></tr>
	</table>

</html>
<%}%>