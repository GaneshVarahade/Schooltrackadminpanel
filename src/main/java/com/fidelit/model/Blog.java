package com.fidelit.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Blog")
public class Blog {

	
	private int blogId;
	
	private String msg;
	
	private String studentClass;
	
    private SchoolAdmin schoolAdmin;
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)  
	public SchoolAdmin getSchoolAdmin() {
		return schoolAdmin;
	}
	public void setSchoolAdmin(SchoolAdmin schoolAdmin) {
		this.schoolAdmin = schoolAdmin;
	}
	
	public String getStudentClass() {
		return studentClass;
	}
	
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
}
