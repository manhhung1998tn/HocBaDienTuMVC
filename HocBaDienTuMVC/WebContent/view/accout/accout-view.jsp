<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
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

			<!--CONTENT-->
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<table class="table">
							<thead>
								<td style="width: 40px;" ><intput type="checkbox" id="checkAll"/></td>
								<td>STT</td>
								<td>Ngày Tạo</td>
								<td>Tên Tài Khoản</td>
								<td>Tên Đầy Đủ</td>
								<td>Email</td>
								<td>Địa Chỉ</td>
								<td>Số Lần Login</td>
								<td colspan="2">Thực Thi</td>

								
								
							</thead>
								<%
									String tbListAccout = (String)session.getAttribute("tbListAccout");
									if(tbListAccout != null){
										out.print(tbListAccout);
									}
								%>
	
						
						</table>
					</div>
				</div> <!-- END ROW -->
			
				<div class="row">
					<div class="col-md-12">
						<%
							String pageHTML = (String)session.getAttribute("pageHTML");
							if(pageHTML != null){
								out.print(pageHTML);
							}
						%>
					</div>
				</div>
			
			
			
			
			</div>
			
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->




	<%@ include file="/view/jsinclude.jsp"%>


</body>
</html>
