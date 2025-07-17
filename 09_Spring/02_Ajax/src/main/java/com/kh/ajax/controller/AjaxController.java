package com.kh.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.service.MemberService;
import com.kh.ajax.vo.Member;

@Controller
public class AjaxController {

    private final PageController pageController;

	private int count = 0;
	
	@Autowired
	private MemberService service;

    AjaxController(PageController pageController) {
        this.pageController = pageController;
    }
	
	@ResponseBody
	@GetMapping("/count")
	public int count() {
		System.out.println("ajax 요청!");
		return ++count;
	}
	
	@ResponseBody
	@GetMapping("/encoding")
	public String encoding(String nickname) {
		return nickname;
	}
	
	@ResponseBody
	@PostMapping("/check")
	public boolean check(String id) {
		//Member member = service.idCheck(id);
		//if(member!=null) return true;
		return service.idBoolCheck(id);
	}
	
	@ResponseBody
	@PostMapping("/signup")
	public void check(Member vo) {
		System.out.println(vo.getId());
		System.out.println(vo.getPwd());
		//Member member = service.idCheck(id);
		//if(member!=null) return true;
		//return service.idBoolCheck(id);
	}
}
