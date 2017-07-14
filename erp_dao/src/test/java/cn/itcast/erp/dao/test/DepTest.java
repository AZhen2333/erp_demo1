package cn.itcast.erp.dao.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.erp.dao.IDepDao;
import cn.itcast.erp.entity.Dep;

public class DepTest {

	@SuppressWarnings("unused")
	@Test
	public void list(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext_*.xml");
		IDepDao depDao = (IDepDao) ac.getBean("depDao");
//		int size = depDao.findAll().size();
//		System.out.println(size);
		Dep dep = new Dep();
//		dep.setName("办");
//		List<Dep> list=  depDao.list(dep);
//		System.out.println(list.size());
		
	}
}
