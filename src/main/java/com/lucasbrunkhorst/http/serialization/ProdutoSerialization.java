package com.lucasbrunkhorst.http.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.lucasbrunkhorst.http.data.request.response.ProdutoResponseDTO;
import com.lucasbrunkhorst.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ProdutoSerialization extends JsonSerializer<Produto> {


    private ModelMapper modelMapper;

    public ProdutoSerialization(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void serialize(Produto produto, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        ProdutoResponseDTO produtoResponseDTO = modelMapper.map(produto, ProdutoResponseDTO.class);
        jsonGenerator.writeObject(produtoResponseDTO);

    }
}
