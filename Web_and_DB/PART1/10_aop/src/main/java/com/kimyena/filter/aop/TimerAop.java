package com.kimyena.filter.aop;

import com.kimyena.filter.model.UserRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.List;

@Aspect //AOP를 사용하기 위한 내용을 정의하겠다는 어노테이션
@Component
public class TimerAop {

    @Pointcut(value = "within(com.kimyena.filter.controller.UserApiController)") //주의: Spring에서 관리되고 있는 Bean들에게만 Spring AOP가 동작하도록 되어 있다.
    public void timerPointCut(){}

    @Before(value = "timerPointCut()")
    public void before(JoinPoint joinPoint ){
        System.out.println("before");

    }

    @After(value = "timerPointCut()")
    public void after(JoinPoint joinPoint ){
        System.out.println("after");
    }

    @AfterReturning(value = "timerPointCut()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint , Object returnValue ){
        System.out.println("after returning");
    }

    @AfterThrowing(value = "timerPointCut()", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint , Throwable throwable ){
        System.out.println("after throwing");
    }


    @Around(value = "timerPointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("메소드 실행 이전");

        //해당 메서드가 실행될 때 들어가는 모든 매개변수를 불러오는 메소드이다.
        Arrays.stream(joinPoint.getArgs()).forEach(
               it -> {
                   System.out.println(it); //UserRequest(name=홍길동, phoneNumber=010-1111-1111, email=hone@gmail.com, age=10)

                   if(it instanceof UserRequest){
                       var tempUser = (UserRequest) it;
                       var phoneNumber = tempUser.getPhoneNumber().replace("-", "");  //전화번호 받을 때 -를 ""로 대체
                       tempUser.setPhoneNumber(phoneNumber);
                   }
               }
        );

        //보통 여기서 암/복호화를 하다든지, 로깅을 한다.
        var newObjs = List.of(
                new UserRequest()
        );
//        joinPoint.proceed(); //UserRequest(name=홍길동, phoneNumber=010-1111-1111, email=hone@gmail.com, age=10)

        var stopWatch = new StopWatch();
        stopWatch.start();

        joinPoint.proceed(newObjs.toArray()); //UserRequest(name=null, phoneNumber=null, email=null, age=null) 다 null로 바뀐다

        stopWatch.stop();

        System.out.println("총 소요된 시간(MS): " + stopWatch.getTotalTimeMillis());
        System.out.println("메소드 실행 이후");

    }
}
