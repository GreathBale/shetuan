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
            function shenqingAdd(shetuanId)
            {
                <c:if test="${sessionScope.userType!=1}">
	                  alert("请先登录");
	            </c:if>
	            <c:if test="${sessionScope.userType==1}">
	                 var strUrl = "<%=path %>/site/shenqing/shenqingAdd.jsp?shetuanId="+shetuanId;
		             var ret = window.open(strUrl,"","dialogWidth:700px; dialogHeight:400px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
		             window.location.reload();
	            </c:if>
            }
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
      	  <h2>社团详细信息</h2>
	      <div id="welcome">
	        <div>
	           <table width="100%" border="0" cellpadding="3" cellspacing="3">
						    <tr>
						       <td align="left">社团名称：${requestScope.shetuan.mingcheng }<hr/></td>
						    </tr>
						    <tr>
						       <td align="left">社团介绍：<c:out value="${requestScope.shetuan.jieshao }" escapeXml="false"></c:out><hr/></td>
						    </tr>
						    <tr>
						       <td align="left">成立时间：${requestScope.shetuan.lishijian }<hr/></td>
						    </tr>
						    <tr>
						       <td align="left">主负责人：${requestScope.shetuan.fuzeren }<hr/></td>
						    </tr>
						    <tr>
						       <td align="left"><input type="button" value="申请加入" onclick="shenqingAdd(${requestScope.shetuan.id })" style="width: 80px;font-family: 微软雅黑"/></td>
						    </tr>
	                    </table>
	        </div>
	        <!-- <p class="more"><a href="#">more</a></p> -->
	      </div>
	      <!-- 111 -->
      </div>
      <div class="clear"> </div>
      <div id="footer">
	      <div id="copyright">
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=path %>/login.jsp">系统后台登陆</a>
	      </div>
	      <div id="footerline"></div>
      </div>
  </div>
</body>
</html>
