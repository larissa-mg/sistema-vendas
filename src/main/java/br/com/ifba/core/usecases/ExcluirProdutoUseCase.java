/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.core.usecases;

import lombok.RequiredArgsConstructor;

/**
 *
 * @author larissa
 */
@RequiredArgsConstructor
public class ExcluirProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public void execute(Long id) {
        produtoGateway.excluir(id);
    }
}