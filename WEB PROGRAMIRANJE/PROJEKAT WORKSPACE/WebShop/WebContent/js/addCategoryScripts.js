$(document).ready(function(){
                        
				$('#dugme').click(function(e)
                        {   
                        	e.preventDefault();
                        	var name=$('#name').val();
                            var description  =$("#description").val();
                            var inWhatCategory =$("#inWhatCategory").val();
                            var user_id =$("#user_id").val();
                        	
					if(!$("form").smkValidate()){
						
					}
					else if(name == inWhatCategory){
						$.smkAlert({text:'Kategorija ne moze biti parent sama sebi', type:'warning'});
					}
 						
					
					else{

						
                            /*var name=$('#name').val();
                            var description  =$("#description").val();
                            var inWhatCategory =$("#inWhatCategory").val();*/
                        	
                            
                            $.ajax({
                                type: "POST",
                                url:"CategoryStartServlet",   // this is my servlet
                                data:{
                                	"name":name,
                                	"description":description,
                                	"inWhatCategory":inWhatCategory,
                                	"user_id":user_id
                                	},
                                	dataType: 'json',
                                success: function (data) {
                                	$('#inWhatCategory').append( new Option(data.id,data.id) );
                                	var s = JSON.stringify(data.user);
                                	s = s.substring(1, s.length-1);
                                	
                                	$.smkConfirm({
                            		    text: 'Dodaj jos koju kategoriju?',
                            		    accept: 'Da',
                            		    cancel: 'Ne'
                            		  }, function(e) {
                            		    if (e) {
                            		    	$('form').smkClear();
                            		      $.smkAlert({
                            		        text: 'Unesite podatke kategorije!',
                            		        type: 'success'
                            		      });
                            		    }else{$(location).attr("href","kategorijaStartPage.jsp?"+s);}
                            		  });
                                    
                                }
                            });
					}
                        });
                    });