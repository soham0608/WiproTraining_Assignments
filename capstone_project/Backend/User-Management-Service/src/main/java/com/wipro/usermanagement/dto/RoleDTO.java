package com.wipro.usermanagement.dto;

public class RoleDTO {
	
    private Integer rid;
    
    private String rname;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public RoleDTO(Integer rid, String rname) {
		super();
		this.rid = rid;
		this.rname = rname;
	}

	public RoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
