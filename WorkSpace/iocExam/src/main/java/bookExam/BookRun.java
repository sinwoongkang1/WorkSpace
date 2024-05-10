package bookExam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookRun {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
        Book java = (Book) context.getBean(Book.class);
        java.setTitle("모두의 Java");
        java.setPrice(20000);
        System.out.println(java);
    }
}
