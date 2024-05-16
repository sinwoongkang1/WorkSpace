package org.example.iocexam;

import org.example.iocexam.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IocExamApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(IocExamApplication.class, args);
		//내가 생성한 공장엔 userconfig 를 넣어줬는디, 스프링이 세운 공장에는 공장 정보가 없으니,
		//Config파일에 Configuration 애노테이션을 붙여서 공장이라는 걸 알려줘야 한다.
		UserController	userController= context.getBean(UserController.class);
		userController.joinUser();
	}

}
