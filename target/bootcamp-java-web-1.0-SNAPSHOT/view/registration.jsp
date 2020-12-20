<%-- 
    Document   : registration
    Created on : Nov 21, 2020, 10:15:18 AM
    Author     : fadli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Registration page</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        
        <!-- optional css -->
        <style>
            
            html {
                height: 100%;
            }
            body {
                height: 100%;
                margin: 0;
                background-repeat: no-repeat;
                background-attachment: fixed;
            }

            /* Text Align */
            .text-c {
                text-align: center;
            }
            .text-l {
                text-align: left;
            }
            .text-r {
                text-align: right
            }
            .text-j {
                text-align: justify;
            }

            /* Text Color */
            .text-whitesmoke {
                color: whitesmoke
            }
            .text-darkyellow {
                color: rgba(255, 235, 59, 0.432)
            }

            /* Lines */

            .line-b {
                border-bottom: 1px solid #FFEB3B !important;
            }

            /* Buttons */
            .button {
                border-radius: 3px;
            }
            .form-button {
                background-color: rgba(255, 235, 59, 0.24);
                border-color: rgba(255, 235, 59, 0.24);
                color: #e6e6e6;
            }
            .form-button:hover,
            .form-button:focus,
            .form-button:active,
            .form-button.active,
            .form-button:active:focus,
            .form-button:active:hover,
            .form-button.active:hover,
            .form-button.active:focus {
                background-color: rgba(255, 235, 59, 0.473);
                border-color: rgba(255, 235, 59, 0.473);
                color: #e6e6e6;
            }
            .button-l {
                width: 100% !important;
            }

            /* Margins g(global) - l(left) - r(right) - t(top) - b(bottom) */

            .margin-g {
                margin: 15px;
            }
            .margin-g-sm {
                margin: 10px;
            }
            .margin-g-md {
                margin: 20px;
            }
            .margin-g-lg {
                margin: 30px;
            }

            .margin-l {
                margin-left: 15px;
            }
            .margin-l-sm {
                margin-left: 10px;
            }
            .margin-l-md {
                margin-left: 20px;
            }
            .margin-l-lg {
                margin-left: 30px;
            }

            .margin-r {
                margin-right: 15px;
            }
            .margin-r-sm {
                margin-right: 10px;
            }
            .margin-r-md {
                margin-right: 20px;
            }
            .margin-r-lg {
                margin-right: 30px;
            }

            .margin-t {
                margin-top: 15px;
            }
            .margin-t-sm {
                margin-top: 10px;
            }
            .margin-t-md {
                margin-top: 20px;
            }
            .margin-t-lg {
                margin-top: 30px;
            }

            .margin-b {
                margin-bottom: 15px;
            }
            .margin-b-sm {
                margin-bottom: 10px;
            }
            .margin-b-md {
                margin-bottom: 20px;
            }
            .margin-b-lg {
                margin-bottom: 30px;
            }

            /* Bootstrap Form Control Extension */

            .form-control,
            .border-line {
                background-color: #5f5f5f;
                background-image: none;
                border: 1px solid #424242;
                border-radius: 1px;
                color: inherit;
                display: block;
                padding: 6px 12px;
                transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
                width: 100%;
            }
            .form-control:focus,
            .border-line:focus {
                border-color: #FFEB3B;
                background-color: #616161;
                color: #e6e6e6;
            }
            .form-control,
            .form-control:focus {
                box-shadow: none;
            }
            .form-control::-webkit-input-placeholder { color: #BDBDBD; }

            /* Container */

            .container-content {
                background-color: #3a3a3aa2;
                color: inherit;
                padding: 15px 20px 20px 20px;
                border-color: #FFEB3B;
                border-image: none;
                border-style: solid solid none;
                border-width: 1px 0;
            }

            /* Backgrounds */

            .main-bg {

                background: #424242;
                background: linear-gradient( #424242, #212121);
            }

            /* Login & Register Pages*/

            .login-container {
                max-width: 400px;
                z-index: 100;
                margin: 0 auto;
                padding-top: 100px;
            }
            .login.login-container {
                width: 300px;
            }
            .wrapper.login-container {
                margin-top: 140px;
            }
            .logo-badge {
                color: #e6e6e6;
                font-size: 80px;
                font-weight: 800;
                letter-spacing: -10px;
                margin-bottom: 0;
            }
            
            footer {
                width: 100%;
                height: 50px;
                bottom: 0;
                background-color: #333;
                position: absolute;
            }

            footer p {
                color: cornsilk;
            }
            
            .jumbotron {
                padding-top: 7%;
            }
        </style>
        
    </head>
    
    <body class="bg-dark pt-5">
        
        <!-- Form Register -->
        <div class="login-container text-c animated flipInX mt-5">
            <h3 class="text-whitesmoke">SIGN UP</h3>
            <div class="container-content">
                <form class="margin-t" action="register" method="post" onsubmit="validateForm()">
                    <p id="error" style="color: white">${error}</p>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Email" required="" name="userName" value="${userName}">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Password" required="" name="password">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Confirm Password" required="" name="confirmPassword">
                    </div>
                    <button type="submit" class="form-button button-l margin-b">Register</button>
                </form>
                <p class="text-whitesmoke text-center"><small>have an account?</small></p>
                <a class="text-darkyellow" href="login"><button class="form-button button-l margin-b">Sign In</button></a>
            </div>
        </div>
        <!-- End Form Register -->
        
        <!-- Footer -->
        <footer class="footer" id="footer">
            <div class="container">
                <div class="row text-center pt-2">
                    <div class="col-sm-12">
                        <p>&copy; copyright 2020 | build by Muhammad Fadlil</p>
                    </div>
                </div>
            </div>
        </footer>
        <!-- End Footer -->
        
        <!-- Optional JavaScript; choose one of the two! -->
        <script>
            function validateForm() {
                const validForm = validateUserNameAsEmailAddress() && validatePasswordAndConfirmPasswordIsTheSame();
                if( !validForm ) {
                    event.preventDefault();
                    // error selector
                    const errorBuffer = document.getElementById("error");
                    if (!validateUserNameAsEmailAddress()){
                        errorBuffer.innerHTML = "UserName can not be empty, and shoould be a valid email address!";
                    } else {
                        errorBuffer.innerHTML = "Password and Confirm password is not match or can not be Empty!";
                    }
                } else {
                    return validForm;
                }
            }
            
            function validateUserNameAsEmailAddress() {
                const emailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
                const userName = document.getElementsByName("userName")[0].value;
                if ( userName && emailRegex.test(userName) ) {
                    return true;
                } else {
                    return false;
                }
            }
            
            function validatePasswordAndConfirmPasswordIsTheSame() {
                // validate password and confirm password is the same value
                const password = document.getElementsByName("password")[0].value;
                const confirmPassword = document.getElementsByName("confirmPassword")[0].value;
                if ( password && password === confirmPassword ) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>
        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    </body>
</html>
