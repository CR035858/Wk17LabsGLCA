package com.gl.tdms.labwk17d02dem1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Teacher_Details")
@Data 
public class TeacherDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="teacherName")
	private String teacherName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="eMail")
	private String eMail;
	
	@Column(name="classesHandled")
	private String classesHandled;
	
	@Column(name="mobileNo")
	private String mobileNo;
	
	@Column(name="basicPay")
	private int basicPay;
	
	@Column(name="allowances")
	private int allowances;
}
