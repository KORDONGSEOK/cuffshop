package dev.cuffshop.service;

import dev.cuffshop.config.AppConfig;
import dev.cuffshop.domain.member.Grade;
import dev.cuffshop.domain.member.Member;
import dev.cuffshop.domain.order.Order;
import dev.cuffshop.service.member.MemberService;
import dev.cuffshop.service.order.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class OrderServiceTest {

//    MemberService memberService;
//    OrderService orderService;
//
//    @BeforeEach
//    public void beforeEach() {
//        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//        memberService = ac.getBean("memberService", MemberService.class);
//        orderService = ac.getBean("orderService", OrderService.class);
//    }
//
//    @Test
//    public void createOrder() {
//        Long memberId = 1L;
//        Member member = new Member(memberId, "memberA", Grade.VIP);
//        memberService.join(member);
//
//        Order order = orderService.createOrder(memberId, "itemA", 20000);
//        assertThat(order.getItemPrice()).isEqualTo(20000);
//    }

}