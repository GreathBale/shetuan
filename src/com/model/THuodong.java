package com.model;

/**
 * THuodong entity. @author MyEclipse Persistence Tools
 */

public class THuodong implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Integer shetuanId;
	private String biaoti;
	private String neirong;
	
	private String shijian;
	private String didian;
	private String lianxiren;
	private String lianxihua;

	private TShetuan shetuan;
	private Integer status;
	

	private String shenheren;

	

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

	public TShetuan getShetuan()
	{
		return shetuan;
	}

	public void setShetuan(TShetuan shetuan)
	{
		this.shetuan = shetuan;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getShenheren() {
		return shenheren;
	}

	public void setShenheren(String shenheren) {
		this.shenheren = shenheren;
	}
}