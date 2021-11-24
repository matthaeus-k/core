package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

//    MemberService memberService = new MemberServiceImpl();
//    OrderService orderService = new OrderServiceImpl();

    MemberService memberService ;
    OrderService orderService ;

    @BeforeEach
    public void beforeEach(){
        memberService =  new AppConfig().memberService();
        orderService = new AppConfig().orderService();
    }

    @Test
    void createOrder(){

        // given
        Long memberID = 1L ; // Wrapper null 허용 , long null 허용 X
        Member member = new Member(memberID,"memberName",Grade.VIP);
        // when
        memberService.join(member);
        Member rtn = memberService.findMember(memberID);
        Order order = orderService.createOrder(memberID,"itemName",30000);

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
