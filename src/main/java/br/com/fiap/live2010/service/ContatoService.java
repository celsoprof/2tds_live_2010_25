package br.com.fiap.live2010.service;

import br.com.fiap.live2010.model.Contato;
import br.com.fiap.live2010.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public Contato salvar(Contato contato) {
        return contatoRepository.save(contato);
    }

    public Contato atualizar(Long id, Contato contatoNovo) {
        Optional<Contato> contatoAtual = contatoRepository.findById(id);

        if (contatoAtual.isPresent()) {
            contatoNovo.setId(id);
            return contatoRepository.save(contatoNovo);
        }

        return null;
    }

    public Contato buscarPorId(Long id) {
        Optional<Contato> contato = contatoRepository.findById(id);
        if (contato.isPresent()) {
            return contato.get();
        }
        return null;
    }

    public List<Contato> buscarTodos() {
        return contatoRepository.findAll();
    }

    public void remover(Long id) {
        contatoRepository.deleteById(id);
    }

}
