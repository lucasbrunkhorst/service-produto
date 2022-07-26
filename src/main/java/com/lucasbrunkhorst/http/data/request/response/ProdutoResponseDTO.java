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

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
