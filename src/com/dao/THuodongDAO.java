package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.THuodong;



public class THuodongDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(THuodongDAO.class);
	// property constants
	public static final String SHETUAN_ID = "shetuanId";
	public static final String BIAOTI = "biaoti";
	public static final String NEIRONG = "neirong";
	public static final String SHIJIAN = "shijian";
	public static final String DIDIAN = "didian";
	public static final String LIANXI = "lianxi";

	protected void initDao()
	{
		// do nothing
	}

	public void save(THuodong transientInstance)
	{
		log.debug("saving THuodong instance");
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
	

	public void update(THuodong transientInstance)
	{
		log.debug("saving THuodong instance");
		try
		{
			getHibernateTemplate().update(transientInstance);
			log.info("update successful");
		} catch (RuntimeException re)
		{
			log.error("update failed", re);
			throw re;
		}
	}

	public void delete(THuodong persistentInstance)
	{
		log.debug("deleting THuodong instance");
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

	public THuodong findById(java.lang.Integer id)
	{
		log.debug("getting THuodong instance with id: " + id);
		try
		{
			THuodong instance = (THuodong) getHibernateTemplate().get(
					"com.model.THuodong", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(THuodong instance)
	{
		log.debug("finding THuodong instance by example");
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
		log.debug("finding THuodong instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from THuodong as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByShetuanId(Object shetuanId)
	{
		return findByProperty(SHETUAN_ID, shetuanId);
	}

	public List findByBiaoti(Object biaoti)
	{
		return findByProperty(BIAOTI, biaoti);
	}

	public List findByNeirong(Object neirong)
	{
		return findByProperty(NEIRONG, neirong);
	}

	public List findByShijian(Object shijian)
	{
		return findByProperty(SHIJIAN, shijian);
	}

	public List findByDidian(Object didian)
	{
		return findByProperty(DIDIAN, didian);
	}

	public List findByLianxi(Object lianxi)
	{
		return findByProperty(LIANXI, lianxi);
	}

	public List findAll()
	{
		log.debug("finding all THuodong instances");
		try
		{
			String queryString = "from THuodong";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public THuodong merge(THuodong detachedInstance)
	{
		log.debug("merging THuodong instance");
		try
		{
			THuodong result = (THuodong) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(THuodong instance)
	{
		log.debug("attaching dirty THuodong instance");
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

	public void attachClean(THuodong instance)
	{
		log.debug("attaching clean THuodong instance");
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

	public static THuodongDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (THuodongDAO) ctx.getBean("THuodongDAO");
	}
}