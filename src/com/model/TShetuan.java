package com.model;

/**
 * TShetuan entity. @author MyEclipse Persistence Tools
 */

public class TShetuan implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String mingcheng;
	private String jieshao;
	private String lishijian;
	
	private String fuzeren;
	private String loginname;
	private String loginpw;
	private String del;

	// Constructors

	/** default constructor */
	public TShetuan()
	{
	}

	/** full constructor */
	public TShetuan(String mingcheng, String jieshao, String lishijian,
			String fuzeren, String loginname, String loginpw, String del)
	{
		this.mingcheng = mingcheng;
		this.jieshao = jieshao;
		this.lishijian = lishijian;
		this.fuzeren = fuzeren;
		this.loginname = loginname;
		this.loginpw = loginpw;
		this.del = del;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getMingcheng()
	{
		return this.mingcheng;
	}

	public void setMingcheng(String mingcheng)
	{
		this.mingcheng = mingcheng;
	}

	public String getJieshao()
	{
		return this.jieshao;
	}

	public void setJieshao(String jieshao)
	{
		this.jieshao = jieshao;
	}

	public String getLishijian()
	{
		return this.lishijian;
	}

	public void setLishijian(String lishijian)
	{
		this.lishijian = lishijian;
	}

	public String getFuzeren()
	{
		return this.fuzeren;
	}

	public void setFuzeren(String fuzeren)
	{
		this.fuzeren = fuzeren;
	}

	public String getLoginname()
	{
		return this.loginname;
	}

	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}

	public String getLoginpw()
	{
		return this.loginpw;
	}

	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}

	public String getDel()
	{
		return this.del;
	}

	public void setDel(String del)
	{
		this.del = del;
	}

}