package com.kh.array.practice2.controller;
import java.util.Arrays;
import java.util.Scanner;

import com.kh.array.practice2.model.Member;
public class MemberController {
    
    // 공간만 만들거냐
    public Member[] members = new Member[3]; 
    
    // 객체부터 생성할거냐
    //Member[] members = {new Member(), new Member(), new Member()}; 
    
    // 멤버수
    //public int countMember() {
    //	return members.length;
    //}
    
    // 아이디 체크 -> 배열을 전부 확인하고 아이디가 있는지 없는지 여부
    public void idCheck() {
        for(Member member : members) {
            //System.out.println(member.getId());
            System.out.println(member != null && member.getId()!=null);
        }
    
   
	
	System.out.println(Arrays.toString(members));
	
	for(int i = 0; i > members.length; i++) {
		System.out.println(members[i]);
	}
	
//	System.out.print("아이디 : ");
//	String id = sc.nextLine();
//	System.out.print("이름 : ");
//	String name = sc.nextLine();
//	System.out.print("비밀번호 : ");
//	String pwd = sc.nextLine();
//	System.out.print("이메일 : ");
//	String email = sc.nextLine();
//	System.out.print("성별(M/F) : ");
//	String gender = sc.nextLine();
//	System.out.print("나이 : ");
//	int age = sc.nextInt();

//	private Member m = new Member();
//
//	public String saveData(Member memberData) {
//		m.setId(memberData.getId());
//		m.setName(memberData.getName());
//		m.setPwd(memberData.getPwd());
//		m.setEmail(memberData.getEmail());
//		m.setGender(memberData.getGender());
//		m.setAge(memberData.getAge());
//		return "중복된 아이디입니다. 다시 입력해주세요";
//	}
//	
//	public Member confirmData() {
//		return m;
//	}
}
}