package dev.cuffshop.repository.member;

import dev.cuffshop.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;

@Slf4j
@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public void save(Member member) {
        member.setId(++sequence);

        log.info("save: member.getId={}", member.getId());
        log.info("save: member.getEmail={}", member.getEmail());
        log.info("save: member.getPassword={}", member.getPassword());
        log.info("save: member.getPassword={}", member.getYear());
        log.info("save: member.getPassword={}", member.getMonthCode());
        log.info("save: member.getPassword={}", member.getDayCode());
        log.info("save: member.getPassword={}", member.getPhoneNumber());
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

    public Optional<Member> findByEmail(String email) {
        return findAll().stream()
                .filter(m -> m.getEmail().equals(email))
                .findFirst();
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
