package cn.itcast.erp.biz.impl;

import cn.itcast.erp.biz.IEmpBiz;
import cn.itcast.erp.dao.IEmpDao;
import cn.itcast.erp.entity.Emp;

public class EmpBiz extends BaseBiz<Emp> implements IEmpBiz {
	@SuppressWarnings("unused")
	private IEmpDao empDao;
	public void setEmpDao(IEmpDao empDao) {
		this.empDao = empDao;
		setBaseDao(empDao);
	}
	
}
