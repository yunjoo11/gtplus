<!-- registerMember.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Member</title>
</head>
<body>
    <h2>Register Member</h2>
    <form action="registerMember" method="post">
        <label for="id">ID: </label>
        <input type="text" id="id" name="id">
        <br>
        <label for="pwd">Password: </label>
        <input type="text" id="pwd" name="pwd">
        <br>
        <label for="name">Name: </label>
        <input type="text" id="name" name="name">
        <br>
        <input type="submit" value="Register">
    </form>
</body>
</html>