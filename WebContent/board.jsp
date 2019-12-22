<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.Writing" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<title>Board</title>
</head>
<body>
	<h1>Board</h1>
	<%--table design 출처 : https://seinarin.tistory.com/3?category=452459--%>
	<table width="100%" cellpadding="0" cellspacing="0" border="0">
	 <tr height="5"><td width="5"></td></tr>
	  <tr>
	   <td width="73">번호</td>
	   <td width="379">제목</td>
	   <td width="73">작성자</td>
	   <td width="164">작성일</td>
	   <td width="58">최근수정시각</td>
	  </tr>
	<%
	ArrayList<Writing> writings = (ArrayList<Writing>)request.getAttribute("writings");
	for(Writing w : writings) {
	%>  
	 <tr height="25" align="center">
		<td>&nbsp;</td>
		<a href='update?no<%=w.getId() %>'><td><%=w.getId() %></td></a>
		<td align="left"><%=w.getTitle() %></td>
		<td align="center"><%=w.getName() %></td>
		<td align="center"><%=w.getWriteDate() %></td>
		<td align="center"><%=w.getModDate() %></td>
		<a href='delete?'no<%=w.getId() %>'>[del]</a>
		<td>&nbsp;</td>
	 </tr>
	 <tr height="1" bgcolor="#D2D2D2"><td colspan="6"></td></tr>
	 <%} %>
	 <tr height="1" bgcolor="#82B5DF"><td colspan="6" width="752"></td></tr>
	 </table>
	<button a href='Write'>Write</a></button>
</body>
</html>