<!DOCTYPE html>
<%@ page import="java.io.*"%>
<html lang="es">

<head>
<meta charset="utf-8" />
<link rel=icon href="images/elastic.png" type="image/png">
<meta name="description"
	content="Página de descarga de Elastic Business">
<title>Elastic Business</title>
</head>

<body class="background">
	<div id="wrapper">
		<link rel="stylesheet" type="text/css" href="css/patron.css" />
		<link rel="stylesheet" type="text/css" href="css/navigator.css" />
		<link rel="icon" href="images/elastic.ico" />
		<jsp:include page="parametrosPatronResearch.jsp" />
		<script src="js/elastic.util.js"></script>
		<script src="https://java.com/js/deployJava.js"></script>

		<header>

			<div id="header">
				<nav id="nav">
					<ul id="navigation">
						<li class="dropdown"><a href="index.jsp" class="dropbtn"><img
								src="images/menu.png" width="50" height="50" /></a>
							<div class="dropdown-content">
								<%
                      ServletContext servletContext = request.getServletContext();
                      String file = servletContext.getRealPath("/webstart/changelog/");

                      File f = new File(file);
                      String [] fileNames = f.list();
                      File [] fileObjects= f.listFiles();

                      for (int i = 0; i < fileObjects.length; i++) {
                        if(!fileObjects[i].isDirectory() && fileNames[i].endsWith("txt")){
                    %>
								<a href="changelog.jsp?csv=<%=fileNames[i]%>"><%=fileNames[i].substring(0, fileNames[i].lastIndexOf('.'))%></a>
								<%
                        }
                      }
                    %>
							</div></li>
					</ul>
				</nav>

				<a href="http://www.imatia.com" target="_blank"> <img
					src="images/Imatia_logo.png" width="181" height="76" />
				</a> <img src="images/transparent.png" width="50" height="50" />
			</div>
			<div>
				<img src="images/curve_bar.png" width="100%" height="35px" />
			</div>
		</header>