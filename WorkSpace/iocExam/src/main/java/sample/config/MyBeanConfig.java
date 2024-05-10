package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sample.MyBean;

@ComponentScan
public class MyBeanConfig {
    //<bean id = "myBean" class="sample.MyBean"/>의 xml 파일을 자바 코드화 한 것
//    @Bean
//    public MyBean myBean(){
//        return new MyBean();
//    }
    @Bean
    public MyBean myBean2(){
        return new MyBean();
    }
    @Bean
    @Scope("prototype")
    public MyBean myBean3(){
        return new MyBean();
    }

    //공장 생성시 일단 빈 생성은 안된다.(미리 생성 안한다)
    //객체 생성시 빈이 생성된다 getBean 할때 생성됨. 여러개 생성하면 다른 인스턴스이다. 프로토 타입이기 때문

}
