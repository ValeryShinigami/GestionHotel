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
        <title>Editer une chambre</title>
        <link rel="shortcut icon" href="images/logo.png">
        <style>
            html,
            body * {
                box-sizing: border-box;
                font-family: 'Open Sans', sans-serif
            }

            body {
                background: linear-gradient(rgba(246, 247, 249, 0.8), rgba(246, 247, 249, 0.8)), url(images/hotel.jpg) no-repeat center center fixed;
                background-size: cover
            }

            .container {
                width: 100%;
                padding-top: 60px;
                padding-bottom: 100px
            }

            .frame {
                height: 595px;
                width: 430px;
                background: linear-gradient(rgba(35, 43, 85, 0.75), rgba(35, 43, 85, 0.95)), url(images/hotel.jpg) no-repeat center center;
                background-size: cover;
                margin-left: auto;
                margin-right: auto;
                border-top: solid 1px rgba(255, 255, 255, .5);
                border-radius: 5px;
                box-shadow: 0px 2px 7px rgba(0, 0, 0, 0.2);
                overflow: hidden;
                transition: all .5s ease
            }

            .form-signin {
                width: 430px;
                height: 375px;
                font-size: 16px;
                font-weight: 300;
                padding-left: 37px;
                padding-right: 37px;
                padding-top: 10px;
                transition: opacity .5s ease, transform .5s ease
            }

            .success {
                background-color: green;
                border-radius: 10px;
                height: 70px;
                padding: 10px;
                text-align: center;
            }


            .successtext {
                color: #ffffff;
                font-size: 16px;
                font-weight: 300;
            }

            .form-signin input,.form-signin textarea {
                color: #ffffff;
                font-size: 13px
            }

            .form-styling {
                width: 100%;
                height: 35px;
                padding-left: 15px;
                border: none;
                border-radius: 20px;
                margin-bottom: 20px;
                background: rgba(255, 255, 255, .2)
            }

            .form-styling-textarea {
                width: 100%;
                height: 70px;
                padding-left: 15px;
                border: none;
                border-radius: 20px;
                margin-bottom: 20px;
                background: rgba(255, 255, 255, .2)
            }

            label {
                font-weight: 400;
                text-transform: uppercase;
                font-size: 13px;
                padding-left: 15px;
                padding-bottom: 10px;
                color: rgba(255, 255, 255, .7);
                display: block
            }

            :focus {
                outline: none
            }

            .form-signin input:focus,
            textarea:focus,
            .form-signup input:focus,
            textarea:focus {
                background: rgba(255, 255, 255, .3);
                border: none;
                padding-right: 40px;
                transition: background .5s ease
            }



            .btn-signin {
                float: left;
                padding-top: 8px;
                width: 100%;
                height: 45px;
                color:#232B55;
                font-weight: bold;
                font-size: 20px;
                border: none;
                border-radius: 20px;
                margin-top: -10px
            }

            .btn-animate {
                float: left;
                font-weight: 700;
                text-transform: uppercase;
                font-size: 13px;
                text-align: center;
                color: rgba(255, 255, 255, 1);
                padding-top: 8px;
                width: 100%;
                height: 35px;
                border: none;
                border-radius: 20px;
                margin-top: 23px;
                background-color: rgba(16, 89, 255, 1);
                left: 0px;
                top: 0px;
                transition: all .5s ease, top .5s ease .5s, height .5s ease .5s, background-color .5s ease .75s
            }
            button.btn-signin:hover {
                cursor: pointer;
                background-color: black;
                color:white;
                transition: background-color .5s
            }

            h1 {
                color: #ffffff;
                font-size: 35px;
                font-weight: bold;
                text-align: center
            }


            .left-position{
                color:#232B55;
                background-color: white;
                border-radius: 10px;
                border:none;
                padding: 10px;
                text-decoration: none;
                font-weight: bold;

                margin: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="frame">
                <br>
                <a href="${pageContext.request.contextPath}/chambres" class="left-position">Retourner</a>
                <br><br>
                <h1>Editer une chambre</h1>

                <form class="form-signin" action="${pageContext.request.contextPath}/edit-chambre?id=${chambre.id}"
                      method="post" name="form"> 

                    <label for="numero">Numéro de chambre</label> 
                    <input class="form-styling" type="text" value="${chambre.numero}" name="numero"
                           placeholder="Tapez le numéro de chambre" required /> 

                    <label for="prix">Prix</label> 
                    <input class="form-styling" type="text" name="prix" value="${chambre.prix}" 
                           placeholder="Renseignez le prix" required/> 

                    <label for="description">Description</label> 
                    <textarea class="form-styling-textarea" name="description" 
                              placeholder="Description de la chambre..." rows="3" required>${chambre.description}</textarea> 

                    <div class="btn-animate"> <button type="submit" class="btn-signin">Modifier</button> </div>
                </form>

            </div>
            </div>
    </body>
</html>