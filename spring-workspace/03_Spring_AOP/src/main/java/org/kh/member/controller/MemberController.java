package org.kh.member.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.board.model.vo.Board;
import org.kh.member.model.service.MemberService;
import org.kh.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import net.sf.json.JSONObject;

@Controller
public class MemberController {
	@Autowired
	@Qualifier(value = "memberService")
	private MemberService memberService;

	@RequestMapping(value = "/login.do")
	public String memberLogin(HttpServletRequest request, @RequestParam String memberId,
			@RequestParam String memberPw) {

		System.out.println("로그인 처리 로직");
		System.out.println(memberId);
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		Member member = memberService.selectOneMember(m);

		if (member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			return "member/loginSuccess";
		} else {
			return "member/loginFailed";
		}

	}

	@RequestMapping(value = "/logout.do")
	public String memberLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:/index.jsp";
	}

	@RequestMapping(value = "/mypage.do")
	public String memberMypage(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		Model model = new ExtendedModelMap();
		// model 객체는 Controller에서 View로 데이터전송시 사용하는 일회용 객체
		model.addAttribute("member", member);
		return "member/mypage";
	}

	@RequestMapping(value = "/update.do")
	public String memberUpdate(HttpSession session, Member m) {
		int result = memberService.updateMember(m);
		if (result > 0) {
			session.setAttribute("member", m);
			return "member/updateSuccess";
		} else {
			return "member/updateFailed";
		}
	}

	@RequestMapping(value = "/enrollPage.do")
	public String enrollPage() {
		return "member/enrollPage";
	}

	@RequestMapping(value = "/enroll.do")
	public String enroll(Member m) {
		int result = memberService.insertMember(m);
		if (result > 0) {
			return "member/insertSuccess";
		} else {
			return "member/insertFailed";
		}
	}

	@RequestMapping(value = "/deleteMember.do")
	public String deleteMember(HttpSession session) {
		int memberNo = ((Member) session.getAttribute("member")).getMemberNo();
		int result = memberService.deleteMember(memberNo);
		if (result > 0) {
			return "member/deleteSuccess";
		} else {
			return "member/deleteFailed";
		}
	}

	@RequestMapping(value = "/allMemberList.do")
	public ModelAndView allMemberList() {
		ArrayList<Member> list = memberService.selectAllMember();
		ModelAndView mav = new ModelAndView();
		if (list != null & !list.isEmpty()) {
			mav.addObject("list", list);
			mav.setViewName("member/allMemberList");
		} else {
			mav.setViewName("member/error");
		}
		return mav;
	}
	
	@RequestMapping(value="/test.do")
	public void test() {
		memberService.test();
	}

	@ResponseBody
	@RequestMapping(value="/checkId.do")
	public String checkId(@RequestParam String id) {
		Member m = memberService.checkId(id);
		JSONObject obj = new JSONObject();
		if(m == null) {
			obj.put("result", "1");
		} else {
			obj.put("result", "0");
		}
		return new Gson().toJson(obj);
	}

	@RequestMapping(value="/uploadTest.do")
	public String uploadTest(HttpServletRequest request, @RequestParam MultipartFile fileTest, @RequestParam String test) {
		String savePath = request.getSession().getServletContext().getRealPath("/resources/upload/");
		String originalFileName = fileTest.getOriginalFilename();
		System.out.println(originalFileName);
		String fullPath = savePath + originalFileName;
		if(!fileTest.isEmpty()) {
			try {
				byte[] bytes = fileTest.getBytes();
				File file = new File(fullPath);
				FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				bos.write(bytes);
				bos.close();
				System.out.println("파일업로드 성공");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("파일없음");
		}
		System.out.println("testString : " + test);
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(value="/insertBoard.do")
	public String boardInsert(Board b, @RequestParam MultipartFile file) {
		System.out.println(b.getBoardTitle());
		b.setFilename(file.getOriginalFilename());
		System.out.println(file.getOriginalFilename());
		return "redirect:/index.jsp";
	}
}
