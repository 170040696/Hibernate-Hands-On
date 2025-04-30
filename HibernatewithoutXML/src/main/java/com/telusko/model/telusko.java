package com.telusko.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class telusko {

	@Id
	@Column(name="ID")
	private Integer tid;
	
	@Column(name="NAME")
	private String tname;
	
	@Column(name="CITY")
	private String tcity;

	@Override
	public String toString() {
		return "telusko [tid=" + tid + ", tname=" + tname + ", tcity=" + tcity + "]";
	}

	public telusko(Integer tid, String tname, String tcity) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tcity = tcity;
	}

	public telusko() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTcity() {
		return tcity;
	}

	public void setTcity(String tcity) {
		this.tcity = tcity;
	}

	
	
	
	
}
