package com.senai.library.application.ports.in;

import com.senai.library.application.domain.Livro;

public interface CreateLivroUseCase {

    Livro cadastrarLivro(Livro livro);

}
