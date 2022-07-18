package com.lucasbrunkhorst.data.request;

import java.math.BigDecimal;

public class ProdutoPersistDTO {

    private String descricao;

    private BigDecimal valor;

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
