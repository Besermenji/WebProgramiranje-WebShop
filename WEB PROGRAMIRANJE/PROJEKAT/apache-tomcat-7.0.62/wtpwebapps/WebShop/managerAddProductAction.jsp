<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Dodavanje akcije</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
	<!--script src="js/less-1.3.3.min.js"></script-->
	<!--append ÃÂÃÂ¢ÃÂÃÂÃÂÃÂ#!watchÃÂÃÂ¢ÃÂÃÂÃÂÃÂ to the browser URL, then refresh the page. -->
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/smoke.min.css" rel="stylesheet">
	<link href="css/addProductStyle.css" rel="stylesheet">

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="img/favicon.png">
  
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/smoke.min.js"></script>
	<script type="text/javascript" src="js/managerAddProductActionScripts.js"></script> 
	<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="js/callback.js"></script>
	<script type="text/javascript" src="js/loginCheckScript.js"></script>
	
	
</head>

<body>

		<input type="hidden" id="user_id" value="${user}"></input>


<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h2 class="text-info">
			Black Magic Woman - PRODAVNICA NAMESTAJA
			</h2>
			<h4 class="text-info"> Rad sa namestajem - dodavanje namestaja</h4>
			<br>
			<br>
			<form  id="back" method="get" action="managerStartPage.jsp">
						 		<input type="hidden" name="user" value="${user}"></input>
						 </form>
						<button id="bbb" class="btn btn-default" type="submit" form="back">
							 Pocetna admin strana
						</button>
			
			<br>			
			<br>
			<form  id="coki" role="form" method="post" action="ProductStartServlet">
				
				
				
				
				
				<!-- KATEGORIJA input-->
				<div class="form-group">
				  <label  for="textinput">Izaberi namestaj za akciju</label>  
				  <div>
				         <select id="category" name="category" class="form-control" required>
							<option value="">Izaberite namestaj</option>
							<c:forEach items="${category}" var="k">
							
								<option value="${k.name}">${k.name}</option>
							
							</c:forEach>
							
						</select>
 
				  </div>
				</div>
				
				
				<!-- AKCIJA input-->
				<div class="form-group">
				  <label  for="textinput">Da li je na akciji?</label>  
				  <div>
				         <select id="action" name="action" class="form-control" required>
							<option value="">Izaberite:</option>
							<option value="da">da</option>
							<option value="ne">ne</option>
						</select>
 
				  </div>
				</div>
				
				
				<!-- STARTDATE input-->
				<div class="form-group" id="start">
				  <label  for="textinput">Datum pocetka akcije</label>  
				  <div class="hero-unit">
				  <input id="startDate" name="startDate" placeholder="Kliknite za izbor datuma"  type="text">  
				  </div>
				</div>
				
				<!-- ENDDATE input-->
				<div class="form-group" id="end">
				  <label  for="textinput">Datum kraja akcije</label>  
				  <div class="hero-unit">
				  <input id="endDate" name="endDate" placeholder="Kliknite za izbor datuma"  type="text">  
				  </div>
				</div>
				
				<!-- AKCIJA input-->
				<div class="form-group" id="akcija">
				  <label  for="textinput">Procenat popusta?</label>  
				  <div>
				         <select id="percent" name="percent" class="form-control">
							<option value="">Izaberite:</option>
							<option value="10">10%</option>
							<option value="20">20%</option>
							<option value="30">30%</option>
							<option value="40">40%</option>
							<option value="50">50%</option>
							<option value="60">60%</option>
							<option value="70">70%</option>
							<option value="80">80%</option>
							<option value="90">90%</option>
							
						</select>
 
				  </div>
				</div>
														<input type="hidden" name="cat_ac" value="namestaj"></input>
														<input type="hidden" name="user_id" value="${user}"></input>
				
				

				 <button  name="salonButton"  id="dugme" type="submit" class="btn btn-default">Dodaj Akciju</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>
