package com.ayushsoni9025.todo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue
	private int id;
	
	
	private String uname;
	
	@Size(min=10,message="Enter atleast 10 character")
	private String description;
	private LocalDate targetDate;
	private Boolean done;
	public Todo(int id, String uname, String description, LocalDate targetDate, Boolean done) {
		super();
		this.id = id;
		this.uname = uname;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public Boolean getDone() {
		return done;
	}
	public void setDone(Boolean done) {
		this.done = done;
	}
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", uname=" + uname + ", description=" + description + ", targetDate=" + targetDate
				+ ", done=" + done + "]";
	}
	
}
