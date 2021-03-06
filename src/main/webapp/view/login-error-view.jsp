<%-- 
    Document   : login-failed
    Created on : Nov 18, 2020, 8:43:06 PM
    Author     : fadli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <!-- Optional CSS -->
        <style>
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


        <title>Login Failed!</title>
    </head>
    <body class="bg-dark">
        
        <!-- jumbotron -->
        <div class="jumbotron jumbotron-fluid mt-4 bg-dark">
            <div id="home">
                <div class="container pt-5">
                    <div class="row mt-5 mb-5">
                        <div class="col-md-12 mt-2 text-center">
                            <h1 class="display-4 text-white">Login Failed, please try again!</h1><br/>
                            <a href="login" style="text-decoration: none; color: black;"><button type="button" class="btn btn-warning">Go To Sign In Page</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End jumbotron -->
    
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
        <!-- Akhir Footer -->
        
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
