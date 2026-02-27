package com.example.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class task {
	
	public task() {
		
	}
	
	
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int    id ;
	 private String title;
	 private String description;
	 private String status;
	 public int getId() {
		 return id;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 public String getTitle() {
		 return title;
	 }
	 public void setTitle(String title) {
		 this.title = title;
	 }
	 public String getDescription() {
		 return description;
	 }
	 public void setDescription(String description) {
		 this.description = description;
	 }
	 public String getStatus() {
		 return status;
	 }
	 public void setStatus(String status) {
		 this.status = status;
	 }
	 @Override
	 public String toString() {
		return "task [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status + "]";
	 }
	 public task(int id, String title, String description, String status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
	 }
	
	
}
