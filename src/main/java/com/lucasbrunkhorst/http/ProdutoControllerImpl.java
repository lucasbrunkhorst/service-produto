package com.lucasbrunkhorst.http;

import com.lucasbrunkhorst.http.data.request.ProdutoPersistDTO;
import com.lucasbrunkhorst.http.data.request.response.ProdutoResponseDTO;
import com.lucasbrunkhorst.model.Produto;
import com.lucasbrunkhorst.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produto")
public class ProdutoControllerImpl {

    private final ProdutoService produtoService;

    private ModelMapper modelMapper;

    public ProdutoControllerImpl(ProdutoService produtoService, ModelMapper modelMapper) {
        this.produtoService = produtoService;
        this.modelMapper = modelMapper;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponseDTO inserir(@RequestBody ProdutoPersistDTO dto) {
        Produto produto = new Produto(dto.getDescricao(), dto.getValor());
        Produto produtoPersistido = produtoService.inserir(produto);
        return modelMapper.map(produtoPersistido, ProdutoResponseDTO.class);
    }

    @GetMapping("{id}")
    public ProdutoResponseDTO one(@PathVariable("id") Long id) {
        var produto = produtoService.one(id);
        return modelMapper.map(produto, ProdutoResponseDTO.class);
    }

}
