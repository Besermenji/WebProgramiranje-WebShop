<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Izmena kategorije</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
	<!--script src="js/less-1.3.3.min.js"></script-->
	<!--append Ã¢ÂÂ#!watchÃ¢ÂÂ to the browser URL, then refresh the page. -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/smoke.min.css" rel="stylesheet">
	<link href="css/addCategoryStyle.css" rel="stylesheet">

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
	<script type="text/javascript" src="js/loginCheckScript.js"></script>
	
	<!--<script type="text/javascript" src="js/addCategoryScripts.js"></script>-->
	
</head>

<body>

		<input type="hidden" id="user_id" value="${user}"></input>


<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h2 class="text-info">
			Black Magic Woman - PRODAVNICA NAMESTAJA
			</h2>
			<h4 class="text-info"> Rad sa salonima - dodavanje kategorije</h4>
			<br>
			<br>
			<br>
			<form id="back_form" action="CategoryStartServlet" method="post">
						<input type="hidden" name="user_id" value="${user}"></input>
			</form>
			<button id="rad_saloni" class="btn btn-default" type="submit" form="back_form">
							 Povratak
			</button> 
			
			<br>
			<br>
			<form  id="coki" role="form" method="post" action="CategoryStartServlet">
				
				<!-- NAZIV input-->
				<div class="form-group">
				  <label  for="textinput">Naziv kategorije</label>  
				  <div>
				  <input id="name" name="name" value="${c.name}" ${r} placeholder="Unesite naziv kategorije" class="form-control input-md" type="text" required>  
				  </div>
				</div>
				
				<!-- OPIS input-->
				<div class="form-group">
				  <label  for="textinput">Opis kategorije</label>  
				  <div>
				  <input value="${c.description}" id="description" name="description" placeholder="Unesite opis kategorije" class="form-control input-md" type="text" required>  
				  </div>
				</div>
				
				
				<!-- NAZIV input-->
				<div class="form-group">
				  <label  for="textinput">Naziv parent kategorije</label>  
				  <div>
				          <select id="inWhatCategory" name="inWhatCategory" class="form-control">
							<option value="${c.inWhatCategory}">${c.inWhatCategory}</option>
							<option value="">Nema parent</option>
							<c:forEach items="${category}" var="k">
							
								<option value="${k.name}">${k.name}</option>
							
							</c:forEach>
						</select>
 
				  </div>
				</div>
				
										<input type="hidden" name="user_id" value="${user}"></input>
				
				
				 <button  name="izmeni"  id="dugme" type="submit" class="btn btn-default">Izmeni kategoriju</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>
