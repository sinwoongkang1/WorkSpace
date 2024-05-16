package org.example.annotation;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.*;

@Retention(RUNTIME) //에노테이션이 언제 동작하게 할까? >> runtime 시에 하자~
public @interface Count100 {
}
