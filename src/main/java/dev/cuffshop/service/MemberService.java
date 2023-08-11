package dev.cuffshop.service;

import dev.cuffshop.domain.member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
