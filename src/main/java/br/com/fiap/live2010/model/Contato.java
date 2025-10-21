package br.com.fiap.live2010.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_contatos")
public class Contato {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CONTATOS"
    )
    @SequenceGenerator(
            name = "SEQ_CONTATOS",
            sequenceName = "SEQ_CONTATOS",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "nome_contato")
    @NotEmpty(message = "Nome do contato é obrigatório.")
    private String nomeContato;

    private String email;
    private String telefone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
