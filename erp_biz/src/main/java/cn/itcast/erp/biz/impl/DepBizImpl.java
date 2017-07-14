package cn.itcast.erp.biz.impl;

import java.util.List;

import cn.itcast.erp.biz.DepBiz;
import cn.itcast.erp.dao.DepDao;
import cn.itcast.erp.entity.Dep;

public class DepBizImpl implements DepBiz {

	private DepDao depDao;

	public void setDepDao(DepDao depDao) {
		this.depDao = depDao;
	}

	// @Override
	// public List<Dep> findAll(Dep dep) {
	//
	// return depDao.findAll(dep);
	// }

	@Override
	public List<Dep> listByPage(Dep dep1, Dep dep2, Object param, int firstResult, int maxResults) {
		return depDao.listByPage(dep1, dep2, param, firstResult, maxResults);
	}

	@Override
	public Long getTatalCount(Dep dep1, Dep dep2, Object param) {
		return depDao.getTatalCount(dep1, dep2, param);
	}

	@Override
	public void add(Dep dep1) {
		depDao.add(dep1);

	}

}
