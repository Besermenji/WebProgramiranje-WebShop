<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Izaberite vasu ulogu!</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="stranica u kojoj se bira uloga korisnika">
  <meta name="author" content="Besermenji">

	<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
	<!--script src="js/less-1.3.3.min.js"></script-->
	<!--append â#!watchâ to the browser URL, then refresh the page. -->
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/izborUlogaStyle.css" rel="stylesheet">

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
	<script type="text/javascript" src="js/izborUlogaScripts.js"></script>
</head>

<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3>
				Izaberite ulogu za logovanje:
			</h3>
			<br>
			<br>
			<br>
			<div class="row clearfix">
				<form  method="post" action="loginPageRedirectServlet">
				<div class="col-md-4 column">
					 <button name="user" type="submit" class="btn btn-lg">Korisnik</button>
				</div>
				<div class="col-md-4 column">
					 <button name="manager" type="submit" class="btn btn-lg">Menadzer</button>
				</div>
				<div class="col-md-4 column">
					 <button name="admin" type="submit" class="btn btn-lg">Administrator</button>
				</div>
				</form>
				
				<form method="post" action="InitServlet">
					<button type="submit">Inicijalizuj</button>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
