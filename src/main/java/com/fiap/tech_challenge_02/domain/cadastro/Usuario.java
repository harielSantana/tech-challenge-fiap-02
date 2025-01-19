package com.fiap.tech_challenge_02.domain.cadastro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("usuarios")
public class Usuario extends AbstractAggregateRoot<Usuario> {

    @Id
    private String id;
    private String nome;
    private String email;
    private CPF cpf;
    private Endereco endereco;
    private TipoUsuarioEnum tpUsuario;

    private String username;
    private String password;
    private String token;

    @AfterDomainEventPublication
    private void clienteCadastrado() {
        registerEvent(new UsuarioCadastrado(this));
    }

}
