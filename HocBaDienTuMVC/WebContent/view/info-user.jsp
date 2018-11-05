	<%@ page language="java" contentType="text/html; UTF-8"
	    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	  <meta charset="utf-8" />
	  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	  <title>Học Bạ Điện Tử</title>
	 <%@ include file="/view/cssinclude.jsp" %>
	<script src="<%=request.getContextPath() %>/assets/js/jquery-3.3.1.min.js"></script>

	</head>
	<body>
	    <div id="wrapper">
	        <!--HEADER-->
	        <jsp:include page="/view/header.jsp"></jsp:include>
	        <!--END HEADER-->  
	        <!-- /. NAV TOP  --> 
	        <!--MENU-->
	        <jsp:include page="/view/menu.jsp"></jsp:include>
	        <!--END MENU-->
	        <!-- /. NAV SIDE  -->
	
	
	        <div id="page-wrapper" >
	
	              <!--CONTENT-->
	<div id="page-inner">
	                
	                 <hr />
	            
	
	
	
	
	    <div class="row">
	    <div class="col-md-12 col-sm-12">
	                    
	                        
	                        
	                            <ul class="nav nav-tabs">
	                                <li class="active"><a href="#home" data-toggle="tab">Thông Tin Cá Nhân</a>
	                                </li>
	                                <li class=""><a href="#tab1" data-toggle="tab">Thông Tin Liên Hệ</a>
	                                </li>
	                                
	                            </ul>
	
	                            <div class="tab-content">
	                                <div class="tab-pane fade active in" id="home">
	                                     
	                                    <form>
	                                    <!--Thông Tin Cơ Bản-->
	                                        <div class="col-md-12 col-sm-12 tab-content-mid">
	                                            <div class="panel panel-default">
	                                            
	                                                <div class="panel-body">
	                                                    <div class="table-responsive">
	                                                        <table class="table">
	                                                            <thead>
	                                                                <tr>
	                                                                    <td colspan="2" class="heade-table">Thông Tin Cơ Bản</td>
	                                                                </tr>
	                                                            </thead>
	                                                            <!-- tbody -->
	                                                            <%
	                                                            	String infoAccout = (String)request.getSession().getAttribute("infoAccout");
	                                                            	if(infoAccout != null){
	                                                            		out.print(infoAccout);
	                                                            	}
	                                                            %>
	                                                        </table>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                        </div>
	                                        <!--Thông Tin Thường Chú-->
	                                          <div class="col-md-12 col-sm-12 tab-content-mid">
	                                            <div class="panel panel-default">
	                                            
	                                                <div class="panel-body">
	                                                    <div class="table-responsive">
	                                                        <table class="table">
	                                                            <thead>
	                                                                <tr>
	                                                                    <td colspan="2" class="heade-table">Thông Tin Đẩy Đủ</td>
	                                                                </tr>
	                                                            </thead>
	                                                            <!-- tbody -->
	                                                            <%
	                                                            	String infoTeacher = (String)request.getSession().getAttribute("infoTeacher");
	                                                            	if(infoTeacher != null){
	                                                            		out.print(infoTeacher);
	                                                            	}
	                                                            %>
	                                                        </table>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                        </div>
	
	                                        <!--Update Thông Tin Thường Chú-->
	                                        
	
	                                        <!--submit-->
	                                        <div class="col-md-12"> 
	                                                <table class="table">
	                                                    <thead>
	                                                        <tr>
	                                                            <td rowspan="2">
	                                                                 <button style="float: right;" type="submit" class="btn btn-default">Xuất Danh Sách Ra File</button>
	                                                            </td>
	                                                            <td style="width: 100px;">
	                                                                <button style="float: right; width: 100%;" type="submit" class="btn btn-primary">Lưu</button>
	                                                            </td>
	                                                        </tr>
	                                                        
	                                                    </thead>
	                                                </table>
	                                        </div>
	                                        
	                                    </form>
	                                </div>
	
	
	                                <div class="tab-pane fade" id="tab1">
	                                    <h4>Profile Tab</h4>
	                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
	                                </div>
	                               
	                            </div>
	                   
	                </div>
	
	</div>
	<!-- /. ROW  -->
	<div class="row">
	                
	            </div>
	<!-- /. ROW  -->           
	</div>          
	<!-- /. PAGE INNER  -->
	</div>
	<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->
	
		<script type="text/javascript">
		
		$(document).ready(function() {
			var value_sex = $("#student_sex").val();
			console.log(value_sex);
			var array_sex = ["Nam", "Nữ" , "Khác"];
			for(var index = 0; index < array_sex.length; ++index){
				if(value_sex != array_sex[index]){
					 $("#student_sex").append('<option value="'+ array_sex[index] +'">'+ array_sex[index] +'</option>');
				}
				
				
			}
		
	
			$.getJSON( "<%=request.getContextPath() %>/assets/dist/tinh_tp.json" , function( json ) {
				
	    		Object.keys(json).forEach(function(key){
	    			json[key];  // <- obj is undefined !!
	    
	    			$("#tinh_tp").append('<option code='+ json[key].code +' value="'+json[key].name+'">'+json[key].name_with_type+'</option>');
	    		});
	
			});
		
			$("#tinh_tp").change(function(){
				$("#quan_huyen").html("<option selected hidden disabled >Chọn Quận Huyện</option>");
				$("#xa_phuong").html("<option selected hidden disabled >Chọn Xã Phường</option>");
				var code = $('option:selected', this).attr('code');
				console.log("code tinh_tp : " + code);
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
				console.log("code quan_huyen : " + code);
				var path = "<%=request.getContextPath() %>/assets/dist/xa-phuong/"+ code +".json";
				$.getJSON( path , function( json ) {
						Object.keys(json).forEach(function(key){
			    			json[key];  // <- obj is undefined !!
			    			
			    			$("#xa_phuong").append('<option code='+ json[key].code +' value="'+json[key].name_with_type+'">'+json[key].name_with_type+'</option>');
			    		});
					
				});
				
			});
			
		
			
			
			
			
		});
	</script>
	
	
	<%@ include file= "/view/jsinclude.jsp" %>
	
	
	</body>
	</html>
