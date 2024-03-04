package helloworld.hellospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import helloworld.hellospring.domain.Member;
import helloworld.hellospring.dto.MemberDTO;
import helloworld.hellospring.repository.MemberRepository;

@Service
public class MemberService {
	private final MemberRepository memberRepository;
	public MemberService(MemberRepository memberRepository) {   // 빈 주입
		this.memberRepository = memberRepository;
	}
	public List<MemberDTO> getAllMembers(){
		List<Member> memberList = memberRepository.findAll();
		List<MemberDTO> memberDTOList = memberList.stream().map(member -> new MemberDTO(member.getId(),member.getName())).toList();
		return memberDTOList;
	}
}
