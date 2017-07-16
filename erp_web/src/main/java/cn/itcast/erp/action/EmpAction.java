package cn.itcast.erp.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.itcast.erp.biz.IEmpBiz;
import cn.itcast.erp.entity.Emp;

public class EmpAction extends BaseAction<Emp> {

	private static final Logger log = LoggerFactory.getLogger(DepAction.class);// 日志


	@SuppressWarnings("unused")
	private IEmpBiz empBiz;
	public void setEmpBiz(IEmpBiz empBiz) {
		this.empBiz = empBiz;
		super.setBaseBiz(empBiz);
	}
	
	@Override
	public Logger getloger() {
		return log;
	}
	
	

}
