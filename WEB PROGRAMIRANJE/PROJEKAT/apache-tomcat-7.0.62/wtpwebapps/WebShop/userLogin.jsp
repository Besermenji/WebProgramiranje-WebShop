<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Korisnicko logovanje</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
	<!--script src="js/less-1.3.3.min.js"></script-->
	<!--append ‘#!watch’ to the browser URL, then refresh the page. -->
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/smoke.min.css" rel="stylesheet">
	<link href="css/userLoginStyle.css" rel="stylesheet">

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
	<script type="text/javascript" src="js/userLoginScripts.js"></script>
</head>

<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3>
				Ulogujte se kao korisnik:
			</h3>
			<form role="form">
				<!-- Text input-->
				<div class="form-group">
				  <label  for="textinput">Korisnicko ime</label>  
				  <div>
				  <input id="username" name="textinput" placeholder="Unesite korisnicko ime" class="form-control input-md" type="text" required>  
				  </div>
				</div>

				<!-- Password input-->
				<div class="form-group">
				  <label  for="passwordinput">Lozinka</label>
				  <div >
					<input id="password" name="passwordinput" placeholder="Unesite lozinku" class="form-control input-md" type="password" required>
				  </div>
				  
				  
				
				</div> <button name="userButton" type="button" id="dugme" class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>
