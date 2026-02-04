/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.core.usecases;

import br.com.ifba.core.domain.Produto;
import java.util.List;

/**
 *
 * @author larissa
 */
public interface ProdutoGateway {
    Produto salvar(Produto produto);
    Produto alterar(Produto produto);
    void excluir(Long id);
    List<Produto> listarTodos();
    List<Produto> listarPorNome(String nome);
    Produto buscarPorNome(String nome);
    Produto buscarPorId(Long id);
    void atualizarEstoque(Long id, Integer novaQuantidade);
}