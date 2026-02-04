/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.core.usecases;

import br.com.ifba.core.domain.Fornecedor;
import java.util.List;

/**
 *
 * @author larissa
 */
public interface FornecedorGateway {
    List<Fornecedor> listarTodos();
    Fornecedor buscarPorNome(String nome);
}
