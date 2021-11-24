package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int rateDiscount = 10;

    @Override
    public int discount(Member member, int price) {
        int rtn = 0;
        if(Grade.VIP == member.getGrade()){
            rtn = (price * rateDiscount) / 100 ;
        }
        return rtn;
    }
}
