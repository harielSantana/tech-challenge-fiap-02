package com.fiap.tech_challenge_02.domain.cadastro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Usuario {

    @Id
    private String id;
    private String nome;
    private CPF cpf;
    private String username;
    private String password;
    private String token;
    private Endereco endereco;
    private TipoUsuarioEnum tpUsuario;
    private String email;

}
