<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <title>Add Sale</title>
        <link type="image/png" sizes="96x96" rel="icon" href="/resources/icons8-new-store-96.png">
        <link rel="stylesheet" type="text/css" href="/resources/form.css">
    </head>

    <body>
        <h2>Add Sale</h2>
        <form action="/sales/add" method="post">
            <fieldset>
                Item Name: <input type="text" name="itemName"><br><br>
                Selling Price: <input type="text" name="sellingPrice"><br><br>
                Cost Price: <input type="text" name="costPrice"><br><br>
                <input class="button" type="submit" value="Submit">
            </fieldset>
        </form>
        <p><a href="/admin/menu"><input class="button" type="submit" value="Back"></a></p>
    </body>

    </html>
