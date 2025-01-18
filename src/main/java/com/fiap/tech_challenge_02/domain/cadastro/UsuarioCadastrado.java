package com.fiap.tech_challenge_02.domain.cadastro;

public class UsuarioCadastrado {

    public UsuarioCadastrado(Usuario usuario){
        System.out.println("Enviando e-mail para novo usuario cadastro com suas credencias de acesso");
        System.out.println("Usuario: " + usuario.getNome());
    }
}
