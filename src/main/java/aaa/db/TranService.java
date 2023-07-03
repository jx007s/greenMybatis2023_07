package aaa.db;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;

@Service
public class TranService {
	@Resource
	TranMapper tm;
	
	
	///@RequestMapping 가 있는 클래스에 메소드를 같이 둘 경우
	// @Transactional 이 적용되지 않아 에러시  rollback  되지 않음
	// 서비스 클래스를 분리하여 DB 처리를 따로 해야 함
	@Transactional   //자동 commit, rollback 처리
	public void tranGO() {
		//try ~ catch 존재시 @Transactional 실행 안함
		tm.insert2(arrs(123,121,124));
	}
	
	ArrayList<BoardDTO> arrs(int ...arr){
		ArrayList<BoardDTO> res = new ArrayList<>();
		for (int i: arr) {
			res.add(new BoardDTO(i, "제목"+i, "유택"+i));
		}
		
		return res;
	}
}
