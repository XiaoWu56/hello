package com.spring.boot.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "questionDetail")//questionDetail/addDetails
public interface IQuestionDetailinfoDAO {
	/*
	 * 	作用：操作tQuestionDetail表（辅助tQuestion表）【但也配个路径，方便先测试】
	 * 	操作：
	 * 	增删查改
	 */
	
	
	/*	
	 * 方法作用：测试运行
	 * 数据格式：无
	 */
	@RequestMapping(value = "testQuestionDetail")
	public String testQuestionDetail();
	
	/*	
	 * @添加一张表单所有明细
	 *	 步骤：
	 * questionControll给json字符串（各项明细字符串）
	 *	循环交给下一层add
	 * 	过程无误返回questionControll给true（判断添加成功）
	 * @param formId, json
	 * {
	 * text: "sss",
	 * type: "A1",
	 * model: "{option: [{text: 'a'},[text: 'b']]}"
	 * }许多个的数组对象
	 * 
	 * public void addDetails(list);
	 * insert XXX 
	 * values
	 * (),
	 * (),
	 * ()
	 * <foreach>
	 * 
	 * </foreach>
	 * 	;
	 */
	@RequestMapping(value = "addDetails")
	public String addDetails();//int formId, String data
	

}
