<%@include file="../WEB-INF/jspf/header.jspf" %>
<script type="text/javascript">
            $(document).ready(function(){
                $("#addCustForm").validate({
                    rules: {
                        firstName: {minlength: 2},
                        lastName: {minlength: 2},
                        password: {minlength: 6},
                        email:{required: true, email: true}
                        //, remote: "CheckEmailCommand"
                    }
                });
                $("#btn").click(function(){
                    $.ajax({
                              url: "CheckEmailCommand",
                              data: "email="+$(this).val(),
                              cache: false,
                              dataType: "text",
                              success: dataReady
                    });
                });
            });
            function dataReady(data){
                $("#feedback").val(data);
            }
</script>
<div id="main">
    <p id="username">${username} is currently logged in</p>

<div id="addcustpanel">
    <form action="Controller" id="addCustForm">
        <label>First Name:</label><br>
        <input type="text" name="firstName" id="firstName" class="required"><br>
        <label>Last Name:</label><br>
        <input type="text" name="lastName" id="lastName" class="required"><br>
        <label>Email:</label><br>
        <input type="email" name="email" id="email" class="required email"><label id="feedback"></label><br>
        <label>Password:</label><br>
        <input type="password" name="password" id="password" class="required"><br>
        <button name="submit" id="btn">Submit</button>
        <input type="hidden" name="command" value="addCustomer">
    </form>
</div>
    
</div>

<%@include file="../WEB-INF/jspf/footer.jspf" %>
