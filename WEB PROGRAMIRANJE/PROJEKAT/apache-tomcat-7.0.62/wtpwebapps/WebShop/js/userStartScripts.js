$(document).ready(function(){
	
	
	
	
	
	
	
	//ucitavamo komobo boxeve pocetne
	$.ajax({
        type: "POST",
        url:"SearchServlet",   // this is my servlet
        data:{"type":"init"},
    	dataType: 'json',
        success: function (data) {
        	for(var i = 0; i < data.length;i++){
        		
        		if(JSON.stringify(data[i].countries) != undefined){
        			for(var j = 0; j < data[i].countries.length;j++){
                		var tmp =JSON.stringify(data[i].countries[j].c_key);
                		var zemlja = tmp.substring(1, tmp.length-1);
                		$('#zemljeDD').append( new Option(zemlja,zemlja) );
        			}
        		}
        		else if(JSON.stringify(data[i].color) != undefined){
        			for(var j = 0; j < data[i].color.length;j++){
                		var tmp =JSON.stringify(data[i].color[j].color_key);
                		var boja = tmp.substring(1, tmp.length-1);
                		$('#bojeDD').append( new Option(boja,boja) );
        			}
        			
        		}
        		
        		else if(JSON.stringify(data[i].category) != undefined){
        			for(var j = 0; j < data[i].category.length;j++){
                		var tmp =JSON.stringify(data[i].category[j].category_key);
                		var kategorija = tmp.substring(1, tmp.length-1);
                		$('#kategorijeDD').append( new Option(kategorija,kategorija) );
        			}
        			
        		}
        		
        		else if(JSON.stringify(data[i].producer) != undefined){
        			for(var j = 0; j < data[i].producer.length;j++){
                		var tmp =JSON.stringify(data[i].producer[j].producer_key);
                		var producer = tmp.substring(1, tmp.length-1);
                		$('#producersDD').append( new Option(producer,producer) );
        			}
        			
        		}
        		
        		
        	}
        
        }
    });
	
	
	
	$("#prikaz_namestaj").hide();
	$("#prikaz_usluga").hide();
	
	$("#button_cena").click(function(){
		
		if(!$("form").smkValidate()){
			
		}
	}); 
	
$("#button_kolicina").click(function(){
		
		if(!$("form").smkValidate()){
			
		}
	}); 
	
$("#button_godina").click(function(){
	
	if(!$("form").smkValidate()){
		
	}
}); 

	
	$("#pretraga_namestaj").click(function(){
		
		
		
		$("#prikaz_namestaj").show();
		$("#prikaz_usluga").hide();
		$('#namestaj_bodi').find('tr').remove();
		var name = $("#namestaj_name").val();
		var max_cena = $("#max_cena").val();
		var min_cena = $("#min_cena").val();
		var min_kolicina = $("#min_kolicina").val();
		var max_kolicina = $("#max_kolicina").val();
		var kategorije = $("#kategorijeDD").val();
		var zemlja = $("#zemljeDD").val();
		var min_godina = $("#min_godina").val();
		var max_godina = $("#max_godina").val();
		var boja = $("#bojeDD").val();
		var proizvodjac = $("#producersDD").val();
		
		
		$.ajax({
	        type: "POST",
	        url:"SearchServlet",   // this is my servlet
	        data:{"type":"namestaj",
	        	"name":name,
	        	"max_cena":max_cena,
	        	"min_cena":min_cena,
	        	"min_kolicina":min_kolicina,
	        	"max_kolicina":max_kolicina,
	        	"kategorija":kategorije,
	        	"zemlja":zemlja,
	        	"min_godina":min_godina,
	        	"max_godina":max_godina,
	        	"boja":boja,
	        	"proizvodjac":proizvodjac
	        },
	    	dataType: 'json',
	        success: function (data) {
	        	for(var i = 0; i < data.length;i++){
	        		//alert(JSON.stringify(data[i]));
	        		
	        		//kolicina na lageru
	        		var kolikos = JSON.stringify(data[i].quantity);
	        		kolikos = kolikos.substring(1,kolikos.length-1);
	        		var kolikos_brojos = kolikos;
	        		//kolikos = "<td id='"+codeID+" quantity' val='123123123'>"+kolikos+"</td>";
	        		if(kolikos_brojos>0){
	        		
	        		//sifra proizvoda
	        		var code = JSON.stringify(data[i].code);
	        		code = code.substring(1, code.length-1);
	        		codeID = code;
	        		code = "<td>"+code+"</td>";
	        		
	        		//slika proizvoda
	        		var slika = JSON.stringify(data[i].picture);
	        		slika = slika.substring(1,slika.length-1);
	        		slika = '<td><img width="50" height="50" class="slika" alt="Nema slike" src="'+slika+'"></td>';
	        		
	        		//naziv proizvoda
	        		var naziv = JSON.stringify(data[i].name);
	        		naziv = naziv.substring(1, naziv.length-1);
	        		naziv = "<td>"+naziv+"</td>"
	        		
	        		//boja proizvoda
	        		var boja = JSON.stringify(data[i].color);
	        		boja = boja.substring(1,boja.length-1);
	        		boja = "<td>"+boja+"</td>";
	        		
	        		//zemlja proizvodje
	        		var zemlja = JSON.stringify(data[i].origin);
	        		zemlja = zemlja.substring(1,zemlja.length-1);
	        		zemlja = "<td>"+zemlja+"</td>"
	        		
	        		//proizvodjac proizvoda
	        		var proizvodjac = JSON.stringify(data[i].producer);
	        		proizvodjac = proizvodjac.substring(1, proizvodjac.length-1);
	        		proizvodjac = "<td>"+proizvodjac+"</td>";
	        		
	        		//akicja proizvoda
	        		var actiono = JSON.stringify(data[i].action);
	        		actiono = actiono.substring(1, actiono.length-1);
	        		actiono = "<td>"+actiono+"</td>";
	        		
	        		//pocetak akcije proizvoda
	        		var starto = JSON.stringify(data[i].startDate);
	        		starto = starto.substring(1, starto.length-1);
	        		starto = "<td>"+starto+"</td>";
	        		
	        		//kraj akcije 
	        		var endo = JSON.stringify(data[i].endDate);
	        		endo = endo.substring(1,endo.length-1);
	        		endo = "<td>"+endo+"</td>";
	        		
	        		//procenat
	        		var percento = JSON.stringify(data[i].percent);
	        		percento = percento.substring(1, percento.length-1);
	        		percento = "<td>"+percento+"</td>";
	        		
	        		//cena
	        		var cenos = JSON.stringify(data[i].price);
	        		cenos = cenos.substring(1,cenos.length-1);
	        		cenos = "<td>"+cenos+"</td>";
	        		
	        		
	        		//bespatna usluga
	        		var besplatnos = JSON.stringify(data[i].freeService);
	        		besplatnos = besplatnos.substring(1,besplatnos.length-1);
	        		besplatnos = "<td>"+besplatnos+"</td>";
	        		
	        		//kategorija namestaja
	        		var categoros = JSON.stringify(data[i].category);
	        		categoros = categoros.substring(1, categoros.length-1);
	        		categoros = "<td>"+categoros+"</td>";
	        		
	        		//godina proizvodnje
	        		var yearos = JSON.stringify(data[i].productionYear);
	        		yearos = yearos.substring(1, yearos.length-1);
	        		yearos = "<td>"+yearos+"</td>";
	        		
	        		//salon
	        		var salonos = JSON.stringify(data[i].salon);
	        		salonos = salonos.substring(1, salonos.length-1);
	        		salonos = "<td>"+salonos+"</td>";
	        		
	        		//youtube vidoje
	        		var videos = JSON.stringify(data[i].video);
	        		videos = videos.substring(1,videos.length-1);
	        		if(videos == ""){
	        			videos = "<td>Nema video</td>";
	        		}
	        		else{
	        			videos = "<td><a href="+videos+">Link do videa</a></td>";
	        		}
	        		
	        		//pravljenje dugmeta za dodavanje u korpu
	        		if(kolikos_brojos == 0){
	        			var dugme = "<td><button disabled type='button' class='btn btn-default produkat' id ='"+codeID+" korpa'>U korpu</button></td>";
	        		}
	        		else{
	        			var dugme = "<td><button type='button' class='btn btn-default produkat' id ='"+codeID+" korpa'>U korpu</button></td>";
	        		}
	        		
	        		//punjenje tabel
	        		$("#namestaj_bodi").append("<tr id='"+codeID+"'>"+code+slika+naziv+boja+zemlja+proizvodjac+actiono+starto+endo+percento+cenos+besplatnos+categoros+yearos+salonos+videos+dugme+"</tr>");
	        	}
	        	}
	        
	        }
	    });
		
		
		
		
		
	});
	
	$("#pretraga_usluga").click(function(){
		
		$("#prikaz_namestaj").hide();
		$("#prikaz_usluga").show();
		
		
		var description = $("#serviceDescription").val();
		var name = $("#serviceName").val();
		
		$('#usluge_bodi').find('tr').remove();
		
		$.ajax({
			type:"POST",
			url:"SearchServlet",
			data:{
				"type":"usluge",
				"name":name,
				"description":description
			},
			dataType:'json',
			success: function(data){
				for(var i = 0; i < data.length; i++){
					
					//ime usluge
					var ime = JSON.stringify(data[i].name);
					ime = ime.substring(1, ime.length-1);
					var ime_id = ime;
					ime = "<td>"+ime+"</td>";
					
					//opis
					var opis = JSON.stringify(data[i].description);
					opis = opis.substring(1, opis.length-1);
					opis = "<td>"+opis+"</td>";
					
					
					//var cena
					var cena = JSON.stringify(data[i].price);
					cena = cena.substring(1, cena.length-1);
					cena = "<td>"+cena+"</td>";
					
					//dugme
        			var dugme = "<td><button type='button' class='btn btn-default usluga' id ='"+ime_id+" korpa'>U korpu</button></td>";

					
					$("#usluge_bodi").append("<tr>"+ime+opis+cena+dugme+"</tr>");
					
				}
			}
			
		});
		
	});
	

	$(this).on('click', '.usluga', function(){ 
	    var product_id = this.id;
	    product_id = product_id.replace(' korpa','');
	    var user = $("#user_id").val();
	    var type = "add_service";
	    
	    $.ajax({
			type:"POST",
			url:"BasketServlet",
			data:{
				"type":type,
				"user":user,
				"product_id":product_id
			},
			success: function(data){
				
				if(data=="True"){
					
					
					$.smkAlert({
	             	      text: "Usluga sa imenom "+product_id+" uspesno dodat u korpu!",
	             	      type: 'success'
	             	    });
					
				}
				else {
					$.smkAlert({text:'Ovog namestaja vise nema na lageru', type:'danger', time: 10});
					$("#"+product_id).remove();
				}
			}
			
		});
	    
	});

	
	//rad sa dodatnim uslugama
	$(this).on('click', '.produkat', function(){ 
	    var product_id = this.id.split(" ")[0];
	    var user = $("#user_id").val();
	    var type = "add_product";
	    
	    $.ajax({
			type:"POST",
			url:"BasketServlet",
			data:{
				"type":type,
				"user":user,
				"product_id":product_id
			},
			success: function(data){
				var s = data.split(" ");
				if(s[0]=="True"){
					
					
					$.smkAlert({
	             	      text: "Namestaj sa sifrom "+product_id+" uspesno dodat u korpu, ostalo jos"+s[1]+" komada!",
	             	      type: 'success'
	             	    });
					
				}
				else if(s[0]=="Fail"){
					$.smkAlert({text:'Ovog namestaja vise nema na lageru', type:'danger', time: 10});
					$("#"+product_id).remove();
				}
			}
			
		});
	    
	});
	
	
	
	
});

