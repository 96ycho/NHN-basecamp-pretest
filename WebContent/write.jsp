<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">

 <!-- Bootstrap CSS -->
 <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> -->

<title>Write</title>
</head>
<body>
<div style="margin:20px">
	<h1>새 글 작성하기</h1>
</div>
<div style="float:left; margin:20px; width:90%">
<form action='Write' method='post'>
<div>
    <label>작성자</label><br>
    <input type='text' name='name' style="width:200px;">
</div><br>
<div>
    <label>이메일</label><br>
    <input type='email' name='email' style="width:200px;">
</div><br>
<div>
    <label>비밀번호</label><br>
    <input type='password' name='password' style="width:200px;">
</div><br>
<div>
    <label>제목</label><br>
    <input type='text' name='title' style="width:900px;">
</div><br>
<div>
    <label>본문</label><br>
    <textarea name='content' style="width:900px; height:300px"></textarea>
</div><br>
<div style="float:left"><button type="submit">등록</button>
</div>
</form>
<button style="margin-left:20px" onclick="location.href='board'">취소</button>
</div>
</body>
</html>