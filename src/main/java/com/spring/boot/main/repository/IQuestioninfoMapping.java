package com.spring.boot.main.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.spring.boot.main.po.Questioninfo;

public interface IQuestioninfoMapping {
	//提取重复句，用@one，@many
	
	
	
	@Insert("insert into tquestion"
			+"(tUser_id, publishDate, endDate, name, coverImage, content, btnCss, sendString)"
			+"values"
			+"(#{tUser_id},now(),now(),#{name},#{coverImage},#{content},#{btnCss},#{sendString})")
	@SelectKey(keyProperty = "id",before = false,resultType =Integer.class,statement = {" select last_insert_id()"})
	public void addForm(Questioninfo questioninfo);
	
//	@Update("update `tquestion` "
//			+"set name=#{name},coverImage=#{coverImage},content=#{content},btnCss=#{btnCss} "
//			+"where id=#{id}")
//	public void updForm(Questioninfo questioninfo);
	
	@Select("select * from tquestion "
			+"where tUser_id=#{userId} and isDelete=0 "
			+"order by publishDate desc ")
//	@Results(id="listforms", 
//		value={
//		@Result(column="id", property="id", id=true),
//		@Result(column="tUser_id", property="tUser_id"),
//		@Result(column="publishDate", property="publishDate"),
//		@Result(column="status", property="status"),
//		@Result(column="name", property="name"),
//		@Result(column="sendString ", property="sendString"),
//		@Result(column="istop", property="isTop"),
//		@Result(column="islike ", property="isLike"),
//		@Result(column="isdelete ", property="isDelete"),
//		@Result(column="icon ", property="icon")
//		})
//	(用results取不到值，sendString,islike,isdelete,icon，可能为名字原因，（返回结果比较规范，让其自动装载也行）)
	public List<Questioninfo> selectForms(int userId);
	
//	public List<Questioninfo> selectFormsByCondition(@Param("userId") int userId, @Param("condition") String condition, @Param("num") char num);
	//sql的搜索字段不能是传入的变量名，selectFormsByCondition化为2个（收藏夹、回收站）
	@Select("select * from tquestion "
			+"where isLike=1 and isDelete=0 "
			+"order by publishDate desc ")
//	@ResultMap(value = { "listforms" })
	public List<Questioninfo> selectFormsByIsLike(int userId);
	@Select("select * from tquestion "
			+"where isDelete=1 "
			+"order by publishDate desc ")
	public List<Questioninfo> selectFormsByIsDelete(int userId);
	
////	public List<Questioninfo> selectFormsToRank(@Param("userId") int userId, @Param("condition") String condition);
//	//sql的搜索字段不能是传入的变量名，selectFormsToRank化为2种，newCreate最新创建【为selectForms方法】，newData最新数据【要联合】，peopleMake手动序列【】
//	public List<Questioninfo> selectFormsToRankNewData(@Param("userId") int userId, @Param("condition") String condition);
////	@Select("select * from `tquestion` "
////			+"where tUser_id=#{userId} "
////			+"order by peopleMake ")
////	@ResultMap(value = { "listforms" })
////	public List<Questioninfo> selectFormsToRankPeopleMake(int userId);
//	@Results(id="", 
//			value={
//			@Result(column="id", property="id", id=true),
//			@Result(column="tUser_id", property="tUser_id"),
//			@Result(column="publishDate", property="publishDate"),
//			@Result(column="endDate", property="endDate"),
//			@Result(column="status", property="status"),
//			@Result(column="name", property="name"),
//			@Result(column="coverImage", property="coverImage"),
//			@Result(column="content", property="content"),
//			@Result(column="btnCss", property="btnCss"),
//			@Result(column="sendString ", property="sendString"),
//			@Result(column="showNum", property="showNum"),
//			@Result(column="limitTime", property="limitTime"),
//			@Result(column="isAutoSave", property="isAutoSave"),
//			@Result(column="isOpen", property="isOpen"),
//			@Result(column="top", property="top"),
//			@Result(column="like ", property="like"),
//			@Result(column="delete ", property="delete"),
//			@Result(column="icon ", property="icon"),
//			@Result(property="listQuestionDetailinfo",
//					many=@Many(
//			                select = "mapping.IQuestionDetailinfoMapping.selectDetails")
//					)
//		})
	
	@Select("select * from tquestion "
			+"where sendString=#{sendString}")
	@Results( 
		value={
		@Result(column="id", property="id", id=true),		
		@Result(column="id", property="listQuestionDetailinfo",
				many=@Many(
		                select = "com.spring.boot.main.repository.IQuestionDetailinfoMapping.selectDetails")
				)
	})//@many=collection可在基础上添加，不写已有字段。注意事项：column是tquestion的字段，以tQ表的条件搜索tQD表
	public Questioninfo selectForm(String sendString);

	public static final String updChar1 = "update tquestion set ";
	public static final String updChar2 = "= case when ";
	public static final String updChar3 = "='1' then '0' when ";
	public static final String updChar4 = "='0' then '1' end where id=#{formId} ";
//	public void updFormToChar(int formId, String condition);
	//注意事项：sql的搜索字段不能是传入的变量名  updFormToChar化为5种
//	（显示序号showNum，开启状态isOpen，置顶isTop，收藏isLike, isDelete）
	@Update(updChar1+"showNum"+updChar2+"showNum"+updChar3+"showNum"+updChar4)
	public void updFormToShowNum(int formId);
	@Update(updChar1+"isOpen"+updChar2+"isOpen"+updChar3+"isOpen"+updChar4)
	public void updFormToIsOpen(int formId);
	@Update(updChar1+"isTop"+updChar2+"isTop"+updChar3+"isTop"+updChar4)
	public void updFormToIsTop(int formId);
	@Update(updChar1+"isLike"+updChar2+"isLike"+updChar3+"isLike"+updChar4)
	public void updFormToIsLike(int formId);
	@Update(updChar1+"isDelete"+updChar2+"isDelete"+updChar3+"isDelete"+updChar4)
	public void updFormToIsDelete(int formId);
	
//	public String updFormToCondition(int formId, String condition, String conditionNum);
	//updFormToCondition化为3种（填写次数limitTime，表单名字name，表单图标（颜色，图标）icon）
	public static final String updHasNum1 = "update tquestion set ";
	public static final String updHasNum2 = "=#{conditionNum} where id=#{formId} ";
	//@Param("conditionNum")需要，注意返回类型（否则500错误，但报错不明显，只显示找不到conditionNum。。）
	//有时jrabel不及时，要重启服务器（像添加@Param("formId")不及时反映）
	@Update(updHasNum1+"limitTime"+updHasNum2)
	public void updFormToLimitTime(@Param("formId") int formId, @Param("conditionNum") String conditionNum);
	@Update(updHasNum1+"name"+updHasNum2)
	public void updFormToName(@Param("formId") int formId, @Param("conditionNum") String conditionNum);
	@Update(updHasNum1+"icon"+updHasNum2)
	public void updFormToIcon(@Param("formId")int formId, @Param("conditionNum") String conditionNum);
	
	@Delete("delete from tquestion "
			+"where id=#{formId}")
	public void delForm(int formId);
	
	@Delete("delete from tquestion "
			+"where tUser_id=#{userId} "
			+"and isDelete=1 ")
	public void delForms(int userId);
//	
	
}
