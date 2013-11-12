<%-- 
    Document   : mobilelogin, Created: 08-Nov-2013, 11:47:00
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
                $.mobile.page.prototype.options.addBackBtn = true;
            });
        </script>
    </head>
    <body>
        <div data-role="page" data-theme="b" data-add-back-btn="true">

            <div data-role="header">
                <h1>Daily Banking</h1>
            </div>

            <div data-role="content">
                <h3>Logon</h3><hr/>
                <form action='Controller'>
                <div data-role="fieldcontain" > 
                    <label for="username" class="ui-hidden-accessible">Username</label>
                    <input type="text" name="username" id="username" value="" 
                           placeholder="username"/>
                </div>
                <div data-role="fieldcontain" > 
                    <label for="password" class="ui-hidden-accessible">Password</label>
                    <input type="password" name="password" id="password" value="" 
                           placeholder="password"/>
                </div>
                <input type='submit' value='login'>
                <input type='hidden' name='command' value='mobileLogin'>;
                </form>
            </div>

            <div data-role="footer" data-position="fixed"> <!-- Add data-position="fixed" to align to button -->
                <h4>My Footer</h4>
            </div>
        </div>
    </body>
</html>