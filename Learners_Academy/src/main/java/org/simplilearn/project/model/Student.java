package org.simplilearn.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "email")
	private String email;

	@ManyToOne(targetEntity = Class.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "class_id")
	public Class foreignClass;

	public Student() {
		super();
	}

	public Student(String first_name, String last_name, String email, Class foreignClass) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.foreignClass = foreignClass;
	}

	public Student(Integer id, String first_name, String last_name, String email, Class foreignClass) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.foreignClass = foreignClass;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Class getForeignClass() {
		return foreignClass;
	}

	public void setForeignClass(Class foreignClass) {
		this.foreignClass = foreignClass;
	}

	@Override
	public String toString() {
		return String.format("Student [id=%s, first_name=%s, last_name=%s, email=%s]", id, first_name, last_name,
				email);
	}
}
