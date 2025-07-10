package me.dio.controller;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.controller.dto.ProdutoDto;
import me.dio.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/produtos")
@Tag(name = "Produtos Controller", description = "RESTful API para gerenciamento de produtos.")
public record ProdutoController(ProdutoService produtoService) {

    @GetMapping
    @Operation(summary = "Listar todos os produtos")
    public ResponseEntity<List<ProdutoDto>> findAll() {
        var produtos = produtoService.findAll()
            .stream()
            .map(ProdutoDto::new)
            .collect(Collectors.toList());
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar produto por ID")
    public ResponseEntity<ProdutoDto> findById(@PathVariable Long id) {
        var produto = produtoService.findById(id);
        return ResponseEntity.ok(new ProdutoDto(produto));
    }

    @PostMapping
    @Operation(summary = "Criar um novo produto")
    public ResponseEntity<ProdutoDto> create(@RequestBody ProdutoDto dto) {
        var produto = produtoService.create(dto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(location).body(new ProdutoDto(produto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um produto existente")
    public ResponseEntity<ProdutoDto> update(@PathVariable Long id, @RequestBody ProdutoDto dto) {
        var produto = produtoService.update(id, dto.toModel());
        return ResponseEntity.ok(new ProdutoDto(produto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um produto")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
