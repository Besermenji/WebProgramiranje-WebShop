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
							var category = $("#category").val();
                            var action = $("#action").val();
                            
                            
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
                            
                            
                           
                           
                            
                            $.ajax({
                                type: "POST",
                                url:"ProductStartServlet",   // this is my servlet
                                data:{
                                	"tip":"kategorija",
                                	"category":category,
                                	"action":action,
                                	"startDate":startDate,
                                	"endDate":endDate,
                                	"percent":percent,
                                	"user_id":user_id
                                	},
                                success: function (data) {
                                     // I want to call my home page from here
                                	var s = data.split(" ");
                                	if(s[0]=='True'){
                                		$(location).attr("href","adminStartPage.jsp?user="+s[1]);
                                        
                                	}
                                	
                                }
                            });
					}
                        });
    	    	
    	    	
                            
            });