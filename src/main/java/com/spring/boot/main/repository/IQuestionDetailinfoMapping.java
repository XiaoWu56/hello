package com.spring.boot.main.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.spring.boot.main.po.QuestionDetailinfo;

public interface IQuestionDetailinfoMapping {
	public static final String selectD = "";
	
	@Insert("<script>"
			+"insert into tQuestionDetail "
			+"(tQuestion_id, name, type, model) "
			+"VALUES "
			+"<foreach collection=\"listQuestionDetailinfo\" item=\"detail\" index=\"index\" separator=\",\" > "
			+"(#{detail.tQuestion_id}, #{detail.name}, #{detail.type}, #{detail.model}) "
			+"</foreach> "
			+"</script>")
	public void addDetails(@Param("listQuestionDetailinfo") List<QuestionDetailinfo> listQuestionDetailinfo);
	
//	@Update("<script>"
//			+"update tQuestionDetail "
//			+"set "
//			+"<foreach collection=\"listQuestionDetailinfo\" item=\"detail\" index=\"index\" separator=\",\" > "
//			+"name=#{detail.name}, type=#{detail.type}, model=#{detail.model} "
//			+"where id=#{detail.id} "
//			+"</foreach> "
//			+"</script>")
//	是一个一个更新？上面错？
	public void updDetails(@Param("listQuestionDetailinfo") List<QuestionDetailinfo> listQuestionDetailinfo);
	
	@Select("select * from tquestionDetail where tQuestion_id=#{questionId}")
	public List<QuestionDetailinfo> selectDetails(int questionId);
	
	@Delete("delete from tquestiondetail where tQuestion_id=#{questionId}")
	public void delDetails(int questionId);
	
	@Delete("<script>"
			+"delete from tquestiondetail "
			+"where tQuestion_id in "
			+"<foreach collection='delIdList' item='formIdNum' index='index' open='(' close=')' separator=',' > "
			+"#{formIdNum}"
			+"</foreach> "
			+"</script>")
	public void delDetailsToForms(@Param("delIdList") String[] delIdList);
}
