package com.nttdata.controleestoque.produtos.estudosSpringProdutos.services;

import com.nttdata.controleestoque.produtos.estudosSpringProdutos.models.ProdutosModel;
import org.springframework.stereotype.Service;
import com.nttdata.controleestoque.produtos.estudosSpringProdutos.repository.ProdutosRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    final ProdutosRepository produtosRepository;

    public ProdutosService(ProdutosRepository produtosRepository){
        this.produtosRepository = produtosRepository;
    }

    @Transactional
    public ProdutosModel salvar(ProdutosModel produtosModel) {
        return produtosRepository.save(produtosModel);
    }

    public boolean existsByDescricao(String descricao) {
        return produtosRepository.existsByDescricao(descricao);
    }

    public List<ProdutosModel> findAll() {
        return produtosRepository.findAll();
    }

    public Optional<ProdutosModel> findById(String id) {
        return produtosRepository.findById(id);
    }

    @Transactional
    public void delete(ProdutosModel produtosModel) {
        produtosRepository.delete(produtosModel);
    }
    public List<ProdutosModel> findByNome(String produto){
        return produtosRepository.buscarNomeProduto(produto);
    }
}
