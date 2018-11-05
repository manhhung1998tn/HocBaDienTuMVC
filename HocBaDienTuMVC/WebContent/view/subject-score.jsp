<%@page import="hocba.model.object.ClassesObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hocba.model.ClassesModel"%>
<%@page import="hocba.util.Utilities"%>
<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="<%=request.getContextPath() %>/assets/js/jquery-3.3.1.min.js"></script>
<style type="text/css">
	.huongdan{
		color: red;
	}
</style>
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
                            	 <form id="form-select">
                                <thead>
                                    <tr>
                                        <td>
                                        
                                             <select class="form-control" name="classSubject" id="classSubject" >
                                                 <%=(String)session.getAttribute("slClassSubject")%>
                                             
                             
                                             </select>
                                        </td>

                                        <td>
                                             <select class="form-control" name="subjectSubject" id="subjectSubject" >
                                                 <%=(String)session.getAttribute("slSubjectName")%>      
                                             </select>
                                        </td>


                                        <td>
                                             <select class="form-control" name="termSubject" id="termSubject" >
                                                <option value="0" selected disabled hidden>Chọn Kỳ</option>
                                                <option value="1">Kỳ 1</option>
                                                <option value="2">Kỳ 2</option>
                                                <option value="3">Tổng Kết</option>
                                             </select>
                                        </td>

                                       

                                        <td>
                                        	
                                        	<select class="form-control" name="typeScore" id="typeScore">
                                                <option value="0" selected>Tổng Quan</option>
                                                <option value="1">Nhập Điểm 15p</option>
                                                <option value="2">Nhập Điểm 45p</option>
                                                <option value="3">Nhập Điểm Thi</option>
                                             </select>
                                             <!-- <button type="submit" class="btn btn-default">Duyệt</button> -->
                                        </td>
                                        <input type="hidden" id="custId" name="custId" value="">
                                    </tr>
                                </thead>
                                </form>
                                
                             
                            </table>
                            

                        
                        
                         
                         
                    </div>
                    
                </div>
               <hr>
               <form id="form-edit">
               <input type="hidden" id="termSubject-copy" name="termSubject" value="-1">
               <input type="hidden" id="typeScore-copy" name="typeScore" value="0">
               <input type="hidden" id="custIdEdit" name="custId" value="">
                <div class="row">
                    <div class="col-md-12">
                         <div class="table-responsive">
                                    <%
                                    	String tb = (String)session.getAttribute("tbSubject");
                                    	if(tb != null){
                                    		out.print(tb);
                                    	}
                                    %>
                             

                        </div>
                    </div>

                </div>
               
                <hr>
                <div class="row">
                    <div class="col-md-12">
                        
                            <table class="table">
                                <thead>
                                    <tr>
                                        <td>
                                            <button type="submit" class="btn btn-default">Nhập Điểm Từ File excel</button>
                                        </td>

                                      

                                       

                                        <td rowspan="2">
                                             <button type="submit" class="btn btn-default">Xuất Danh Sách Ra File</button>
                                        </td>
                                        <td style="">
                                            <button style="float: right; width: 100px;" type="submit" id="submit" class="btn btn-primary">Lưu</button>
                                        </td>
                                    </tr>
                                    
                                </thead>
                            </table>
                            

                       
                         
                    </div>
                </div>

                </form>
                <div class="row">
				 	<div class="col-md-12 huongdan">
				 	
				 		<h3>Hướng Dẫn Sử Dụng</h3>
				 		<h4 style="padding-top:5px">Các tính năng đã hoàn thiện</h4>
				 		<p style="padding-top:5px">Cách hiện thi danh sách học sinh : Chọn Lớp -> chọn môn dạy -> chọn kỳ cần xem</p>
				 		<p style="padding-top:5px">Update điểm 15 hoặc 45 sẽ tự động update điểm trung binh môn kỳ tương ứng</p>
				 		<p style="padding-top:5px">Update Thi cuối Kỳ sẽ tự động update điểm tổng kết cả kỳ tương ứng (phải có điểm trung bình môm rồi)</p>
				 		<p style="padding-top:5px">Update điểm tổng kết 2 kỳ sẽ tự động update đểm tổng kết môn cả năm</p>
				 		<p style="padding-top:5px">===============================================================================</p>
				 		<p style="padding-top:5px">Quy Tắc Nhập Điểm : Mục đích giảm bớt số lần nhập số 0</p>
				 		<p style="padding-top:5px">===========>Nhập 7 <=> 7.00 tư tương tự với số từ 1 -> 10</p>
				 		<p style="padding-top:5px">===========>Nhập 77 <=> 7.70 tư tương tự với số từ 11 -> 99</p>
				 		<p style="padding-top:5px">===========>Nhập 777 <=> 7.77 tư tương tự với số từ 100 -> 1000</p>
				 		<p style="padding-top:5px">===========>Màu đỏ : nhập sai</p>
				 		<p style="padding-top:5px">===========>Màu xanh : nhập đúng</p>
				 		<p style="padding-top:5px">Sau khi nhập điểm hoản tất nhất phím Lưu để Lưu điểm</p>
				 		<p style="padding-top:5px">===============================================================================</p>
				 		<h4 style="padding-top:5px">Các tính năng chưa hoàn thiện</h4>
				 		<p style="padding-top:5px">Nhập Điểm Từ Excel : Nhập 1 file exel chưa đủ thông tin điểm của học sinh</p>
				 		<p style="padding-top:5px">Xuất File Exel Mẫu : Xuất ra File exel mấu chưa tên cột giúp nhập điểm nhanh</p>
				 		<p style="padding-top:5px"></p>
				 		<p style="padding-top:5px"></p>
				 	</div>
				</div>
                     







          
            </div>
			
			
			
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->

	<script type="text/javascript">
	 console.log("deo hieu");	
	
     $(document).ready(function() {	
    	
    	// $('.dataScore input').on("load",function(){
   		  //if($(this).val() == ""){//rgb(254, 247, 224)
   			//  $(this).attr("style","red");
   		  //}
   		  
   //	});
    	 
    	 $('.dataScore input').on("input", function() {
    		    var dInput = this.value.substr(this.value.length-1);
    		    if(!$.isNumeric(dInput)){
    		    	$(this).val(function(){
    		    		return $(this).val().substr(0,this.value.length-1);
    		    	});
    		    }

    		    if(this.value.replace(/\./g,'').length > 4){
    		    	$(this).val(function(){
    		    		return $(this).val().substr(0,4);
    		    	});
    		    }
    		    
    		   
    		});
    	 //
    	 
    	 
    	 
    	 
    	 
    	 $(this).attr("style","background:#d9534f");
    	 $('.dataScore input').change(function() {
    		 console.log("vao change");
			var val = this.value.replace(/\./g,'');
			var check = true;
			if(!$.isNumeric(val)){
		    	check = false;
		    }else{
		    	var valInt = parseInt(val);
		    	if(valInt <= 0 || valInt > 1000){
		    		check = false;
		    	}
		    	if(valInt <= 10 && valInt >= 0 && check){
		    		$(this).val(function() {
						return valInt + ".00";
					});
		    	}
		    	if(valInt <= 99 && valInt > 10 && check){
		    		$(this).val(function() {
		    			var tmp = valInt/10;
		    			if(Number.isInteger(tmp)){
		    				return tmp + ".00";
		    			}
		    			var tmpStr = tmp.toString();
		    			if(tmpStr.substring(tmpStr.indexOf(".") + 1,tmpStr.length).length <= 1){
		    				return tmpStr + "0";
		    			}
		    			
						return tmp;
					});
		    	}
		    	
		    	if(valInt <= 1000 && valInt > 99 && check){
		    		$(this).val(function() {
		    			var tmp = valInt/100;
		    			if(Number.isInteger(tmp)){
		    				return tmp + ".00";
		    			}
		    			
		    			
		    			var tmpStr = tmp.toString();
		    			if(tmpStr.substring(tmpStr.indexOf(".") + 1,tmpStr.length).length <= 1){
		    				return tmpStr + "0";
		    			}
		    			
						return tmp;
					});
		    	}
		    }
			
			
			
			
			
			
			if(!check){
				$(this).attr("style","background:#d9534f");
			}else{
				$(this).attr("style","background:#ccffcc");
				
			}
			
			
		});
    	 
    	 function inputSubmit(check) {
			if(check){
				
			}else{
				
			}
		
    	 }
    	 <%
    	 
	    	 String termSubject = (String)session.getAttribute("termSubject");
	    	 if(termSubject != null && !termSubject.equals("")){
	    		 out.print("$('#termSubject').val('"+ termSubject +"');");
	    	 }else{
	    		 out.print("$('#termSubject').val('"+ 0 +"');");
	    	 }
	    	 
	    	 String typeScore = (String)session.getAttribute("typeScore");
	    	 if(termSubject != null && !termSubject.equals("")){
	    		 out.print("$('#typeScore').val('"+ typeScore +"');");
	    	 }else{
	    		 out.print("$('#typeScore').val('"+ 0 +"');");
	    	 }
    	 
    	 %>
    	 console.log('typeScore : ' + $('#typeScore').val() );
    	 console.log('termSubject : ' + $('#termSubject').val());
    	 
    	 
    	 $("#termSubject-copy").val( $("#termSubject").val());
    	 $("#typeScore-copy").val( $("#typeScore").val());
    	 console.log("term change");
    	 if( $("#termSubject").val() == 1){
    		  $('#typeScore').attr('disabled', false);
  		   $("#term-1").attr("style", "");
  	    	$("#term-2").attr("style", "display:none");
  	    	 $("#average").attr("style", "display:none");
  		   $("#custIdEdit").val("3");
  	   }else if($("#termSubject").val() == 2){
  		  $('#typeScore').attr('disabled', false);
  		   $("#term-1").attr("style", "display:none");
  	    	 $("#term-2").attr("style", "");
  	    	 $("#average").attr("style", "display:none");
  		   $("#custIdEdit").val("4");
  	   }else if($("#termSubject").val() == 3){
  		   
  		  $('#typeScore').attr('disabled', true);
	  		$('#typeScore').val('0');
  		 
  		   
  		   $("#term-1").attr("style", "display:none");
  	    	 $("#term-2").attr("style", "display:none");
  	    	 $("#average").attr("style", "");
  		   $("#custIdEdit").val("5");
  	   }else{
  		  $('#typeScore').attr('disabled', true);
  		   $("#term-1").attr("style", "display:none");
	    	 $("#term-2").attr("style", "display:none");
	    	 $("#average").attr("style", "display:none");
  	   }
    	 
    	 $("#submit").click(function(){

    		 $("#form-edit").attr('method', 'POST');
         	   $("#form-edit").attr('action', 'subject');
         	   $("#form-edit").submit();
    	 });
  	   	
    	 $("#termSubject").change(function(){
    		  $("#termSubject-copy").val( $("#termSubject").val());
        	   console.log("class name change");
        	   if( $("#termSubject").val() == 1){
        		   $('#typeScore').attr('disabled', false);
        		   $("#term-1").attr("style", "");
        	    	$("#term-2").attr("style", "display:none");
        	    	 $("#average").attr("style", "display:none");
        		   $("#custIdEdit").val("3");
        	   }else if($("#termSubject").val() == 2){
        		   $('#typeScore').attr('disabled', false);
        		   $("#term-1").attr("style", "display:none");
        	    	 $("#term-2").attr("style", "");
        	    	 $("#average").attr("style", "display:none");
        		   $("#custIdEdit").val("4");
        	   }else if($("#termSubject").val() == 3){
        		   $('#typeScore').attr('disabled', true);
        	  		$('#typeScore').val('0');
        		   
        		   
        		   $("#term-1").attr("style", "display:none");
        	    	 $("#term-2").attr("style", "display:none");
        	    	 $("#average").attr("style", "");
        		   $("#custIdEdit").val("5");
        	   }else{
        		   $('#typeScore').attr('disabled', true);
        		   $("#term-1").attr("style", "display:none");
      	    	 $("#term-2").attr("style", "display:none");
      	    	 $("#average").attr("style", "display:none");
        	   }
        	  
           });
    	 
    	 
    	
    	 
    	 $("#typeScore").change(function(){        	   
    		 $("#custId").val("2");
        	   $("#form-select").attr("method", "POST");
        	   $("#form-select").attr("action", "subject");
        	   $("#form-select").submit();
           });
    	 
    	 
    	 
         $("#classSubject").change(function(){
      	   console.log("class name change");
      	   $("#custId").val("1");
      	   
      	   
      	   $("#form-select").attr("method", "POST");
      	   $("#form-select").attr("action", "subject");
      	   $("#form-select").submit();
         });
          
         
			$("#subjectSubject").change(function(){
				console.log("subjectSubject change");
				 $("#custId").val("2");
				
				 
				$("#form-select").attr('method', 'POST');
           	   $("#form-select").attr('action', 'subject');
           	   $("#form-select").submit();
         });
			
		
     }); 
	</script>


	<%@ include file="/view/jsinclude.jsp"%>


</body>
</html>
