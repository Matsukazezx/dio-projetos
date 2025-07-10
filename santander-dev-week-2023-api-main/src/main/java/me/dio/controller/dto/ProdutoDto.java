package me.dio.controller.dto;

import java.math.BigDecimal;
import me.dio.domain.model.Produto;
import static java.util.Optional.ofNullable;

public record ProdutoDto(
    Long id,
    String nome,
    String descricao,
    BigDecimal preco,
    CategoriaDto categoria,
    FornecedorDto fornecedor
) {

    public ProdutoDto(Produto model) {
        this(
            model.getId(),
            model.getNome(),
            model.getDescricao(),
            model.getPreco(),
            ofNullable(model.getCategoria()).map(CategoriaDto::new).orElse(null),
            ofNullable(model.getFornecedor()).map(FornecedorDto::new).orElse(null)
        );
    }

    public Produto toModel() {
        Produto model = new Produto();
        model.setId(this.id);
        model.setNome(this.nome);
        model.setDescricao(this.descricao);
        model.setPreco(this.preco);
        model.setCategoria(ofNullable(this.categoria).map(CategoriaDto::toModel).orElse(null));
        model.setFornecedor(ofNullable(this.fornecedor).map(FornecedorDto::toModel).orElse(null));
        return model;
    }
}

