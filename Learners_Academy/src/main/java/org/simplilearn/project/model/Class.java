package org.simplilearn.project.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer id;

	@Column(name = "name")
	private String name;

	@OneToMany(targetEntity = Subject.class, fetch = FetchType.LAZY, mappedBy = "foreignClass")
	private Set<Subject> subjects;

	@OneToMany(targetEntity = Student.class, fetch = FetchType.LAZY, mappedBy = "foreignClass")
	private Set<Student> students;

	public Class() {
		super();
	}

	public Class(String name) {
		super();
		this.name = name;
	}

	public Class(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", subjects=" + subjects + ", students=" + students + "]";
	}

}
