// Empty JS for your own code to be here

$(document).ready(function(){
	
	$(".brisanje").click(function(){
		
		var tmp = this.id;
		var toRemove = " brisanje";
		var id = tmp.replace(toRemove,"");
		
		   $.ajax({
               type: "POST",
               url:"ProductStartServlet",   // this is my servlet
               data:{
            	   "tip":"brisanje",
            	   "id":id
               },
               success: function (data) {
                    // I want to call my home page from here
               	if(data=='True'){
               		$.smkAlert({
               	      text: "Uspesno obrisan namestaj sa sifrom "+id+".",
               	      type: 'success'
               	    });
               		
               		$("[id='"+id+"']").remove();
                       
               	}
               	else{
               		$.smkAlert({text:'Neuspesno brisanje', type:'danger', time: 10});
               	}
               }
           });
		
		
	});
	
});