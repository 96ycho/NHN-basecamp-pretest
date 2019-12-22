<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">

 <!-- Bootstrap CSS -->
 <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> -->

<title>Update</title>
</head>
<body>
<div>
	<h1>글 수정</h1>
</div>
<form action='Update' method='post'>
<div>
    <label>작성자</label><br>
    <input type='text' name='name' value='${w.name}'><br>
</div>
<div>
    <label>이메일<br></label><br>
    <input type='email' name='email' value='${w.email}'><br>
</div>
<div>
    <label>비밀번호<br></label><br>
    <input type='password' name='password' value='${w.password}'><br>
</div>
<div>
    <label>제목<br></label><br>
    <input type='text' name='title' value='${w.title}'><br>
</div>
<div>
    <label>본문<br></label><br>
    <textarea name='content' value='${w.content}'><br>
</div>
<button type="submit">전송</button>
</form>
</body>
</html>