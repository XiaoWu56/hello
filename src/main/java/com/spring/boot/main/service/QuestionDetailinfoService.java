package com.spring.boot.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.main.po.QuestionDetailinfo;
import com.spring.boot.main.repository.AllMapping;

@Service
public class QuestionDetailinfoService {
	@Autowired
	private AllMapping allMapping;

	public AllMapping getAllmapping() {
		return allMapping;
	}

	public void setAllmapping(AllMapping allmapping) {
		this.allMapping = allmapping;
	}
	
	public void addDetailsServiceMethod(List<QuestionDetailinfo> listQuestionDetailinfo) {
		allMapping.getQuestionDetailinfoMapping().addDetails(listQuestionDetailinfo);
	}
	
	public void delDetailsServiceMethod(int questionId) {
		allMapping.getQuestionDetailinfoMapping().delDetails(questionId);
	}
	
	public void delDetailsToFormsServiceMethod(String[] delIdList) {
		allMapping.getQuestionDetailinfoMapping().delDetailsToForms(delIdList);
	}
}
