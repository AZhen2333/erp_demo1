package cn.itcast.erp.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.erp.dao.DepDao;
import cn.itcast.erp.entity.Dep;

public class DepDaoImpl extends HibernateDaoSupport implements DepDao {

	// @SuppressWarnings("unchecked")
	// @Override
	// public List<Dep> findAll() {
	// return (List<Dep>) getHibernateTemplate().find("from Dep");
	// }

	private DetachedCriteria getDetachedCriteria(Dep dep) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Dep.class);
		if (dep != null) {
			if (dep.getName() != null && dep.getName().length() != 0) {
				criteria.add(Restrictions.like("name", dep.getName(), MatchMode.ANYWHERE));
			}
			if (dep.getTele() != null && dep.getTele().length() != 0) {
				criteria.add(Restrictions.like("tele", dep.getTele(), MatchMode.ANYWHERE));
			}
		}
		return criteria;

	}

	//条件查询
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Dep> findAll(Dep dep) {
//		DetachedCriteria criteria = getDetachedCriteria(dep);
//		return (List<Dep>) getHibernateTemplate().findByCriteria(criteria);
//	}
	
	//每页显示的数据查询
	@SuppressWarnings("unchecked")
	@Override
	public List<Dep> listByPage(Dep dep, int firstResult, int maxResults) {
		DetachedCriteria criteria = getDetachedCriteria(dep);
		return (List<Dep>) getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}

	//总条数查询
	@SuppressWarnings("unchecked")
	@Override
	public Long getTatalCount(Dep dep) {
		DetachedCriteria criteria = getDetachedCriteria(dep);
		criteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(criteria);
		return list.isEmpty()?0:list.get(0);
	}

	@Override
	public void add(Dep dep) {
		getHibernateTemplate().save(dep);
		
	}

}
