package com.offcn.po;

import java.util.List;

public class CourseExt extends Course{

	private String tid;
	private List<Integer> claids;
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public List<Integer> getClaids() {
		return claids;
	}
	public void setClaids(List<Integer> claids) {
		this.claids = claids;
	}
	
	
	
}
