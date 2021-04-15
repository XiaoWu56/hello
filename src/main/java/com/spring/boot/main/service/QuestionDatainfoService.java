package com.spring.boot.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.main.po.QuestionDatainfo;
import com.spring.boot.main.repository.AllMapping;

@Service
public class QuestionDatainfoService {
	@Autowired
	private AllMapping allMapping;

	public AllMapping getAllmapping() {
		return allMapping;
	}

	public void setAllmapping(AllMapping allmapping) {
		this.allMapping = allmapping;
	}

	public void addDataServiceMethod(QuestionDatainfo questionDatainfo) {
		this.getAllmapping().getQuestionDatainfoMapping().addData(questionDatainfo);
	}
	
	public int selectDatasNumServiceMethod(int formId) {
		return this.getAllmapping().getQuestionDatainfoMapping().selectDatasNum(formId);
	}
	public int selectDatasTodayServiceMethod(int formId) {
		return this.getAllmapping().getQuestionDatainfoMapping().selectDatasToday(formId);
	}
	public int[] selectDatasAverTimeServiceMethod(int formId) {
		return this.getAllmapping().getQuestionDatainfoMapping().selectDatasAverTime(formId);
	}
	
	public String[] selectDatasPlaceServiceMethod(int formId) {
		return this.getAllmapping().getQuestionDatainfoMapping().selectDatasPlace(formId);
	}
	
	public List<QuestionDatainfo> selectDatasServiceMethod(int formId) {
		return this.getAllmapping().getQuestionDatainfoMapping().selectDatas(formId);
	}
	
//	public void selectDatasAnalyseServiceMethod(int formId) {
//	}
	
	public void updDataServiceMethod(int dataId, String data) {
		this.getAllmapping().getQuestionDatainfoMapping().updData(dataId, data);
	}
	
//	public void updDatasServiceMethod(int dataId, String data) {
//	}
	
	public void updDatasColorServiceMethod(int[] dataIdList, String color) {
		this.getAllmapping().getQuestionDatainfoMapping().updDatasColor(dataIdList, color);
	}
	
	public void delDatasByFormIdServiceMethod(int formId) {
		this.getAllmapping().getQuestionDatainfoMapping().delDatasByFormId(formId);
	}
	
	public void delDatasServiceMethod(int[] listdataId) {
		this.getAllmapping().getQuestionDatainfoMapping().delDatas(listdataId);
	}
	
	public void updDatasStatusServiceMethod(int[] listdataId) {
		this.getAllmapping().getQuestionDatainfoMapping().updDatasStatus(listdataId);
	}
}
