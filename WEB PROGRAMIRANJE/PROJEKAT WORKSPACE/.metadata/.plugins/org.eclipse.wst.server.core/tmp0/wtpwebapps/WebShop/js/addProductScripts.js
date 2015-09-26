$(document).ready(function () {
                
	
		
                
	
				
	
	
				$('#startDate').datepicker({
                    format: "dd/mm/yyyy"
                });  
                
                $('#endDate').datepicker({
                    format: "dd/mm/yyyy"
                });  
                
                $('#start').hide();
    	    	$('#end').hide();
    	    	$('#akcija').hide();
    	    	$('#startDate').attr('required', false);
    	    	$('#endDate').attr('required', false);
    	    	$('#percent').attr('required', false);
    	    	
    	    	
    	    	
    	    	$("#action").change(function() {
    	    	    if(this.value == "da"){
    	    	    	$('#start').show();
    	    	    	$('#end').show();
    	    	    	$('#akcija').show();
    	    	    	$('#startDate').attr('required', true);
    	    	    	$('#endDate').attr('required', true);
    	    	    	$('#percent').attr('required', true);
    	    	    	
    	    	    	
    	    	    }
    	    	    else{
    	    	    	$('#start').hide();
    	    	    	$('#end').hide();
    	    	    	$('#akcija').hide();
    	    	    	$('#startDate').attr('required', false);
    	    	    	$('#endDate').attr('required', false);
    	    	    	$('#percent').attr('required', false);
    	    	    	
    	    	    }
    	    	});
    	    	$('#dugme').click(function(e)
                        {   
                        	e.preventDefault();
					if(!$("form").smkValidate()){
						
					}
					else{

							var user_id = $("#user_id").val();
							var code =$("#code").val();
                            var name=$('#name').val();
                            var color=$("#color").val();
                            var origin =$("#origin").val();
                            var producer = $("#producer").val();
                            var price = $("#price").val();
                            var quantity = $("#quantity").val();
                            var category = $("#category").val();
                            var productionYear = $("#productionYear").val();
                            var salon = $("#salon").val();
                            var picture = $("#picture").val();
                            var video = $("#video").val();
                            var action = $("#action").val();
                            
                            if(picture === undefined){
                            	picture="";
                            }
                            if(video === undefined){
                            	video="";
                            }
                            
                            if(action=="da"){
                            	
                            	var startDate=$("#startDate").val();
                            	var endDate=$("#endDate").val();
                            	var percent = $("#percent").val();
                            }
                            else{
                            	var startDate="";
                            	var endDate="";
                            	var percent = "";
                            }
                            
                            
                           var freeService= $("#freeService").val();
                           
                           
                            
                            $.ajax({
                                type: "POST",
                                url:"ProductStartServlet",   // this is my servlet
                                data:{"code":code,
                                	"name":name,
                                	"color":color,
                                	"origin":origin,
                                	"producer":producer,
                                	"price":price,
                                	"quantity":quantity,
                                	"category":category,
                                	"productionYear":productionYear,
                                	"salon":salon,
                                	"picture":picture,
                                	"video":video,
                                	"action":action,
                                	"startDate":startDate,
                                	"endDate":endDate,
                                	"percent":percent,
                                	"freeService":freeService,
                                	"user_id":user_id
                                	},
                                success: function (data) {
                                     // I want to call my home page from here
                                	var s = data.split(" ");
                                	if(s[0]=='True'){
                                		$.smkConfirm({
                                		    text: 'Dodaj jos koji namestaj?',
                                		    accept: 'Da',
                                		    cancel: 'Ne'
                                		  }, function(e) {
                                		    if (e) {
                                		    	$('form').smkClear();
                                		      $.smkAlert({
                                		        text: 'Unesite podatke o namestaju!',
                                		        type: 'success'
                                		      });
                                		    }else{$(location).attr("href","productStartPage.jsp?"+s[1]);}
                                		  });
                                        
                                	}else if(data=="PIB"){
                                    	alert("PIB");  
                                		/*$.smkAlert({
                                  		    text: 'Neuspesna prijava na sistem',
                                  		    type: 'danger',
                                  		    time: 10
                                  		  });*/
                                          
                                      }
                                	else{
                                		alert("FAIL");
                                	}
                                }
                            });
					}
                        });
    	    	
    	    	
                            
            });