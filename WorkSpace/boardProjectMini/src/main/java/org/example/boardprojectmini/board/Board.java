package org.example.boardprojectmini.board;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Board {
    @Id
    private Long id;
    private String name;
    private String title;
    private String password;
    private String content;
    private LocalDate created_at;
    private LocalDate updated_at;
}
