/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.ifba.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author larissa
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Produto {
    private Long id;
    private String descricao;
    private double preco;
    private int qtdEstoque;
    private Fornecedor fornecedor; 
}