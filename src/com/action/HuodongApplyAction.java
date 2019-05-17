
package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.THuodongDAO;
import com.dao.TShetuanDAO;
import com.model.THuodong;
import com.model.TShetuan;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HuodongApplyAction extends ActionSupport
{
	private Integer id;
	private Integer shetuanId;
	private String biaoti;
	private String neirong;
	
	private String shijian;
	private String didian;
	private String lianxiren;
	private String lianxihua;
	
	private THuodongDAO huodongDAO;
	private TShetuanDAO shetuanDAO;
	
	
	
	public String huodongAdd()
	{
		Map session=ActionContext.getContext().getSession();
		TShetuan shetuan=(TShetuan)session.get("shetuan");
		
		THuodong huodong=new THuodong();
		
		//huodong.setId(id);
		huodong.setShetuanId(shetuan.getId());
		huodong.setBiaoti(biaoti);
		huodong.setNeirong(neirong);
		
		huodong.setShijian(shijian);
		huodong.setDidian(didian);
		huodong.setLianxiren(lianxiren);
		huodong.setLianxihua(lianxihua);
		huodong.setStatus(new Integer(0));
		huodongDAO.save(huodong);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加成功");
		
		return "msg";
	}
	
	public String huodongMana()
	{
		Map session=ActionContext.getContext().getSession();
		TShetuan shetuan=(TShetuan)session.get("shetuan");
		
		String sql = "from THuodong where shetuanId="+shetuan.getId();
		List huodongList=huodongDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("huodongList", huodongList);
		return ActionSupport.SUCCESS;
	}	
	
	
	
	public String huodongDel()
	{
		THuodong huodong=huodongDAO.findById(id);
		huodongDAO.delete(huodong);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}
	
	public String huodongAll()
	{
		String sql = "from THuodong";
		List huodongList=huodongDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("huodongList", huodongList);
		return ActionSupport.SUCCESS;
	}	
	
	
	public String huodongDetailQian()
	{
		THuodong huodong=huodongDAO.findById(id);
		huodong.setShetuan(shetuanDAO.findById(huodong.getShetuanId()));
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("huodong", huodong);
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

	public Integer getShetuanId()
	{
		return shetuanId;
	}

	public void setShetuanId(Integer shetuanId)
	{
		this.shetuanId = shetuanId;
	}

	public String getBiaoti()
	{
		return biaoti;
	}

	public void setBiaoti(String biaoti)
	{
		this.biaoti = biaoti;
	}

	public String getNeirong()
	{
		return neirong;
	}

	public void setNeirong(String neirong)
	{
		this.neirong = neirong;
	}

	public String getShijian()
	{
		return shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

	public String getDidian()
	{
		return didian;
	}

	public void setDidian(String didian)
	{
		this.didian = didian;
	}

	public String getLianxiren()
	{
		return lianxiren;
	}

	public void setLianxiren(String lianxiren)
	{
		this.lianxiren = lianxiren;
	}

	public String getLianxihua()
	{
		return lianxihua;
	}

	public void setLianxihua(String lianxihua)
	{
		this.lianxihua = lianxihua;
	}

	public THuodongDAO getHuodongDAO()
	{
		return huodongDAO;
	}

	public void setHuodongDAO(THuodongDAO huodongDAO)
	{
		this.huodongDAO = huodongDAO;
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
