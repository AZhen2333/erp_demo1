package cn.itcast.erp.dao;

import java.util.List;

import cn.itcast.erp.entity.Dep;

public interface DepDao {
	// 条件查询
//	public List<Dep> findAll(Dep dep);

	// 分页查询,总页数
	public List<Dep> listByPage(Dep dep1, Dep dep2, Object param, int firstResult, int maxResults);

	// 总数据条数
	public Long getTatalCount(Dep dep1,Dep dep2,Object param);

	// 新增部门
	public void add(Dep dep1);
}
