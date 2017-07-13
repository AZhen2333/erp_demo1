package cn.itcast.erp.biz.impl;

import java.util.List;

import cn.itcast.erp.dao.DepDao;
import cn.itcast.erp.entity.Dep;

public class DepBizImpl implements DepBiz {

	private DepDao depDao;
	
	public void setDepDao(DepDao depDao) {
		this.depDao = depDao;
	}


	@Override
	public List<Dep> findAll(Dep dep) {
		
		return depDao.findAll(dep);
	}


	@Override
	public List<Dep> listByPage(Dep dep, int firstResult, int maxResults) {
		return depDao.listByPage(dep,firstResult,maxResults);
	}


	@Override
	public Long getTatalCount(Dep dep) {
		return depDao.getTatalCount(dep);
	}
	
	
}
