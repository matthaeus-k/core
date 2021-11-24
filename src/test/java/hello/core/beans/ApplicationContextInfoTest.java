package hello.core.beans;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName: beanDefinitionNames){
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("bean : " + bean);
            System.out.println("name : " + beanDefinitionName);
        }
    }
    @Test
    void findAppBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName: beanDefinitionNames){
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            Object bean = ac.getBean(beanDefinitionName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE ) {
                System.out.println("bean : " + bean);
                System.out.println("name : " + beanDefinitionName);
            }
        }
    }



    @Test
    @DisplayName("빈 이름 조회 throew")
    void findBeanNameThrows(){
        String str = assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("asdf", MemberService.class)).getMessage();

        System.out.println("str--->" + str);

    }

    @Test
    @DisplayName("빈 type find")
    void findBeanType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
        @DisplayName("빈 name find")
        void findBeanName() {
            MemberService memberService = ac.getBean("memberService",MemberService.class);
            assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

        }



}
