<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.Writing" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<title>Board</title>
</head>
<body>
<div style="margin:20px">
	<h1>게시판</h1>
</div>
<%--table design 출처 : https://seinarin.tistory.com/3?category=452459--%>
<div style="margin:20px">
	<table cellpadding="0" cellspacing="0" border="0">
	 <tr height="5"><td width="5"></td></tr>
	  <tr>
	   <td align="center" width="50">번호</td>
	   <td align="center" width="500">제목</td>
	   <td align="center" width="100">작성자</td>
	   <td align="center" width="200">작성일</td>
	   <td align="center" width="200">최근수정일</td>
	  </tr>
  	<tr height="1" bgcolor="#82B5DF"><td colspan="6" width="752"></td></tr>
	<%
	ArrayList<Writing> writings = (ArrayList<Writing>)request.getAttribute("writings");
	for(Writing w : writings) {
	%>  
	 <tr height="25" align="center">
		<td align="center"><a href="update?no=<%=w.getId() %>"><%=w.getId() %></a></td>
		<td align="left" style="padding:5px"><%=w.getTitle() %></td>
		<td align="center"><%=w.getName() %></td>
		<td align="center"><%=w.getWriteDate() %></td>
		<td align="center"><%=w.getModDate() %></td>
		<td><a href="delete?no=<%=w.getId() %>">[del]</a></td>
	 </tr>
	 <tr height="1" bgcolor="#D2D2D2"><td colspan="6"></td></tr>
	 <%} %>
	 <tr height="1" bgcolor="#82B5DF"><td colspan="6" width="752"></td></tr>
	 </table><br>
	<button onclick="location.href='write.jsp'">Write</a></button>
</div>
</body>
</html>