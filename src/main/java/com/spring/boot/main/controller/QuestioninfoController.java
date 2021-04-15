package com.spring.boot.main.controller;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.boot.main.po.QuestionDetailinfo;
import com.spring.boot.main.po.Questioninfo;
import com.spring.boot.main.service.AllService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//数据库注解？ 该类实例注解，注入业务类
@Transactional
@Controller
public class QuestioninfoController implements IQuestioninfoDAO{
	@Autowired
	private AllService allService;

	public AllService getAllService() {
		return allService;
	}

	public void setAllService(AllService allService) {
		this.allService = allService;
	}
	
	public String makeSendString() {
		String make = RandomStringUtils.randomAlphanumeric(6);
		return make;
	}
	
	@Override
	public String addForm(Questioninfo questioninfo) {
//		(tUser_id, publishDate, name, coverImage, content, btnCss, sendString),(questionDetail=>前端为icon名字，暂时接收，因有默认值没影响（主因接受一个对象，一个json对象报什么IO流错误）)
		questioninfo.setSendString(makeSendString());
		this.getAllService().getQuestioninfoService().addFormServiceMethod(questioninfo);
		
		int questionId = questioninfo.getId();
		String jsonQD = questioninfo.getIcon();
		addDetails(questionId, jsonQD);
		System.out.println("2 addForm");
		return questioninfo.getSendString();
	}
	
	
//	@Override
//	public void updForm(Questioninfo questioninfo) {//String data
//		this.getAllService().getQuestioninfoService().updFormServiceMethod(questioninfo);
//		
//		//updQuestionDetail
//		//更新detail要根据detailId，id有值，有空（改，加）【没删除，有没保存时改tQuetionDetail，关联到tquestionData】
////		int questionId = questioninfo.getId();
//		String jsonQD = questioninfo.getIcon();
//		updDetails(jsonQD);
//		System.out.println("766 updForm");
//	}
	
	
//	public String selectSendString(@RequestBody JSONObject jsonObject) {
//		int formId = Integer.parseInt(jsonObject.getString("formId"));
//		Questioninfo questioninfo = this.getAllService().getQuestioninfoService().selectFormServiceMethod(formId);
//		return questioninfo.getSendString();
//	}
	
	@Override
	public List<Questioninfo> selectForms(JSONObject jsonObject){//int userId
		int userId = Integer.parseInt(jsonObject.getString("userId"));
		List<Questioninfo> listQuestioninfo = this.getAllService().getQuestioninfoService().selectFormsServiceMethod(userId);
//		for(Questioninfo a : listQuestioninfo) {
//			System.out.println(a.getId());
//		}
		
		System.out.println("336 selectForms");
		return listQuestioninfo;
	}

	@Override
	public List<Questioninfo> selectFormsByCondition(JSONObject jsonObject){//int userId, String condition
		int userId = Integer.parseInt(jsonObject.getString("userId"));
		String condition = jsonObject.getString("condition");
		List<Questioninfo> listQuestioninfo =  null;
		switch(condition) {
			case "isLike":
				listQuestioninfo = this.getAllService().getQuestioninfoService().selectFormsByIsLikeServiceMethod(userId);
				break;
			case "isDelete":
				listQuestioninfo = this.getAllService().getQuestioninfoService().selectFormsByIsDeleteServiceMethod(userId);
				break;
		}
		System.out.println(listQuestioninfo.size());
		for(int i=0; i<listQuestioninfo.size(); i++) {
			Questioninfo questioninfo = listQuestioninfo.get(i);
			System.out.println("id="+questioninfo.getId());
		}
		System.out.println("226 selectFormsByCondition");
		return listQuestioninfo;
	}

	/*
	@Override
	public List<Questioninfo> selectFormsToRank(int userId, String condition){
//		@param 表单条件condition（默认newCreate最新创建，newData最新数据，peopleMake手动序列【】）
		List<Questioninfo> listQuestioninfo = null;
//		List<Questioninfo> listQuestioninfo = selectForms(userId);
//		if(condition.equals("newData")) {
//			//关联tquestionData的submit_time
//			//将condition下传，识别【待定，是识别后选<sql>拼接还是有单一对应的方法】
//			listQuestioninfo = this.getAllService().getQuestioninfoService().selectFormsToRankServiceMethod(condition);
//		}
//		if(condition.equals("peopleMake")) {
//			//select * from tquestion order by {peoplemake};(数据库peoplemake待设置)
////			listQuestioninfo = this.getAllService().getQuestioninfoService().selectFormsToRankServiceMethod(condition);
//		}
//		System.out.println("=E==selectFormsToRank");
		return listQuestioninfo;
		 
	}
	*/
	
	@Override
	public Questioninfo selectForm(JSONObject jsonObject) {//int formId
		String sendString = jsonObject.getString("sendString");
		Questioninfo questioninfo = this.getAllService().getQuestioninfoService().selectFormServiceMethod(sendString);
		
		JSONObject json = JSONObject.fromObject(questioninfo);//将java对象转换为json对象
		String str = json.toString();
		System.out.println("770 selectForm");
		return questioninfo;
	}
	
	@Override
	public void updFormToChar(JSONObject jsonObject) {//int formId, String condition
//		(showNum, isOpen, isTop, isLike, isDelete)
		int formId = Integer.parseInt(jsonObject.getString("formId"));
		String condition = jsonObject.getString("condition");
		switch(condition) {
			case "showNum":
				this.getAllService().getQuestioninfoService().updFormToShowNumServiceMethod(formId);
				break;
			case "isOpen":
				this.getAllService().getQuestioninfoService().updFormToIsOpenServiceMethod(formId);
				break;
			case "isTop":
				this.getAllService().getQuestioninfoService().updFormToIsTopServiceMethod(formId);
				break;
			case "isLike":
				this.getAllService().getQuestioninfoService().updFormToLikeServiceMethod(formId);
				break;
			case "isDelete":
				this.getAllService().getQuestioninfoService().updFormToIsDeleteServiceMethod(formId);
				break;
		}
		System.out.println("663 updFormToChar");
	}
	
	@Override
	public void updFormToCondition(JSONObject jsonObject) {//int formId, String condition, String conditionNum
//		（填写次数limitTime，表单名字name，表单图标（颜色，图标）icon）
		//注意事项：limit要转为数字//可以不用，sql可以识别（数据库为char(1)类型，要改）
		int formId = Integer.parseInt(jsonObject.getString("formId"));
		String condition = jsonObject.getString("condition");
		String conditionNum = jsonObject.getString("conditionNum"); 
		switch(condition) {
			case "limitTime":
				this.getAllService().getQuestioninfoService().updFormToLimitTimeServiceMethod(formId, conditionNum);
				break;
			case "name":
				this.getAllService().getQuestioninfoService().updFormToNameServiceMethod(formId, conditionNum);
				break;
			case "icon":
				this.getAllService().getQuestioninfoService().updFormToIconServiceMethod(formId, conditionNum);
				break;
		}
		System.out.println("882 updFormToCondition");
	}
	
	@Override
	public void delForm(JSONObject jsonObject) {//int formId
		int formId = Integer.parseInt(jsonObject.getString("formId"));
		delDetails(formId);
		this.getAllService().getQuestioninfoService().delFormServiceMethod(formId);
		System.out.println("992 delForm");
	}
	
	@Override
	public void delForms(JSONObject jsonObject) {//int userId
		int userId = Integer.parseInt(jsonObject.getString("userId"));
		List<Questioninfo> listQuestioninfo = selectFormsByCondition(JSONObject.fromObject("{userId:"+userId+", condition:'isDelete'}"));
		String delIdS = "";
		if(listQuestioninfo.size()>0) {
			for(int i=0; i<listQuestioninfo.size(); i++) {
				Questioninfo questioninfo = listQuestioninfo.get(i);
				delIdS += questioninfo.getId();
				delIdS += ",";
			}
		}
		String[] delIdL = delIdS.split(",");//可以不用int型，因sql可识别
		System.out.println(delIdS);
		delDetailsToForms(delIdL);
		this.getAllService().getQuestioninfoService().delFormsServiceMethod(userId);
	}

//	//====================================================
	@Override
	public void addDetails(int questionId, String data) {
//	 * 许多个的数组对象{name: "sss", type: "A1", model: "{}"}
		int tQuestion_id = questionId;
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<QuestionDetailinfo> listQuestionDetailinfo = new LinkedList<>();
		if (jsonArray.size() > 0) {
		for(int i=0; i<jsonArray.size(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			//值较少，不直接一步到对象（值为json对象无影响）
			QuestionDetailinfo questionDetailinfo = new QuestionDetailinfo();
			questionDetailinfo.settQuestion_id(tQuestion_id);
			questionDetailinfo.setName(jsonObject.getString("name"));
			questionDetailinfo.setType(jsonObject.getString("type"));
			questionDetailinfo.setModel(jsonObject.getString("model"));
			listQuestionDetailinfo.add(questionDetailinfo);
		}
		}
		this.getAllService().getQuestionDetailinfoService().addDetailsServiceMethod(listQuestionDetailinfo);
	
	}

//	public void updDetails(String data) {
////		int tQuestion_id = questionId;
//		JSONArray jsonArray = JSONArray.fromObject(data);
//		List<QuestionDetailinfo> listQuestionDetailinfo = new LinkedList<>();
//		if (jsonArray.size() > 0) {
//		for(int i=0; i<jsonArray.size(); i++) {
//			JSONObject jsonObject = jsonArray.getJSONObject(i);
//			//值较少，不直接一步到对象（值为json对象无影响）
//			QuestionDetailinfo questionDetailinfo = new QuestionDetailinfo();
//			questionDetailinfo.settQuestion_id(Integer.parseInt(jsonObject.getString("id")));
//			questionDetailinfo.settQuestion_id(Integer.parseInt(jsonObject.getString("tQuestion_id")));
//			questionDetailinfo.setName(jsonObject.getString("name"));
//			questionDetailinfo.setType(jsonObject.getString("type"));
//			questionDetailinfo.setModel(jsonObject.getString("model"));
//			listQuestionDetailinfo.add(questionDetailinfo);
//		}
//		}
//		this.getAllService().getQuestionDetailinfoService().updDetailsServiceMethod(listQuestionDetailinfo);
//	
//	}
	
	public void delDetails(int questionId) {
		this.getAllService().getQuestionDetailinfoService().delDetailsServiceMethod(questionId);
	}
	public void delDetailsToForms(String[] delIdList) {
		this.getAllService().getQuestionDetailinfoService().delDetailsToFormsServiceMethod(delIdList);
	}
}
