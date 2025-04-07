<!-- member.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.example.gtplus.MemberVO" %>
<!-- member.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
</head>
<body>
    <h2>Member List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Password</th>
            <th>Name</th>
            <th>Edit</th>
        </tr>
        <% List<MemberVO> memberList = (List<MemberVO>) request.getAttribute("memberList");
           for (MemberVO member : memberList) { %>
        <tr>
            <td><%= member.getId() %></td>
            <td><%= member.getPwd() %></td>
            <td><%= member.getName() %></td>
            <td><a href="editMember?id=<%= member.getId() %>">Edit</a></td>
        </tr>
        <% } %>
    </table>
    
    <br>
    <a href="/registerMember">Register New Member</a>
</body>
</html>