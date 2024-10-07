package com.gl.tdms.labwk17d03dem1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "teacher_Details")
@Data 
public class TeacherDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="teacher_Name")
	private String teacherName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="e_Mail")
	private String eMail;
	
	@Column(name="classes_Handled")
	private String classesHandled;
	
	@Column(name="mobile_No")
	private String mobileNo;
	
	@Column(name="basic_Pay")
	private int basicPay;
	
	@Column(name="allowances")
	private int allowances;
}
