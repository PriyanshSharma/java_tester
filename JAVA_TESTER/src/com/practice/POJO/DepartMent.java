package com.practice.POJO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DepartMent {

	private int deptId;
	private String deptName;
	private List<String> deptWorkerNames = new ArrayList<String>();
	
	
	
	
	public DepartMent(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}
	public DepartMent(DepartMent d, List<String> wrkerNames) {
		super();
		this.deptId = d.getDeptId();
		this.deptName = d.getDeptName();
		this.deptWorkerNames=wrkerNames;
	}
	@Override
	public String toString() {
		return "DepartMent [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	
	public List<String> getDeptWorkerNames() {
		return deptWorkerNames;
	}
	public void setDeptWorkerNames(List<String> deptWorkerNames) {
		this.deptWorkerNames = deptWorkerNames;
	}
	public static DepartMent getDefaultDepartMent() {
		int i = ThreadLocalRandom.current().nextInt(3940, 3944);
		return new DepartMent(i, "DEPT--"+i); 
	}
}
