package org.example.springjdbc05;

import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class User {
    private Long id;
    private String name;
    private String email;

}
