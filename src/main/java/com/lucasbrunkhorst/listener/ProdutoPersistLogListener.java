package com.lucasbrunkhorst.listener;

import com.lucasbrunkhorst.event.ProdutoPersistEvent;
import com.lucasbrunkhorst.model.Produto;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ProdutoPersistLogListener implements ApplicationListener<ProdutoPersistEvent> {

    @Override
    public void onApplicationEvent(ProdutoPersistEvent event) {
        Produto produto = event.getProduto();
        System.out.println(produto.getDescricao());
    }
}
