package com.wipro.usermanagement.dto;

public class UserResponseDTO {
    private int id;
    private String username;
    private String email;
    private String name;
    private String address;
    private long phoneno;
    private boolean enabled;
    private String roleName;

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public long getPhoneno() { return phoneno; }
    public void setPhoneno(long phoneno) { this.phoneno = phoneno; }
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }
}
