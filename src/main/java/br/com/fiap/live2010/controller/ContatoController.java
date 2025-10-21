package br.com.fiap.live2010.controller;

import br.com.fiap.live2010.model.Contato;
import br.com.fiap.live2010.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato salvar(@RequestBody Contato contato) {
        return contatoService.salvar(contato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizar(@RequestBody Contato contatoNovo, @PathVariable Long id) {
        Contato contato = contatoService.atualizar(id, contatoNovo);
        if (contato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contato);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> listar(){
        return contatoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> getContatoById(@PathVariable Long id) {
        Contato contato = contatoService.buscarPorId(id);
        if (contato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Contato contato = contatoService.buscarPorId(id);
        if (contato == null) {
            return ResponseEntity.notFound().build();
        }
        contatoService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
