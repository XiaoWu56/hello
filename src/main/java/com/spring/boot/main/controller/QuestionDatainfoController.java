package com.spring.boot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.boot.main.po.QuestionDatainfo;
import com.spring.boot.main.service.AllService;

import net.sf.json.JSONObject;

@Transactional
@Controller
public class QuestionDatainfoController implements IQuestionDatainfoDAO{
	@Autowired
	private AllService allService;

	public AllService getAllService() {
		return allService;
	}

	public void setAllService(AllService allService) {
		this.allService = allService;
	}
	
	@Override
	public void addData(QuestionDatainfo questionDatainfo) {
		//(tQuestion_id, tQuestionData, submitter, write_time, write_place)
		this.getAllService().getQuestionDatainfoService().addDataServiceMethod(questionDatainfo);
		System.out.println(questionDatainfo.gettQuestionData());
		System.out.println("533 addData");
	}
	
//	@Override
//	public String addDatasFromExcal() {
//		return "success";
//	}
	
	@Override
	public int[] selectNumList(JSONObject jsonObject) {
//		（问卷数量，今日新增，平均时间，问卷浏览，结果浏览）
		int formId = Integer.parseInt(jsonObject.getString("formId"));
		System.out.println(formId);
		int[] numList = new int[5];
		numList[0] = selectDatasNum(formId);
		numList[1] = selectDatasToday(formId);
		numList[2] = selectDatasAverTime(formId);
		numList[3] = 0;
		numList[4] = 0;
		return numList;
	}
	@Override
	public int selectDatasNum(int formId) {
		int num = -1;
		num = this.getAllService().getQuestionDatainfoService().selectDatasNumServiceMethod(formId);
		System.out.println("datasNum="+num);
		return num;
	}
	@Override
	public int selectDatasToday(int formId) {
		int num = -1;
		num = this.getAllService().getQuestionDatainfoService().selectDatasTodayServiceMethod(formId);
		System.out.println("numtoday="+num);
		return num;
	}
	@Override
	public int selectDatasAverTime(int formId) {
		int[] times = this.getAllService().getQuestionDatainfoService().selectDatasAverTimeServiceMethod(formId);
		int sum = 0;
		for(int i=0; i<times.length; i++) {
			sum+=times[i];
		}
		if(times.length!=0) {
			sum = sum/times.length;
		}
		System.out.println("AverTime="+sum);
		return sum;
	}

	@Override
	public String[] selectDatasPlace(JSONObject jsonObject) {
		int formId = Integer.parseInt(jsonObject.getString("formId"));
		String[] listplace = this.getAllService().getQuestionDatainfoService().selectDatasPlaceServiceMethod(formId);
		return listplace;
	}
	
	@Override
	public List<QuestionDatainfo> selectDatas(JSONObject jsonObject){
		int formId = Integer.parseInt(jsonObject.getString("formId"));
		List<QuestionDatainfo> listQuestionDatainfo = this.getAllService().getQuestionDatainfoService().selectDatasServiceMethod(formId);
		//注意事项：对于日期，sql为datetime型含时分秒，java对应java.util.date接受含时分秒，日期格式转化在对象的get方法中
		return listQuestionDatainfo;
	}
	
//	@Override
//	public String selectDatasAnalyse(int formId) {
//		return "success";
//	}
	
	@Override
	public void updData(JSONObject jsonObject) {//int dataId, String data
		int dataId = Integer.parseInt(jsonObject.getString("dataId"));
		String data = jsonObject.getString("data");//"{'A1':'YYU', 'A2':'fg7777', 'A3':'ss'}"
		this.getAllService().getQuestionDatainfoService().updDataServiceMethod(dataId, data);
	}
	
//	@Override
//	public String updDatas(String data) {
//		return "success";
//	}
	
	//本类方法： string数组装int数组
	public int[] stringLTointL(String[] stringL) {
		int[] dataIdList = new int[stringL.length];
		for(int i=0; i<dataIdList.length; i++) {
			dataIdList[i]=Integer.parseInt(stringL[i]);
		}
		return dataIdList;
	}
	@Override
	public void updDatasColor(JSONObject jsonObject) {//String dataIdListS, String color
		String[] dataIdListS = jsonObject.getString("dataIdListS").split(",");
		String color = jsonObject.getString("color");
		
		int[] dataIdList = stringLTointL(dataIdListS);
		this.getAllService().getQuestionDatainfoService().updDatasColorServiceMethod(dataIdList, color);
	}
	
	@Override
	public void delDatasByFormId(JSONObject jsonObject) {//int formId
		int formId = Integer.parseInt(jsonObject.getString("formId"));
		this.getAllService().getQuestionDatainfoService().delDatasByFormIdServiceMethod(formId);
	}
	
	@Override
	public void delDatas(JSONObject jsonObject) {//String dataIdListS
		String[] dataIdListS = jsonObject.getString("dataIdListS").split(",");
		
		int[] dataIdList = stringLTointL(dataIdListS);
		this.getAllService().getQuestionDatainfoService().delDatasServiceMethod(dataIdList);
	}

	@Override//String dataIdListS
	public void updDatasStatus(JSONObject jsonObject) {//String dataIdListS
		String[] dataIdListS = jsonObject.getString("dataIdListS").split(",");

		int[] dataIdList = stringLTointL(dataIdListS);
		this.getAllService().getQuestionDatainfoService().updDatasStatusServiceMethod(dataIdList);
	}
}
