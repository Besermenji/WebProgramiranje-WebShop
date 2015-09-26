$(document).ready(function () {
                
				$('#startDate').datepicker({
                    format: "dd/mm/yyyy"
                });  
                
                $('#endDate').datepicker({
                    format: "dd/mm/yyyy"
                });  
                
                $("#izvestaj_dugme").click(function(){
                	$("#za_tabele").empty();
                	var startDate = $("#startDate").val();
                	var endDate = $("#endDate").val();
                	var category = $("#category").val();
                	if(category == ""){
                	$.ajax({
                        type: "POST",
                        url:"GetReportServlet",   // this is my servlet
                        data:{"startDate":startDate,
                        	"endDate":endDate,
                        	"category":category},
                    	dataType: 'json',
                        success: function (data) {
                        	var total = parseInt(0,10);
                        	for(var i = 0;i < data.length;i++){
                        		$.each(data[i], function(key, value){
                        			$("#za_tabele").append("<h3>Izvestaj za datum: "+key+"</h3>");
                        			$("#za_tabele").append("<br><br>");
                        			for(var j = 0; j< value.length;j++){
                        				var total_total = parseInt(0,10);
                        				$.each(value[j],function(kljuc,vrednost){
                        					
                        					$("#za_tabele").append("<p>Izvestaj za salon: "+kljuc+"</p><br>");
                        					$("#za_tabele").append("<table id='tabelos"+j+"' class='table table-striped'><thead><tr><th>Namestaj</th><th>Cena</th></tr></thead><tbody id='bodej"+j+"'>");
                        					var totalTabela = parseInt(0,10);
                        					for(var k = 0; k < vrednost.length;k++){
                        						//ime namestaja
                        						var ime = JSON.stringify(vrednost[k].name);
                        						ime = ime.substring(1,ime.length-1);
                        						ime = "<td>"+ime+"</td>";
                        						//cena namestaja
                        						var cena = JSON.stringify(vrednost[k].price);
                        						cena = cena.substring(1,cena.length-1);
                        						var cenaInt = parseInt(cena,10);
                        						totalTabela+=cenaInt;
                        						cena = "<td>"+cena+"</td>";
                        						$("#bodej"+j).append("<tr>"+ime+cena+"</tr>");
                        						if(k == vrednost.length-1){
                        							$("#bodej"+j).append("</tbody>");
                        							$("#tabelos"+j).append("</table><br><br><p>Ukupna cena tabele: <b>"+totalTabela+"</b></p>");
                        							total +=totalTabela;
                        						}
                        					}
                        				if(j==value.length-1){
                        					$("#za_tabele").append("<br><br><h3>UKUPNO: <b>"+total+"</b></h3>");
                        				}	
                        				});
                        			}
                        		});
                        	}
                        }
                    });}
                	else{$.ajax({
                        type: "POST",
                        url:"GetReportServlet",   // this is my servlet
                        data:{"startDate":startDate,
                        	"endDate":endDate,
                        	"category":category},
                    	dataType: 'json',
                        success: function (data) {
                        	$("#za_tabele").append("<br><br><br><table class='table table-striped'><thead><tr><th>Ime namestaja</th><th>Kolicina</th><th>Cena za komad</th></tr></thead><tbody id='bodej'>");
                        	var total = parseInt(0,10);
                        	for(var i = 0 ; i< data.length;i++){
                        		//ime
                        		var ime = JSON.stringify(data[i].name);
                        		ime = ime.substring(1,ime.length);
                        		ime = "<td>"+ime+"</td>";
                        		
                        		//kolicina
                        		var kolicina = JSON.stringify(data[i].quan);       
                        		kolicina = kolicina.substring(1,kolicina.length-1);
                        		var intKolicina = parseInt(kolicina,10);
                        		kolicina = "<td>"+kolicina+"</td>";
                        		
                        		//cena 
                        		var price = JSON.stringify(data[i].price);
                        		price = price.substring(1,price.length-1);
                        		var intPrice = parseInt(price,10);
                        		price = "<td>"+price+"</td>";
                        		
                        		total += intKolicina*intPrice;
                        		$("#bodej").append("<tr>"+ime+kolicina+price+"</tr>");
                        	}
                        	$("#za_tabele").append("</tbody></table><br><br><br><p>UKUPNO: <b>"+total+"</b></p>");
                        }
                    });}
                	
                	
                });
                
});