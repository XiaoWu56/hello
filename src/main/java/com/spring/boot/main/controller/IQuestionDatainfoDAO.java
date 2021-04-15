package com.spring.boot.main.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.main.po.QuestionDatainfo;

import net.sf.json.JSONObject;

@RequestMapping("/questionData")
public interface IQuestionDatainfoDAO {
	
	/*
	 * @添加一条表单数据
	 * (tQuestion_id, tQuestionData, submitter, update_time, write_time, write_place)
		填写时长（前端获取，提交时间减进入时间的秒数，不是实时的秒数加一。进入页面时就绑定属性进入时间（可在在提交按钮的属性））
		填写地区（前端插件获取T，后端要从前端取ip在再解析地址）
	 * @param json
	 */
	@RequestMapping("/addData")
	@ResponseBody
	public void addData(@RequestBody QuestionDatainfo questionDatainfo);
	
//	/*
//	 * @通过excal添加多条表单数据【待定】
//	 */
//	@RequestMapping("/addDatasFromExcal")
//	public String addDatasFromExcal();
	
	/*
	 * @查概述页的数组组合（问卷数量，今日新增，平均时间，问卷浏览，结果浏览）
	 * 	分3个方法，问卷浏览【待定】
	 * @param formId
	 * @return
	 */
	@RequestMapping("/selectNumList")
	@ResponseBody
	public int[] selectNumList(@RequestBody JSONObject jsonObject);//int formId//注意事项：直接 int formId一直失败，因axios的post为application/json方式封装
	/*
	 * @查填写问卷数量(数据概述页，提供一个数字)
	 * @param formId
	 * @return
	 */
	public int selectDatasNum(int formId);
	/*
	 * @查今日新增(数据概述页，提供一个数字)
	 * @param formId
	 * @return
	 */
	public int selectDatasToday(int formId);
	/*
	 * @查填写平均时长
	 * 	后端处理得平均秒（如果大于1分钟的不处理，交给前端处理）
	 * @param formId
	 * @return
	 */
	public int selectDatasAverTime(int formId);
	
	/*
	 * @查数据填写地址
	 * @param formId
	 * @return
	 * 
	 * 	注意事项：等与前端连接改返回类型为String[]
	 */
	@RequestMapping("/selectDatasPlace")
	@ResponseBody
	public String[] selectDatasPlace(@RequestBody JSONObject jsonObject);//int formId
	
	/*
	 * @查全部填写数据
	 * @param formId
	 * @return 
	 */
	@RequestMapping("/selectDatas")
	@ResponseBody
	public List<QuestionDatainfo> selectDatas(@RequestBody JSONObject jsonObject);//int formId
	
//	/*
//	 * @查询处理过得全部数据
//	 * 步骤：
//	 * 前端传【formId】
//	 * （会有多个查询）
//	 * 1.交给questioninfo的selectForm获取全部题目名和题目明细（因要按顺序，并且查询会detailId进行查找）
//	 * （调用这个方法看用static的还是实例一个对象在调用，尽量前者，前者语句一条，关系简单看）
//	 * 2.{title：{detailId：XX， text：XX}，
//	 * 		details：[
//	 * 			{}
//	 * 		]
//	 * }
//	 * {detailId：答案}
//	 * 
//	 * 
//	 * @param formId
//	 * @return json
//	 */
//	@RequestMapping(value = "selectDatasAnalyse")
//	public String selectDatasAnalyse(int formId);
	
	/*
	 * @修改一条数据
	 * @param dataId, json(tQuestionData)
	 * @return
	 */
	@RequestMapping("/updData")
	@ResponseBody
	public void updData(@RequestBody JSONObject jsonObject);//int dataId, String data
	
//	/*
//	 * @批量修改数据
//	 * （会改一些tQuestionData表的tQuestionData其中某些detailId，逐个改还是再寻找sql的替换功能T，有修改和添加两类）
//	 * @param json([dataId,...], details:[{detailId: text},....])
//	 * @return
//	 */
//	@RequestMapping("/updDatas")
//	public String updDatas(String data);
	
	/*
	 * @修改颜色数据(批量)
	 * @param dataIdListS:"34,33,44"(id数组列字符串，减少过多json转换), color:"34,34,23"
	 * @return
	 */
	@RequestMapping("/updDatasColor")
	@ResponseBody
	public void updDatasColor(@RequestBody JSONObject jsonObject);//String dataIdListS, String color
	
	/*
	 * @删除一个表单全部数据
	 * @param formId
	 * @return
	 */
	@RequestMapping("/delDatasByFormId")
	@ResponseBody
	public void delDatasByFormId(@RequestBody JSONObject jsonObject);//int formId
	
	/*
	 * @删除数据 真删(批量)
	 * @param listdataIdS
	 * @return
	 */
	@RequestMapping("/delDatas")
	@ResponseBody
	public void delDatas(@RequestBody JSONObject jsonObject);//String listdataIdS
	
	/*
	 * @删除数据 (只改状态,账号等级高可恢复)(批量)
	 * @param listdataIdS
	 * @return
	 */
	@RequestMapping("/updDataStatus")
	@ResponseBody
	public void updDatasStatus(@RequestBody JSONObject jsonObject);//String listdataIdS
}
