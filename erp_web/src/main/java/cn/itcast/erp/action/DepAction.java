package cn.itcast.erp.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.itcast.erp.biz.IDepBiz;
import cn.itcast.erp.entity.Dep;

public class DepAction extends BaseAction<Dep> {
	private static final Logger log = LoggerFactory.getLogger(DepAction.class);// 日志

	// bean
	private IDepBiz depBiz;
	
	public void setDepBiz(IDepBiz depBiz) {
		this.depBiz = depBiz;
		super.setBaseBiz(this.depBiz);
	}
	
	@SuppressWarnings("static-access")
	@Override
	public Logger getloger(){
		return this.log;
	}

}
