package sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.MyBean;
import sample.config.MyBeanConfig;

public class SpringExam01 {
    public static void main(String[] args) {
        //직접 개발자가 객체를 사용
        MyBean bean = new MyBean();
        bean.setName("kang");
        System.out.println(bean);

        //자바 설정 파일로 빈을 알려주고 스프링이 빈을 생성하게 하는 법
        //Bean을 생성하는 방법 -빈팩토리,어플리케잏션컨텍스트 클래스로
        //빈팩토리 -> aop 기술이 없어서 안쓴다. 간단한 기능만 가지고 있다.
        System.out.println("ApplicationContext 생성 전");
        ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class);
        //MyBeanConfig.class 이 설정이 있어서 config 파일에 @configuration 이없어도 된다. 공장을직접세움
        System.out.println("ApplicationContext 생성 후");
        //스프링이 관리하는 어플리케이션컨텍스트가 선언되는 순간 빈들이 생성(생성자가 나오자나)
            //MyBeanConfig.class 여기에 빈에 대한 설정이 들어있어
        MyBean bean1 = (MyBean) context.getBean("myBean"); //object로 들어와서  형변환 필요
        bean1.setName("jung");
        System.out.println(bean1);

//        MyBean bean2 = (MyBean) context.getBean(MyBean.class); 타입만 알려줘서 생성
        MyBean bean2 = (MyBean) context.getBean("myBean2",MyBean.class);//타입만 알려줘서 생성, 타입에 아이디를 알려주면
        //다른 인스턴스로 생성된다 "myBean2" 추가 (bean 이 두개 이상이자나 누군지 알려줘야지)


        bean2.setName("son");
        System.out.println(bean2); //싱글턴 패턴이라 같은 인스턴스 이다
        System.out.println(bean1); // jung 이 아니라 son


        MyBean bean3 = context.getBean("myBean",MyBean.class); //아이다가 같으면 같은 인스턴스이다.

        System.out.println(bean3);


    }

}
