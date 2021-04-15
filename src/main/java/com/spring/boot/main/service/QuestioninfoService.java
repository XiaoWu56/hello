package com.spring.boot.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.main.po.Questioninfo;
import com.spring.boot.main.repository.AllMapping;

@Service
public class QuestioninfoService {
	@Autowired
	private AllMapping allMapping;

	public AllMapping getAllmapping() {
		return allMapping;
	}

	public void setAllmapping(AllMapping allmapping) {
		this.allMapping = allmapping;
	}

	public void addFormServiceMethod(Questioninfo questioninfo) {
		this.allMapping.getQuestioninfoMapping().addForm(questioninfo);
	}
	
//	public void updFormServiceMethod(Questioninfo questioninfo) {
//		this.allMapping.getQuestioninfoMapping().updForm(questioninfo);
//	}
	
	public List<Questioninfo> selectFormsServiceMethod(int userId) {
		return this.allMapping.getQuestioninfoMapping().selectForms(userId);
	}
	
//	public List<Questioninfo> selectFormsByConditionServiceMethod(int userId, String condition, char num){}
	public List<Questioninfo> selectFormsByIsLikeServiceMethod(int userId){
		return this.allMapping.getQuestioninfoMapping().selectFormsByIsLike(userId);
	}
	public List<Questioninfo> selectFormsByIsDeleteServiceMethod(int userId){
		return this.allMapping.getQuestioninfoMapping().selectFormsByIsDelete(userId);
	}
//	
////	public List<Questioninfo> selectFormsToRank(@Param("userId") int userId, @Param("condition") String condition);
////	public List<Questioninfo> selectFormsToRankNewDataServiceMethod(@Param("userId") int userId, @Param("condition") String condition);
////	public List<Questioninfo> selectFormsToRankPeopleMakeServiceMethod(int userId){
////		return this.allMapping.getQuestioninfoMapping().selectForm(userId);
////	}

	public Questioninfo selectFormServiceMethod(String sendString) {
		return this.allMapping.getQuestioninfoMapping().selectForm(sendString);
	}
	
////	public String updFormToChar(int formId, String condition) {}
	public void updFormToShowNumServiceMethod(int formId) {
		this.allMapping.getQuestioninfoMapping().updFormToShowNum(formId);
	}
	public void updFormToIsOpenServiceMethod(int formId) {
		this.allMapping.getQuestioninfoMapping().updFormToIsOpen(formId);
	}
	public void updFormToIsTopServiceMethod(int formId) {
		this.allMapping.getQuestioninfoMapping().updFormToIsTop(formId);
	}
	public void updFormToLikeServiceMethod(int formId) {
		this.allMapping.getQuestioninfoMapping().updFormToIsLike(formId);
	}
	public void updFormToIsDeleteServiceMethod(int formId) {
		this.allMapping.getQuestioninfoMapping().updFormToIsDelete(formId);
	}
	
	
//	public String updFormToCondition(int formId, String condition, String conditionNum);
	public void updFormToLimitTimeServiceMethod(int formId, String conditionNum) {
		this.allMapping.getQuestioninfoMapping().updFormToLimitTime(formId, conditionNum);
	}
	public void updFormToNameServiceMethod(int formId, String conditionNum) {
		this.allMapping.getQuestioninfoMapping().updFormToName(formId, conditionNum);
	}
	public void updFormToIconServiceMethod(int formId, String conditionNum) {
		this.allMapping.getQuestioninfoMapping().updFormToIcon(formId, conditionNum);
	}
	
	public void delFormServiceMethod(int formId) {
		this.allMapping.getQuestioninfoMapping().delForm(formId);
	};
	public void delFormsServiceMethod(int userId) {
		this.allMapping.getQuestioninfoMapping().delForms(userId);
	};
	
}
