package cn.itcast.erp.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.erp.dao.DepDao;
import cn.itcast.erp.entity.Dep;

public class DepDaoImpl extends HibernateDaoSupport implements DepDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Dep> findAll() {
		return (List<Dep>) getHibernateTemplate().find("from Dep");
	}

}
