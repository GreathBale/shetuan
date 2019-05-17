<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<link rel="stylesheet" href="<%=path %>/css/qiantai.css" type="text/css" charset="utf-8" />
	
	<style type="text/css">
		.c1-bline{border-bottom:#999 1px dashed;border-top:1px;}
		.f-right{float:right}
		.f-left{float:left}
		.clear{clear:both}
    </style>
	
	<script type="text/javascript">
    </script>
  </head>
  
  <body>
  <div id="wrapper">
      <div id="header"></div>
      <div id="left">
	      <jsp:include flush="true" page="/site/left.jsp"></jsp:include>
      </div>
      <div id="right">
      	  <!-- 111 -->
      	  <h2>活动详细信息</h2>
	      <div id="welcome">
	        <div>
	           <div class="c1-body">
                   <table width="100%" border="0" cellpadding="3" cellspacing="3">
						    <tr>
						       <td align="left">社团名称：${requestScope.huodong.shetuan.mingcheng }<hr/></td>
						    </tr>
						    <tr>
						       <td align="left">活动标题：<c:out value="${requestScope.huodong.biaoti }" escapeXml="false"></c:out><hr/></td>
						    </tr>
						    <tr>
						       <td align="left">活动内容：<c:out value="${requestScope.huodong.neirong }" escapeXml="false"></c:out><hr/></td>
						    </tr>
						    <tr>
						       <td align="left">活动时间：${requestScope.huodong.shijian }<hr/></td>
						    </tr>
						    <tr>
						       <td align="left">活动地点：${requestScope.huodong.didian }<hr/></td>
						    </tr>
						    <tr>
						       <td align="left">联系人员：${requestScope.huodong.lianxiren }<hr/></td>
						    </tr>
						    <tr>
						       <td align="left">联系方式：${requestScope.huodong.lianxihua }<hr/></td>
						    </tr>
	                    </table>
		       </div>
	        </div>
	        <!-- <p class="more"><a href="#">more</a></p> -->
	      </div>
	      <!-- 111 -->
      </div>
      <div class="clear"> </div>
      <div id="footer">
	      <div id="copyright">
	        Copyright &copy; 2013 Company Name All right reserved&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=path %>/login.jsp">系统后台登陆</a>
	      </div>
	      <div id="footerline"></div>
      </div>
  </div>
</body>
</html>
