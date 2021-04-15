package com.spring.boot.main.po;

public class QuestionDetailinfo {
	private int id;
	private int tQuestion_id;
	private String name;
	private String type;
	private String model;
	public QuestionDetailinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionDetailinfo(int id, int tQuestion_id, String name, String type, String model) {
		super();
		this.id = id;
		this.tQuestion_id = tQuestion_id;
		this.name = name;
		this.type = type;
		this.model = model;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int gettQuestion_id() {
		return tQuestion_id;
	}
	public void settQuestion_id(int tQuestion_id) {
		this.tQuestion_id = tQuestion_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
}
