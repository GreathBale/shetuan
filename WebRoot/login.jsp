<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<STYLE type=text/css>
		BODY{TEXT-ALIGN: center; PADDING-BOTTOM: 0px; BACKGROUND-COLOR: #ddeef2; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; PADDING-TOP: 0px}
		A:link {
			COLOR: #000000; TEXT-DECORATION: none
		}
		A:visited {
			COLOR: #000000; TEXT-DECORATION: none
		}
		A:hover {
			COLOR: #ff0000; TEXT-DECORATION: underline
		}
		A:active {
			TEXT-DECORATION: none
		}
		.input {
			BORDER-BOTTOM: #ccc 1px solid; BORDER-LEFT: #ccc 1px solid; LINE-HEIGHT: 20px; WIDTH: 182px; HEIGHT: 20px; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid
		}
		.input1 {
			BORDER-BOTTOM: #ccc 1px solid; BORDER-LEFT: #ccc 1px solid; LINE-HEIGHT: 20px; WIDTH: 120px; HEIGHT: 20px; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid
		}
	</STYLE>
	
	<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
       
	<script language="javascript">
		function check1()
		{                                                                                         
		     if(document.ThisForm.userName.value=="")
			 {
			 	alert("请输入用户名");
				document.ThisForm.userName.focus();
				return false;
			 }
			 if(document.ThisForm.userPw.value=="")
			 {
			 	alert("请输入密码");
				document.ThisForm.userPw.focus();
				return false;
			 }
			 if(document.ThisForm.userType.value=="-1")
			 {
			 	alert("请选择登陆身份");
				document.ThisForm.userType.focus();
				return false;
			 }
			 document.getElementById("indicator").style.display="block";
			 loginService.login(document.ThisForm.userName.value,document.ThisForm.userPw.value,document.ThisForm.userType.value,callback);
		}
		
		function callback(data)
		{
		    document.getElementById("indicator").style.display="none";
		    if(data=="no")
		    {
		        alert("用户名或密码错误");
		    }
		    if(data=="yes")
		    {
		        alert("通过验证,系统登录成功");
		        window.location.href="<%=path %>/loginSuccess.jsp";
		    }
		    
		}
    </script>
  </head>
  
  <BODY>
      <DIV style="MARGIN: 0px auto; WIDTH: 936px;margin-top: 180px;font-family: 微软雅黑;font-size: 33px;">
                           学生社团管理系统
      </DIV>
      <DIV style="BACKGROUND-COLOR: #278296;margin-top: 20px;">
	      <DIV style="MARGIN: 0px auto; WIDTH: 936px">
		      <DIV style="BACKGROUND: url(<%=path %>) no-repeat; HEIGHT: 155px">
			      <DIV style="TEXT-ALIGN: left; WIDTH: 360px; FLOAT: right; HEIGHT: 200px; _height: 95px;">
				      <form action="<%=path %>/admin/index.jsp" name="ThisForm" method="post">
				      <TABLE border=0 cellSpacing=0 cellPadding=0 width="100%">
				          <TR>
					          <TD style="HEIGHT: 18px">
					              &nbsp;
					          </TD>
				          </TR>
				          <TR>
					          <TD style="HEIGHT: 30px">
					              <span style="font-family: 微软雅黑;font-size: 13px;"> 账号：</span>
					              <INPUT type=text name=userName style="width: 110px;">
					          </TD>
				          </TR>
				          <TR>
					          <TD style="HEIGHT: 30px">
					              <span style="font-family: 微软雅黑;font-size: 13px;"> 密码：</span>
					              <INPUT type="password" name=userPw style="width: 110px;">
					          </TD>
				          </TR>
				          <TR>
					          <TD style="HEIGHT: 50px">
					              <span style="font-family: 微软雅黑;font-size: 13px;"> 类型：</span>
					              <!-- <input type="radio" name="userType" value="0" checked="checked"><span style="font-family: 微软雅黑;font-size: 13px;">管理员</span>
					              &nbsp;&nbsp;
					              <input type="radio" name="userType" value="1"><span style="font-family: 微软雅黑;font-size: 13px;">操作员</span>
					              &nbsp;&nbsp; -->
					              <select class="INPUT_text" name="userType" style="height:20px;width:115px;">
									<option value="0">系统管理员</option>
									<option value="2">社团负责人</option>
								  </select>
					              <input type="button" value="登陆" style="width: 80px;" onclick='check1()'>
					              <img id="indicator" src="<%=path %>/images/loading.gif" style="display:none"/>
					          </TD>
				          </TR>   
					  </TABLE>
					  </form>
			      </DIV>
		      </DIV>
	      </DIV>
      </DIV>
  </BODY>
</html>
