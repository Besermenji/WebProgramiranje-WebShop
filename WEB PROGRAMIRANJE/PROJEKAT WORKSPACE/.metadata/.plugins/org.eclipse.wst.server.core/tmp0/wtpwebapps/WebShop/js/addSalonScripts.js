$(document).ready(function(){
                        
				$('#dugme').click(function(e)
                        {   
                        	e.preventDefault();
					if(!$("form").smkValidate()){
						
					}
					else{

							var pib=$('#pib').val();
                            var name=$('#name').val();
                            var mb = $('#mb').val();
                            var adress =$("#adress").val();
                            var phone = $("#phone").val();
                            var email = $("#email").val();
                            var www = $("#www").val();
                            var bzr = $("#bzr").val();
                            var user_id =$("#user_id").val();
                        	
                            
                            $.ajax({
                                type: "POST",
                                url:"SalonStartServlet",   // this is my servlet
                                data:{"pib":pib,
                                	"name":name,
                                	"mb":mb,
                                	"adress":adress,
                                	"phone":phone,
                                	"email":email,
                                	"www":www,
                                	"bzr":bzr,
                                	"user_id":user_id},
                                success: function (data) {
                                     // I want to call my home page from here
                                	var s = data.split(" ");
                                	if(s[0]=='True'){
                                		$.smkConfirm({
                                		    text: 'Dodaj jos koji salon?',
                                		    accept: 'Da',
                                		    cancel: 'Ne'
                                		  }, function(e) {
                                		    if (e) {
                                		    	$('form').smkClear();
                                		      $.smkAlert({
                                		        text: 'Unesite podatke salona!',
                                		        type: 'success'
                                		      });
                                		    }else{$(location).attr("href","salonStartPage.jsp?"+s[1]);}
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