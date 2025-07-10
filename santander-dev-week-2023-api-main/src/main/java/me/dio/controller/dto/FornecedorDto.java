package me.dio.controller.dto;

import me.dio.domain.model.Fornecedor;

public record FornecedorDto(
    Long id,
    String nome,
    String cnpj,
    String telefone,
    String email
) {

    public FornecedorDto(Fornecedor model) {
        this(model.getId(), model.getNome(), model.getCnpj(), model.getTelefone(), model.getEmail());
    }

    public Fornecedor toModel() {
        Fornecedor model = new Fornecedor();
        model.setId(this.id);
        model.setNome(this.nome);
        model.setCnpj(this.cnpj);
        model.setTelefone(this.telefone);
        model.setEmail(this.email);
        return model;
    }
}

