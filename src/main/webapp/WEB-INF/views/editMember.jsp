<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.gtplus.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Member</title>
</head>
<body>
    <h2>Edit Member</h2>
    <form action="updateMember" method="post">
        <input type="hidden" name="id" value="${member.id}">
        <label for="id">ID: </label>
        <input type="text" id="id" name="id" value="${member.id}" readonly>
        <br>
        <label for="pwd">New Password: </label>
        <input type="text" id="pwd" name="pwd" value="${member.pwd}">
        <br>
        <label for="name">New Name: </label>
        <input type="text" id="name" name="name" value="${member.name}">
        <br>
        <input type="submit" value="Update">
    </form>
</body>
</html>