package com.spring.boot.main.po;

import java.util.Date;
import java.util.List;

public class Questioninfo {
	private int id;
	private int tUser_id;
	private Date publishDate; //可以Timestamp数据类型
	private Date endDate;
	private char status;//status与delete有删除状态重复，【待定】
	private String name;
	private String coverImage;
	private String content;
	private String btnCss;
	private String sendString;
	private char showNum;
	private char limitTime;
	private char isAutoSave;
	private char isOpen;
	private char isTop;
	private char isLike;
	private char isDelete;
	private String icon;
	private List<QuestionDetailinfo> listQuestionDetailinfo;
	
	public Questioninfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Questioninfo(int id, int tUser_id, Date publishDate, Date endDate, char status, String name,
			String coverImage, String content, String btnCss, String sendString, char showNum, char limitTime,
			char isAutoSave, char isOpen, char isTop, char isLike, char isDelete, String icon,
			List<QuestionDetailinfo> listQuestionDetailinfo) {
		super();
		this.id = id;
		this.tUser_id = tUser_id;
		this.publishDate = publishDate;
		this.endDate = endDate;
		this.status = status;
		this.name = name;
		this.coverImage = coverImage;
		this.content = content;
		this.btnCss = btnCss;
		this.sendString = sendString;
		this.showNum = showNum;
		this.limitTime = limitTime;
		this.isAutoSave = isAutoSave;
		this.isOpen = isOpen;
		this.isTop = isTop;
		this.isLike = isLike;
		this.isDelete = isDelete;
		this.icon = icon;
		this.listQuestionDetailinfo = listQuestionDetailinfo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int gettUser_id() {
		return tUser_id;
	}
	public void settUser_id(int tUser_id) {
		this.tUser_id = tUser_id;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBtnCss() {
		return btnCss;
	}
	public void setBtnCss(String btnCss) {
		this.btnCss = btnCss;
	}
	public String getSendString() {
		return sendString;
	}
	public void setSendString(String sendString) {
		this.sendString = sendString;
	}
	public char getShowNum() {
		return showNum;
	}
	public void setShowNum(char showNum) {
		this.showNum = showNum;
	}
	public char getLimitTime() {
		return limitTime;
	}
	public void setLimitTime(char limitTime) {
		this.limitTime = limitTime;
	}
	public char getIsAutoSave() {
		return isAutoSave;
	}
	public void setIsAutoSave(char isAutoSave) {
		this.isAutoSave = isAutoSave;
	}
	public char getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(char isOpen) {
		this.isOpen = isOpen;
	}
	public char getIsTop() {
		return isTop;
	}
	public void setIsTop(char isTop) {
		this.isTop = isTop;
	}
	public char getIsLike() {
		return isLike;
	}
	public void setIsLike(char isLike) {
		this.isLike = isLike;
	}
	public char getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(char isDelete) {
		this.isDelete = isDelete;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public List<QuestionDetailinfo> getListQuestionDetailinfo() {
		return listQuestionDetailinfo;
	}
	public void setListQuestionDetailinfo(List<QuestionDetailinfo> listQuestionDetailinfo) {
		this.listQuestionDetailinfo = listQuestionDetailinfo;
	}
	
	
	
	
}
