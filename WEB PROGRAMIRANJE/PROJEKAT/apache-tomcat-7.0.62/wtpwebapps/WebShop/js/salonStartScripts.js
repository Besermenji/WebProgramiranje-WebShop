// Empty JS for your own code to be here

$(document).ready(function(){
	
	$(".brisanje").click(function(){
		
		var tmp = this.id;
		var id = tmp.split(" ")[0];
		
		   $.ajax({
               type: "POST",
               url:"SalonStartServlet",   // this is my servlet
               data:{
            	   "tip":"brisanje",
            	   "id":id
               },
               success: function (data) {
                    // I want to call my home page from here
               	if(data=='True'){
               		$.smkAlert({
               	      text: "Uspesno obrisan salon sa sifrom "+id+".",
               	      type: 'success'
               	    });
               		
               		$("#"+id).remove();
                       
               	}
               	else{
               		alert("faaaa");
               	}
               }
           });
		
		
	});
	
});