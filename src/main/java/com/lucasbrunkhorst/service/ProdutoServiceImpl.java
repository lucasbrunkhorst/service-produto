package com.lucasbrunkhorst.service;


import com.lucasbrunkhorst.model.Produto;
import com.lucasbrunkhorst.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto inserir(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto one(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new NoResultException(String.format("Produto de codigo %d nao encontrado", id)));
    }
}
