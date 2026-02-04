/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dataproviders.mysql.mapper;

import br.com.ifba.core.domain.Produto;
import br.com.ifba.infrastructure.dataproviders.mysql.entity.ProdutoEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author larissa
 */
@Component
public class ProdutoMapper {

    public Produto toDomain(ProdutoEntity entity) {
        if (entity == null) return null;
        return new Produto(
            entity.getId(),
            entity.getDescricao(),
            entity.getPreco(),
            entity.getQtdEstoque(),
            null
        );
    }

    public ProdutoEntity toEntity(Produto domain) {
        if (domain == null) return null;
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(domain.getId());
        entity.setDescricao(domain.getDescricao());
        entity.setPreco(domain.getPreco());
        entity.setQtdEstoque(domain.getQtdEstoque());
        return entity;
    }
}