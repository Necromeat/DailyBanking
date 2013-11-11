<%@include file="../WEB-INF/jspf/header.jspf" %>
<script type="text/javascript">
            $(document).ready(function(){
                $("#addCustForm").validate({
                    rules: {
                        firstName: {minlength: 2},
                        lastName: {minlength: 2},
                        password: {minlength: 6}
                    }
                });
            });
</script>
<div id="main">

<div id="addcustpanel">
    <form action='Controller'>
        <label>First Name:</label><br>
        <input type="text" name="firstName" id="firstName"><br>
        <label>Last Name:</label><br>
        <input type="text" name="lastName" id="lastName"><br>
        <label>Email:</label><br>
        <input type="text" name="email" id="email"><br>
        <label>Password:</label><br>
        <input type="password" name="password" id="password"><br>
        <button name="submit">Submit</button>
        <input type="hidden" name="command" value="addCustomer">
    </form>
</div>
    
</div>

<%@include file="../WEB-INF/jspf/footer.jspf" %>
