// Empty JS for your own code to be here

$(document).ready(function(){
	
	$(".brisanje").click(function(){
		
		var tmp = this.id;
		var toRemove = " brisanje";
		var id = tmp.replace(toRemove,"");
		
		   $.ajax({
               type: "POST",
               url:"ServiceStartServlet",   // this is my servlet
               data:{
            	   "tip":"brisanje",
            	   "id":id
               },
               success: function (data) {
                    // I want to call my home page from here
               	if(data=='True'){
               		$.smkAlert({
               	      text: "Uspesno obrisana dodatna usluga  "+id+".",
               	      type: 'success'
               	    });
               		
               		$("[id='"+id+"']").remove();
                       
               	}
               	else{
               		alert("FAIL");
               	}
               }
           });
		
		
	});
	
});