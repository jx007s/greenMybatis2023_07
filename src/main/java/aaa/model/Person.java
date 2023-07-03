package aaa.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	String pname = "백승렬";
	boolean marriage = true;
	String gender="it인", email2="구글";
	
	String [] genders = {"남성","it인","여성"};
	
	String [] emails = {"네이버","다음","네이트","구글","줌"};
	
	String [] characters = {"피카추","라이추","파이리","꼬부기"};
	
	public Map<String, String> getHobby(){
		Map<String, String> res = new LinkedHashMap<>();
		res.put("coding","코딩하기");
		res.put("programming","프로그램만들기");
		res.put("debuging","디버깅");
		res.put("project","프로젝트");
		return res;
	}
	
	
	/// 선택할 캐릭터 가지고 있을 리스트
	public ArrayList<String> getChars(){
		ArrayList<String> res = new ArrayList<>();
		res.add("피카추");
		res.add("파이리");
		return res;
	} 
	
	
	
}
