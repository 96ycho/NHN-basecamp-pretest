<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.Writing" %>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Password</title>
</head>
<body>
<div style="margin:20px">
	<h2>비밀번호를 입력하세요.</h2>
</div>
<% String id = (String)request.getAttribute("id"); %>
<div style="float:left; margin:20px; width:90%">
<form action='Password' method='post'>
	<div>
	    <label>비밀번호</label><br>
	    <input type='password' name='password' style="width:200px;">
	    <input type='hidden' name='id' value='<%=id %>'>
	</div><br>
	<div style="float:left"><button type="submit">확인</button></div>
</form>
<button style="margin-left:20px" onclick='location.href="read?id=<%=id %>"'>취소</button>
</div>
</body>
</html>