package com.nttdata.controleestoque.produtos.estudosSpringProdutos.dtos;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class ProdutosDto {

    @NotBlank
    private String produto;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String desconto;

    private double preco;

    private int quantidade;

}
