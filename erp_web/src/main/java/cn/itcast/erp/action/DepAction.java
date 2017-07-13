package cn.itcast.erp.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import cn.itcast.erp.biz.impl.DepBiz;
import cn.itcast.erp.entity.Dep;

public class DepAction {

	private DepBiz depBiz;
	private static final Logger log = LoggerFactory.getLogger(DepAction.class);

	public void list() {
		List<Dep> list = depBiz.findAll();
		HttpServletResponse response = ServletActionContext.getResponse();
		// 转json
		String jsonString = JSON.toJSONString(list);

		response.setContentType("utf-8");
		response.setContentType("text/html;Charset=utf-8");
		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			log.error("列出所有的部门出错了:", e);
		}

	}

	public void setDepBiz(DepBiz depBiz) {
		this.depBiz = depBiz;
	}

}
