package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TShenqingDAO;
import com.model.TShenqing;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class shenqingAction extends ActionSupport
{
	private Integer id;
	private Integer shetuanId;
	private int userId;
	private String liyou;
	
	private String shenqingshi;
	private String huifuxinxi;
	private String huifushi;
	
	private TShenqingDAO shenqingDAO;
	
	
	
	public String shenqingAdd()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		TShenqing shenqing=new TShenqing();
		
		//shenqing.setId(0);
		shenqing.setShetuanId(shetuanId);
		shenqing.setUserId(user.getId());
		shenqing.setLiyou(liyou);
		
		shenqing.setShenqingshi(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		shenqing.setHuifuxinxi("");
		shenqing.setHuifushi("");
		
		shenqingDAO.save(shenqing);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "申请成功，等待社团负责人审核");
		
		return "msg";
	}
	
	public String shenqingMana()
	{
		String sql = "from TShenqing";
		List shenqingList=shenqingDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("shenqingList", shenqingList);
		return ActionSupport.SUCCESS;
	}	
	
	public String shenqingDel()
	{
		TShenqing shenqing=shenqingDAO.findById(id);
		shenqingDAO.delete(shenqing);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}
	
	
	public String shenqingHuifu()
	{
		TShenqing shenqing=shenqingDAO.findById(id);
		
		shenqing.setHuifuxinxi(huifuxinxi);
		shenqing.setHuifushi(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		
		shenqingDAO.attachDirty(shenqing);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息回复完毕");
		return "msg";
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


	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getLiyou()
	{
		return liyou;
	}

	public void setLiyou(String liyou)
	{
		this.liyou = liyou;
	}

	public String getShenqingshi()
	{
		return shenqingshi;
	}

	public void setShenqingshi(String shenqingshi)
	{
		this.shenqingshi = shenqingshi;
	}

	public String getHuifuxinxi()
	{
		return huifuxinxi;
	}

	public void setHuifuxinxi(String huifuxinxi)
	{
		this.huifuxinxi = huifuxinxi;
	}

	public String getHuifushi()
	{
		return huifushi;
	}

	public void setHuifushi(String huifushi)
	{
		this.huifushi = huifushi;
	}

	public TShenqingDAO getShenqingDAO()
	{
		return shenqingDAO;
	}

	public void setShenqingDAO(TShenqingDAO shenqingDAO)
	{
		this.shenqingDAO = shenqingDAO;
	}
	
}
