$(document).ready(function(){
	 $.ajax({
			type:"POST",
			url:"BasketServlet",
			data:{
				"type":"init",
				"user":$("#user_id").val()
			},
			dataType: 'json',
			success: function(data){
				
				var total = parseInt(0, 10);
				
				//ubacivanje kupca u listu
				var buyer = JSON.stringify(data[0].buyer);
				buyer = buyer.substring(1,buyer.length-1);
			    $('#buyer').text(buyer);
				
			    //ubacivanje poreza
			    var taxes = JSON.stringify(data[1].taxes);
			    taxes = taxes.substring(1, taxes.length-1);
			    $("#taxes").text(taxes);
			    
			    //datum
			    var date = JSON.stringify(data[2].date);
			    date = date.substring(1,date.length-1);
			    $("#date").text(date);
			
			    //vreme
			    var time = JSON.stringify(data[3].time);
			    time = time.substring(1 ,time.length-1);
			    $("#time").text(time);
			    
			    //servisi
			    var counter = parseInt(0,10);
			    for(var i = 0; i<data[4].length;i++){
			    	var name = JSON.stringify(data[4][i].name);
			    	name = name.substring(1, name.length-1);
			    	var td_name = "<td>"+name+"</td>";
			    	
			    	var price = JSON.stringify(data[4][i].price);
			    	price = price.substring(1,price.length-1);
			    	var price_td = "<td>"+price+"</td>";
			    	
			    	var button = "<td><button class='btn btn-default iz_korpe' id='usluga "+counter+" "+name+" "+price+"'>Ukloni iz korpe</button></td>";
			    	
			    	var tr = "<tr id='"+counter+"'>"+td_name+price_td+button+"</tr>";
			    	$("#namestaj_bodi").append(tr);
			    	
			    	//za total
			    	var t = JSON.stringify(data[4][i].price);
			    	t = t.substring(1,t.length-1);
			    	total = total + parseInt(t, 10);
			    	counter = counter + parseInt(1,10);
			    	
			    }
			    
			    
			    for(var i = 0; i<data[5].length;i++){
			    	var name = JSON.stringify(data[5][i].name);
			    	name = name.substring(1, name.length-1);
			    	var td_name = "<td>"+name+"</td>";
			    	
			    	var price = JSON.stringify(data[5][i].price);
			    	price = price.substring(1,price.length-1);
			    	var price_td = "<td>"+price+"</td>";
			    	
			    	var button = "<td><button class='btn btn-default iz_korpe' id='namestaj "+counter+" "+name+" "+price+"'>Ukloni iz korpe</button></td>";
			    	
			    	var tr = "<tr id="+counter+" "+price+" "+name+">"+td_name+price_td+button+"</tr>";
			    	$("#namestaj_bodi").append(tr);
			    	
			    	//za total
			    	var t = JSON.stringify(data[5][i].price);
			    	t = t.substring(1,t.length-1);
			    	total = total + parseInt(t, 10);
			    	counter = counter + parseInt(1,10);

			    }
			    $("#total").text(total);
			    
			
			}
			
		});
	 
	 	//izvoz racuna
	 $('#show').click(function () {
		 var user = $("#user_id").val();
		 var type = "buy";
		    
		    $.ajax({
				type:"POST",
				url:"BasketServlet",
				data:{
					"type":type,
					"user":user,
					},
				success: function(data){
				if(data == "True"){
					$("#show").hide();
					$(".iz_korpe").hide();
					$("#naslov").text("RACUN ZA KUPOVINU");
				}
				}
				
			});
		 
		 
     });
	 
		//rad sa dodatnim uslugama
		$(this).on('click', '.iz_korpe', function(){ 
		    var array = this.id.split(" ");
			var identifier = array[0];
			var counter = array[1];
			var price = array[array.length-1];
			var name ="";
			for(var i = 2; i < array.length-1;i++){
				name+=array[i]+" ";
			}
			name = name.trim();
		    var user = $("#user_id").val();
		    var type = "delete_product";
		    
		    $.ajax({
				type:"POST",
				url:"BasketServlet",
				data:{
					"type":type,
					"user":user,
					"identifier":identifier,
					"price":price,
					"name":name
				},
				success: function(data){
				var s = data.split(" ");
				if(s[0]=="true"){
					$("#"+counter).remove();
					var tmp = $("#total").text();
					var ttl = parseInt(tmp,10);
					ttl = ttl- parseInt(s[1],10);
					$("#total").text(ttl);
				}
				}
				
			});
		    
		});
	 
});