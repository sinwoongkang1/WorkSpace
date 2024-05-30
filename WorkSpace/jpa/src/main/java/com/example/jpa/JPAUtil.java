package com.example.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    //생성자에 private ->나만 만들 수 있게 (싱글턴)
    private JPAUtil(){
    }
    private static final EntityManagerFactory emfInstance =
            Persistence.createEntityManagerFactory("UserPU");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emfInstance;
    }

    //어플리케이션이 종료될 때 자동으로 close() 메소드가 호출되도록 구현.
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(()-> {
            if (emfInstance != null) {
                System.out.println("Shutting down");
                emfInstance.close();
            }
        }));
    }
}
