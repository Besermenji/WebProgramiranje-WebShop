<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Izmena salona</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
	<!--script src="js/less-1.3.3.min.js"></script-->
	<!--append â#!watchâ to the browser URL, then refresh the page. -->
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/smoke.min.css" rel="stylesheet">
	<link href="css/addSalonStyle.css" rel="stylesheet">

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
	<!--  <script type="text/javascript" src="js/addSalonScripts.js"></script> -->
	
</head>

<body>

		<input type="hidden" id="user_id" value="${user}"></input>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h2 class="text-info">
			Black Magic Woman - PRODAVNICA NAMESTAJA
			</h2>
			<h4 class="text-info"> Rad sa salonima - dodavanje salona</h4>
			<br>
			<br>
			<br>
			<form id="back_form" action="SalonStartServlet" method="post">
						<input type="hidden" name="user_id" value="${user}"></input>
			</form>
			<button id="rad_saloni" class="btn btn-default" type="submit" form="back_form">
							 Povratak
			</button> 
			
			<br>
			<br>
			<form  id="coki" role="form" method="post" action="SalonStartServlet">
				
				<!-- PIB input-->
				<div class="form-group">
				  <label  for="textinput">PIB</label>  
				  <div>
				  <input value="${s.pib}" id="pib" name="pib" placeholder="Unesite pib salona" class="form-control input-md" smk-type="number" minlength="9" maxlength="9"  type="text" required
				  ${r}>  
				  </div>
				</div>
				
				<!-- NAZIV input-->
				<div class="form-group">
				  <label  for="textinput">Naziv salona</label>  
				  <div>
				  <input value="${s.name}" id="name" name="name" placeholder="Unesite naziv salona" class="form-control input-md" type="text" required>  
				  </div>
				</div>
				
				<!-- MB input-->
				<div class="form-group">
				  <label  for="textinput">Maticni broj</label>  
				  <div>
				  <input ${r} value="${s.mb}"  id="mb" name="mb" placeholder="Unesite maticni broj salona" smk-type="number" minlength="13" maxlength="13" class="form-control input-md" type="text" required>  
				  </div>
				</div>
				
				<!-- ADRESA input-->
				<div class="form-group">
				  <label  for="textinput">Adresa salona</label>  
				  <div>
				  <input value="${s.adress}" id="adress" name="adress" placeholder="Unesite adresu salona" class="form-control input-md" type="text" required>  
				  </div>
				</div>
				
				<!-- TELEFON input-->
				<div class="form-group">
				  <label  for="textinput">Telefon salona</label>  
				  <div>
				  <input value="${s.phone}" id="phone" name="phone" placeholder="Unesite telefon salona" class="form-control input-md" type="text" required>  
				  </div>
				</div>
				
				<!-- EMAIL input-->
				<div class="form-group">
				  <label  for="textinput">Email salona</label>  
				  <div>
				  <input value="${s.email}" id="email" name="email" placeholder="Unesite email salona" class="form-control input-md" type="email" required>  
				  </div>
				</div>
				
				<!-- WWW input-->
				<div class="form-group">
				  <label  for="textinput">Web stranica salona</label>  
				  <div>
				  <input value="${s.www}" id="www" name="www" placeholder="Unesite web stranicu salona" class="form-control input-md" type="text" required>  
				  </div>
				</div>
				
				
				<!-- BZR input-->
				<div class="form-group">
				  <label  for="textinput">Ziro racun salona</label>  
				  <div>
				  <input ${r} value="${s.bzr}" id="bzr" name="bzr" placeholder="Unesite ziro racun salona" class="form-control input-md" type="text" required>  
				  </div>
				</div>
				
						<input type="hidden" name="user_id" value="${user}"></input>
				
				

				 <button  name="salonButtonIzmeni"  id="dugme" type="submit" class="btn btn-default">Izmeni salon</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>
