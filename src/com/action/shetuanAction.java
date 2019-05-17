package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TShetuanDAO;
import com.model.TShetuan;
import com.opensymphony.xwork2.ActionSupport;

public class shetuanAction extends ActionSupport
{
	private Integer id;
	private String mingcheng;
	private String jieshao;
	private String lishijian;
	
	private String fuzeren;
	private String loginname;
	private String loginpw;
	private String del;
	
	private String message;
	private String path;
	
	private TShetuanDAO shetuanDAO;
	
	
	
	public String shetuanAdd()
	{
		TShetuan shetuan=new TShetuan();
		
		shetuan.setMingcheng(mingcheng);
		shetuan.setJieshao(jieshao);
		shetuan.setLishijian(lishijian);
		shetuan.setFuzeren(fuzeren);
		
		shetuan.setLoginname(loginname);
		shetuan.setLoginpw(loginpw);
		shetuan.setDel("no");
		
		shetuanDAO.save(shetuan);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加成功");
		
		return "msg";
	}
	
	public String shetuanMana()
	{
		String sql = "from TShetuan where del='no'";
		List shetuanList=shetuanDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("shetuanList", shetuanList);
		return ActionSupport.SUCCESS;
	}	
	
	public String shetuanDel()
	{
		TShetuan shetuan=shetuanDAO.findById(id);
		shetuan.setDel("yes");
		shetuanDAO.attachDirty(shetuan);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}
	
	public String shetuanAll()
	{
		String sql = "from TShetuan where del='no'";
		List shetuanList=shetuanDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("shetuanList", shetuanList);
		return ActionSupport.SUCCESS;
	}	
	
	
	public String shetuanDetailQian()
	{
		TShetuan shetuan=shetuanDAO.findById(id);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("shetuan", shetuan);
		return ActionSupport.SUCCESS;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getMingcheng()
	{
		return mingcheng;
	}

	public void setMingcheng(String mingcheng)
	{
		this.mingcheng = mingcheng;
	}

	public String getJieshao()
	{
		return jieshao;
	}

	public void setJieshao(String jieshao)
	{
		this.jieshao = jieshao;
	}

	public String getLishijian()
	{
		return lishijian;
	}

	public void setLishijian(String lishijian)
	{
		this.lishijian = lishijian;
	}

	public String getFuzeren()
	{
		return fuzeren;
	}

	public void setFuzeren(String fuzeren)
	{
		this.fuzeren = fuzeren;
	}

	public String getLoginname()
	{
		return loginname;
	}

	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}

	public String getLoginpw()
	{
		return loginpw;
	}

	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}

	public String getDel()
	{
		return del;
	}

	public void setDel(String del)
	{
		this.del = del;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public TShetuanDAO getShetuanDAO()
	{
		return shetuanDAO;
	}

	public void setShetuanDAO(TShetuanDAO shetuanDAO)
	{
		this.shetuanDAO = shetuanDAO;
	}
	
}
