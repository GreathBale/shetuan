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
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	
	<script type="text/javascript">
	$(function(){
		//setMenuHeight
		$('.menu').height($(window).height()-51-27-26-5);
		$('.sidebar').height($(window).height()-51-27-26-5);
		$('.page').height($(window).height()-51-27-26-5);
		$('.page iframe').width($(window).width()-15-168);
		
		//menu on and off
		$('.btn').click(function(){
			$('.menu').toggle();
			
			if($(".menu").is(":hidden")){
				$('.page iframe').width($(window).width()-15+5);
				}else{
				$('.page iframe').width($(window).width()-15-168);
					}
			});
			
		//
		$('.subMenu a[href="#"]').click(function(){
			$(this).next('ul').toggle();
			return false;
			});
	})
	</script>
	
  </head>
  
  <body style="background: #e6f4fa;">
    <c:if test="${sessionScope.userType==0 }">
    <div class="menu fleft">
    	<ul>
        	<li class="subMenuTitle">导航菜单</li>
            <li class="subMenu"><a href="#">修改密码</a>
            	<ul style="display: none">
                	<li><a style="margin-left: 15px;" href="<%=path %>/admin/userinfo/userPw.jsp" target="I2">修改密码</a></li>
                </ul>
            </li>
            <li class="subMenu"><a href="#">留言管理</a>
            	<ul style="display: none">	
                	<li><a style="margin-left: 15px;" href="<%=path %>/liuyanMana.action" target="I2">留言管理</a></li>
                </ul>
            </li>
            <li class="subMenu"><a href="#">社团管理</a>
            	<ul style="display: none">
                	<li><a style="margin-left: 15px;" href="<%=path %>/shetuanMana.action" target="I2">社团管理</a></li>
                	<li><a style="margin-left: 15px;" href="<%=path %>/admin/shetuan/shetuanAdd.jsp" target="I2">添加社团</a></li>
                	
                </ul>
            </li>
            
              <li class="subMenu"><a href="#">活动管理</a>
            	<ul style="display: none">
                	<li><a style="margin-left: 15px;" href="<%=path %>/huodongShenheQuery.action" target="I2">活动审核</a></li>
                	
                </ul>
            </li>
        </ul>
    </div>
    </c:if>
    
    
    
    
    
    <c:if test="${sessionScope.userType==2 }">
    <div class="menu fleft">
    	<ul>
        	<li class="subMenuTitle">导航菜单</li>
            <li class="subMenu"><a href="#">申请管理</a>
            	<ul style="display: none">
                	<li><a style="margin-left: 15px;" href="<%=path %>/shenqingMana.action" target="I2">会员申请</a></li>
                	<li><a style="margin-left: 15px;" href="<%=path %>/userMana.action" target="I2">会员管理</a></li>
                	<li><a style="margin-left: 15px;" href="<%=path %>/admin/huodong/huodongAdd.jsp" target="I2">活动申请</a></li>
                	
                </ul>
            </li>
            <li class="subMenu"><a href="#">社团活动</a>
            	<ul style="display: none">
                	<li><a style="margin-left: 15px;" href="<%=path %>/huodongMana.action" target="I2">社团活动</a></li>
                </ul>
            </li>
        </ul>
    </div>
    </c:if>
</body>
</html>
