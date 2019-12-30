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

<title>Update</title>
</head>
<script>
	function delfunction(id){		
		var url = new String("delete?id=");
		var s_id = String(id);
		var res = confirm("글을 삭제하시겠습니까?");
		if(res){
			url = url + s_id;
			location.href = url;
		}else{
			setTimeout(function(){location.reload();},1);
		}
	}
	function checkform(){
		if(document.form1.name.value==""){
			alert("이름을 입력하세요.");
			form1.email.focus();
			return false;
		}else if(document.form1.email.value==""){
			alert("이메일을 입력하세요.");
			form1.email.focus();
			return false;
		}else if(document.form1.password.value==""){
			alert("비밀번호를 입력하세요.");
			form1.password.focus();
			return false;
		}else if(document.form1.title.value==""){
			alert("제목을 입력하세요.");
			form1.email.focus();
			return false;
		}else{
			alert("글이 수정 되었습니다!");
			return true;
		}
	}
</script>
<body>
<div style="margin:20px">
	<h1>글 수정하기</h1>
</div>
<div style="float:left; margin:20px; width:90%">
<form name='form1' action='Update' method='post' onsubmit='return checkform()'>
<%
	Writing w = (Writing) request.getAttribute("writing");
%> 
<div>
    <label>글 번호: <%=w.getId() %></label>
    <input type='hidden' name='id' value='<%=w.getId() %>'>
</div><br>
<div>
    <label>작성자</label><br>
    <input type='text' name='name' style="width:200px;" value='<%=w.getName() %>'>
</div><br>
<div>
    <label>이메일</label><br>
    <input type='email' name='email' style="width:200px;" value='<%=w.getEmail() %>'>
</div><br>
<div>
    <label>비밀번호</label><br>
    <input type='password' name='password' style="width:200px;" value='<%=w.getPassword() %>'>
</div><br>
<div>
    <label>제목</label><br>
    <input type='text' name='title' style="width:900px;" value='<%=w.getTitle() %>'>
</div><br>
<div>
    <label>본문</label><br>
    <textarea name='content' style="width:900px; height:300px"><%=w.getContent() %></textarea>
</div><br>
<div style="float:left"><button type="submit">등록</button>
</div>
</form>
<button style="margin-left:20px" onclick="delfunction(<%=w.getId() %>);">삭제</button>
<button style="margin-left:20px" onclick='location.href="read?id=<%=w.getId() %>"'>취소</button>
</div>
</body>
</html>
