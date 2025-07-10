package me.dio.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.controller.dto.CategoriaDto;
import me.dio.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/categorias")
@Tag(name = "Categorias Controller", description = "RESTful API para gerenciamento de categorias.")
public record CategoriaController(CategoriaService categoriaService) {

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll() {
        var categorias = categoriaService.findAll()
            .stream()
            .map(CategoriaDto::new)
            .collect(Collectors.toList());
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> findById(@PathVariable Long id) {
        var categoria = categoriaService.findById(id);
        return ResponseEntity.ok(new CategoriaDto(categoria));
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> create(@RequestBody CategoriaDto dto) {
        var categoria = categoriaService.create(dto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(location).body(new CategoriaDto(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> update(@PathVariable Long id, @RequestBody CategoriaDto dto) {
        var categoria = categoriaService.update(id, dto.toModel());
        return ResponseEntity.ok(new CategoriaDto(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
