package com.wipro.usermanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
		
	@Column(nullable = false)
	private String name;
	
	@Column
	private String address;
	
	@Column
	private long phoneno;
	
	@Column
	private boolean enabled = true;
	
	@ManyToOne
    @JoinColumn(name = "rid", nullable = false)
    private Role role;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User(int uid, String username, String email, String password, String name, String address,
			long phoneno, boolean enabled, Role role) {
		super();
		this.uid = uid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phoneno = phoneno;
		this.enabled = enabled;
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", name=" + name + ", address=" + address + ", phoneno=" + phoneno + ", enabled=" + enabled
				+ ", role=" + role + "]";
	}
}
