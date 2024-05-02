<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>View Reports</title>
        <link rel="stylesheet" type="text/css" href="/resources/view.css">
        <link type="image/png" sizes="96x96" rel="icon" href="/resources/icons8-new-store-96.png">
    </head>

    <body>
        <h2>View Reports</h2>
        <fieldset>

            <form action="/sales/daily-report" method="get">
                <div class="input"><input class="view" type="submit" value="Daily Report"></div>
            </form>
            <br>
            <form action="/sales/weekly-report" method="get">
                <div class="input"><input class="view" type="submit" value="Weekly Report"></div>
            </form>
            <br>
            <form action="/sales/monthly-report" method="get">
                <div class="input"><input class="view" type="submit" value="Monthly Report"></div>
            </form>
            <br>
            <form action="/sales/quarterly-report" method="get">
                <div class="input"><input class="view" type="submit" value="Quarterly Report"></div>
            </form>
        </fieldset>
        <p><a href="/admin/menu"><input class="button" type="submit" value="Back"></a></p>
    </body>

    </html>