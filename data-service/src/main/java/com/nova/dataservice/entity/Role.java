package com.nova.dataservice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    
    private Long id;
    private String name;
    private String code;
    private String status;

    
//    private List<UserDetails> users;

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @Column(name = "role_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	@OneToMany(mappedBy = "role")
//	public List<UserDetails> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<UserDetails> users) {
//		this.users = users;
//	}

}
