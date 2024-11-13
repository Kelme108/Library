package com.senai.library.adapters.in.web;

import com.senai.library.application.domain.Livro;
import com.senai.library.application.LivroService;
import com.senai.library.application.ports.in.CreateLivroUseCase;
import com.senai.library.application.ports.in.DeleteLivroUseCase;
import com.senai.library.application.ports.in.GetLivroUseCase;
import com.senai.library.application.ports.in.UpdateLivroUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/livros")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LivroController {

    @Autowired
    private CreateLivroUseCase createLivroUseCase;
    @Autowired
    private GetLivroUseCase getLivroUseCase;
    @Autowired
    private DeleteLivroUseCase deleteLivroUseCase;
    @Autowired
    private UpdateLivroUseCase updateLivroUseCase;

    @PostMapping()
    public Livro criarLivro(@RequestBody Livro livro) {
        Livro resultado = createLivroUseCase.cadastrarLivro(livro);
        return resultado;
    }

    @GetMapping
    public List<Livro> listar() {
        return getLivroUseCase.getLivros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivro(@PathVariable Long id) {
        Livro livro = getLivroUseCase.getLivro(id);
        return ResponseEntity.ok().body(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable(value = "id") Long id,
                                                @RequestBody Livro livroDetails) {
        Livro updatedLivro = updateLivroUseCase.updateLivro(livroDetails, id);
        return ResponseEntity.ok(updatedLivro);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteLivro(@PathVariable(value = "id") Long id) {
        deleteLivroUseCase.deleteLivro(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}