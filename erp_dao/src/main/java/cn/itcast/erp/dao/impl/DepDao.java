package cn.itcast.erp.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import cn.itcast.erp.dao.IDepDao;
import cn.itcast.erp.entity.Dep;

public class DepDao extends BaseDao<Dep> implements IDepDao {

	public DetachedCriteria getDetachedCriteria(Dep dep1, Dep dep2, Object param) {
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

	

}
