$(document).ready(function(){
	var id = $("#user_id").val();
	if(id==""){
		$(location).attr('href','izborUloga.jsp');
	}
	else{
		var user_id = $("#user_id").val();
		$.ajax({
            type: "POST",
            url:"LoginCheckServlet",   // this is my servlet
            data:{"user_id":user_id},
            success: function (data) {
                 // I want to call my home page from here
            	
            	//alert(s[1]);
            	if(data=='True'){
                    //alert("true");
                  }else{
                	  $(location).attr('href','izborUloga.jsp');
                      
                  }
            }
        });
		
		
		
	}
	
	 $("#logout_dugme").click(function(){
		
		 var user_id = $("#user_id").val();
		 $.ajax({
	            type: "POST",
	            url:"LogoutServlet",   // this is my servlet
	            data:{"user_id":user_id},
	            success: function (data) {
	                 // I want to call my home page from here
	            	var s = data.split(" ");
	            	//alert(s[1]);
	            	if(s[0]=='True'){
	                    //alert("true");
	                  
	                	  $(location).attr('href','izborUloga.jsp');
	                      
	                  }
	            }
	        });
			
		 
		 
	 });
	
	
});