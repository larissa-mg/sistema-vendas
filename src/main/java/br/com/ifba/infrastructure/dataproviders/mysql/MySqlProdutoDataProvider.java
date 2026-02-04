/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dataproviders.mysql;

import br.com.ifba.core.domain.Produto;
import br.com.ifba.core.usecases.ProdutoGateway;
import br.com.ifba.infrastructure.dataproviders.mysql.entity.ProdutoEntity;
import br.com.ifba.infrastructure.dataproviders.mysql.mapper.ProdutoMapper;
import br.com.ifba.infrastructure.dataproviders.mysql.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author larissa
 */
@Component
@RequiredArgsConstructor
public class MySqlProdutoDataProvider implements ProdutoGateway {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    @Override
    @Transactional
    public Produto salvar(Produto produto) {
        ProdutoEntity entity = mapper.toEntity(produto);
        ProdutoEntity salvo = repository.save(entity);
        return mapper.toDomain(salvo);
    }

    @Override
    @Transactional
    public Produto alterar(Produto produto) {
        return this.salvar(produto);
    }

    @Override
    @Transactional
    public void excluir(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Produto com ID " + id + " não encontrado para exclusão.");
        }
    }

    @Override
    public List<Produto> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Produto> listarPorNome(String nome) {
        String termoDeBusca = nome.replace("%", ""); 
        
        return repository.findByDescricaoContainingIgnoreCase(termoDeBusca)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Produto buscarPorNome(String nome) {
        return repository.findByDescricaoIgnoreCase(nome)
                .map(mapper::toDomain)
                .orElse(null);
    }

    @Override
    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .orElse(null);
    }

    @Override
    @Transactional
    public void atualizarEstoque(Long id, Integer novaQuantidade) {
        repository.findById(id).ifPresent(entity -> {
            entity.setQtdEstoque(novaQuantidade);
            repository.save(entity);
        });
    }
}