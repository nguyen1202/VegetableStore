<%-- 
    Document   : login
    Created on : Mar 7, 2022, 7:46:47 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>LOGIN PAGE</title>

        <!-- Meta-Tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="keywords" content="Existing Login Form Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- //Meta-Tags -->

        <link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />

        <!-- Style --> <link rel="stylesheet" href="css/style.css" type="text/css" media="all">

        <!-- Fonts -->
        <link href="//fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
        <!-- //Fonts -->

    </head>
    <!-- //Head -->

    <!-- Body -->
    <body>

        <h1>LOGGING FOR SHOPPING</h1>

        <div class="w3layoutscontaineragileits">
            <h2>Login here</h2>
            <form action="MainController" method="POST" onsubmit="return validateForm()">
                <input type="text" name="userID" required="" placeholder="userID"/>
                <input type="password" name="password" required="" placeholder="password"/>
                <ul class="agileinfotickwthree">
                    <li>
                        <input type="checkbox" id="brand1" value="">
                        <label for="brand1"><span></span>Remember me</label>
                        <a href="#">Forgot password?</a>
                    </li>
                </ul>
                <script src='https://www.google.com/recaptcha/api.js?hl=vi'></script>
                <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
                <div class="g-recaptcha" data-sitekey="6LfietMeAAAAAFCkqwzohGa6O6PrfUoSLJE5bVSH"></div><br/>
                <div class="g-signin2" data-onsuccess="onSignIn"></div><br/>
                <div class="aitssendbuttonw3ls">
                    <input type="submit" name="action" value="Login"/>
                    <p> To register new account <span>→</span> <a class="w3_play_icon1" href="#small-dialog1"> Click Here</a></p>
                    <div class="clear"></div>
                </div>
                <script type="text/javascript" >
                    function validateForm() {
                        if (grecaptcha.getResponse()) {
                            return true;
                        } else {
                            alert("You are a human!!! Not a robot :D check again");
                            return false;
                        }
                    }
                </script>
            </form>
        </div>

        <!-- for register popup -->
        <div id="small-dialog1" class="mfp-hide">
            <div class="contact-form1">
                <div class="contact-w3-agileits">
                    <h3>Register Form</h3>
                    <form action="#" method="post">
                        <div class="form-sub-w3ls">
                            <input placeholder="User Name"  type="text" required="">
                            <div class="icon-agile">
                                <i class="fa fa-user" aria-hidden="true"></i>
                            </div>
                        </div>
                        <div class="form-sub-w3ls">
                            <input placeholder="Email" class="mail" type="email" required="">
                            <div class="icon-agile">
                                <i class="fa fa-envelope-o" aria-hidden="true"></i>
                            </div>
                        </div>
                        <div class="form-sub-w3ls">
                            <input placeholder="Password"  type="password" required="">
                            <div class="icon-agile">
                                <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                            </div>
                        </div>
                        <div class="form-sub-w3ls">
                            <input placeholder="Confirm Password"  type="password" required="">
                            <div class="icon-agile">
                                <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                            </div>
                        </div>
                        <div class="login-check">
                            <label class="checkbox"><input type="checkbox" name="checkbox" checked="">I Accept Terms & Conditions</label>
                        </div>
                        <div class="submit-w3l">
                            <input type="submit" value="Register">
                        </div>
                    </form>
                </div>
            </div>	
        </div>
        <!-- //for register popup -->
        <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>

        <!-- pop-up-box-js-file -->  
        <script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
        <!--//pop-up-box-js-file -->
        <script>
                    $(document).ready(function () {
                        $('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
                            type: 'inline',
                            fixedContentPos: false,
                            fixedBgPos: true,
                            overflowY: 'auto',
                            closeBtnInside: true,
                            preloader: false,
                            midClick: true,
                            removalDelay: 300,
                            mainClass: 'my-mfp-zoom-in'
                        });
                    });
        </script>

    </body>
    <!-- //Body -->
    <div style="color: white; font-size: 50px; font-weight: bold;">
        <%
            String error = (String) request.getAttribute("ERROR");
            if (error == null) {
                error = "";
            }

        %>
        <%= error%></br>
    </div>

</html>