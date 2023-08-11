package dev.cuffshop.repository;

import dev.cuffshop.domain.member.Member;
import org.springframework.stereotype.Repository;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
