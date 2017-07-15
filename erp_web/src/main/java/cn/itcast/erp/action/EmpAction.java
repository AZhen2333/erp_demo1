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

import cn.itcast.erp.biz.IEmpBiz;
import cn.itcast.erp.entity.Emp;

public class EmpAction extends BaseAction<Emp> {

	private IEmpBiz empBiz;

	private Emp emp1;// 参数1
	private Emp emp2;// 参数2
	private Object param;// 参数3
	private int page;// 当前页码
	private int rows;// 每页显示的数据条数

	private static final Logger log = LoggerFactory.getLogger(DepAction.class);// 日志

	
	public void listByPage() {
		int firstResult = (page - 1) * rows;
		List<Emp> list = empBiz.listByPage(emp1, emp2, param, firstResult, rows);
		System.out.println(list.toString());
		Long totalCunt = empBiz.getTatalCount(emp1, emp2, param);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalCunt);
		map.put("rows", list);
		String jsonString = JSON.toJSONString(map);
		write(jsonString);
	}

	// 回显jsoStringn数据
	public void write(String jsonString) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("utf-8");
		response.setContentType("text/html;Charset=utf-8");
		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			log.error("列出所有的部门出错了:", e);
		}
	}

	public Emp getEmp1() {
		return emp1;
	}

	public void setEmp1(Emp emp1) {
		this.emp1 = emp1;
	}

	public Emp getEmp2() {
		return emp2;
	}

	public void setEmp2(Emp emp2) {
		this.emp2 = emp2;
	}

	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setEmpBiz(IEmpBiz empBiz) {
		this.empBiz = empBiz;
	}

}
