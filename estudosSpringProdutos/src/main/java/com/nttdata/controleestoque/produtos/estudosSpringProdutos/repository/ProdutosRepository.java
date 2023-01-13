package com.nttdata.controleestoque.produtos.estudosSpringProdutos.repository;

import com.nttdata.controleestoque.produtos.estudosSpringProdutos.models.ProdutosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosModel, String> {

    public boolean existsByDescricao(String descricao);


    @Query(value = "select pd from ProdutosModel pd where trim (pd.produto) like %?1%")
    List<ProdutosModel> buscarNomeProduto(String descricao);

}

