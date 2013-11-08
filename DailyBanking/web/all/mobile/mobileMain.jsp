<%-- 
    Document   : mainMobileNA2, Created: 08-Nov-2013, 11:43:46
    Author     : Aaron, Kris, Lars, Timea
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>My Page</title> 
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.1/jquery.mobile-1.2.1.min.css" />
        <script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.2.1/jquery.mobile-1.2.1.min.js"></script>
        <script>
            $(document).bind('mobileinit', function() {
                $.mobile.page.prototype.options.addBackBtn = false;
            });
        </script>
    </head>
    <body>
        <div data-role="page" data-theme="b" data-add-back-btn="false">

            <div data-role="header">
                <h1>Daily Banking</h1>
            </div>

            <div data-role="content">
                <p>100 Downtown</p>
                <p>Big City</p>
                <p>3000</p>
                <p>email:info@dailybanking.dk</p>
                <p>Tel.<a href="tel:(+45)12345678">(+45)12345678</a></p>
                <p>Sms.<a href="sms:(+45)12345678" data-theme="a" data-role="button">(+45)12345678</a></p>
                <p>fax.(+45)22334455 </p>
                <a href="Controller?command=mobileLogin" data-role="button" data-transition='slide'>Login</a>
            </div>

            <div data-role="footer" data-position="fixed"> <!-- Add data-position="fixed" to align to button -->
                <h4>My Footer</h4>
            </div>
        </div>
    </body>
</html>