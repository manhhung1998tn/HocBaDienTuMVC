<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>


<nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li class="text-center">
                        <img src="<%=request.getContextPath() %>/assets/img/find_user.png" class="user-image img-responsive"/>
                    </li>


                    <li>
                        <a  href="home"><i class="fa fa-home fa-1x"></i> Trang Chủ</a>
                    </li>
                    <li>
                        <a  href="accoutview"><i class="fa fa-home fa-1x"></i>Người Sử Dụng</a>
                    </li>
                      <li>
                        <a href="#"><i class="fa fa-user fa-1x"></i>Thông tin cá nhân<span class="fa arrow"></span></a>
                        <ul class="nav">
                            <li>
                                <a href="infouser">Cập Nhật Thông Tin</a>
                            </li>
                            <li>
                                <a href="#">Đổi Mật Khẩu</a>
                            </li>
                           
                        </ul>
                    </li>

                    <li>
                        <a  href="subject"><i class="fa fa-desktop fa-1x"></i>Quản Lý Điểm Bộ Môn</a>
                    </li>


                    <li>
                        <a href="#"><i class="fa fa-users fa-1x"></i>Quản Lý Lớp Học<span class="fa arrow"></span></a>
                        <ul class="nav">
                            <li>
                                <a href="infostudent">Thông Tin Học Sinh</a>
                            </li>
                            <li>
                                <a href="accademic">Tổng Kết Học Kỳ</a>
                            </li>
                            <!--  
                            <li>
                                <a href="#">Đánh Giá Hạnh Kiểm</a>
                            </li>
                            

                            
                             <li>
                                <a href="#">Gửi Mail Đến Học Sinh</a>
                            </li>
							-->
                           
                        </ul>
                    </li> 
					<!-- 
                    <li>
                        <a disable  href="#"><i class="fa fa-user-plus fa-1x"></i>Tạo Lớp Học Mới</a>
                    </li> -->




                    
                  
                </ul>

            </div>
            
        </nav>   