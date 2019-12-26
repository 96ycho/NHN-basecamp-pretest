<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ page import="vo.Writing" %>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">

 <!-- Bootstrap CSS -->
 <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> -->

<title>Read</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	Writing w = (Writing) request.getAttribute("writing");
%> 
<div style="margin-top:50px; margin-left:20px;">
	<h2><%=w.getTitle() %></h2>
</div>
<div style="float:left; margin:20px; width:70%">
<table>
	<tr>
		<td align="center" width="70" style="margin: 10px">작성자 : </td>
		<td align="left" width="150"><%=w.getName() %></td>
	</tr><tr></tr>
 	<tr height="1" bgcolor="#D2D2D2"><td colspan="6"></td></tr>
	<tr>
		<td align="center" width="70" style="margin: 10px">이메일 : </td>
		<td align="left" width="150"><%=w.getEmail() %></td>
	</tr><tr></tr>
	<tr height="1" bgcolor="#D2D2D2"><td colspan="6"></td></tr>
	<tr>
		<td align="center" width="70" style="margin: 10px">본문 : </td>
		<td align="left"><pre><%=w.getContent() %></pre></td>
	</tr>
</table><br>
<button style="margin-left:20px" onclick='location.href="password?id=<%=w.getId() %>"'>수정</button>
<button style="margin-left:20px" onclick='location.href="board"'>목록</button>
</div>
</body>
</html>
