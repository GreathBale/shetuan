<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">
         function userReg()
         {
                var url="<%=path %>/site/userReg/userReg.jsp";
                var ret = window.open(url,"","dialogWidth:800px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
         }
    </script>
	
  </head>
  
  <body>
          <div id="logo">
	         <br/><br/><br/><span style="font-size: 25px;">学生社团管理系统</span>
	      </div>
	      <div id="nav">
	        <ul>
	          <li><a href="<%=path %>/index.action" style="font-family: 微软雅黑;font-size: 12px;">系统首页</a></li>
	          <li><a href="#" onclick="userReg()" style="font-family: 微软雅黑;font-size: 12px;">学生注册</a></li>
	          <li><a href="<%=path %>/huodongAll.action" style="font-family: 微软雅黑;font-size: 12px;">社团活动</a></li>
	          <li><a href="<%=path %>/liuyanAll.action" style="font-family: 微软雅黑;font-size: 12px;">系统留言板</a></li>
	        </ul>
	      </div>
	      <div id="news">
	        <jsp:include flush="true" page="/site/userlogin/userlogin.jsp"></jsp:include>
	        <div class="hr-dots"> </div>
	      </div>
	      
  </body>
</html>
