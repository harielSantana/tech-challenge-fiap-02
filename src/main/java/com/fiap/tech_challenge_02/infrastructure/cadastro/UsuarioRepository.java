package com.fiap.tech_challenge_02.infrastructure.cadastro;

import com.fiap.tech_challenge_02.domain.cadastro.TipoUsuarioEnum;
import com.fiap.tech_challenge_02.domain.cadastro.Usuario;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByToken(String token);

    Optional<Usuario> findByUsernameAndPassword(@NotBlank String username, String s);
}
