<%-- 
    Document   : index
    Created on : 20 janv. 2022, 13:06:57
    Author     : farouk228
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des réservations</title>
        <link rel="shortcut icon" href="images/logo.png">
        <style>
            html,
            body * {
                box-sizing: border-box;
                font-family: 'Open Sans', sans-serif
            }

            body {
                background: linear-gradient(rgba(246, 247, 249, 0.8), rgba(246, 247, 249, 0.8)), url(images/reservation.jpg) no-repeat center center fixed;
                background-size: cover
            }

            .container {
                width: 100%;
                padding-top: 60px;
                padding-bottom: 100px
            }

            .frame {
                height: 650px;
                width: 900px;
                overflow: auto;
                background: linear-gradient(rgba(35, 43, 85, 0.75), rgba(35, 43, 85, 0.95)), url(images/reservation.jpg) no-repeat center center;
                background-size: cover;
                margin-left: auto;
                margin-right: auto;
                border-top: solid 1px rgba(255, 255, 255, .5);
                border-radius: 5px;
                box-shadow: 0px 2px 7px rgba(0, 0, 0, 0.2);
                overflow: hidden;
                transition: all .5s ease
            }


            h1 {
                color: #ffffff;
                font-size: 35px;
                font-weight: bold;
                text-align: center
            }
            span{
                color:white;
                text-align: center;
            }

            table, tr, td, th{
                border: 1px solid white ;
                text-align:center;
                color:white;
            }
            td, th{
                width:20%;
                padding: 10px;
            }

            table{
                border-collapse: collapse;
                width: 90%;
                margin:auto;
            }
            a{
                color:#232B55;
                background-color: white;
                border-radius: 10px;
                border:none;
                padding: 10px;
                text-decoration: none;
                font-weight: bold;
                
                margin: 10px;
            }
            .left-position{
                float: left;
            }
            
            .right-position{
                float: right;
                color: green;
            }



        </style>
    </head>
    <body>
        <div class="container">
            <div class="frame">
                <br>
                <a href="${pageContext.request.contextPath}" class="left-position">Retourner à l'accueil</a>
                <a href="${pageContext.request.contextPath}/add-reservation" class="right-position">Ajouter une reservation</a>
                <br><br><br>
                <h1>Liste des réservations</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Chambre</th>
                            <th>Date de reservation</th>
                            <th>Prix</th>
                            <th>Nombre de jours</th>
                            <th>Date de départ</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listeReservations}" var="reservation">
                            <tr>
                                <td>${reservation.chambre.getNumero()}</td><!-- comment -->
                                 <td>${reservation.getDateReservation()}</td><!-- comment -->
                                <td>${reservation.getPrixTotal()} euros</td><!-- comment -->
                                <td>${reservation.getNbreJours()}</td><!-- comment -->
                               <td>${reservation.getDateDepart()}</td><!-- comment -->
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            </div>
    </body>
</html>