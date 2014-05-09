package com.sis.eims4.action;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.sis.eims4.entity.Condition;
import com.sis.eims4.entity.Dept;
import com.sis.eims4.entity.EmpDto;
import com.sis.eims4.entity.Manager;
/**
 * @author SIS
 *
 */
public class BaseAction extends ActionSupport
                        implements SessionAware,
                                   ServletRequestAware,
                                   ServletResponseAware,
                                   ServletContextAware,
                                   Preparable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String, Object> session;
	protected HttpServletRequest   request;
	protected HttpServletResponse  response;
	protected ServletContext  application;
	protected Condition condition;
	protected EmpDto empDto;
	protected List<Dept> deptList;
	protected List<EmpDto> empList;
	protected List<Manager> mgrList;

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletContext(ServletContext application) {
		this.application = application;
	}
	public List<Dept> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public List<EmpDto> getEmpList() {
		return empList;
	}
	public void setEmpList(List<EmpDto> empList) {
		this.empList = empList;
	}
	public List<Manager> getMgrList() {
		return mgrList;
	}
	public void setMgrList(List<Manager> mgrList) {
		this.mgrList = mgrList;
	}
	public EmpDto getEmpDto() {
		return empDto;
	}
	public void setEmpDto(EmpDto empDto) {
		this.empDto = empDto;
	}

	@Override
	public void prepare() throws Exception {
	}
}
