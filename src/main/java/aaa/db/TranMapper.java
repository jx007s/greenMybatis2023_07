package aaa.db;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TranMapper {

	@Select("select * from board")
	ArrayList<BoardDTO> list();
	
	
	//rollback 필요없음 : 에러시 모두 실행 X 
	@Insert({
		"<script>",
		"insert into board(id, title, pname, pw, reg_date) values",
		"<foreach collection='list' item='dd' separator=','>",
		"(#{dd.id},#{dd.title},#{dd.pname},'1111', sysdate() )",
		"</foreach>",
		"</script>"
	})
	int insert1(ArrayList<BoardDTO> arrs);
	
	
	//rollback 필요함 : 에러 발생 이전 내용은 저장됨 
	@Insert({
		"<script>",
		"<foreach collection='list' item='dd' separator=' ; '>",
		"	insert into board(id, title, pname, pw, reg_date) values ",
		"	(#{dd.id},#{dd.title},#{dd.pname},'1111', sysdate() )",
		"</foreach>",
		"</script>"
	})
	int insert2(ArrayList<BoardDTO> arrs);
}
