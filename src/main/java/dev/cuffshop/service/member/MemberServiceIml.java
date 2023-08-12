package dev.cuffshop.service.member;

import dev.cuffshop.domain.member.Member;
import dev.cuffshop.repository.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceIml implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceIml(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
