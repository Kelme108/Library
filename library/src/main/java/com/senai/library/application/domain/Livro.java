package com.senai.library.application.domain;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    private Long id;
    private String fotoCapa;
    private String nome;
    private String autor;
    private Integer ano;
    private Integer exemplares;
}

