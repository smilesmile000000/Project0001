package com.tomato.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tomato.member.model.service.MemberService;
import com.tomato.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	@Qualifier(value = "memberService")
	private MemberService memberService;
	
	@RequestMapping(value = "/login.do")
	public String memberLogin(HttpServletRequest request, @RequestParam String memberId,
			@RequestParam String memberPw) {
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		Member member = memberService.selectOneMember(m);
		
		if(member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			return "member/loginSuccess";
		} else {
			return "member/loginFailed";
		}
	}
	
	@RequestMapping(value = "/logout.do")
	public String memberLogour(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:/index.jsp";
	}
}
