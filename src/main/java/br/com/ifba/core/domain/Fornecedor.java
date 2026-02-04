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
public class Fornecedor {
    private Long id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    
    @Override
    public String toString() {
        return this.nome;
    }
}