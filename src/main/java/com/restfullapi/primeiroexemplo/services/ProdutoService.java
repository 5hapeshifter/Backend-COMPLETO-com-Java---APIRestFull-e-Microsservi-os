package com.restfullapi.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;

import com.restfullapi.primeiroexemplo.model.Produto;
import com.restfullapi.primeiroexemplo.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    /**
     * Método para retornar uma lista de produtos
     * @return Lista de produtos
     */
    public List<Produto> obterTodos() {
        return produtoRepository.obterTodos();
    }

    /**
     * Método que retorna o produto encontrado pelo seu ID
     * @param id do produto que será localizado
     * @return Retorna um produto caso seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtoRepository.obterPorId(id);
    }

    /**
     * Método para adicionar produto na lista
     * @param produto que será adicionado
     * @return Retorna o produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto){
        // Poderíamos inserir uma regra de negócio aqui para validar o produto
        return produtoRepository.adicionar(produto);
    }
    
    /**
     * Método para deletar o produto por id
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id){
        // Poderíamos inserir uma regra de negócio aqui para validar
        produtoRepository.deletar(id);
    }

    /**
     * Método para atualizar o produto na lista
     * @param produto produto que será atualizado
     * @param id id do produto;
     * @return Retorna o produto após atualizar a lista
     */
    public Produto atualizar(Integer id, Produto produto){
        // Poderia ter uma validação do ID
        produto.setId(id);
        return produtoRepository.atualizar(produto);
    }
}
