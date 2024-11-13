package com.senai.library.application.ports.in;

import com.senai.library.application.domain.Livro;

public interface UpdateLivroUseCase {

    Livro updateLivro(Livro livroDetails, Long id);

}
