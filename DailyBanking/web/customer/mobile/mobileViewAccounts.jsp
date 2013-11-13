<%-- 
    Document   : mobilelogin, Created: 08-Nov-2013, 11:47:00
    Author     : Aaron, Kris, Lars, Timea
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <p>${username} is currently logged in</p>

                <div>
                    <c:forEach var="custAccount" items="${custAccounts}">
                        <table>
                            <tr>
                                <th>Account ID</th>
                                <th>Account Type</th>
                                <th>Account Balance</th>
                            </tr>
                            <tr>
                                <td>${custAccount.accountId}</td>
                                <td>${custAccount.accountType}</td>
                                <td>${custAccount.balance}</td>
                                <td><a href="Controller?accountid=${custAccount.accountId}&command=mobileAccountHistory&username=${username}&userid=${userid}">Account history</a></td>
                            </tr>
                        </table>
                    </c:forEach>
                </div>

                <div>
                    <%--<a href="Controller?accountid=${account.accountId}&username=${username}&userid=${userid}&command=customerAccountHistory">View Transaction's</a>--%>

                    <a href="Controller?accountid=${account.accountId}&username=${username}&userid=${userid}&command=customerCreateTransfer">Make Transfer</a>
                </div>

                

            </div>

            <div data-role="footer" data-position="fixed"> <!-- Add data-position="fixed" to align to button -->
                <h4><a href="Controller?command=mobileLogout">Log out</a></h4>
            </div>

        </div>
    </body>
</html>