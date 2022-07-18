package com.lucasbrunkhorst.service;

import com.lucasbrunkhorst.model.Produto;

public interface ProdutoService {

    Produto inserir(Produto produto);

    Produto one(Long id);
}
