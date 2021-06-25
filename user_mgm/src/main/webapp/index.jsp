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
			性別:<input type="radio" name="sex" value="男">男
			<input type="radio" name="sex" value="女">女
			<br>
			生年月日:<input type="text" name="born"> 
			<input type="submit" value="送信">
		</form>

<br>
<%if(list != null && list.size()>0){%>
<table>
<tr><th>名前</th><th>性別</th><th>更新日</th><th></th></tr>
<%for(User_info u : list) {%>
<tr><td><%=u.getName() %></td><td><%=u.getSex() %></td><td><%=u.getBorn() %></td><td><a href="/user_mgm/main?action=delete&id=<%=String.valueOf(u.getId()) %>" class="btn btn-danger" onclick="return confirm('削除してよろしいですか？');">削除</a></td>
</tr>
<%} %>
</table>
<%} %>
	</body>
</html>