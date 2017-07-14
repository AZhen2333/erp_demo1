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

import cn.itcast.erp.biz.DepBiz;
import cn.itcast.erp.entity.Dep;

public class DepAction {
	// bean
	private DepBiz depBiz;
	/*
	 * 属性驱动
	 */
	// Dep
	private Dep dep1;
	private Dep dep2;
	private Object param;
	// 当前页码
	private int page;
	// 每页显示的数据条数
	private int rows;
	// 日志
	private static final Logger log = LoggerFactory.getLogger(DepAction.class);

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

	// 是否成功返回
	@SuppressWarnings("unchecked")
	public String ajaxRuturn(boolean success, String message) {
		Map map = new HashMap();
		map.put("success", success);
		map.put("message", message);
		String jsonString = JSON.toJSONString(map);
		return jsonString;
	}

	// @SuppressWarnings("unused")
	// public void list() {
	// List<Dep> list = depBiz.findAll(dep);
	// // 转json
	// String jsonString = JSON.toJSONString(list);
	// write(jsonString);
	// }

	// 条件、分页查询
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void listByPage() {
		int firstResult = (page - 1) * rows;
		List<Dep> list = depBiz.listByPage(dep1, dep2, param, firstResult, rows);
		Long totalCunt = depBiz.getTatalCount(dep1, dep2, param);
		// 转json
		Map map = new HashMap();
		map.put("total", totalCunt);
		map.put("rows", list);
		String jsonString = JSON.toJSONString(map);
		write(jsonString);
	}

	// 新增部门
	public void add() {
		try {
			depBiz.add(dep1);
			// 条用write进行回显，同时输出信息
			write(ajaxRuturn(true, "添加成功"));
		} catch (Exception e) {
			e.printStackTrace();
			write(ajaxRuturn(false, "添加失败"));
		}

	}

	public void setDepBiz(DepBiz depBiz) {
		this.depBiz = depBiz;
	}

	public Dep getDep() {
		return dep1;
	}

	public void setDep(Dep dep1) {
		this.dep1 = dep1;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

}
