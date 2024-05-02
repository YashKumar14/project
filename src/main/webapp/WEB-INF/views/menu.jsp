<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Menu</title>
        <link rel="stylesheet" type="text/css" href="/resources/menu.css">
        <link type="image/png" sizes="96x96" rel="icon" href="/resources/icons8-new-store-96.png">
    </head>

    <body>
        <h2>Menu</h2>
        <fieldset>
            <form action="/sales/add" method="get">
                <div class="input"><input class="view" type="submit" value="Add Sales"></div>
            </form>
            <br>
            <form action="/sales/view-reports" method="get">
                <div class="input"><input class="view" type="submit" value="View Reports"></div>
            </form>
        </fieldset>
        <p><a href="/admin/logout"><input class="button" type="submit" value="Logout"></a></p>
    </body>

    </html>