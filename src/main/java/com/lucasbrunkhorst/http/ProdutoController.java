package com.lucasbrunkhorst.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.lucasbrunkhorst.http.data.request.ProdutoPersistDTO;
import com.lucasbrunkhorst.http.data.request.response.ProdutoResponseDTO;
import com.lucasbrunkhorst.model.Produto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface ProdutoController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Produto inserir(@Valid @RequestBody ProdutoPersistDTO dto);

    @Operation(summary = "Retorna o produto correspondente ao identificador recuperado por parametro")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "404",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                "codigo": "X_100",
                                                "mensagem": "Produto de código %d não encontrado",
                                                "documentacao": null
                                            }
                                            """
                            )
                    )
            )
    })
    @GetMapping("{id}")
    Produto one(@PathVariable("id") Long id);

    @PatchMapping("{id}")
    Produto update(@PathVariable("id") Long id, @RequestBody JsonPatch patch) throws JsonPatchException, JsonProcessingException;
}

