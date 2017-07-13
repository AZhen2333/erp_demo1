package cn.itcast.erp.biz.impl;

import java.util.List;

import cn.itcast.erp.dao.DepDao;
import cn.itcast.erp.entity.Dep;

public class DepBizImpl implements DepBiz {

	private DepDao depDao;
	
	@Override
	public List<Dep> findAll() {
		return depDao.findAll();
	}


	public void setDepDao(DepDao depDao) {
		this.depDao = depDao;
	}
	
	
}
