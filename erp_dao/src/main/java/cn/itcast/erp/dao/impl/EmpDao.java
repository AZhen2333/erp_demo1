package cn.itcast.erp.dao.impl;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import cn.itcast.erp.dao.IEmpDao;
import cn.itcast.erp.entity.Dep;
import cn.itcast.erp.entity.Emp;

public class EmpDao extends BaseDao<Emp> implements IEmpDao{
	public DetachedCriteria getDetachedCriteria(Emp emp1, Emp emp2, Object param) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Emp.class);
		if (emp1 != null) {
			if (emp1.getName() != null && emp1.getName().trim().length() != 0) {
				criteria.add(Restrictions.like("name", emp1.getName().trim(), MatchMode.ANYWHERE));
			}
			if (emp1.getTele() != null && emp1.getTele().trim().length() != 0) {
				criteria.add(Restrictions.like("tele", emp1.getTele().trim(), MatchMode.ANYWHERE));
			}
		}
		return criteria;

	}

}
