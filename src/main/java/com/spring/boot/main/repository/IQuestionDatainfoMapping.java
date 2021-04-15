package com.spring.boot.main.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.boot.main.po.QuestionDatainfo;

public interface IQuestionDatainfoMapping {
	@Insert("insert into tquestionData"
			+"(tQuestion_id, tQuestionData, submitter, submit_time, update_time, write_time, write_place)"
			+"values"
			+"(#{tQuestion_id},#{tQuestionData},#{submitter},now(),now(),#{write_time},#{write_place})")
	public void addData(QuestionDatainfo questionDatainfo);
	
	public String addDatasFromExcal();
	
	@Select("select count(id) from tQuestionData "
			+ "where tQuestion_id=#{formId}")
	public int selectDatasNum(int formId);
	@Select("select count(id) from tQuestionData "
			+ "where tQuestion_id=#{formId} "
			+ "and submit_time>left(now(), 10)")
	public int selectDatasToday(int formId);
	@Select("select write_time from tQuestionData "
			+ "where tQuestion_id=#{formId} ")
	public int[] selectDatasAverTime(int formId);
	
	@Select("select write_place from tQuestionData "
			+ "where tQuestion_id=#{formId} ")
	public String[] selectDatasPlace(int formId);
	
	@Select("select * from tQuestionData "
			+ "where tQuestion_id=#{formId} ")
	public List<QuestionDatainfo> selectDatas(int formId);
	
	public String selectDatasAnalyse(int formId);
	
	@Update("update tQuestionData "
			+"set tQuestionData=#{data} "
			+"where id=#{dataId} ")
	public void updData(@Param("dataId") int dataId, @Param("data") String data);
	
	public void updDatas();
	
	@Update("<script>"
			+"update tQuestionData "
			+"set color=#{color} "
			+"where id in "
			+"<foreach collection='dataIdList' item='dataId' index='index' open='(' close=')' separator=',' > "
			+"#{dataId}"
			+"</foreach> "
			+"</script>")	
	public void updDatasColor(@Param("dataIdList") int[] dataIdList, @Param("color") String color);
	
	@Delete("delete from tQuestionData "
			+"where tQuestion_id=#{formId} ")	
	public void delDatasByFormId(int formId);
	
	@Delete("<script>"
			+"delete from tQuestionData "
			+"where id in "
			+"<foreach collection='listdataId' item='dataId' index='index' open='(' close=')' separator=',' > "
			+"#{dataId}"
			+"</foreach> "
			+"</script>")
	public void delDatas(@Param("listdataId") int[] listdataId);
	
	@Update("<script>"
			+"update tQuestionData "
			+"set isDelete= "
			+"case "
			+"when isDelete=1 then 0 "
			+"when isDelete=0 then 1 "
			+"end "
			+"where id in "
			+"<foreach collection='listdataId' item='dataId' index='index' open='(' close=')' separator=',' > "
			+"#{dataId}"
			+"</foreach> "
			+"</script>")
	public void updDatasStatus(@Param("listdataId") int[] listdataId);
}
