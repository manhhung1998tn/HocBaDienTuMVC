<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hocba.model.object.*" %>
<nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="home">THCS HaUI HN</a> 
            </div>
            <div style="color: white;
            padding: 15px 50px 5px 50px;
            float: right;
            font-size: 16px;"> 
            <% 
            	AccoutObject accoutlogin = (AccoutObject)request.getSession().getAttribute("UserLogin");
            	out.print(accoutlogin.getAccout_fullname());
            
            %> 
             &nbsp;
            <a href="#" class="btn btn-success "><i class="fa fa-envelope fa-1x"></i>123</a> 
           
            &nbsp; 
            &nbsp; <a href="login" class="btn btn-danger "><i class="fa fa-power-off fa-1x"></i>&nbsp;Logout</a> </div>
</nav> 