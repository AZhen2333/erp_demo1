package cn.itcast.erp.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;

import com.alibaba.fastjson.JSON;

import cn.itcast.erp.biz.IBaseBiz;

public class BaseAction<T> {

private IBaseBiz<T> baseBiz;
	
	private T t1;//查询条件
	private T t2;//查询条件
	private Object param;//查询条件
	private int page;//页码
	private int rows;//每页的记录数
	
	private T t;//只接收新增和修改功能的参数
	private Long id;//编号

	// 条件、分页查询
	public void listByPage() {
		int firstResult = (page - 1) * rows;
		List<T> list = baseBiz.listByPage(t1, t2, param, firstResult, rows);
		Long totalCunt = baseBiz.getTatalCount(t1, t2, param);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalCunt);
		map.put("rows", list);
		String jsonString = JSON.toJSONString(map);
		write(jsonString);
	}

	// 新增部门
	public void add() {
		try {
			baseBiz.add(t);
			// 条用write进行回显，同时输出是否成功信息
			write(ajaxRuturn(true, "添加成功"));
		} catch (Exception e) {
			e.printStackTrace();
			write(ajaxRuturn(false, "添加失败"));
		}
	}

	// 删除部门
	public void delete() {
		try {
			baseBiz.delete(id);
			write(ajaxRuturn(true, "删除成功"));
		} catch (Exception e) {
			e.printStackTrace();
			write(ajaxRuturn(false, "删除失败"));
		}

	}

	// 根据id回显部门信息
	public void getTById() {
		T t = (T) baseBiz.getDepById(id);
		String jsonString = JSON.toJSONString(t);
		// 转成map格式
		Map<String, Object> map = JSON.parseObject(jsonString);
		// 创建新的map
		Map<String, Object> newMap = new HashMap<String, Object>();
		for (String key : map.keySet()) {
			newMap.put("t." + key, map.get(key));
		}
		write(JSON.toJSONString(newMap));
	}

	// 修改部门
	public void update() {
		try {
			baseBiz.update(t);
			write(ajaxRuturn(true, "修改成功"));
		} catch (Exception e) {
			e.printStackTrace();
			write(ajaxRuturn(false, "修改失败"));
		}
	}

	// 回显jsoStringn数据
	public void write(String jsonString) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("utf-8");
		response.setContentType("text/html;Charset=utf-8");
		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			getloger().error("列出所有的部门出错了:", e);
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

	public void setPage(int page) {
		this.page = page;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public T getT1() {
		return t1;
	}

	public void setT1(T t1) {
		this.t1 = t1;
	}

	public T getT2() {
		return t2;
	}

	public void setT2(T t2) {
		this.t2 = t2;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Logger getloger() {
		return null;
	}

	public void setBaseBiz(IBaseBiz<T> baseBiz) {
		this.baseBiz = baseBiz;
	}
}
