package dev.cuffshop.repository.member;

import dev.cuffshop.domain.member.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

    public Optional<Member> findByEmail(String email);

    public List<Member> findAll();
}
