/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.config;

import br.com.ifba.core.usecases.BaixaEstoqueUseCase;
import br.com.ifba.core.usecases.CadastrarProdutoUseCase;
import br.com.ifba.core.usecases.ExcluirProdutoUseCase;
import br.com.ifba.core.usecases.ProdutoGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author larissa
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public CadastrarProdutoUseCase cadastrarProdutoUseCase(ProdutoGateway produtoGateway) {
        return new CadastrarProdutoUseCase(produtoGateway);
    }

    @Bean
    public BaixaEstoqueUseCase baixaEstoqueUseCase(ProdutoGateway produtoGateway) {
        return new BaixaEstoqueUseCase(produtoGateway);
    }
    
    @Bean
    public ExcluirProdutoUseCase excluirProdutoUseCase(ProdutoGateway produtoGateway) {
        return new ExcluirProdutoUseCase(produtoGateway);
    }
}