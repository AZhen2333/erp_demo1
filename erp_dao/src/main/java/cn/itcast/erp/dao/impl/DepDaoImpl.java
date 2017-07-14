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

	private DetachedCriteria getDetachedCriteria(Dep dep1, Dep dep2, Object param) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Dep.class);
		if (dep1 != null) {
			if (dep1.getName() != null && dep1.getName().trim().length() != 0) {
				criteria.add(Restrictions.like("name", dep1.getName().trim(), MatchMode.ANYWHERE));
			}
			if (dep1.getTele() != null && dep1.getTele().trim().length() != 0) {
				criteria.add(Restrictions.like("tele", dep1.getTele().trim(), MatchMode.ANYWHERE));
			}
		}
		return criteria;

	}

	// 条件查询
	// @SuppressWarnings("unchecked")
	// @Override
	// public List<Dep> findAll(Dep dep) {
	// DetachedCriteria criteria = getDetachedCriteria(dep);
	// return (List<Dep>) getHibernateTemplate().findByCriteria(criteria);
	// }

	@SuppressWarnings("unchecked")
	@Override // 每页显示的数据查询
	public List<Dep> listByPage(Dep dep1, Dep dep2, Object param, int firstResult, int maxResults) {
		DetachedCriteria criteria = getDetachedCriteria(dep1, dep2, param);
		return (List<Dep>) getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}

	@SuppressWarnings("unchecked")
	@Override // 总条数查询
	public Long getTatalCount(Dep dep1, Dep dep2, Object param) {
		DetachedCriteria criteria = getDetachedCriteria(dep1, dep2, param);
		criteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(criteria);
		return list.isEmpty() ? 0 : list.get(0);
	}

	@Override // 新增部门
	public void add(Dep dep) {
		getHibernateTemplate().save(dep);

	}

	@Override // 删除部门
	public void delete(Long id) {
		Dep dep = getHibernateTemplate().get(Dep.class, id);
		getHibernateTemplate().delete(dep);
	}

	@Override // 修改部门
	public void update(Dep dep) {
		getHibernateTemplate().update(dep);
	}

	@Override//根据id查找部门
	public Dep getDepById(Long id) {
		 return getHibernateTemplate().get(Dep.class, id);
		
	}

}
