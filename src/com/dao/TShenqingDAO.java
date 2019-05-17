package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TShenqing;


public class TShenqingDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TShenqingDAO.class);
	// property constants
	public static final String SHETUAN_ID = "shetuanId";
	public static final String USER_ID = "userId";
	public static final String LIYOU = "liyou";
	public static final String SHENQINGSHI = "shenqingshi";
	public static final String HUIFUXINXI = "huifuxinxi";
	public static final String HUIFUSHI = "huifushi";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TShenqing transientInstance)
	{
		log.debug("saving TShenqing instance");
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

	public void delete(TShenqing persistentInstance)
	{
		log.debug("deleting TShenqing instance");
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

	public TShenqing findById(java.lang.Integer id)
	{
		log.debug("getting TShenqing instance with id: " + id);
		try
		{
			TShenqing instance = (TShenqing) getHibernateTemplate().get(
					"com.model.TShenqing", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TShenqing instance)
	{
		log.debug("finding TShenqing instance by example");
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
		log.debug("finding TShenqing instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TShenqing as model where model."
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

	public List findByUserId(Object userId)
	{
		return findByProperty(USER_ID, userId);
	}

	public List findByLiyou(Object liyou)
	{
		return findByProperty(LIYOU, liyou);
	}

	public List findByShenqingshi(Object shenqingshi)
	{
		return findByProperty(SHENQINGSHI, shenqingshi);
	}

	public List findByHuifuxinxi(Object huifuxinxi)
	{
		return findByProperty(HUIFUXINXI, huifuxinxi);
	}

	public List findByHuifushi(Object huifushi)
	{
		return findByProperty(HUIFUSHI, huifushi);
	}

	public List findAll()
	{
		log.debug("finding all TShenqing instances");
		try
		{
			String queryString = "from TShenqing";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TShenqing merge(TShenqing detachedInstance)
	{
		log.debug("merging TShenqing instance");
		try
		{
			TShenqing result = (TShenqing) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TShenqing instance)
	{
		log.debug("attaching dirty TShenqing instance");
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

	public void attachClean(TShenqing instance)
	{
		log.debug("attaching clean TShenqing instance");
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

	public static TShenqingDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TShenqingDAO) ctx.getBean("TShenqingDAO");
	}
}