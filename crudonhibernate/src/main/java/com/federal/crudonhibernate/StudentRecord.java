package com.federal.crudonhibernate;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table

@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class StudentRecord {

	@Id
	private int sid;
	@Override
	public String toString() {
		return "StudentRecord [sid=" + sid + ", sname=" + sname + ", ssubject=" + ssubject + ", smarks=" + smarks
				+ ", saddress=" + saddress + "]";
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	private String sname;
	private String ssubject;
	private int smarks;
	private String saddress;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsubject() {
		return ssubject;
	}
	public void setSsubject(String ssubject) {
		this.ssubject = ssubject;
	}
	public int getSmarks() {
		return smarks;
	}
	public void setSmarks(int smarks) {
		this.smarks = smarks;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	
}
