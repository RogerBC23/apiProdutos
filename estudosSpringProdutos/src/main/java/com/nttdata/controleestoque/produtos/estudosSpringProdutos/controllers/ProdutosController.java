package com.nttdata.controleestoque.produtos.estudosSpringProdutos.controllers;

import com.nttdata.controleestoque.produtos.estudosSpringProdutos.dtos.MensagensDto;
import com.nttdata.controleestoque.produtos.estudosSpringProdutos.dtos.ProdutosDto;
import com.nttdata.controleestoque.produtos.estudosSpringProdutos.models.ProdutosModel;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nttdata.controleestoque.produtos.estudosSpringProdutos.services.ProdutosService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/produtos")
public class ProdutosController {

    final ProdutosService produtosService;

    public ProdutosController (ProdutosService produtosService){
        this.produtosService = produtosService;
    }

    @PostMapping
    public ResponseEntity<Object> salvaProduto(@RequestBody @Valid ProdutosDto produtosDto){
        if(produtosService.existsByDescricao(produtosDto.getDescricao())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Produto já cadastrado");
        }
        var produtosModel = new ProdutosModel();
        BeanUtils.copyProperties(produtosDto, produtosModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtosService.salvar(produtosModel));
    }

    @GetMapping
    public ResponseEntity<List<ProdutosModel>> getAllProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>getOneProduto(@PathVariable(value = "id")String id){
        Optional<ProdutosModel> produtosModelOptional = produtosService.findById(id);
        if(!produtosModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Código do produto não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtosModelOptional.get());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirProduto(@PathVariable(value = "id") String id){
        Optional<ProdutosModel> produtosModelOptional = produtosService.findById(id);
        if (!produtosModelOptional.isPresent()){
            //MensagensDto mensagem = new MensagensDto();
            //mensagem.setMensagem(mensagem);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Código do produto não encontrado");
        }
        produtosService.delete(produtosModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto excluído com sucesso !");
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> atualizarProdutos(@PathVariable(value = "id") String id,
                                                    @RequestBody @Valid ProdutosDto produtosDto){
       Optional <ProdutosModel> produtosModelOptional = produtosService.findById(id);
        if (!produtosModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        var produtosModel = produtosModelOptional.get();
        produtosModel.setDescricao(produtosDto.getDescricao());
        produtosModel.setPreco(produtosDto.getPreco());
        produtosModel.setQuantidade(produtosDto.getQuantidade());
        produtosModel.setProduto(produtosDto.getProduto());
        produtosModel.setModelo(produtosDto.getModelo());
        produtosModel.setMarca(produtosDto.getMarca());
        produtosModel.setDesconto(produtosDto.getDesconto());

        return ResponseEntity.status(HttpStatus.OK).body(produtosService.salvar(produtosModel));
    }

    @GetMapping(value = "buscarNomeProduto") // Mapeia a URL
    @ResponseBody
    public ResponseEntity<List<ProdutosModel>> buscarNomeProduto
            (@org.jetbrains.annotations.NotNull @RequestParam(name = "produto") String descricaoProduto){
        List<ProdutosModel> produto = produtosService.findByNome(descricaoProduto.trim()) ;
        return ResponseEntity.status(HttpStatus.OK).body(produtosService.findByNome(descricaoProduto.trim()));
    }

}

