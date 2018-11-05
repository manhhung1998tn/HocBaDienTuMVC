<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<script type="text/javascript"></script>
	<script src="<%=request.getContextPath() %>/assets/js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<select id="tinh_tp">
		<option selected hidden disabled >Chọn tỉnh/TP</option>
	</select>
	<select id="quan_huyen">
		<option selected hidden disabled >Chọn Quận Huyện</option>
	</select>
	<select id="xa_phuong">
		<option selected hidden disabled >Chọn Xã Phường</option>
	</select>

	<script type="text/javascript">
		
		$(document).ready(function() {
		var tinh_tp;
		
	
			$.getJSON( "<%=request.getContextPath() %>/assets/dist/tinh_tp.json" , function( json ) {
				var tmp = "hung dz";
				
				
				
	    		Object.keys(json).forEach(function(key){
	    			json[key];  // <- obj is undefined !!
	    
	    			$("#tinh_tp").append('<option code='+ json[key].code +' value="'+json[key].name+'">'+json[key].name_with_type+'</option>');
	    		});
	
			});
		
			$("#tinh_tp").change(function(){
				$("#quan_huyen").html("<option selected hidden disabled >Chọn Quận Huyện</option>");
				$("#xa_phuong").html("<option selected hidden disabled >Chọn Xã Phường</option>");
				var code = $('option:selected', this).attr('code');
				var path = "<%=request.getContextPath() %>/assets/dist/quan-huyen/"+ code +".json";
				$.getJSON( path , function( json ) {
						Object.keys(json).forEach(function(key){
			    			json[key];  // <- obj is undefined !!
			    			
			    			$("#quan_huyen").append('<option code='+ json[key].code +' value="'+json[key].name+'">'+json[key].name_with_type+'</option>');
			    		});
					
				});
				
			});
			
			
			
			
			$("#quan_huyen").change(function(){
				$("#xa_phuong").html("<option selected hidden disabled >Chọn Xã Phường</option>");
				var code = $('option:selected', this).attr('code');
				var path = "<%=request.getContextPath() %>/assets/dist/xa-phuong/"+ code +".json";
				$.getJSON( path , function( json ) {
						Object.keys(json).forEach(function(key){
			    			json[key];  // <- obj is undefined !!
			    			
			    			$("#xa_phuong").append('<option code='+ json[key].code +' value="'+json[key].name+'">'+json[key].name_with_type+'</option>');
			    		});
					
				});
				
			});
			
			
			
			
			
			
			
		});
	</script>
</body>
</html>