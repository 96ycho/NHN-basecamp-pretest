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
<div>
	<h1>새 글</h1>
</div>
<form action='Write' method='post'>
<div>
    <label>작성자</label>
    <input type='text' name='name'><br>
</div>
<div>
    <label>이메일</label>
    <input type='email' name='email'><br>
</div>
<div>
    <label>비밀번호</label>
    <input type='password' name='password'><br>
</div>
<div>
    <label>제목</label>
    <input type='text' name='title'><br>
</div>
<div>
    <label>본문</label>
    <textarea name='content'><br>
</div>
<button type="submit">전송</button>
</form>
</body>
</html>