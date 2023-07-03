package aaa.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.db.AnnoMapper;
import aaa.db.BoardDTO;
import aaa.db.BoardMapper;
import jakarta.annotation.Resource;

@Controller
public class DBController {

	@Resource
	//BoardMapper bm;    //xml 방식
	AnnoMapper bm;		//annotation 방식
	
	@RequestMapping("/db/list")
	String dbListttt(Model mm, BoardDTO dto) {
		
		List<BoardDTO> mainData = bm.list(dto);
		System.out.println("list:"+dto.getSch()+", "+dto.getCnt());
		mm.addAttribute("mainData", mainData);
		return "db/list";
	}
	
	@RequestMapping("/db/listPname/{pno}")
	String dblistPname(Model mm, BoardDTO dto) {
		
		List<BoardDTO> mainData = bm.listPname(dto);
		mm.addAttribute("mainData", mainData);
		return "db/list";
	}
	
	
	@RequestMapping("/db/detail/{id}")
	String dbDetail(Model mm, BoardDTO dto) {
		
		mm.addAttribute("mainData", bm.detail(dto));
		return "db/detail";
	}
	
	@GetMapping("/db/insert")
	String dbInsertForm(BoardDTO dto) {
		return "db/insertForm";
	}
	
	@PostMapping("/db/insert")
	String  dbInsertComplete(Model mm, BoardDTO dto) {
		bm.inserttt(dto);
		mm.addAttribute("msg", "입력되었습니다.");
		mm.addAttribute("goUrl", "detail/"+dto.getId());
		System.out.println("InsertComplete:"+dto);
		return "db/alert";
	}
	
	
	
	@GetMapping("/db/insertList")
	String  dbInsertList(Model mm) {
		ArrayList<BoardDTO> arr = new ArrayList<>();
		arr.add(new BoardDTO("무슨제목31", "칠공1", "1111", "무슨 내용1"));
		arr.add(new BoardDTO("무슨제목32", "칠공2", "1111", "무슨 내용2"));
		arr.add(new BoardDTO("무슨제목33", "칠공3", "1111", "무슨 내용3"));
		
		
		bm.insertList(arr);
		mm.addAttribute("msg", "입력되었습니다.");
		mm.addAttribute("goUrl", "list");
		System.out.println("InsertList:");
		return "db/alert";
	}
	
	
	
	@GetMapping("/db/delete/{id}")
	String dbDeleteForm(BoardDTO dto) {
		return "db/deleteForm";
	}
	@PostMapping("/db/delete/{id}")
	String dbDeleteComplete(Model mm,BoardDTO dto) {
		int cnt = bm.deleteee(dto);
		String msg = "암호 에러";
		String goUrl = "/db/delete/"+dto.getId();
		if(cnt>0) {
			msg = "삭제되었습니다.";
			goUrl = "/db/list";
		}
		System.out.println("삭제갯수:"+cnt);
		mm.addAttribute("msg", msg);
		mm.addAttribute("goUrl", goUrl);
		return "db/alert";
	}
	
	@GetMapping("/db/modify/{id}")
	String dbModifyForm(Model mm, BoardDTO dto) {
		
		mm.addAttribute("mainData", bm.detail(dto));
		return "db/modifyForm";
	}
	@PostMapping("/db/modify/{id}")
	String dbModifyComplete(Model mm,BoardDTO dto) {
		int cnt = bm.modifyyy(dto);
		String msg = "암호 에러";
		String goUrl = "/db/modify/"+dto.getId();
		if(cnt>0) {
			msg = "수정되었습니다.";
			goUrl = "/db/detail/"+dto.getId();
		}
		System.out.println("수정갯수:"+cnt);
		mm.addAttribute("msg", msg);
		mm.addAttribute("goUrl", goUrl);
		return "db/alert";
	}
}
