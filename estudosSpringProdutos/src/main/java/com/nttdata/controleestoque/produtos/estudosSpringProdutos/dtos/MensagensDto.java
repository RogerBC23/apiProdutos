package com.nttdata.controleestoque.produtos.estudosSpringProdutos.dtos;

import lombok.Data;

@Data
public class MensagensDto {


    public String setMensagem() {
        String mensagem = "Produto não cadastrado";
        return mensagem;
    }
}
