package aaa.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aaa.model.HandPhone;
import aaa.model.Member;
import aaa.model.Person;
import aaa.model.Shape;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	@RequestMapping("/")
	String home(Model mm) {
		System.out.println("home 실행");
		mm.addAttribute("now", new Date());
		mm.addAttribute("phone", new HandPhone());
		return "index";
	}
	
	@RequestMapping("/basic/var")
	String vaR(Model mm) {
		System.out.println("VAR 실행");
		mm.addAttribute("aa", 1234);
		mm.addAttribute("phone", new HandPhone());
		mm.addAttribute("arr", new String[] {"장동건","장서건","장남건","장북건"});
		
		ArrayList<Shape> shapes = new ArrayList<>();
		shapes.add(new Shape("직사각형", 10, 4));
		shapes.add(new Shape("직각삼각형", 20, 15));
		shapes.add(new Shape("원", 25, 21));
		shapes.add(new Shape("직사각형", 19, 11));
		
		Map<String, HandPhone> maps = new HashMap<>();
		maps.put("gall",new  HandPhone("은하수",00));
		maps.put("iphone",new  HandPhone("아이폰",00));
		maps.put("aphone",new  HandPhone("어른폰",00));
		maps.put("barrey",new  HandPhone("딸기폰",00));
		
		mm.addAttribute("shapes", shapes);
		mm.addAttribute("maps", maps);
		return "basic/var";
	}
	
	
	@RequestMapping("/basic/scope")
	String scope(Model mm, HttpSession session) {
		System.out.println("/basic/scope 실행");
		mm.addAttribute("aaa", 456);
		mm.addAttribute("ph1", new HandPhone("req_Ph1",100));
		session.setAttribute("ph1", new HandPhone("se_Ph1",10));
		session.setAttribute("ph2", new HandPhone("se_Ph2",20));
		return "basic/scope";
	}
	
	@RequestMapping("/basic/calc")
	String calc(Model mm) {
		System.out.println("/basic/calc 실행");
		mm.addAttribute("aaa", 456);
		mm.addAttribute("ph", new HandPhone("은하수",77));
		
		return "basic/calc";
	}
	
	@RequestMapping("/basic/exam")
	String exam(Model mm) {
		mm.addAttribute("name", "장우성");
		mm.addAttribute("kor", 81 );
		mm.addAttribute("eng", 76);
		mm.addAttribute("mat", 65);
		
		return "basic/exam";
	}
	
	@RequestMapping("/basic/control")
	String control(Model mm) {
		System.out.println("/basic/control 실행");
		mm.addAttribute("arr", new int[] {11,33,55,22,44,66});
		Map<String, HandPhone> maps = new HashMap<>();
		maps.put("gall",new  HandPhone("은하수",200));
		maps.put("iphone",new  HandPhone("아이폰",100));
		maps.put("aphone",new  HandPhone("어른폰",150));
		maps.put("barrey",new  HandPhone("딸기폰",130));
		mm.addAttribute("maps",maps);
		
		return "basic/control";
	}
	
	@RequestMapping("/basic/link")
	String link(Model mm) {
		System.out.println("/basic/link 실행");
		mm.addAttribute("cate1", "qwer");
		mm.addAttribute("cate2", "list");
		mm.addAttribute("pp1", "iphone");
		mm.addAttribute("pp2", 23);
		
		return "basic/link";
	}
	
	@GetMapping("/basic/join")
	String joinForm(Member mem) { 
		//Member mem 가 있어야 joinForm을  get으로 열었을때 멤버요소에 접근가능하여 에러가 나지 않는다
		// 반대로 Member mem 가 없다면 에러발생
		//@Valid Member mem  매개변수에 @Valid 를 넣으면 유효성 검사하여 에러메세지를 출력하려는 에러가 발생된다. 
		System.out.println("/basic/joinForm 실행");
		
		return "basic/joinForm";
	}
	
	
	@Resource
	JoinChk joinChk;
	
	@PostMapping("/basic/joinGo")
	//@Valid --> spring 에서 이 객체(Member)에 대한 멤버변수의 에러 점검
	String joinComplete(@Valid Member mem, BindingResult bRes) {
		System.out.println("/basic/joinComplete 실행");
		
		//에러가 있다면 form 페이지로  view 변경
		if(joinChk.hasErrors(mem, bRes)) {
			return "basic/joinForm";//view 페이지 진입임(url  변경이 아님)
		}
		
		return "basic/joinComplete";
	}
	
	
	@RequestMapping("/basic/formform")
	String formForm(Person person) {
		System.out.println("/basic/formform 실행");
		
		return "basic/formform";
	}
	
	@RequestMapping("/basic/layout")
	String layout(Model mm) {
		System.out.println("/basic/layout 실행");
		
		return "basic/lalala";
	}
	
}
