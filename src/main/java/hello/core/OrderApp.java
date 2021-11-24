package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        //MemberService memberService = new MemberServiceImpl();
        //OrderService orderService = new OrderServiceImpl();
//        AppConfig  appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);
        Long MemberId = 1l;
        Member member = new Member(MemberId,"member1",Grade.VIP);
        //memberService.join(member);
        memberService.join(member);

        //Order order = orderService.createOrder(MemberId,"itemName-a",10000);
        Order order = orderService.createOrder(MemberId,"itemName-a",10000);
        System.out.println("order -->" + order);
        System.out.println("cal" + order.calculatePrice());
        //memberService.findMember(1L);
    }
}
