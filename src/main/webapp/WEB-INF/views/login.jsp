<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <title>Admin Login</title>
        <link type="image/png" sizes="96x96" rel="icon" href="/resources/icons8-new-store-96.png">
        <link rel="stylesheet" type="text/css" href="/resources/form.css">
        <script src="/resources/functions.js"></script>
    </head>

    <body>
        <h2>Admin Login</h2>
        <form action="/admin/login" method="post">
            <fieldset>
                Username: <br><input type="text" name="username"><br><br>
                Password: <br><input type="password" id="password" name="password"><br>
                <input type="checkbox" id="showPassword" onclick="togglePassword()">
                <label for="showPassword">Show Password</label><br><br>
                <input class="button" type="submit" value="Login">
            </fieldset>
        </form>
        <p style="color: #ff5733;">${error}</p>
    </body>

    </html>