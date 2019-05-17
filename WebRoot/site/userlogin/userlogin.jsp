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
	
	<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
     
    <script type="text/javascript">
            function check()
			{                                                                                         
			     if(document.ThisForm.loginname.value=="")
				 {
				 	alert("请输入账号");
					return false;
				 }
				 if(document.ThisForm.loginpw.value=="")
				 {
				 	alert("请输入密码");
					return false;
				 }
				 document.getElementById("indicator").style.display="block";
				 loginService.login(document.ThisForm.loginname.value,document.ThisForm.loginpw.value,1,callback);
			}
		
			function callback(data)
			{
			    document.getElementById("indicator").style.display="none";
			    if(data=="no")
			    {
			        alert("账号或密码错误");
			    }
			    if(data=="yes")
			    {   
			        alert("登陆成功");
			        var url="<%=path %>/site/default.jsp";
			        window.location.href=url;
			    }
			}
	        
	        
	        
	        function userLogout()
	        {
	            document.getElementById("indicator1").style.display="block";
	            loginService.userLogout(callback1);
	        }
	        function callback1(data)
			{
			    document.getElementById("indicator1").style.display="none";
			    if(data=="no")
			    {
			        alert("系统错误，请联系管理员");
			    }
			    if(data=="yes")
			    {   
			        alert("安全退出系统");
			        var url="<%=path %>/site/default.jsp";
			        window.location.href=url;
			    }
			    
			}
			
			
			function c()
	        {
	           if(document.form1.goodsName.value=="")
	           {
	               alert("请输入关键字");
	               return false;
	           }
	           document.form1.submit();
	        }
	        
	        
      </script>
	
  </head>
     <TABLE border=0 cellSpacing=3 cellPadding=3 width=178 height=22>
		 <TR>
		     <TD height=22 vAlign=middle width="100%">
                    <c:if test="${sessionScope.userType !=1}">
                    <form action="<%=path %>/user?type=userLogin" name="ThisForm" method="post">
			        <table cellspacing="0" cellpadding="0" width="98%" align="center" border="0" height="60">
			          <tr>
			            <td align="center" colspan="2" height="10"></td>
			          </tr>
			          <tr>
			            <td align="right" width="31%" height="30" style="font-size: 11px;">学号：</td>
			            <td align="left" width="69%"><input name="loginname" type="text" style="width: 100px;"/></td>
			          </tr>
			          <tr>
			            <td align="right" height="30" style="font-size: 11px;">密码：</td>
			            <td align="left"><input type="password" style="width: 100px;" name="loginpw"/></td>
			          </tr>
			          <tr>
			            <td align="center" colspan="2" height="3"></td>
			          </tr>
			          <tr>
			            <td align="right" height="30" style="font-size: 11px;">&nbsp;</td>
			            <td align="left">
			                <input type="button" value="登录" onclick="check()" style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px;font-family: 微软雅黑;width: 50px;" />
			                <input type="reset" value="重置" style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px;font-family: 微软雅黑;width: 50px;" />
			                <img id="indicator" src="<%=path %>/images/loading.gif" style="display:none"/>
			            </td>
			          </tr>
			        </table>
				    </form>
				    </c:if>
				    <c:if test="${sessionScope.userType==1}">
				        <br/>
				                        欢迎您：${sessionScope.user.xuehao}
					    <a href="#" onclick="userLogout()">退出</a> 
					    <img id="indicator1" src="<%=path %>/images/loading.gif" style="display:none"/>
					    <br/><br/><br/>
					</c:if>
             </TD>           
		 </TR>
	 </TABLE>
  <body>
      
  </body>
</html>
