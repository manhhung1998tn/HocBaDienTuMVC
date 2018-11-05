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
			           <!--CONTENT-->
            <div id="page-inner">
                
            <div class="row">

                <div class="col-md-12">
                    <form>
                        <table class="table">
                            <thead>
                                <tr>
                                    <td>
                                         <select class="form-control" >
                                            <option value="" selected disabled hidden>Chọn Lớp</option>
                                            <option>10A1</option>
                                            <option>10A2</option>
                                            <option>11A3</option>
                                            
                                         </select>
                                    </td>

                                    <td>
                                         <select class="form-control" value = "Chọn Lớp">
                                            <option value="" selected disabled hidden>Chọn Nắm</option>
                                            <option>Năm 1</option>
                                            <option>Năm 2</option>
                                            <option>Năm 3</option>
                                            
                                         </select>
                                    </td>


                                   

                                   

                                    <td rowspan="2">
                                         <button type="submit" class="btn btn-default">Duyệt</button>
                                    </td>
                                </tr>
                            </thead>
                        </table>
                        

                    </form>
                     
                </div>
                
            </div>
            <!--END ROW-->
           <hr>

           <div class="row">
                <div class="col-md-12">
                    <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                 <thead>
                                        <tr>
                                            <th>STT</th>
                                            <th>Họ Tên</th>
                                            <th>Mã Học Sinh</th>
                                            <th>Điểm Tổng Kết</th>
                                            <th>Hạnh Kiểm</th>
                                            <th>Xếp Loại</th>
                                            <th>Thực Hiện</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                        <td>1</td>
                                        <td>Nguyễn Mạnh Hùng</td>                                        
                                         <td>1141360221</td>
                                        <td>9(tự tính)</td>                                                     
                                        <td>Khá(Tự Tính)</td>
                                        <td>Giỏi(Tự Tính)</th>                                        
                                        <td><a id="chitiet" href="#">Chi Tiết</a></td> 

                                        </tr>
                                    </tbody> 
                                    
                                </table>
                    </div>
                </div>

            </div>
            <hr>
            <h2>Chú Thích : Sẽ show ra khi ấn chi tiết từng học sinh</h2>
            <div id="ChiTiet">
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                
                                <thead>
                                    <tr>
                                        <th colspan="3" class="heade-table">Môn Học</th>
                                    </tr>
                                    <tr>
                                        <th>Tên Môn</th>
                                        
                                        <th>Đánh Giá Của GVBM</th>
                                        <th>Điểm</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Toán </td>
                                        
                                        <td>Chăm Chú Nghe Giảng</td>
                                        <td>10</td>
                                    </tr>

                                    <tr>
                                        <td>Văn </td>
                                        
                                        <td>Có tốt chất =))</td>
                                        <td>10</td>
                                    </tr>

                                    <tr>
                                        <td>Sử </td>
                                        
                                        <td></td><td>10</td>
                                    </tr>

                                    <tr>
                                        <td>Địa </td>
                                        
                                        <td></td><td>10</td>
                                    </tr>

                                    <tr>
                                        <td colspan="2">Tổng Kết : </td>
                                        <td >10</td>
                                    </tr>

                                    <hr>



                                </tbody>

                                <thead>
                                    <tr>
                                        <th colspan="3" class="heade-table">Hạnh Kiểm</th>
                                    </tr>
                                    <tr>
                                        <th>Học Kỳ</th>
                                        <th>Nhận Xét</th>
                                        <th>Xếp Loại</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                        <td>Kỳ 1</td>
                                        <td>Giúp đỡ thầy cô</td>
                                        <td>Giỏi</td>
                                    </tr>
                                    <tr>
                                        <td>Kỳ 2</td>
                                        <td>Nghỉ học hơi nhiều</td>
                                        <td>Khá</td>
                                    </tr>

                                    <tr>
                                        <td colspan="2">Tổng Kết</td>
                                        <td>Khá</td>
                                    </tr>
                                </tbody>

                                <thead>
                                    <tr>
                                        <th colspan="2" class="heade-table">Tổng Kết Cả Năm</th>
                                        <th>Khá</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
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
