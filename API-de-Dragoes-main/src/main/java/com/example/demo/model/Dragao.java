package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dragao {

    private Long id;
    private String nome;
    private String cor;
    private Integer poderDeFogo;
    private Double peso;
    private Double altura;
    private Boolean possuiMontador;
}