<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<%
List<User_info> list = (List<User_info>)request.getAttribute("list");

%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>ユーザー情報入力</h1>


		<form action="<%= request.getContextPath()%>/main"  method="post">
			<input type="hidden" name="id">
			<br>
			名前:<input type="text" name="name">
			<br>
			性別:<input type="radio" name="sex" value="men">男
			<input type="radio" name="sex" value="women">女
			<br>
			生年月日:<input type="text" name="born"> 
			<input type="submit" value="送信">
		</form>

<table class="table table-striped mt-4">
<tr><th>製品名</th><th>価格</th><th>更新日</th><th></th></tr>
<%for(User_info u:list) {%>
<tr><th><%=u.getName() %></th><td><%=u.getSex() %></td><td><%=u.getBorn() %></td>
</tr>
<%} %>
</table>
	</body>
</html>