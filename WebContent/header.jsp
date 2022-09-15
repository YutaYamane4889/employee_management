<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String code = (String)session.getAttribute("userid");%>

<link rel="stylesheet" href="employee_management.css">
<div class="header">
従業員情報管理システム<br>
ログインユーザ:<%=code%>
</div>