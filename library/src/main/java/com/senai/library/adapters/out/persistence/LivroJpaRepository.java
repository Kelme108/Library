package com.senai.library.adapters.out.persistence;

import com.senai.library.application.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroJpaRepository extends JpaRepository<LivroEntity, Long> {
}
