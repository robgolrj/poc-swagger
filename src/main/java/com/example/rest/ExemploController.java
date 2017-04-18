package com.example.rest;

import com.example.Pessoa;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class ExemploController {

    @RequestMapping(method = RequestMethod.GET, path = "/exemplo", produces = "application/jason")
    @ApiOperation(value = "getExemplo", nickname = "getExemplo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nome", value = "Nome de alguem", required = false, dataType = "string", paramType = "query", defaultValue="Fulano")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Pessoa.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public String getExemplo(@RequestParam("nome") String nome) {
        return "nome" + " de Tal";
    }

    @RequestMapping(value = "/exemplo/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Exclui nome", notes = "Exclui um nome pelo ID")
    public String remove(@PathVariable Long id) {
        return "Fulano";
    }

    @RequestMapping(value = "/exemplo/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Busca Nome", notes = "Retorna um nome buscado")
    public String entry(@PathVariable Long id) {
        return "Fulano";
    }

    @RequestMapping(value = "/exemplo/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "Atualiza Nome", notes = "Atualiza um nome")
    public String update(@RequestBody String novoNome) {
        return "Fulano";
    }
}
