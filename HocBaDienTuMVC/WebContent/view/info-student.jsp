<%@page import="hocba.util.Utilities"%>
<%@page import="hocba.model.StudentModel"%>
<%@page import="hocba.dao.StudentDAO"%>
<%@page import="hocba.model.ClassesModel"%>
<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ page import="java.util.*" %>
	<%@ page import="hocba.controller.*" %>
	<%@ page import="hocba.model.object.*" %>

	
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Học Bạ Điện Tử</title>
<%@ include file="/view/cssinclude.jsp"%>



	
<script src="<%=request.getContextPath() %>/assets/js/jquery-3.3.1.min.js"></script>
	
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
			  <div id="page-inner" class="view">
            <div class="row">

                <div class="col-md-12">
                    <form id="my-form" method="POST" action="infostudent">
                        <table class="table">
                            <thead>
                                <tr>
                                    <td style="width: 25%;">
                                         <select id="select-class" class="form-control" name="class" onchange="classChange(this.from)" >
                                           
                                            
                                            <%=(String)request.getSession().getAttribute("slClassInfoStudent")%>
                                            
                          
                                            
                                         </select>
                                    </td>

                                   

                                   <td colspan="2">
                                   <button type="submit" class="btn btn-default">Duyệt</button>
                                   </td>

                                    
                                </tr>
                            </thead>
                        </table>
                        <script type="text/javascript">
                        	/*
	                        function classChange(fn) {
	                			console.log("submit form");
	                			fn.method = "POST";
	                			fn.action = "infostudent";
	                			fn.submit();
	                		}
	                        */
	                        $(document).ready(function() {
	                        	$("#select-class").change(function(){
	                        		$('form#my-form').submit();
	                			});
	                        });
	                        
                	
                        </script>

                    </form>
                     
                </div>
                
            </div>

            <!--End row-->
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
                                            
                                            <th>SĐT</th>
                                            <th>Email</th>
                                            <th>Tên Người Giám Hộ</th>
                                          	<th>SĐT Người Giám Hộ</th>
                                            <th colspan="2">Thực Hiện</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <!-- Đưa từ classesDAO vào -->
                                       
                                        <%
                                        	
                                        	String infoStudent = (String)request.getSession().getAttribute("infoStudent");
                                        	if(infoStudent != null){
                                        		out.print(infoStudent);
                                        	}
                                        	
                                        	String fullInfoStudent = (String)request.getSession().getAttribute("fullInfoStudent");
                                        	if(infoStudent != null){
                                        		out.print(fullInfoStudent);
                                        	}
                                        	
                                        %>
                                        
                                        
                                       
                                  
                                       	
                                    </tbody> 
                                    
                                </table>
                    </div>
                </div>

            </div>
           
            <hr>
            <div id="info-student" style="display: none">

                <div id="page-wrapper">
                    <div ></div>
                    <div class="row">
                        <div class="col-md-12">
                            <div>
                            <table class="table">
                               <thead>
                                    <tr>
                                        <th colspan="2" class="heade-table">
                                            Thông tin chi tiết
                                        </th>
                                    </tr>
                               </thead>
                               <tbody id="info-content">
                                  

                               </tbody>
                            </table>
                        </div>
                            
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <input style="float:right;" onclick="hideInfo()" type="submit" name="" 
                            id="close-info-student" class="btn btn-primary" value="Đóng">
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


	<%
		/*
		if(listStudent != null && listStudent.size() != 0){
			out.print("<script type=\"text/javascript\">");
			out.print("var myJons{");
			for(StudentObject v : listStudent){		
				out.print("k" + v.getStudent_id() + ":" + Utilities.ObjectToJson(v));
				out.print(",");
				
	
			}
			
			out.print("};");
			out.print("</script>");
		}
	*/
	%>
	
	<jsp:include page="/view/jsinclude.jsp" flush="true"></jsp:include>
	
	<%
		String rs = Utilities.getValue(request.getParameter("rs"));
		if(rs != null){
			if(rs.equals("1")){
	%>
			<script type="text/javascript">
				alert("Sửa Thành Cồng");
			</script>
		
	<%
			}else if(rs.equals("0")){
	%>
			<script type="text/javascript">
				alert("Sửa Thất Bại");
			</script>
	<%		
			}
		}
	%>
	
	<script>
		
	
		
		
	
		function showInfo(a) {
			var index = a.getAttribute('index');
			
			
			//var str = infoStudentArray[parseInt(index)].student_name;
			//console.log(str);
			var divshow = document.getElementById("info-student");
			divshow.setAttribute('style', '');

			var str = "";
			var json = infoStudentArray[parseInt(index)];
			var arraykey = Object.keys(json);
			for(var i = 0; i < arraykey.length; ++i){
				str += "<tr>";
					var tmp = arraykey[i];
					str += "<td>" + tmp + "</td>";
					str += "<td>" + json[tmp] + "</td>";
				str += "</tr>";
			}
			
			
			
			
			document.getElementById("info-content").innerHTML = str;
		}
		
		
		function hideInfo() {
			document.getElementById("info-student").setAttribute('style', 'display: none;');
		}
    </script>
	

</body>
</html>
