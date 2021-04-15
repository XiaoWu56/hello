package com.spring.boot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.main.service.AllService;

@Transactional
@Controller
public class QuestionDetailinfoController{
	@Autowired
	private AllService allService;

	public AllService getAllService() {
		return allService;
	}

	public void setAllService(AllService allService) {
		this.allService = allService;
	}

	public String addDetails(int questionId, String dataa) {//int formId, String data
		return "";
	}

	


	

}
