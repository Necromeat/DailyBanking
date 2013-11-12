<%-- 
    Document   : mobileCustomerIndex
    Created on : Nov 12, 2013, 11:23:06 AM
    Author     : angeloron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.1/jquery.mobile-1.2.1.min.css" />
        <script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.2.1/jquery.mobile-1.2.1.min.js"></script>
        <script>
            $(document).bind('mobileinit', function() {
                $.mobile.page.prototype.options.addBackBtn = true;
            });
        </script>
    </head>
    <div >
        <p id="username">${username} is currently logged in</p>
        <a href="Controller?userid=${userid}&username=${username}&command=mobileCustomerViewDetails">Your Bank Profile</a>

    </div>
</html>
