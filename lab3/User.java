package com.huawei.classroom.student.lab3;
/** @author liebes */
@Table("user")

public class User{
    @Column("id")
    private int id = -1;

    @Column("username")
    private String username = "";
    
    @Column("age")
    private int age = -1;

    @Column("email")
    private String email = "";

    @Column("telephone")
    private String telephone = "";

	public void setId(int i) {
		// TODO Auto-generated method stub
		this.id = i;
	}

	public void setUsername(String string) {
		// TODO Auto-generated method stub
		this.username = string;
		
	}

	public void setTelephone(String string) {
		// TODO Auto-generated method stub
		this.telephone = string;
	}

	public void setEmail(String string) {
		// TODO Auto-generated method stub
		this.email = string;
	}

	public void setAge(int i) {
		// TODO Auto-generated method stub
		this.age = i;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public int getAge() {
		return this.age;
	}
}
