package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

//    @Test
//    @DisplayName("스프링 없는 순수한 DI 컨테이너")
//    void pureContainer() {
//        AppConfig appConfig = new AppConfig();
//
//        MemberService memberService1 = appConfig.memberService();
//
//        MemberService memberService2 = appConfig.memberService();
//
//        Assertions.assertSame(memberService1, memberService2);
//    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonServiceTest singletonServiceTest = SingletonServiceTest.getInstance();
        SingletonServiceTest singletonServiceTest2 = SingletonServiceTest.getInstance();

        System.out.println("service : "+singletonServiceTest);

        Assertions.assertSame(singletonServiceTest,singletonServiceTest2 );
    }

    @Test
    @DisplayName(" 스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        Assertions.assertSame(memberService1, memberService2);
    }
}
