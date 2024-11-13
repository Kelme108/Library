package com.senai.library.application;

import com.senai.library.adapters.out.persistence.LivroEntity;
import com.senai.library.application.domain.Livro;
import com.senai.library.adapters.out.persistence.LivroJpaRepository;
import com.senai.library.application.ports.in.CreateLivroUseCase;
import com.senai.library.application.ports.in.DeleteLivroUseCase;
import com.senai.library.application.ports.in.GetLivroUseCase;
import com.senai.library.application.ports.in.UpdateLivroUseCase;
import com.senai.library.application.ports.out.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService implements CreateLivroUseCase, GetLivroUseCase, DeleteLivroUseCase, UpdateLivroUseCase {

    @Autowired
    private LivroRepository repository;

    public void excluirLivro(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Livro cadastrarLivro(Livro livro) {
        return repository.save(livro);
    }

    @Override
    public void deleteLivro(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Livro> getLivros() {
        return repository.findAll();
    }

    @Override
    public Livro getLivro(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Livro updateLivro(Livro livroDetails, Long id) {
        Livro livro = repository.findById(id).orElseThrow(() -> new RuntimeException("Livro not found for this id :: " + id));

        livro.setFotoCapa(livroDetails.getFotoCapa());
        livro.setNome(livroDetails.getNome());
        livro.setAutor(livroDetails.getAutor());
        livro.setAno(livroDetails.getAno());
        livro.setExemplares(livroDetails.getExemplares());

        return repository.save(livro);
    }
}
