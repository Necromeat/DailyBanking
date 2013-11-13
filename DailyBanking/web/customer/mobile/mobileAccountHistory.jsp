<%-- 
    Document   : mobilelogin, Created: 08-Nov-2013, 11:47:00
    Author     : Aaron, Kris, Lars, Timea
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
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
                <p id="username">${username} is currently logged in</p>

                <div id="basicPanel">
                    <h3>Account History for: </h3>
                    <h3>${account.accountType}&nbsp; - Account number: &nbsp;${account.accountId}</h3>
                    <%--<h3>Account Owner:&nbsp${account.owner.firstName}&nbsp${account.owner.lastName}</h3>
                    <a href="Controller?accountid=${account.accountId}&command=viewAccount">Account Details</a>--%> 
                </div>

                <div id="basicPanel">
                    <table>
                        <caption>${account.accountType}&nbsp;-&nbsp;${transaction.accountId}</caption>
                        <thead>
                            <tr><th>Date</th><th>Description</th><th>Amount</th><th>Balance</th></tr>
                        </thead>


                        <c:forEach var="item" items="${account.transactions}">
                            <tr>
                                <td><f:formatDate type="date" value="${today}"/></td>
                                <td>${item.info}</td>
                                <td><div itemid="L1"><f:formatNumber type="number"  minFractionDigits="2" maxFractionDigits="2" value="${item.amount}"/></div></td>
                                <td><div itemid="L1"><f:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.balance}"/></div></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

            <div data-role="footer" data-position="fixed"> <!-- Add data-position="fixed" to align to button -->
                <h4><a href="Controller?command=mobileLogout">Log out</a></h4>
            </div>

        </div>
    </body>
</html>