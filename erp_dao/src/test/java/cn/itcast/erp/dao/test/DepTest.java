package cn.itcast.erp.dao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.erp.dao.DepDao;
import cn.itcast.erp.entity.Dep;

public class DepTest {

	@Test
	public void list(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext_*.xml");
		DepDao depDao = (DepDao) ac.getBean("depDao");
//		int size = depDao.findAll().size();
//		System.out.println(size);
		Dep dep = new Dep();
//		dep.setName("办");
//		List<Dep> list=  depDao.list(dep);
//		System.out.println(list.size());
		
	}
}
