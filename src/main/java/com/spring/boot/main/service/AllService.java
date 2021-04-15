package com.spring.boot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service//少了
public class AllService {
	@Autowired
	private QuestioninfoService questioninfoService;
	@Autowired
	private QuestionDetailinfoService questionDetailinfoService;
	@Autowired
	private QuestionDatainfoService questionDatainfoService;


	public QuestioninfoService getQuestioninfoService() {
		return questioninfoService;
	}

	public void setQuestioninfoService(QuestioninfoService questioninfoService) {
		this.questioninfoService = questioninfoService;
	}

	public QuestionDetailinfoService getQuestionDetailinfoService() {
		return questionDetailinfoService;
	}

	public void setQuestionDetailinfoService(QuestionDetailinfoService questionDetailinfoService) {
		this.questionDetailinfoService = questionDetailinfoService;
	}

	public QuestionDatainfoService getQuestionDatainfoService() {
		return questionDatainfoService;
	}

	public void setQuestionDatainfoService(QuestionDatainfoService questionDatainfoService) {
		this.questionDatainfoService = questionDatainfoService;
	}

	
}
