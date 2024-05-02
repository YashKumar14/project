<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <title>Admin Registration</title>
        <link type="image/png" sizes="96x96" rel="icon" href="/resources/icons8-new-store-96.png">
        <link rel="stylesheet" type="text/css" href="/resources/form.css">
    </head>

    <body>
        <h2>Admin Registration</h2>
        <form action="/admin/register" method="post">
            <fieldset>
                Username: <br><input type="text" name="username" required><br><br>
                Password: <br><input type="password" name="password"
                    pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@.#$%&*]).{8,16}$"
                    title="Must contain atleast one number,one uppercase,one lowercase,one special character(!@#$%&*) and atleast 8 and less than 16 characters"
                    required><br><br>
                Confirm Password: <br><input type="password" name="confirmPassword"><br><br>
                <input class="button" type="submit" value="Register">
                <span style="margin-left: 50px;"></span>
                <a href="/admin/login"><input class="button" type="button" value="Login"></a>
            </fieldset>
        </form>
        <p style="color: #ff5733;">${error}</p>
    </body>

    </html>