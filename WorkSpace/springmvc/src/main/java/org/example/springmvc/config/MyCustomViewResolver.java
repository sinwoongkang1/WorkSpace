package org.example.springmvc.config;

import org.example.springmvc.view.MyCustomView;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class MyCustomViewResolver implements ViewResolver, Ordered {
    private int order ;
    @Override
    public int getOrder() {
        return 0;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        if (viewName.equals("myView")) {
            return new MyCustomView();
        }
        return null; //else 면 다음 뷰 리졸버가 처리
    }
}
