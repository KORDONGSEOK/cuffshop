package dev.cuffshop.config;

import dev.cuffshop.domain.discount.DiscountPolicy;
import dev.cuffshop.domain.discount.RateDiscountPolicy;
import dev.cuffshop.repository.member.MemberRepository;
import dev.cuffshop.repository.member.MemoryMemberRepository;
import dev.cuffshop.service.member.MemberService;
import dev.cuffshop.service.member.MemberServiceIml;
import dev.cuffshop.service.order.OrderService;
import dev.cuffshop.service.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceIml(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
