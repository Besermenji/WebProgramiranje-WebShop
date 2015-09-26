$(document).ready(function(){
                        
				$('#dugme').click(function(e)
                        {   
                        	e.preventDefault();
					if(!$("form").smkValidate()){
						
					}
					else{

							
                            var name=$('#name').val();
                            var description = $("#description").val();
                            var price = $("#price").val();
                        	var user_id = $("#user_id").val();
                            
                            $.ajax({
                                type: "POST",
                                url:"ServiceStartServlet",   // this is my servlet
                                data:{
                                	"name":name,
                                	"description":description,
                                	"price":price,
                                	"user_id":user_id
                                },
                                success: function (data) {
                                     // I want to call my home page from here
                                	var s = data.split(" ");
                                	if(s[0]=='True'){
                                		$.smkConfirm({
                                		    text: 'Dodaj jos koju uslugu?',
                                		    accept: 'Da',
                                		    cancel: 'Ne'
                                		  }, function(e) {
                                		    if (e) {
                                		    	$('form').smkClear();
                                		      $.smkAlert({
                                		        text: 'Unesite podatke usluge!',
                                		        type: 'success'
                                		      });
                                		    }else{$(location).attr("href","serviceStartPage.jsp?"+s[1]);}
                                		  });
                                        
                                	}
                                	else{
                                		alert("FAIL");
                                	}
                                }
                            });
					}
                        });
                    });