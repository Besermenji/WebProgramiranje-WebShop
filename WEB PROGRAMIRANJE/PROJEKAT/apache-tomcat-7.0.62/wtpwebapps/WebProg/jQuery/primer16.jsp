<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="jquery-1.11.0.js">
</script>
<script>
$(document).ready(function(){
    $("button#b_1").click(function(){
    	$.get("${pageContext.request.contextPath}/GetArticles",function(data,status){
    	    //alert("Data: " + data + "\nStatus: " + status);
    	    $("div#d_1").empty();
    	    for (var i = 0; i < data.length; i++) {
    	        //alert(JSON.stringify(data[i]));
    	        $("div#d_1").append('<div id="article_'+i.toString()+'"><div>'+data[i].title+'</div><div>'+    	        		
    	        		data[i].description+'</div><div>'+data[i].text+'</div></div><br/>');
    	    }  
    	});
    });
    $("button#b_2").click(function(){
    	 $.post("${pageContext.request.contextPath}/PostArticle",
    			  {
    			    jsonData:JSON.stringify({
    	                title:$("input#naslov").val(),
    	                description:$("input#opis").val(),
    	                text:$("textarea#tekst").val()
    	            })

    			  }//,
//     			  function(data,status){
//     			    alert("Data: " + data + "\nStatus: " + status);
//     	 		  }
    		);
    });
    
});
</script>
</head>

<body>
<h1>AJAX get i post</h1>
<div id="d_1">    
</div>
<table>
	<tr>
		<td>naslov</td>
		<td><input type="text" id="naslov"/></td>
	</tr>
	<tr>
		<td>opis</td>
		<td><input type="text" id="opis"/></td>
	</tr>
	<tr>
		<td>članak</td>
		<td><textarea rows="20" cols="50" id="tekst"></textarea> </td>
	</tr>
</table>
<button id="b_1">učitaj</button>
<button id="b_2">pošalji</button>
<br />
<a href="index.html">Nazad</a>

</body>
</html>
