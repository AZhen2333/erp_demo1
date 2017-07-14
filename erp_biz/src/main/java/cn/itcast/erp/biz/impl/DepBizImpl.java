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

	@Override // 条件分页查询
	public List<Dep> listByPage(Dep dep1, Dep dep2, Object param, int firstResult, int maxResults) {
		return depDao.listByPage(dep1, dep2, param, firstResult, maxResults);
	}

	@Override // 总页数
	public Long getTatalCount(Dep dep1, Dep dep2, Object param) {
		return depDao.getTatalCount(dep1, dep2, param);
	}

	@Override // 新增部门
	public void add(Dep dep) {
		depDao.add(dep);

	}

	@Override // 删除部门
	public void delete(Long id) {
		depDao.delete(id);
	}

	@Override // 修改部门
	public void update(Dep dep) {
		depDao.update(dep);

	}

	@Override // 根据id查找部门
	public Dep getDepById(Long id) {
		return depDao.getDepById(id);

	}

}
