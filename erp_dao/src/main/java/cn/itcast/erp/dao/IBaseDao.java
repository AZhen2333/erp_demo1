package cn.itcast.erp.dao;

import java.util.List;

public interface IBaseDao<T> {
	// 分页查询,总页数
	public List<T> listByPage(T t1, T t2, Object param, int firstResult, int maxResults);

	// 总数据条数
	public Long getTatalCount(T t1, T t2, Object param);

	// 新增部门
	public void add(T t);

	// 删除部门
	public void delete(Long id);

	// 修改部门
	public void update(T t);

	// 根据id查找部门
	public T getDepById(Long id);
}
