package com.lucasbrunkhorst.repository;


import com.lucasbrunkhorst.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
