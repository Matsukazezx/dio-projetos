package me.dio.controller.dto;
import me.dio.domain.model.Categoria;

public record CategoriaDto(
    Long id,
    String nome,
    String descricao
) {

    public CategoriaDto(Categoria model) {
        this(model.getId(), model.getNome(), model.getDescricao());
    }

    public Categoria toModel() {
        Categoria model = new Categoria();
        model.setId(this.id);
        model.setNome(this.nome);
        model.setDescricao(this.descricao);
        return model;
    }
}
