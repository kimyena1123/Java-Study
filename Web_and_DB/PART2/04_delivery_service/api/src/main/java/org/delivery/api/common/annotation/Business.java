package org.delivery.api.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//내가 만든 Business 커스텀 어노테이션은 @Service가 달려있기 때문에 Spring에서 자동적으로 이 어노테이션(Business)를 감지하고
//Business 어노테이션이 달린 클래스들도 Bean으로 등록이 될 거다. 다만 Business 어노테이션이 달린 애는 비즈니스 로직을 처리할거야 라는 나만의 룰을 만들기 위해서 만든거다.
@Service  //@Component라고 해도 상관없다.
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Business {

    @AliasFor(annotation = Service.class)
    String value() default "";
}
