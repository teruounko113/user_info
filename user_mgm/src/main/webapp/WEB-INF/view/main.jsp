<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<%
List<User_info> list = (List<User_info>)request.getAttribute("list");
User_info user_info=(User_info)request.getAttribute("user_info");
String id=user_info==null ? "":String.valueOf(user_info.getId());
String name=user_info == null ? "":user_info.getName();
String sex=user_info == null ? "":String.valueOf(user_info.getSex());
String born=user_info == null ? "":String.valueOf(user_info.getBorn());
String title=(String)request.getAttribute("title");
title=title==null? "商品を登録してください。":title;
String err=(String)request.getAttribute("err");
String msg=(String)request.getAttribute("msg");
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ユーザー情報</title>
	</head>
	<body>
		<h1>ユーザー情報入力</h1>


		<form action="<%= request.getContextPath()%>/main"  method="post">
			<input type="hidden" name="id" value="<%=id %>">
			<br>
			名前:<input type="text" name="name" value="<%=name%>">
			<br>
			<p><%=sex %></p>
			性別:<input type="radio" name="sex" value="男" <%if(sex == "男"){ %>checked<%} %>>男
			<input type="radio" name="sex" value="女" <%if(sex == "女"){ %>checked<%} %>>女
			<br>
			生年月日:<input type="text" name="born" value="<%=born%>"> 
			<input type="submit" value="送信">
		</form>

		<br>
		<%if(list != null && list.size()>0){%>
		<table>
			<tr><th>名前</th><th>性別</th><th>生年月日</th><th></th></tr>
			<%for(User_info u : list) {%>
			<tr>
				<td><%=u.getName() %></td>
				<td><%=u.getSex() %></td>
				<td><%=u.getBorn() %></td>
				<td><a href="/user_mgm/main?action=update&id=<%=String.valueOf(u.getId()) %>" class="btn btn-primary">更新</a></td>
				<td><a href="/user_mgm/main?action=delete&id=<%=String.valueOf(u.getId()) %>" class="btn btn-danger" onclick="return confirm('削除してよろしいですか？');">削除</a></td>
			</tr>
			<%} %>
		</table>
		<%} %>
	</body>
</html>