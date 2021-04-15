package com.spring.boot.main.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.main.po.QuestionDatainfo;
import com.spring.boot.main.po.Questioninfo;

import net.sf.json.JSONObject;

@RequestMapping("/question")
public interface IQuestioninfoDAO {
	
	/*	
	 * @添加一个表单
	 * 步骤：
	 * ===
		发布人
		发布时间（表单创建时间，年月日时分秒）【后】
		截止时间（默认无）
		问卷状态【默认】
		问卷名
		封面图片
		问卷说明
		提交按钮样式
		发布匹配码【后】
	 * ===前5
	 * @param json(其中questionId为空)
	 * @return
	 */
	@RequestMapping("/addForm")
	@ResponseBody
	public String addForm(@RequestBody Questioninfo questioninfo);
	
	/*	
	 * @修改一个表单
	 * 步骤：
	 * ===
		问卷名
		封面图片
		问卷说明
		提交按钮样式
	 * ===前5
	 * @param json数据(其中有questionId)
	 * @return
	 */
//	@RequestMapping("/updForm")
//	@ResponseBody
//	public void updForm(@RequestBody Questioninfo questioninfo);//String data

	/*
	 * @查问卷编码
	 */
//	@RequestMapping("/selectSendString")
//	@ResponseBody
//	public String selectSendString(@RequestBody JSONObject jsonObject);
	
	/*	
	 * @搜索全部表单（用于首页）
	 * @param userId
	 * @return
	 */
	@RequestMapping("/selectForms")
	@ResponseBody
	public List<Questioninfo> selectForms(@RequestBody JSONObject jsonObject);//int userId
	
	/*	
	 * @有条件搜索全部表单（用于收藏夹、回收站）
	 * @param	userId, 表单条件Condition(isLike, isDelete[数据库字段，有大写])
	 * @return
	 * 	注意事项：sql的搜索字段不能是传入的变量名，内部再if
	 */
	@RequestMapping("/selectFormsByCondition")
	@ResponseBody
	public List<Questioninfo> selectFormsByCondition(@RequestBody JSONObject jsonObject);//int userId, String condition
	
//	/*	
//	 * @有排序条件搜索全部表单（首页，用于排序）
//	 * 步骤：
//	 * 前端给【表单条件condition】
//	 * 交给下一层select
//	 * 过程无误给前端返回List<Questioninfo>
//	 * @param userId, 表单条件condition（newCreate最新创建，newData最新数据，peopleMake手动序列【】）
//	 * @return
//	 * 
//	 * select * from XXX order by {} {desc};
//	 */
//	@RequestMapping(value = "selectFormsToRank")
//	public List<Questioninfo> selectFormsToRank(int userId, String condition);
	
	/*	
	 * @搜索一个完整表单(tquestion,tquestionDetail)
	 * @param formId
	 * @return
	 */
	@RequestMapping("/selectForm")
	@ResponseBody
	public Questioninfo selectForm(@RequestBody JSONObject jsonObject);//int formId
	
	/*	
	 * @不传值修改表单属性（显示序号showNum，开启状态isOpen，置顶isTop，收藏isLike, 删除isDelete）
	 * @param formId，表单条件Condition(showNum, isOpen, isTop, isLike, isDelete)
	 * @return
	 */
	@RequestMapping("/updFormToChar")
	@ResponseBody
	public void updFormToChar(@RequestBody JSONObject jsonObject);//int formId, String condition
	
	/*	
	 * @传值修改表单属性（填写次数limitTime，表单名字name，表单图标（颜色，图标）icon）
	 * @param formId，表单条件condition, 条件值conditionNum
	 * @return
	 */
	@RequestMapping("/updFormToCondition")
	@ResponseBody
	public void updFormToCondition(@RequestBody JSONObject jsonObject);//int formId, String condition, String conditionNum
	
	/*	
	 * @删除一个表单（真删,问卷与问卷明细）
	 * @param formId
	 * @return
	 */
	@RequestMapping("/delForm")
	@ResponseBody
	public void delForm(@RequestBody JSONObject jsonObject);//int formId
	
	/*	
	 * @清空所有回收站表单(虽然平台无此功能)
	 * @param userId
	 */
	@RequestMapping("/delForms")
	@ResponseBody
	public void delForms(@RequestBody JSONObject jsonObject);//int userId
	
	
	public void addDetails(int questionId, String data);
//	public void updDetails(int questionId, String data)
	public void delDetails(int questionId);
	public void delDetailsToForms(String[] delIdList);
	
}
