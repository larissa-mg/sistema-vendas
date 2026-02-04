/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.core.usecases;

import br.com.ifba.core.domain.Produto;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author larissa
 */
@RequiredArgsConstructor
public class BaixaEstoqueUseCase {

    private final ProdutoGateway produtoGateway;

    public void execute(Long produtoId, Integer quantidadeVendida) {
        Produto produto = produtoGateway.buscarPorId(produtoId);
        
        if (produto == null) {
            throw new RuntimeException("Produto não encontrado!");
        }

        if (produto.getQtdEstoque() < quantidadeVendida) {
            throw new RuntimeException("Estoque insuficiente! Atual: " + produto.getQtdEstoque());
        }

        Integer novoEstoque = produto.getQtdEstoque() - quantidadeVendida;

        produtoGateway.atualizarEstoque(produtoId, novoEstoque);
    }
}