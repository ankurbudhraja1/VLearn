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

//This is model class for Enabler
//@Table specifies table name
@Entity
@Table(name = "Enabler")
public class Enabler {

	// @GeneratedValue automatically generates value for Id
	// @Id specifies primary key
	// @Column specifies column name in table
	@Id
	@GeneratedValue
	@Column(name = "e_id")
	private String e_id;

	public Enabler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enabler(String e_name, String e_city, String e_phone,
			String e_email, String e_username, String e_password) {
		super();
		this.e_name = e_name;
		this.e_city = e_city;
		this.e_phone = e_phone;
		this.e_email = e_email;
		this.e_username = e_username;
		this.e_password = e_password;
	}

	public Enabler(String e_id, String e_name, String e_city, String e_phone,
			String e_email, String e_username, String e_password) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.e_city = e_city;
		this.e_phone = e_phone;
		this.e_email = e_email;
		this.e_username = e_username;
		this.e_password = e_password;
	}

	@Override
	public String toString() {
		return "Enabler [e_id=" + e_id + ", e_name=" + e_name + ", e_city="
				+ e_city + ", e_phone=" + e_phone + ", e_email=" + e_email
				+ ", e_username=" + e_username + ", e_password=" + e_password
				+ "]";
	}

	public String getE_id() {
		return e_id;
	}

	public void setE_id(String e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getE_city() {
		return e_city;
	}

	public void setE_city(String e_city) {
		this.e_city = e_city;
	}

	public String getE_phone() {
		return e_phone;
	}

	public void setE_phone(String e_phone) {
		this.e_phone = e_phone;
	}

	public String getE_email() {
		return e_email;
	}

	public void setE_email(String e_email) {
		this.e_email = e_email;
	}

	public String getE_username() {
		return e_username;
	}

	public void setE_username(String e_username) {
		this.e_username = e_username;
	}

	public String getE_password() {
		return e_password;
	}

	public void setE_password(String e_password) {
		this.e_password = e_password;
	}

	@Column(name = "e_name")
	private String e_name;

	@Column(name = "e_city")
	private String e_city;

	@Column(name = "e_phone")
	private String e_phone;

	@Column(name = "e_email")
	private String e_email;

	@Column(name = "e_username")
	private String e_username;

	@Column(name = "e_password")
	private String e_password;

}
