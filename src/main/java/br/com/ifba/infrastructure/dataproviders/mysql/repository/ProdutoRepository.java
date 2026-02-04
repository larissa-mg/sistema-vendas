/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.infrastructure.dataproviders.mysql.repository;

import br.com.ifba.infrastructure.dataproviders.mysql.entity.ProdutoEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author larissa
 */
@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    
    List<ProdutoEntity> findByDescricaoContainingIgnoreCase(String descricao);
    Optional<ProdutoEntity> findByDescricaoIgnoreCase(String descricao);
}