package cn.itcast.erp.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.erp.dao.IBaseDao;

public class BaseDao<T> extends HibernateDaoSupport implements IBaseDao<T> {
	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		Class<?> childClass = this.getClass();
		Type type = getClass().getGenericSuperclass();
		ParameterizedType pType=(ParameterizedType) type;
		Type[] types = pType.getActualTypeArguments();
		entityClass=(Class<T>) types[0];
	}

	public DetachedCriteria getDetachedCriteria(T t1, T t2, Object param) {

		return null;

	}

	@SuppressWarnings("unchecked")
	@Override // 每页显示的数据查询
	public List<T> listByPage(T t1, T t2, Object param, int firstResult, int maxResults) {
		DetachedCriteria criteria = getDetachedCriteria(t1, t2, param);
		return (List<T>) this.getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}

	@SuppressWarnings("unchecked")
	@Override // 总条数查询
	public Long getTatalCount(T t1, T t2, Object param) {
		DetachedCriteria criteria = getDetachedCriteria(t1, t2, param);
		criteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(criteria);
		return list.isEmpty() ? 0 : list.get(0);
	}

	@Override // 新增部门
	public void add(T t) {
		getHibernateTemplate().save(t);

	}

	@Override // 删除部门
	public void delete(Long id) {
		T dep = getHibernateTemplate().get(entityClass, id);
		getHibernateTemplate().delete(dep);
	}

	@Override // 修改部门
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@Override // 根据id查找部门
	public T getDepById(Long id) {
		return getHibernateTemplate().get(entityClass, id);

	}
}
