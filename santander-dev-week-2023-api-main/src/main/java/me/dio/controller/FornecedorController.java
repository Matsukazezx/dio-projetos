package me.dio.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.controller.dto.FornecedorDto;
import me.dio.service.FornecedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/fornecedores")
@Tag(name = "Fornecedores Controller", description = "RESTful API para gerenciamento de fornecedores.")
public record FornecedorController(FornecedorService fornecedorService) {

    @GetMapping
    public ResponseEntity<List<FornecedorDto>> findAll() {
        var fornecedores = fornecedorService.findAll()
            .stream()
            .map(FornecedorDto::new)
            .collect(Collectors.toList());
        return ResponseEntity.ok(fornecedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDto> findById(@PathVariable Long id) {
        var fornecedor = fornecedorService.findById(id);
        return ResponseEntity.ok(new FornecedorDto(fornecedor));
    }

    @PostMapping
    public ResponseEntity<FornecedorDto> create(@RequestBody FornecedorDto dto) {
        var fornecedor = fornecedorService.create(dto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(fornecedor.getId()).toUri();
        return ResponseEntity.created(location).body(new FornecedorDto(fornecedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorDto> update(@PathVariable Long id, @RequestBody FornecedorDto dto) {
        var fornecedor = fornecedorService.update(id, dto.toModel());
        return ResponseEntity.ok(new FornecedorDto(fornecedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fornecedorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
