package br.com.fiap.live2010.repository;

import br.com.fiap.live2010.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
