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

//This is model class for Learner
//@Table specifies table name
@Entity
@Table(name = "Learner")
public class Learner {

	public Learner() {
		super();
		// TODO Auto-generated constructor stub
	}

	// @GeneratedValue automatically generates value for Id
	// @Id specifies primary key
	// @Column specifies column name in table
	@Id
	@GeneratedValue
	@Column(name = "l_id")
	private String l_id;

	public Learner(String l_name, String l_city, String l_phone,
			String l_email, String l_username, String l_password) {
		super();
		this.l_name = l_name;
		this.l_city = l_city;
		this.l_phone = l_phone;
		this.l_email = l_email;
		this.l_username = l_username;
		this.l_password = l_password;
	}

	@Column(name = "l_name")
	private String l_name;

	@Column(name = "l_city")
	private String l_city;

	@Column(name = "l_phone")
	private String l_phone;

	@Column(name = "l_email")
	private String l_email;

	@Column(name = "l_username")
	private String l_username;

	@Column(name = "l_password")
	private String l_password;

	public String getL_id() {
		return l_id;
	}

	public Learner(String l_id, String l_name, String l_city, String l_phone,
			String l_email, String l_username, String l_password) {
		super();
		this.l_id = l_id;
		this.l_name = l_name;
		this.l_city = l_city;
		this.l_phone = l_phone;
		this.l_email = l_email;
		this.l_username = l_username;
		this.l_password = l_password;
	}

	public Learner(String username, String password) {
		// TODO Auto-generated constructor stub
	}

	public void setL_id(String l_id) {
		this.l_id = l_id;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getL_city() {
		return l_city;
	}

	public void setL_city(String l_city) {
		this.l_city = l_city;
	}

	public String getL_phone() {
		return l_phone;
	}

	public void setL_phone(String l_phone) {
		this.l_phone = l_phone;
	}

	public String getL_email() {
		return l_email;
	}

	public void setL_email(String l_email) {
		this.l_email = l_email;
	}

	public String getL_username() {
		return l_username;
	}

	public void setL_username(String l_username) {
		this.l_username = l_username;
	}

	public String getL_password() {
		return l_password;
	}

	public void setL_password(String l_password) {
		this.l_password = l_password;
	}

	@Override
	public String toString() {
		return "Learner [l_id=" + l_id + ", l_name=" + l_name + ", l_city="
				+ l_city + ", l_phone=" + l_phone + ", l_email=" + l_email
				+ ", l_username=" + l_username + ", l_password=" + l_password
				+ "]";
	}

}
