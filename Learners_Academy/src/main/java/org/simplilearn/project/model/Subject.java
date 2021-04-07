package org.simplilearn.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@OneToOne
	@JoinColumn(name = "teacher_id", referencedColumnName = "id")
	public Teacher foreignTeacher;

	@ManyToOne(targetEntity = Class.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "class_id")
	public Class foreignClass;

	public Subject() {
		super();
	}

	public Subject(String name, String code, Teacher foreignTeacher, Class foreignClass) {
		super();
		this.name = name;
		this.code = code;
		this.foreignTeacher = foreignTeacher;
		this.foreignClass = foreignClass;
	}

	public Subject(Integer id, String name, String code, Teacher foreignTeacher, Class foreignClass) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.foreignTeacher = foreignTeacher;
		this.foreignClass = foreignClass;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Teacher getForeignTeacher() {
		return foreignTeacher;
	}

	public void setForeignTeacher(Teacher foreignTeacher) {
		this.foreignTeacher = foreignTeacher;
	}

	public Class getForeignClass() {
		return foreignClass;
	}

	public void setForeignClass(Class foreignClass) {
		this.foreignClass = foreignClass;
	}

	@Override
	public String toString() {
		return String.format("Subject [id=%s, name=%s, code=%s]", id, name, code);
	}
}
