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
		<script type="text/css" href="<%=path %>/js/jquery.min.js" ></script>
        <script language="javascript">
           function huodongDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/huodongDel.action?id="+id;
               }
           }
           function contentRead(content)
           {
        	   window.alert(content);
               
           }
           function huodongPass(id)
           {
               if(confirm('您确定通过审核吗？'))
               {
                   window.location.href="<%=path %>/huodongPass.action?id="+id;
               }
           }
           function huodongReject(id)
           {
               if(confirm('您确定拒绝吗？'))
               {
                   window.location.href="<%=path %>/huodongReject.action?id="+id;
               }
           }
           
           function huodongAdd()
           {
                 var url="<%=path %>/admin/huodong/huodongAdd.jsp";
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="33" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
				    <td width="10%">序号</td>
					<td width="20%">活动标题</td>
					<td width="10%">活动时间</td>
					<td width="10%">活动地点</td>
					
					<td width="10%">联系人员</td>
					<td width="10%">联系电话</td>
					<td width="10%">审核状态</td>
					<td width="18%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.huodongList}" var="huodong" varStatus="sta">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${sta.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center" titte="${huodong.neirong}">
						${huodong.biaoti}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${huodong.shijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${huodong.didian}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						${huodong.lianxiren}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${huodong.lianxihua}
					</td>
					<td bgcolor="#FFFFFF" align="center" style="color:red">
						<c:if test="${huodong.status ==0}">
						待审核
                        </c:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					<span id="shenheOperate">
						<input type="button" value="查看内容" onclick="contentRead('${huodong.neirong}')"/>
						<input type="button" value="通过" onclick="huodongPass(${huodong.id})"/>
						<input type="button" value="拒绝" onclick="huodongReject(${huodong.id})"/>
						</span>
						<span id="deleteHistory" style="display:none">
						<input type="button" value="删除记录" onclick="huodongDel(${huodong.id})"/>
						</span>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			
	</body>
</html>
