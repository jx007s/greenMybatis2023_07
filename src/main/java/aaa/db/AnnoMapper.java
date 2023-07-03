package aaa.db;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

@Mapper  ///Annotation 방식
public interface AnnoMapper {

	@Select({
		"<script>",   //반드시 해야 한다.
		"select * from board",
		"<where>",
			"<trim prefix='  ' suffixOverrides ='and | or'>",
				"<if test='sch != null'>",
					"title like concat('%',#{sch},'%') and ", 
				"</if>",
				"<if test='cnt != null'>",
				"	cnt >= #{cnt}",
				"</if>",
			"</trim>",
       "</where>",
   "</script>" 		   //반드시 해야 한다.	
   })
	List<BoardDTO> list(BoardDTO erefr);
	
	
	@Select({
		"<script>",   //반드시 해야 한다.
		"select * from board",
		"<where>",
			"<choose>",
			"	<when test='pno == 1'>",
			"		pname = '일공성진'",
			"	</when>",
			"	<when test='pno == 2'>",
			"		pname = '이공성진'",
			"	</when>",
			"	<when test='pno == 3'>",
			"		pname = '삼공성진'",
			"	</when>",
			"	<otherwise>",
			"		pname = '사공성진'",
			"	</otherwise>",
			"</choose>",
		"</where>	",
		"</script>"   //반드시 해야 한다.
	})
	List<BoardDTO> listPname(BoardDTO erefr);
	
	@Select(value = "select * from board where id = #{id}")
	BoardDTO detail(BoardDTO bdedsde);
	
	
	@SelectKey( keyProperty="id", resultType=Integer.class, before = true ,statement = "select max(id)+1 from board")
	@Insert({
		"insert into board (id, title, pname, pw, content, upfile, reg_date, level, seq, cnt, gid)",
		"values",
		"(#{id}, #{title}, #{pname}, #{pw}, #{content}, #{upfile}, sysdate(), 0,0,0, #{id})"
	})
	void inserttt(BoardDTO efev45rtrg);
	
	
	
	@Select("(select max(id)+1 from board bb)")
	int maxId();
	
	
/*
 *  <sql> 이나 <include> 는 script 내에서 작동불가
	"<sql id=\"maxid\">",
 			"(select max(id)+1 from board bb)",
 	"</sql>",
     <include refid="maxid"/> 는 사용 불가
*/
	@Insert({
		"<script>",   //반드시 해야 한다.
		"insert into board (id, title, pname, pw, content, upfile, reg_date, level, seq, cnt, gid)",
		"values",
		"<foreach collection='list' item='dd' separator=',' index='i'>",
		"((select max(id)+1 from board bb)+#{i}, #{dd.title}, #{dd.pname}, #{dd.pw},", 
		"#{dd.content}, #{dd.upfile}, sysdate(), 0,0,0, (select max(id)+1 from board bb)+#{i} )",
		"</foreach>",
		"</script>"   //반드시 해야 한다.
	})
	void insertList(ArrayList<BoardDTO> arr);
	
	
	@Delete("delete from board where id = #{id} and pw = #{pw}")
	int deleteee(BoardDTO efev45rtrg);
	
	@Update({"update board set title = #{title}, pname =  #{pname}, content = #{content}",
			"		where id = #{id} and pw = #{pw}"})
	int modifyyy(BoardDTO refv);
	
}
