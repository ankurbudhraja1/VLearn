package com.virtusa.learn.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//This is model class for Course
//@Table specifies table name
@Entity
@Table(name = "Course")
public class Course {

	// @GeneratedValue automatically generates value for Id
	// @Id specifies primary key
	// @Column specifies column name in table
	@GeneratedValue
	@Id
	@Column(name = "c_id")
	private String c_id;

	@Column(name = "c_name")
	private String c_name;

	@Column(name = "c_description")
	private String c_description;

	@Column(name = "c_e_date")
	private String c_e_date;

	@Column(name = "c_e_time")
	private String c_e_time;

	@Column(name = "c_e_venue")
	private String c_e_venue;

	@Column(name = "c_material1")
	private byte[] c_material1;

	@Column(name = "c_material2")
	private byte[] c_material2;

	@Column(name = "c_material3")
	private byte[] c_material3;

	@Column(name = "e_id")
	private String e_id;

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_description() {
		return c_description;
	}

	public void setC_description(String c_description) {
		this.c_description = c_description;
	}

	public String getC_e_date() {
		return c_e_date;
	}

	public void setC_e_date(String c_e_date) {
		this.c_e_date = c_e_date;
	}

	public String getC_e_time() {
		return c_e_time;
	}

	public void setC_e_time(String c_e_time) {
		this.c_e_time = c_e_time;
	}

	public String getC_e_venue() {
		return c_e_venue;
	}

	public void setC_e_venue(String c_e_venue) {
		this.c_e_venue = c_e_venue;
	}

	public byte[] getC_material1() {
		return c_material1;
	}

	public void setC_material1(byte[] c_material1) {
		this.c_material1 = c_material1;
	}

	public byte[] getC_material2() {
		return c_material2;
	}

	public void setC_material2(byte[] c_material2) {
		this.c_material2 = c_material2;
	}

	public byte[] getC_material3() {
		return c_material3;
	}

	public void setC_material3(byte[] c_material3) {
		this.c_material3 = c_material3;
	}

	public String getE_id() {
		return e_id;
	}

	public void setE_id(String e_id) {
		this.e_id = e_id;
	}

	@Override
	public String toString() {
		return "Course [c_id=" + c_id + ", c_name=" + c_name
				+ ", c_description=" + c_description + ", c_e_date=" + c_e_date
				+ ", c_e_time=" + c_e_time + ", c_e_venue=" + c_e_venue
				+ ", c_material1=" + Arrays.toString(c_material1)
				+ ", c_material2=" + Arrays.toString(c_material2)
				+ ", c_material3=" + Arrays.toString(c_material3) + ", e_id="
				+ e_id + "]";
	}

	public Course(String c_id, String c_name, String c_description,
			String c_e_date, String c_e_time, String c_e_venue,
			byte[] c_material1, byte[] c_material2, byte[] c_material3,
			String e_id) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_description = c_description;
		this.c_e_date = c_e_date;
		this.c_e_time = c_e_time;
		this.c_e_venue = c_e_venue;
		this.c_material1 = c_material1;
		this.c_material2 = c_material2;
		this.c_material3 = c_material3;
		this.e_id = e_id;
	}

	public Course(String c_name, String c_description, String c_e_date,
			String c_e_time, String c_e_venue, byte[] c_material1,
			byte[] c_material2, byte[] c_material3, String e_id) {
		super();
		this.c_name = c_name;
		this.c_description = c_description;
		this.c_e_date = c_e_date;
		this.c_e_time = c_e_time;
		this.c_e_venue = c_e_venue;
		this.c_material1 = c_material1;
		this.c_material2 = c_material2;
		this.c_material3 = c_material3;
		this.e_id = e_id;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

}
