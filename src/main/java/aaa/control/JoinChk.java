package aaa.control;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import aaa.model.Member;
import jakarta.validation.Valid;

@Service
public class JoinChk {

	public boolean hasErrors(Member mem, BindingResult bRes) {
		
		System.out.println("JoinChk hasErrors() 진입");
		
		//spring의 validation 에서 에러 자동 처리
		if(bRes.hasErrors()) {
			System.out.println("@Valid Member mem 에 의한 spring 에러 처리");
			return true;
		}
		
		if(!mem.getPw1().equals(mem.getPw2())) {
			System.out.println("암호 불일치");
			bRes.rejectValue("pw2", null, "암호가 일치하지 않습니다.");
			//               필드명 , 에러코드, 에러메세지
			return true;
		}
		
		
		return false; //에러가 없으면  false
	}
}
