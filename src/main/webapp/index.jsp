<%-- 
    Document   : index
    Created on : 20 janv. 2022, 13:06:57
    Author     : farouk228
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Application de Gestion</title>
<link rel="shortcut icon" href="images/logo.png">
<style>
html, body * {
	box-sizing: border-box;
	font-family: 'Open Sans', sans-serif
}

body {
	background: linear-gradient(rgba(246, 247, 249, 0.8),
		rgba(246, 247, 249, 0.8)), url(images/hotel.jpg) no-repeat center
		center fixed;
	background-size: cover
}

.container {
	width: 100%;
	padding-top: 60px;
	padding-bottom: 100px
}

.frame {
	height: 575px;
	width: 430px;
	background: linear-gradient(rgba(35, 43, 85, 0.75),
		rgba(35, 43, 85, 0.95)), url(images/hotel.jpg) no-repeat center center;
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
	padding-top: 55px;
	transition: opacity .5s ease, transform .5s ease
}

.form-signin input, .form-signup input {
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

.form-signin input:focus, textarea:focus, .form-signup input:focus,
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
	height: 35px;
	border: none;
	border-radius: 20px;
	margin-top: -8px
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
	transition: all .5s ease, top .5s ease .5s, height .5s ease .5s,
		background-color .5s ease .75s
}

a.btn-signin:hover {
	cursor: pointer;
	background-color: #0F4FE6;
	transition: background-color .5s
}

h1 {
	color: #ffffff;
	font-size: 35px;
	font-weight: bold;
	text-align: center
}

a {
	color: #232B55;
	font-size: 28px;
	text-decoration: none;
	font-weight: bold;
}

.link-container {
	background-color: white;
	border-radius: 10px;
	height: 70px;
	padding: 20px;
	text-align: center;
	margin: 20px;
}

.copyright-container {
	text-align: center;
	margin-top: 90px;
}

span {
	color: white;
	text-align: center;
}

.center {
	text-align: center
}
</style>
</head>
<body>
	<div class="container">
		<div class="frame">

			<h1>Application de gestion</h1>
			<div style="text-align: center">
				<img src="images/logo.png" width="150" alt="alt" />
			</div>
			<div class="link-container">
				
				<a href="${pageContext.request.contextPath}/chambres">Gestion des chambres</a>
			</div>
			<br>
			<div class="link-container">
				<a href="${pageContext.request.contextPath}/reservations">Gestion des réservations</a>
			</div>
			<div class="copyright-container">
				<span>Copyright &copy; 2022 Valéry Kalombo </span>
			</div>

		</div>
	</div>
</body>
</html>