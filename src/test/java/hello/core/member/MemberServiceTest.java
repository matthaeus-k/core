package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    //MemberService memberService = new MemberServiceImpl();
    MemberService memberService;


    @BeforeEach
    public void beforeEach(){
        AppConfig config = new AppConfig();
        memberService = config.memberService();
    }

    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberVIP",Grade.VIP);
        //when
        memberService.join(member);
        Member rtn = memberService.findMember(1L);
        //then
        System.out.println("테스트 --> " + member.getId());
        System.out.println(rtn.getName());
        Assertions.assertThat(member.getId()).isEqualTo(rtn.getId());

    }


}
