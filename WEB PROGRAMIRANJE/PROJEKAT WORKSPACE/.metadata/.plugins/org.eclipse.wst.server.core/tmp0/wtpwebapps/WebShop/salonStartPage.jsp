<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Saloni</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/smoke.min.css" rel="stylesheet">
    <link href="css/salonStartStyle.css" rel="stylesheet">
	
	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/smoke.min.js"></script>
    <script src="js/salonStartScripts.js"></script>
    <script src="js/loginCheckScript.js" type="text/javascript"></script>

  </head>
  <body>
		<input type="hidden" id="user_id" value="${user}"></input>
	
    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h2 class="text-info">
			Black Magic Woman - PRODAVNICA NAMESTAJA
			</h2>
			<h4 class="text-info"> Rad sa salonima </h4>
		</div>
		
	</div>
	
	
	<br>
	<br>
	<br>
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-8">
					<div class="btn-group">
						 <form  id="add" method="post" action="AddSalonServlet">
						 		<input type="hidden" name="user_id" value="${user}"></input>
						 </form>
						<button id="dodaj" class="btn btn-default" type="submit" form="add">
							 Dodavanje salona
						</button>
						
						 
						 
					</div>
				</div>
				<div class="col-md-4">
					 
					 <form  id="back" method="get" action="adminStartPage.jsp">
						 		<input type="hidden" name="user" value="${user}"></input>
						 </form>
						<button id="bbb" class="btn btn-default" type="submit" form="back">
							 Pocetna admin strana
						</button>
					 
					<button id="logout_dugme" type="button" class="btn btn-default pull-right">
						Odjava sa sistema
					</button>
				</div>
			</div>
			<br>				
				
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>
							PIB
						</th>
						<th>
							Ime
						</th>
						<th>
							Maticni broj
						</th>
						<th>
							Adresa
						</th>
						<th>
							Telefon
						</th>
						<th>
							Email
						</th>
						<th>
							Web Stranica
						</th>
						<th>
							Broj ziro racuna
						</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${salons}" var="s">
				
				<tr id="${s.pib}">
					<td>
					
						${s.pib}
					</td>
					<td>
						${s.name}
					</td>
					<td>
						${s.mb}
					</td>
					<td>
						${s.adress}
					</td>
					<td>
						${s.phone}
					</td>
					
					<td>
						${s.email}
					</td>
					<td>
						<a href="${s.www}">${s.www}</a>
					</td>
					<td>
						${s.bzr}
					</td>
					
					
					<td><form  id="${s.pib} izm" method="post" action="ChangeSalonServlet">
					<input type="hidden" name="pib" value="${s.pib}"></input>
					<input type="hidden" name="name" value="${s.name}"></input>
					<input type="hidden" name="mb" value="${s.mb}"></input>
					<input type="hidden" name="adress" value="${s.adress}"></input>
					<input type="hidden" name="phone" value="${s.phone}"></input>
					<input type="hidden" name="email" value="${s.email}"></input>
					<input type="hidden" name="www" value="${s.www}"></input>
					<input type="hidden" name="bzr" value="${s.bzr}"></input>
					<input name="user_id" type="hidden" value="${user}"></input>
					</form></td>
					<td>
					
					<button  class="btn btn-default" type="submit" form="${s.pib} izm">Izmeni</button></td>
					<td><button id="${s.pib} brisanje" class="btn btn-default brisanje" type="button">Obrisi</button></td>
				</tr>
				
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>