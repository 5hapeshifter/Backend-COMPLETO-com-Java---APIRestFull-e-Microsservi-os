package com.restfullapi.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.restfullapi.primeiroexemplo.model.Produto;
import com.restfullapi.primeiroexemplo.model.exception.ResourceNotFoundException;

import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {
    
    // Simulando um banco de dados
    private ArrayList<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;
    
    /**
     * Método para retornar uma lista de produtos
     * @return Lista de produtos
     */
    public List<Produto> obterTodos(){
        return produtos;
    }
    
    /**
     * Método que retorna o produto encontrado pelo seu ID
     * @param id do produto que será localizado
     * @return Retorna um produto caso seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id){ //Optional garante que não ocorrerá erro, pois se o produto não existir, retornará "null"
        return produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    /**
     * Método para adicionar produto na lista
     * @param produto que será adicionado
     * @return Retorna o produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }
    
    /**
     * Método para deletar o produto por id
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id); // o Método remove if verifica se o Id do produto bate com o que foi informado para fazer a deleção
    }

    /**
     * Método para atualizar o produto na lista
     * @param produto produto que será atualizado
     * @return Retorna o produto após atualizar a lista
     */
    public Produto atualizar(Produto produto){
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        if(produtoEncontrado.isEmpty()) {
            throw new ResourceNotFoundException("Produto não pode ser atualizado pois não existe");
        }
        deletar(produto.getId());
        produtos.add(produto);
        return produto;
    }
}
