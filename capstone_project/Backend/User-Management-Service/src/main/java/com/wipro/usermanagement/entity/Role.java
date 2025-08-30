package com.wipro.usermanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int rid;
	@Column(nullable = false)
	String rname;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	
	public Role(int rid, String rname) {
		super();
		this.rid = rid;
		this.rname = rname;
	}
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", rname=" + rname + "]";
	}
}
