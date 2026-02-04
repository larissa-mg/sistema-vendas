/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.controllers;

import br.com.ifba.core.domain.Produto;
import br.com.ifba.core.usecases.BaixaEstoqueUseCase;
import br.com.ifba.core.usecases.CadastrarProdutoUseCase;
import br.com.ifba.core.usecases.ExcluirProdutoUseCase;
import br.com.ifba.core.usecases.ProdutoGateway;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author larissa
 */
@Component
@RequiredArgsConstructor
public class ProdutoController {

    private final CadastrarProdutoUseCase cadastrarProdutoUseCase;
    private final BaixaEstoqueUseCase baixaEstoqueUseCase;
    private final ProdutoGateway produtoGateway;
    private final ExcluirProdutoUseCase excluirProdutoUseCase;

    public Produto salvar(Produto produto) {
        return cadastrarProdutoUseCase.execute(produto);
    }
    
    public void excluir(Long id) {
        try {
            excluirProdutoUseCase.execute(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir produto: " + e.getMessage());
        }
    }

    public List<Produto> listarTodos() {
        return produtoGateway.listarTodos();
    }
    
    public List<Produto> listarPorNome(String nome) {
        return produtoGateway.listarPorNome(nome);
    }
    
    public Produto buscarPorNome(String nome) {
        return produtoGateway.buscarPorNome(nome);
    }
    
    public void realizarBaixaEstoque(Long id, int quantidade) {
        try {
            baixaEstoqueUseCase.execute(id, quantidade);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao baixar estoque: " + e.getMessage());
        }
    }
}