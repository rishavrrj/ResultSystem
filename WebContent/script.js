$(document).ready(function(){
$('#go').click(function(){
		
		var x=$("form").serializeArray();
		var c=$('#col').val();
		var p=0;
		 $.each(x, function(i, field){
		  if ((c=="T1"||c=="T2") && (field.value>20 || field.value<0))
				 {
				 p=1;
				 }
			 else if((c=="END_SEM") && (field.value>40 && field.value<0))
				 {
						 p=1;
				 }

			 else if((c=="QUIZ") && (field.value>10 && field.value<0))
				 {
					 p=1;
				 }

			 else if((c=="ATTENDANCE"||c=="ASSIGNMENT") && (field.value>5 || field.value<0))
				 {
					 p=1;
				 }
		 });
		  
		 
		 if(p==0){
			 $.each(x, function(i, field){
	        $.post('Addmarks' , {input1:field.name,input:field.value,input2:c}, function(data)
	        		{
	     
	        		})
			 });
	        		alert('Updation success !');		
		 }
		 else
			 alert('Marks Not valid');		
		 });
		
	});