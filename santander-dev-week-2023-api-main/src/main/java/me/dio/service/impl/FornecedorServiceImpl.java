package me.dio.service.impl;

import me.dio.domain.model.Fornecedor;
import me.dio.domain.repository.FornecedorRepository;
import me.dio.service.FornecedorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorServiceImpl(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Transactional(readOnly = true)
    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Fornecedor findById(Long id) {
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado."));
    }

    @Transactional
    public Fornecedor create(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    @Transactional
    public Fornecedor update(Long id, Fornecedor fornecedorAtualizado) {
        Fornecedor fornecedorExistente = findById(id);
        fornecedorAtualizado.setId(fornecedorExistente.getId());
        return fornecedorRepository.save(fornecedorAtualizado);
    }

    @Transactional
    public void delete(Long id) {
        Fornecedor fornecedor = findById(id);
        fornecedorRepository.delete(fornecedor);
    }
}
