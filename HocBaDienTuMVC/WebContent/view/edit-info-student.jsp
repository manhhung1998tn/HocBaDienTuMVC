<%@page import="hocba.util.Utilities"%>
<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="<%=request.getContextPath() %>/assets/js/jquery-3.3.1.min.js"></script>
<title>Học Bạ Điện Tử</title>
<%@ include file="/view/cssinclude.jsp"%>


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


		<div id="page-wrapper">
			<div id="page-inner" class="view">
	


				<!--CONTENT-->
				<%
				int rs = Utilities.getIntParameter(request, "rs");
				if(rs != -1){%>
					<div class="row">
						<div class="col-md-12 col-sm-12">
							<h2 style="text-align: center">
								<%if(rs == 1){ %>	
								Sửa Thành Công
								<%}else{ %>
								Sửa Thất Bại
								<%} %>
							</h2>
						</div>
					</div>
				
				<%}%>
				
				<form action="editstudent" method="POST">
					<div class="row">
						<div class="col-md-12 col-sm-12">



							<ul class="nav nav-tabs">
								<li class="active"><a href="#home" data-toggle="tab">Thông
										Tin Cá Nhân</a></li>
								<li class=""><a href="#tab1" data-toggle="tab">Thông
										Tin Gia Đình</a></li>

							</ul>

							<div class="tab-content">
								<div class="tab-pane fade active in" id="home">


									<!--Thông Tin Cơ Bản-->
									<div class="col-md-12 col-sm-12 tab-content-mid">
										<div class="panel panel-default">

											<div class="panel-body">
												<div class="table-responsive">
													<%=(String)request.getSession().getAttribute("editInfoStudent") %>
												</div>
											</div>
										</div>
									</div>
									<!--Thông Tin Thường Chú-->
									<div class="col-md-6 col-sm-12 tab-content-left">
										<div class="panel panel-default">

											<div class="panel-body">
												<div class="table-responsive">
													<%=(String)request.getSession().getAttribute("editGuardianStudent") %>
												</div>
											</div>
										</div>
									</div>

									<!--Update Thông Tin Thường Chú-->
									<div class="col-md-6 col-sm-12 tab-content-right">
										<div class="panel panel-default">

											<div class="panel-body">
												<div class="table-responsive">
													<%=(String)request.getSession().getAttribute("editAddressStudent") %>

												</div>
											</div>
										</div>
									</div>

									<!--submit-->
									<div class="col-md-12">
										<table class="table">
											<thead>
												<tr>
													<td rowspan="2"><a style="float: right;"
														class="btn btn-default" href="infostudent">Quay Lại</a></td>
													<td style="width: 100px;">
														<button style="float: right; width: 100%;" type="submit"
															class="btn btn-primary">Lưu Thay Đổi</button>
													</td>
												</tr>

											</thead>
										</table>
									</div>


								</div>


								<div class="tab-pane fade" id="tab1"></div>

							</div>

						</div>

					</div>
					<!-- END ROW -->
				</form>
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
	

	<script type="text/javascript">
	
	/*
        var objs = document.getElementsByTagName("input");
        for(var i = 0;i < objs.length; ++i){
            objs[i].setAttribute('style','background:#ffffcc');
            
            
        }
	
        objs =  document.getElementsByTagName("select");
        for(var i = 0;i < objs.length; ++i){
            objs[i].setAttribute('style','background:#ffffcc');
        }
        */
    </script>


	<%@ include file="/view/jsinclude.jsp"%>


</body>
</html>
