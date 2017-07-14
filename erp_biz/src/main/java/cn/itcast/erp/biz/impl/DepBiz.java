package cn.itcast.erp.biz.impl;


import cn.itcast.erp.biz.IDepBiz;
import cn.itcast.erp.dao.IDepDao;
import cn.itcast.erp.entity.Dep;

public class DepBiz extends BaseBiz<Dep> implements IDepBiz {

	@SuppressWarnings("unused")
	private IDepDao depDao;
	public void setDepDao(IDepDao depDao) {
		this.depDao = depDao;
		setBaseDao(depDao);
	}

	

}
