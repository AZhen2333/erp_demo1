package cn.itcast.erp.dao;

import java.util.List;

import cn.itcast.erp.entity.Dep;

public interface DepDao {
	//条件查询
	List<Dep> findAll(Dep dep);
	//分页查询,总页数
	List<Dep> listByPage(Dep dep,int firstResult,int maxResults );
	//总数据条数
	Long getTatalCount(Dep dep);
}

