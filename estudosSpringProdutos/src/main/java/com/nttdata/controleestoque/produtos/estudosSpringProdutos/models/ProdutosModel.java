package com.nttdata.controleestoque.produtos.estudosSpringProdutos.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "produtos")
@Data
public class ProdutosModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name="UUIDGenerator", strategy ="uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name="id", updatable = false, nullable = false, length = 36)
    // @org.hibernate.annotations.Type(type="org.hibernate.type.UUIDBinaryType")
    private String id;

    @Column(nullable = false, length = 30)
    private String produto;

    @Column(nullable = false, length = 30)
    private String marca;

    @Column(nullable = false, unique = true, length = 40)
    private String modelo;

    @Column(nullable = false,  length = 60)
    private String descricao;

    @Column(nullable = false, length = 5)
    private String desconto;

    @Column(nullable = false, unique = false,length = 11)
    private double preco;

    @Column(nullable = false, unique = false, length = 11)
    private int quantidade;
}
