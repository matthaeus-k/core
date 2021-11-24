package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService {


// 의존관계 주입으로 변경 final 생성자로 ....
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

//    @Autowired
//    private MemberRepository memberRepository;
//    @Autowired
//    private DiscountPolicy discountPolicy;

    private final  MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 생성자 단축키 command + n
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);
        Order order = new Order(memberId,itemName,itemPrice,discountPrice);
        return order;
    }
}
