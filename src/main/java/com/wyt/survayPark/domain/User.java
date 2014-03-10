package com.wyt.survayPark.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
public class User implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String email;
	private String password;
	private String nickName;
	private Timestamp regTime = new Timestamp(System.currentTimeMillis());
	
	public User(){
		
    }
	
	public User(String id, String email, String password, String nickName,
			Timestamp regTime) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.nickName = nickName;
		this.regTime = regTime;
	}
	
	@Id
	@Column(name = "id", nullable = false, length = 36)
	@GeneratedValue(generator="paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")   
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "email",length = 50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="password",nullable=false,length=50) 
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="nickName",length=50) 
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Column(name="regTime",updatable=false) 
	public Timestamp getRegTime() {
		return regTime;
	}
	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}
	
	

}
