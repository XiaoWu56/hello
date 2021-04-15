package com.spring.boot.main.po;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QuestionDatainfo {
	private int id;
	private int tQuestion_id;
	private String tQuestionData;
	private String submitter;
	private String updater;
	private Date submit_time;
	private Date update_time;
	private int write_time;
	private String write_place;
	private String color;
	private char isDelete;
	
	public QuestionDatainfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionDatainfo(int id, int tQuestion_id, String tQuestionData, String submitter, String updater,
			Date submit_time, Date update_time, int write_time, String write_place, String color, char isDelete) {
		super();
		this.id = id;
		this.tQuestion_id = tQuestion_id;
		this.tQuestionData = tQuestionData;
		this.submitter = submitter;
		this.updater = updater;
		this.submit_time = submit_time;
		this.update_time = update_time;
		this.write_time = write_time;
		this.write_place = write_place;
		this.color = color;
		this.isDelete = isDelete;
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

	public String gettQuestionData() {
		return tQuestionData;
	}

	public void settQuestionData(String tQuestionData) {
		this.tQuestionData = tQuestionData;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Date getSubmit_time() {
		return submit_time;
	}
//	public String getSubmit_time() {
//		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
//		String s = formatter.format(submit_time);
//		return s;
//	}

	public void setSubmit_time(Date submit_time) {
		this.submit_time = submit_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}
//	public String getUpdate_time() {
//		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
//		String s = formatter.format(update_time);
//		return s;
//	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public int getWrite_time() {
		return write_time;
	}

	public void setWrite_time(int write_time) {
		this.write_time = write_time;
	}

	public String getWrite_place() {
		return write_place;
	}

	public void setWrite_place(String write_place) {
		this.write_place = write_place;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public char getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(char isDelete) {
		this.isDelete = isDelete;
	}

}
