$(document).ready(function(){
	

	var color = $("#boja").val();
	var origin = $("#zemlja").val();
	var category = $("#kategorija").val();
	var salon = $("#prodavnica").val();
	var action = $("#akcijaa").val();
	var percent = $("#procenat").val();
	var freeService = $("#usluga").val();
	
	$("#color option[value='"+color+"']").attr("selected",true);
	$("#origin option[value='"+origin+"']").attr("selected",true);
	$("#category option[value='"+category+"']").attr("selected",true);
	$("#salon option[value='"+salon+"']").attr("selected",true);
	$("#action option[value='"+action+"']").attr("selected",true);
	$("#percent option[value='"+percent+"']").attr("selected",true);
	$("#freeService option[value='"+freeService+"']").attr("selected",true);
	
	
	
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
	
	
});