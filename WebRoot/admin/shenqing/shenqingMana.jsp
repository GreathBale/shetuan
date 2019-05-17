<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		
        <script language="javascript">
           function shenqingDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/shenqingDel.action?id="+id;
               }
           }
           
           function shenqingHuifu(id)
           {
               if(confirm('您确定回复吗？'))
               {
                   var url="<%=path %>/admin/shenqing/shenqingHuifu.jsp?id="+id;
                   var ret = window.open(url,"","dialogWidth:500px; dialogHeight:200px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
                   window.location.reload();
               }
           }
           
           function userDetail(id)
           {
               var url="<%=path %>/userDetail.action?id="+id;
               var ret = window.open(url,"","dialogWidth:800px; dialogHeight:200px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
           }
        </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="41" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="10%">学生信息</td>
					<td width="20%">加入理由</td>
					<td width="10%">申请时间</td>
					
					<td width="10%">回复信息</td>
					<td width="10%">回复时间</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.shenqingList}" var="shenqing" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 ${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <a style="color: red" href="#" onclick="userDetail(${shenqing.userId})">学生信息</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${shenqing.liyou}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${shenqing.shenqingshi}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						 ${shenqing.huifuxinxi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${shenqing.huifushi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="shenqingDel(${shenqing.id})"/>
						<input type="button" value="回复" onclick="shenqingHuifu(${shenqing.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
