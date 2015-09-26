$(document).ready(function(){
                        
				$('#dugme').click(function(e)
                        {   
                        	
					if(!$("form").smkValidate()){
						
					}
					else{

							var user=$('#username').val();
                            var pwd=$('#password').val();
                        	
                            
                            $.ajax({
                                type: "POST",
                                url:"AdminLoginServlet",   // this is my servlet
                                data:{"username":user,"password":pwd,"role":"ADMIN"},
                                success: function (data) {
                                     // I want to call my home page from here
                                	var s = data.split(" ");
                                	//alert(s[1]);
                                	if(s[0]=='True'){
                                        $(location).attr('href','adminStartPage.jsp?user='+s[1]);
                                      }else{
                                    	  $.smkAlert({
                                  		    text: 'Neuspesna prijava na sistem',
                                  		    type: 'danger',
                                  		    time: 10
                                  		  });
                                          
                                      }
                                }
                            });
					}
                        });
                    });