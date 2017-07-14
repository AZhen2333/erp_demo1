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
	private Dep dep;// 仅用于增删改的参数
	private Dep dep1;// 参数1
	private Dep dep2;// 参数2
	private Object param;// 参数3
	private int page;// 当前页码
	private int rows;// 每页显示的数据条数
	private Long id;//uuid
	
	private static final Logger log = LoggerFactory.getLogger(DepAction.class);// 日志

	// 条件、分页查询
	public void listByPage() {
		int firstResult = (page - 1) * rows;
		List<Dep> list = depBiz.listByPage(dep1, dep2, param, firstResult, rows);
		Long totalCunt = depBiz.getTatalCount(dep1, dep2, param);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalCunt);
		map.put("rows", list);
		String jsonString = JSON.toJSONString(map);
		write(jsonString);
	}

	// 新增部门
	public void add() {
		try {
			depBiz.add(dep);
			// 条用write进行回显，同时输出是否成功信息
			write(ajaxRuturn(true, "添加成功"));
		} catch (Exception e) {
			e.printStackTrace();
			write(ajaxRuturn(false, "添加失败"));
		}
	}
	
	//删除部门
	public void delete(){
		try {
			depBiz.delete(id);
			write(ajaxRuturn(true, "删除成功"));
		} catch (Exception e) {
			e.printStackTrace();
			write(ajaxRuturn(false, "删除失败"));
		}
		
	}
	
	

	// 回显jsoStringn数据
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
	public String ajaxRuturn(boolean success, String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", success);
		map.put("message", message);
		String jsonString = JSON.toJSONString(map);
		return jsonString;
	}

	// getter setter
	public void setDepBiz(DepBiz depBiz) {
		this.depBiz = depBiz;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public Dep getDep() {
		return dep;
	}

	public void setDep(Dep dep) {
		this.dep = dep;
	}

	public Dep getDep1() {
		return dep1;
	}

	public void setDep1(Dep dep1) {
		this.dep1 = dep1;
	}

	public Dep getDep2() {
		return dep2;
	}

	public void setDep2(Dep dep2) {
		this.dep2 = dep2;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
