package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    //RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //MemberService memberService = new MemberServiceImpl();
    MemberService memberService =  new AppConfig().memberService();

    @Test
    void isVIP(){
        //given
        Member member = new Member(1l,"Is VIP", Grade.VIP);
        //when
        memberService.join(member);
        int rtn = discountPolicy.discount(member,30000);
        //then
        org.assertj.core.api.Assertions.assertThat(rtn).isEqualTo(3000);
    }

    @Test
    void isNotVIP(){

        //given
        Member member = new Member(2l,"Is Not VIP", Grade.BASIC);
        //when
        memberService.join(member);
        int rtn = discountPolicy.discount(member,10000);
        //then
        org.assertj.core.api.Assertions.assertThat(rtn).isEqualTo(0);

    }




}