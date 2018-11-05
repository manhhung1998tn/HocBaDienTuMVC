<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Học Bạ Điện Tử</title>
<%@ include file="/view/cssinclude.jsp"%>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/fontawesome.css"
	integrity="sha384-1rquJLNOM3ijoueaaeS5m+McXPJCGdr5HcA03/VHXxcp2kX2sUrQDmFc3jR5i/C7"
	crossorigin="anonymous">
</head>
<body>
	<div id="wrapper">
		<!--HEADER-->
		<jsp:include page="/view/header.jsp"></jsp:include>
		<!--END HEADER-->
		<!-- /. NAV TOP  -->
		<!--MENU-->
		
		<%@ include file="/view/menu.jsp"  %>
		<!--END MENU-->
		<!-- /. NAV SIDE  -->


		<div id="page-wrapper">

			<!--CONTENT-->
			<div id="page-inner">

				
				
					<div></div>
				
				<% String err = request.getParameter("err");
					
					if(err != null && !"".equals(err)){
						out.print("<div class=\"row\">");
						out.print("<div class=\"col-md-12 col-sm-12 col-xs-12\">");
						if("notteacher".equals(err)){
							out.print("<h2>Bạn Không Phải Giáo Viên Chủ Nhiệm</h2>");
							
						}
						
						
						out.print("</div>");
						out.print("</div>");
					}
				
				
				
				%>
			
				<hr />

				<div class="row">


					<!--ROW TKB -->
					<div class="col-md-12 col-sm-12 col-xs-12">

						<div class="panel panel-default">
							<div class="panel-heading">Thời Khóa Biểu : thực hiện từ 19/03/1998 đến 19/3/2020</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Buổi</th>
												<th>Tiết</th>
												<th>Thứ 2</th>
												<th>Thứ 3</th>
												<th>Thư 4</th>
												<th>Thứ 5</th>
												<th>Thứ 6</th>
												<th>Thứ 7</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<th rowspan="5" style="background: #fff">Sáng</th>
												<td>1</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>

											</tr>

											<tr>
												<td>2</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>

											</tr>

											<tr>
												<td>3</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>

											</tr>

											<tr>
												<td>4</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>

											</tr>

											<tr>
												<td>5</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>

											</tr>

											<tr>
												<th rowspan="5">Chiều</th>
												<td>6</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>

											</tr>



											<tr>
												<td>7</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>

											</tr>

											<tr>
												<td>8</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>

											</tr>

											<tr>
												<td>9</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>

											</tr>

											<tr>
												<td>10</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>

											</tr>


										</tbody>
									</table>
								</div>
							</div>
						</div>

					</div>
				</div>




				<!-- /. ROW  -->
				
				  <div class="row">
				 	<div class="col-md-12 huongdan">
				 	
				 		<h3>Mức Độ Hoàn Thiện</h3>
				 		<h4 style="padding-top:5px">Các tính năng đã hoàn thiện</h4>
				 		<p style="padding-top:5px">Xem Thông Tin Học Sinh </p>
				 		<p style="padding-top:5px">Nhập Điệm Bộ Môn</p>
				 		
				 		<p style="padding-top:5px">===============================================================================</p>
				 		<p style="padding-top:5px">Chưa xử lý 1 đống paramet post err bên JSP</p>
				 		<h4 style="padding-top:5px">Các tính năng chưa hoàn thiện 100%</h4>
				 		<p style="padding-top:5px">Thông Tin Cá Nhân - same info student -only view chưa có tinh năng sửa (disable)</p>
				 		<p style="padding-top:5px">Đánh Giá Hạnh Kiểm - only view chưa có tinh năng sửa (disable)</p>
				 		<p style="padding-top:5px">Tổng kết - chưa làm gì (disable)</p>
				 		<p style="padding-top:5px">Gửi mail học sinh - chưa làm gì (disable)</p>
				 		<p style="padding-top:5px">Tạo lớp học - (tính cho giáo vụ đang suy nghĩ (disable))</p>
				 	</div>
				</div>
				<!-- /. ROW  -->
				
				
				
				
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->
	
	



	<%@ include file="/view/jsinclude.jsp"%>
	
	


</body>
</html>
