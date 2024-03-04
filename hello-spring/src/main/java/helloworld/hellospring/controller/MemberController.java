package helloworld.hellospring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import helloworld.hellospring.domain.Member;
import helloworld.hellospring.dto.MemberDTO;
import helloworld.hellospring.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	private MemberDTO memberDTO;

	public MemberController(MemberService memberService) {  // 빈 주입
		this.memberService = memberService;
	}
	@GetMapping("/members")
	public List<MemberDTO> getAllMembers(){
		return memberService.getAllMembers();
	}

}
