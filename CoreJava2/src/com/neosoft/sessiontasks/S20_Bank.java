package com.neosoft.sessiontasks;

import java.io.Serializable;

public class S20_Bank implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private String name;
	 private String add;
	 private String cno;
	 private String uname;
	 private String pwd;
	 private double dep;
	 private double amt;
     
     
     
	public S20_Bank(String name, String add, String cno, String uname, String pwd, double dep) {
		
		this.name = name;
		this.add = add;
		this.cno = cno;
		this.uname = uname;
		this.pwd = pwd;
		this.dep = dep;
		
	}
	
	

	public S20_Bank(double amt) {
		this.amt=amt;
	}



	

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAdd() {
		return add;
	}


	public void setAdd(String add) {
		this.add = add;
	}


	public String getCno() {
		return cno;
	}


	public void setCno(String cno) {
		this.cno = cno;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public double getDep() {
		return dep;
	}


	public void setDep(double dep) {
		this.dep = dep;
	}

	

	public double getAmt() {
		return amt;
	}



	public void setAmt(double amt) {
		this.amt = amt;
	}



	@Override
	public String toString() {
		return "Bank [name=" + name + ", add=" + add + ", cno=" + cno + ", uname=" + uname + ", pwd=" + pwd + ", dep="
				+ dep + "]";
	}


	
}
	
     
	
	
	
     
     



