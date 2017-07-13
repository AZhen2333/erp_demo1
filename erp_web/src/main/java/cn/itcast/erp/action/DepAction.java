package cn.itcast.erp.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import cn.itcast.erp.biz.impl.DepBiz;
import cn.itcast.erp.entity.Dep;

public class DepAction {
	// bean
	private DepBiz depBiz;
	/*
	 * 属性驱动
	 */
	// Dep
	private Dep dep;
	// 当前页码
	private int page;
	// 每页显示的数据条数
	private int rows;
	// 日志
	private static final Logger log = LoggerFactory.getLogger(DepAction.class);

	@SuppressWarnings("unused")
	private void write(String jsonString) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("utf-8");
		response.setContentType("text/html;Charset=utf-8");
		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			log.error("列出所有的部门出错了:", e);
		}

	}

//	@SuppressWarnings("unused")
//	public void list() {
//		List<Dep> list = depBiz.findAll(dep);
//		// 转json
//		String jsonString = JSON.toJSONString(list);
//		write(jsonString);
//	}

	@SuppressWarnings({"unchecked" })
	public void listByPage() {
		int firstResult = (page - 1) * rows;
		List<Dep> list = depBiz.listByPage(dep, firstResult, rows);
		Long totalCunt = depBiz.getTatalCount(dep);
		// 转json
		Map map = new HashMap();
		map.put("total", totalCunt);
		map.put("rows", list);
		String jsonString = JSON.toJSONString(map);
		write(jsonString);
	}

	public void setDepBiz(DepBiz depBiz) {
		this.depBiz = depBiz;
	}

	public Dep getDep() {
		return dep;
	}

	public void setDep(Dep dep) {
		this.dep = dep;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

}
