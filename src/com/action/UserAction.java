package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TUserDAO;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport
{
	private Integer id;
	private String xuehao;
	private String xingming;
	private String xingbie;

	private String nianling;
	private String banji;
	private String loginpw;
	private String del;
	
	private String message;
	private String path;
	
	private TUserDAO userDAO;
	
	
	
	public String userReg()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TUser where xuehao='"+xuehao.trim()+"'";
		List list=userDAO.getHibernateTemplate().find(sql);
		if(list.size()>0)
		{
			request.put("msg", "学号重复。请重新输入");
		}
		else
		{
			TUser user=new TUser();
			
			user.setXuehao(xuehao);
			user.setXingming(xingming);
			user.setXingbie(xingbie);
			user.setNianling(nianling);
			
			user.setBanji(banji);
			user.setLoginpw(loginpw);
			user.setDel("no");
			
			userDAO.save(user);
			
			
			request.put("msg", "注册成功。请登录");
		}
		
		return "msg";
	}
	
	public String userMana()
	{
		String sql = "from TUser where del='no'";
		List userList=userDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}	
	
	public String userDel()
	{
		TUser user=userDAO.findById(id);
		user.setDel("yes");
		userDAO.attachDirty(user);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "操作成功");
		return "msg";
	}
	
	
	public String userDetail()
	{
		String sql = "from TUser where id=?";
		Object[] c={id};
		List userList=userDAO.getHibernateTemplate().find(sql,c);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}	
	

	public String getBanji()
	{
		return banji;
	}

	public void setBanji(String banji)
	{
		this.banji = banji;
	}

	public String getDel()
	{
		return del;
	}

	public void setDel(String del)
	{
		this.del = del;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getLoginpw()
	{
		return loginpw;
	}

	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getNianling()
	{
		return nianling;
	}

	public void setNianling(String nianling)
	{
		this.nianling = nianling;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public TUserDAO getUserDAO()
	{
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

	public String getXingbie()
	{
		return xingbie;
	}

	public void setXingbie(String xingbie)
	{
		this.xingbie = xingbie;
	}

	public String getXingming()
	{
		return xingming;
	}

	public void setXingming(String xingming)
	{
		this.xingming = xingming;
	}

	public String getXuehao()
	{
		return xuehao;
	}

	public void setXuehao(String xuehao)
	{
		this.xuehao = xuehao;
	}

}
