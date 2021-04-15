package com.spring.boot.main.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //org.springframework.stereotype.Component;
public class AllMapping {
	@Autowired
	private IQuestioninfoMapping questioninfoMapping;
	@Autowired
	private IQuestionDetailinfoMapping questionDetailinfoMapping;
	@Autowired
	private IQuestionDatainfoMapping questionDatainfoMapping;
	


	public IQuestioninfoMapping getQuestioninfoMapping() {
		return questioninfoMapping;
	}

	public void setQuestioninfoMapping(IQuestioninfoMapping questioninfoMapping) {
		this.questioninfoMapping = questioninfoMapping;
	}

	public IQuestionDetailinfoMapping getQuestionDetailinfoMapping() {
		return questionDetailinfoMapping;
	}

	public void setQuestionDetailinfoMapping(IQuestionDetailinfoMapping questionDetailinfoMapping) {
		this.questionDetailinfoMapping = questionDetailinfoMapping;
	}

	public IQuestionDatainfoMapping getQuestionDatainfoMapping() {
		return questionDatainfoMapping;
	}

	public void setQuestionDatainfoMapping(IQuestionDatainfoMapping questionDatainfoMapping) {
		this.questionDatainfoMapping = questionDatainfoMapping;
	}
	
	

	
	
	
	
}
