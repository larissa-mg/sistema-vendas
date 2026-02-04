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
public class CadastrarProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public Produto execute(Produto produto) {
        if (produto.getPreco() <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        
        return produtoGateway.salvar(produto);
    }
}