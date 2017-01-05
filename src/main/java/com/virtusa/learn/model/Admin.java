package com.virtusa.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//This is model class for Admin
//@Table specifies table name
@Entity
@Table(name = "Admin")
public class Admin {

	// @Id specifies primary key
	// @Column specifies column name in table
	@Id
	@Column(name = "a_name")
	private String a_name;

	@Column(name = "a_phone")
	private String a_phone;

	@Column(name = "a_email")
	private String a_email;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	// constructor
	public Admin(String a_name, String a_phone, String a_email,
			String a_username, String a_password) {
		super();
		this.a_name = a_name;
		this.a_phone = a_phone;
		this.a_email = a_email;
		this.a_username = a_username;
		this.a_password = a_password;
	}

	@Override
	public String toString() {
		return "Admin [a_name=" + a_name + ", a_phone=" + a_phone
				+ ", a_email=" + a_email + ", a_username=" + a_username
				+ ", a_password=" + a_password + "]";
	}

	@Column(name = "a_username")
	private String a_username;

	@Column(name = "a_password")
	private String a_password;

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public String getA_phone() {
		return a_phone;
	}

	public void setA_phone(String a_phone) {
		this.a_phone = a_phone;
	}

	public String getA_email() {
		return a_email;
	}

	public void setA_email(String a_email) {
		this.a_email = a_email;
	}

	public String getA_username() {
		return a_username;
	}

	public void setA_username(String a_username) {
		this.a_username = a_username;
	}

	public String getA_password() {
		return a_password;
	}

	public void setA_password(String a_password) {
		this.a_password = a_password;
	}

}
