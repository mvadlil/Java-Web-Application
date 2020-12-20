<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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

        <title>Manage Person</title>
    </head>
    <body class="bg-dark">
        
        <!-- Navbar -->
        <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand JQuery-scroll" href="">${userName}</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-link JQuery-scroll" href="logout">LOG OUT</a>
                    </div>
                </div>
            </div>
        </nav>
        <!-- Akhir Navbar -->
        
        <!-- jumbotron -->
        <div class="jumbotron jumbotron-fluid bg-dark">
            <div id="home">
                <div class="container">
                    <div class="row mb-5">
                        <div class="col-md-12 text-center">
                            <h1 class="display-4 text-white">Table of Person</h1><br/>
                            <table class="table table-striped table-dark">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">USERNAME</th>
                                        <th scope="col">DELETE</th>
                                        <th scope="col">UPDATE</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var = "person" items="${persons}">
                                        <tr>
                                            <th scope="row">${person.id}</th>
                                            <td>${person.name}</td>
                                            <td><a href="delete?id=${person.id}" onclick="deletePerson('${person.id}')"><button type="button" class="btn btn-danger">Delete Person</button></a></td>
                                            <td><a href="update?id=${person.id}"><button type="button" class="btn btn-warning">Update Person</button></a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                              </table>
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
        <script>
            function deletePerson(id) {
                event.preventDefault();
                if ( confirm("Are you sure to delete this data?") ) {
                    // actual detele here using ajax request to delete url
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function() {
                        if (this.readyState === 4 && this.status ===200) {
                            alert("success deleting data");
                            location.reload();
                        }
                    };
                    xmlhttp.open("GET", "delete?id=" + id, true);
                    xmlhttp.send();
                } else {
                    return false;
                }
            }
        </script>
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
