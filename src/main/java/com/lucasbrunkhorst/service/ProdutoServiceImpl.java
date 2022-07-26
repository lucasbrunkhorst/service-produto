package com.lucasbrunkhorst.service;


import com.lucasbrunkhorst.event.ProdutoPersistEvent;
import com.lucasbrunkhorst.model.Produto;
import com.lucasbrunkhorst.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    private ApplicationEventPublisher applicationEventPublisher;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.produtoRepository = produtoRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public Produto update( Produto produto) {
        if (!produtoRepository.existsById(produto.getId())) {
            throw new NoResultException(String.format("Produto de codigo %d nao encontrado", produto.getId()));
        }
        return produtoRepository.save(produto);
    }

    @Override
    public Produto save(Produto produto) {
        Produto produtoPersist = produtoRepository.save(produto);
        applicationEventPublisher.publishEvent(new ProdutoPersistEvent(this, produto));
        return produtoPersist;
    }

    @Override
    public Produto one(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new NoResultException(String.format("Produto de codigo %d nao encontrado", id)));
    }

    @Override
    public void delete(Long id){
        if(!produtoRepository.existsById(id)){
            throw new NoResultException(String.format("Produto de codigo %d nao encontrado", id));
        }
        produtoRepository.deleteById(id);
    }


}
