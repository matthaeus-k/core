package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

        //MemberService memberService = new MemberServiceImpl();
        //MemberService memberService = new MemberServiceImpl();
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = new AppConfig().memberService();

        Member member = new Member(1L,"asdf", Grade.VIP);
        memberService.join(member);
        //appConfig.memberService().join(member);
        //souf
        System.out.println("new member = " + member.getName());

        Member rtn = memberService.findMember(1L) ; //memberService.findMember(1L);

        System.out.println("find Member = " + rtn.getName());

    }
}
