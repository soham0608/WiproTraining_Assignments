package com.wipro.usermanagement.dto;

public class UserDTO {
	
    private int uid;
    private String username;
    private String email;
    private String password;
    private String name;
    private String address;
    private long phoneno;
    private boolean enabled;
    private RoleDTO role;  
    
    public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(int uid, String username, String email, String password, String name, String address, long phoneno,
			boolean enabled, RoleDTO role) {
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

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }
}
