package net.slipp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User extends AbstractEntity{
		
	//널 방지
	@Column(nullable=false, length=20)
	@JsonProperty
	private String userId;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String email;
	
	@JsonProperty
	private String password;
	
	public User() {
		
	}
	public User(String userId, String name, String email, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	
	public boolean matchPassword(String newPassword){
		if(newPassword==null){
			return false;
		}
		return this.password.equals(newPassword);
	}
	
	public boolean matchId(Long newId){
		if(newId==null){
			return false;
		}
		return getId().equals(newId);
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + getId() + ", userId=" + userId + ", name=" + name + ", email=" + email + ", password="
				+ password + "]";
	}

	
	
}
