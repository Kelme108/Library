package com.senai.library.application.ports.in;

import com.senai.library.application.domain.Livro;

import java.util.List;

public interface GetLivroUseCase {

    List<Livro> getLivros();

    Livro getLivro(Long id);

}
