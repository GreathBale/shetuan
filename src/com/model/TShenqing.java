package com.model;

/**
 * TShenqing entity. @author MyEclipse Persistence Tools
 */

public class TShenqing implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Integer shetuanId;
	private int userId;
	private String liyou;
	
	private String shenqingshi;
	private String huifuxinxi;
	private String huifushi;
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
}