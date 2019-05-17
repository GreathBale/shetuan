package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TShetuan;



public class TShetuanDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TShetuanDAO.class);
	// property constants
	public static final String MINGCHENG = "mingcheng";
	public static final String JIESHAO = "jieshao";
	public static final String LISHIJIAN = "lishijian";
	public static final String FUZEREN = "fuzeren";
	public static final String LOGINNAME = "loginname";
	public static final String LOGINPW = "loginpw";
	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TShetuan transientInstance)
	{
		log.debug("saving TShetuan instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TShetuan persistentInstance)
	{
		log.debug("deleting TShetuan instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TShetuan findById(java.lang.Integer id)
	{
		log.debug("getting TShetuan instance with id: " + id);
		try
		{
			TShetuan instance = (TShetuan) getHibernateTemplate().get(
					"com.model.TShetuan", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TShetuan instance)
	{
		log.debug("finding TShetuan instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TShetuan instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TShetuan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMingcheng(Object mingcheng)
	{
		return findByProperty(MINGCHENG, mingcheng);
	}

	public List findByJieshao(Object jieshao)
	{
		return findByProperty(JIESHAO, jieshao);
	}

	public List findByLishijian(Object lishijian)
	{
		return findByProperty(LISHIJIAN, lishijian);
	}

	public List findByFuzeren(Object fuzeren)
	{
		return findByProperty(FUZEREN, fuzeren);
	}

	public List findByLoginname(Object loginname)
	{
		return findByProperty(LOGINNAME, loginname);
	}

	public List findByLoginpw(Object loginpw)
	{
		return findByProperty(LOGINPW, loginpw);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all TShetuan instances");
		try
		{
			String queryString = "from TShetuan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TShetuan merge(TShetuan detachedInstance)
	{
		log.debug("merging TShetuan instance");
		try
		{
			TShetuan result = (TShetuan) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TShetuan instance)
	{
		log.debug("attaching dirty TShetuan instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TShetuan instance)
	{
		log.debug("attaching clean TShetuan instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TShetuanDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TShetuanDAO) ctx.getBean("TShetuanDAO");
	}
}