package cn.itcast.erp.biz.impl;

import java.util.List;

import cn.itcast.erp.entity.Dep;

public interface DepBiz {
//	List<Dep> findAll();
	public List<Dep> findAll(Dep dep);
	public List<Dep> listByPage(Dep dep, int firstResult, int maxResults);
	public Long getTatalCount(Dep dep);
}
