<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
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
	<tr height="25" align="center">
	</tr>
	  <tr height="1" bgcolor="#D2D2D2"><td colspan="6"></td></tr>
	 <tr height="1" bgcolor="#82B5DF"><td colspan="6" width="752"></td></tr>
	 </table>
	<button>Write</button>
</body>
</html>