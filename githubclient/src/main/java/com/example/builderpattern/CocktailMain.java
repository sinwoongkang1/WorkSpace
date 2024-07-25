package com.example.builderpattern;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.Arrays;

public class CocktailMain {
    public static void main(String[] args) {
        CustomCocktail myMohito = CustomCocktail.builder()
                .name("내 모히또")
                .category("고량주 믹스")
                .customOptions(Arrays.asList("화요","라임","새우"))
                .build();


        System.out.println(myMohito.getName());
        System.out.println(myMohito.getCategory());
        System.out.println(myMohito.getCustomOptions());
    }

}
