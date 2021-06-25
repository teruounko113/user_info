<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
    
    
<%
List<User_info> list = (List<User_info>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザリスト</title>
</head>
<body>

<%if(list != null && list.size()>0){%>
<table>
<tr><th>名前</th><th>性別</th><th>更新日</th><th></th></tr>
<%for(User_info u : list) {%>
<tr>
	<td><%=u.getName() %></td><td><%=u.getSex() %></td>
	<td><%=u.getBorn() %></td>
	<td><a href="/user_mgm/main?action=update&id=<%=String.valueOf(u.getId()) %>" class="btn btn-primary">更新</a></td>
	<td><a href="/user_mgm/main?action=delete&id=<%=String.valueOf(u.getId()) %>" class="btn btn-danger" onclick="return confirm('削除してよろしいですか？');">削除</a></td>
</tr>
<%} %>
</table>
<%} %>

</body>
</html>