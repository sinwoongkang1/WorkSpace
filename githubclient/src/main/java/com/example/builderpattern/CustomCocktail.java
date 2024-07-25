package com.example.builderpattern;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
public class CustomCocktail {
    private String name;
    private String category;
    private List<String> customOptions;
}
