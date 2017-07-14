package cn.itcast.erp.biz.impl;

import java.util.List;

import cn.itcast.erp.biz.IBaseBiz;
import cn.itcast.erp.dao.IBaseDao;

public class BaseBiz<T> implements IBaseBiz<T> {
	private IBaseDao<T> baseDao;

	@Override // 条件分页查询
	public List<T> listByPage(T t1, T t2, Object param, int firstResult, int maxResults) {
		return baseDao.listByPage(t1, t2, param, firstResult, maxResults);
	}

	@Override // 总页数
	public Long getTatalCount(T t1, T t2, Object param) {
		return baseDao.getTatalCount(t1, t2, param);
	}

	@Override // 新增部门
	public void add(T t) {
		baseDao.add(t);

	}

	@Override // 删除部门
	public void delete(Long id) {
		baseDao.delete(id);
	}

	@Override // 修改部门
	public void update(T t) {
		baseDao.update(t);

	}

	@Override // 根据id查找部门
	public T getDepById(Long id) {
		return baseDao.getDepById(id);

	}

	public void setBaseDao(IBaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

}
