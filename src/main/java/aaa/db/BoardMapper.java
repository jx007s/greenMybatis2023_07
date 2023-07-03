package aaa.db;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper  //xml 방식
public interface BoardMapper {

	List<BoardDTO> list(BoardDTO erefr);
	
	List<BoardDTO> listPname(BoardDTO erefr);
	
	BoardDTO detail(BoardDTO bdedsde);
	
	void inserttt(BoardDTO efev45rtrg);
	
	void insertList(ArrayList<BoardDTO> arr);
	
	int deleteee(BoardDTO efev45rtrg);
	
	int modifyyy(BoardDTO refv);
	
}
