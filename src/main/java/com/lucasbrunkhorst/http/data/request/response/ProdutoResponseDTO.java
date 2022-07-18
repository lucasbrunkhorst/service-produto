package com.lucasbrunkhorst.http.data.request.response;


public class ProdutoResponseDTO {

    private Long id;
    private String descricao;

    @Deprecated
    public ProdutoResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

}
