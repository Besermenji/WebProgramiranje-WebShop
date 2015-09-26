<!DOCTYPE jsp:useBean PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- iz dbPlay apdejtujemo kombo boxeve -->
<jsp:useBean id="db" class="beans.dbPlay" />
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Korpa</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/smoke.min.css" rel="stylesheet">
    <link href="css/adminStartStyle.css" rel="stylesheet">
	
	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/smoke.min.js"></script>
    <script src="js/basketScripts.js"></script>
   <script type="text/javascript" src="js/loginCheckScript.js"></script>

  </head>
  <body>
	<input type="hidden" id="user_id" value="${param.user}${u}"></input>
    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h2 class="text-info">
			Black Magic Woman - PRODAVNICA NAMESTAJA
			</h2>
		</div>
		
	</div>
	<br>
	<br>
	<br>
	
	<div class="row">
		<div class="col-md-12">
			<div "class="row">
				<div class="col-md-8">
				</div>
				<div class="col-md-4">
					  <form  id="back" method="get" action="userStartPage.jsp">
				
					  
						 		<input type="hidden" name="user" value="${param.user}"></input>
						 </form>
						<button id="bbb" class="btn btn-default" type="submit" form="back">
							 Povratak
						</button>
					
					 
					 
					 <button id="logout_dugme" type="button" class="btn btn-default pull-right">
						Odjava sa sistema
					</button>
					
				</div>
			</div>
			<br>
			<h4 id="naslov"></h4>
			<br>
			<table id="prikaz_korpa" class="table table-hover">
				<thead>
					<tr>
						<th>
							Naziv
						</th>
						<th>
							Cena
						</th>
						<th>&nbsp;</th>
						
						
					</tr>

				</thead>
				<tbody id="namestaj_bodi">
					
				</tbody>
			</table>
				
			<br>
			<p>Kupac: <b id="buyer"> </b> </p>
			<p>Datum kupovine: <b id="date"></b></p>
			<p>Vreme kupovine:<b id="time"></b></p>
			<br>
			<p>Porez: <b  id="taxes"></b><b>%</b></p>
			<p>Ukupno: <b id="total"></b><b> dinara</b></p>
				
			
		</div>
	</div>
</div>
<br>
<br>
<div><button id="show" class='btn btn-default kupi'>KUPI</button></div>
</body>
</html>