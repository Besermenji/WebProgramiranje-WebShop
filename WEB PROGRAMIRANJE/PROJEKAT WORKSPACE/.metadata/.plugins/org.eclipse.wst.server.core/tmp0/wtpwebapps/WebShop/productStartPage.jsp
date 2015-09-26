<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Namestaji</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/smoke.min.css" rel="stylesheet">
    <link href="css/productStartStyle.css" rel="stylesheet">
	
	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/smoke.min.js"></script>
    <script src="js/productStartScripts.js"></script>
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
			<h4 class="text-info"> Rad sa namestajima </h4>
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
						 <form  id="add" method="post" action="AddProductServlet">
						 	<input type="hidden" name="user_id" value="${user}"></input>
						 </form>
						<button id="dodaj" class="btn btn-default" type="submit" form="add">
							 Dodavanje namestaja
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
							Sifra
						</th>
						<th>
							Slika
						</th>
						<th>
							Naziv
						</th>
						<th>
							Boja
						</th>
						<th>
							Zemlja proizvodnje
						</th>
						<th>
							Naziv proizvodjaca
						</th>
						<th>
							Akcija
						</th>
						<th>
							Pocetak akcije
						</th>
						<th>
							Kraj akcije
						</th>
						<th>
							Popust u procentima
						</th>
						<th>
							Cena
						</th>
						<th>
							Kolicina na lageru
						</th>
						<th>
							Besplatna usluga
						</th>

						<th>
							Kategorija namestaja
						</th>
						<th>
							Godina proizvodnje
						</th>
						<th>
							Prodajni salon
						</th>
						<th>
							Youtube Video
						</th>
						

						<th>&nbsp;</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${products}" var="p" varStatus="pr">
				
				<tr id="${p.code}">
					<td>
					
						${p.code}
					</td>
					<td>
						<img width="50" height="50" class="slika" alt="Nema slike" src="${p.picture}"> 
					</td>
					<td>
						${p.name}
					</td>
					
					<td>
						${p.color}
					</td>
					<td>
						${p.origin}
					</td>
					<td>
						${p.producer}
					</td>
					<td>
						${p.action}
					</td>
					<td>
						${p.startDate}
					</td>
					<td>
						${p.endDate}
					</td>
					<td>
					
						${p.percent}
					</td>
					<td>
						
						${prices[pr.index]}
					</td>
				
					<td>
						${p.quantity}
					</td>
					<td>
						${p.freeService}
					</td>
					<td>
						${p.category}
					</td>
					<td>
						${p.productionYear}
					</td>
					<td>
						${p.salon}
					</td>
					<td>
						${p.video}
					</td>
					
							
					
					<td><form  id="${p.code} izm" method="post" action="ChangeProductServlet">
					<input type="hidden" name="code" value="${p.code}"></input>
					<input type="hidden" name="name" value="${p.name}"></input>
					<input type="hidden" name="color" value="${p.color}"></input>
					<input type="hidden" name="origin" value="${p.origin}"></input>
					<input type="hidden" name="producer" value="${p.producer}"></input>
					<input type="hidden" name="price" value="${p.price}"></input>
					<input type="hidden" name="quantity" value="${p.quantity}"></input>
					<input type="hidden" name="category" value="${p.category}"></input>
					<input type="hidden" name="productionYear" value="${p.productionYear}"></input>
					<input type="hidden" name="salon" value="${p.salon}"></input>
					<input type="hidden" name="picture" value="${p.picture}"></input>
					<input type="hidden" name="video" value="${p.video}"></input>
					<input type="hidden" name="action" value="${p.action}"></input>
					<input type="hidden" name="startDate" value="${p.startDate}"></input>
					<input type="hidden" name="endDate" value="${p.endDate}"></input>
					<input type="hidden" name="percent" value="${p.percent}"></input>
					<input type="hidden" name="freeService" value="${p.freeService}"></input>
					<input name="user_id" type="hidden" value="${user}"></input>
					
					</form></td>
					<td>
					
					<button  class="btn btn-default" type="submit" form="${p.code} izm">Izmeni</button></td>
					<td><button id="${p.code} brisanje" class="btn btn-default brisanje" type="button">Obrisi</button></td>
				</tr>
				
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>