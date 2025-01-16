package com.fiap.tech_challenge_02.infrastructure.cadastro;

import com.fiap.tech_challenge_02.domain.cadastro.TipoUsuarioEnum;
import com.fiap.tech_challenge_02.domain.cadastro.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Long> {

    Optional<Usuario> findByIdAndTpUsuario(String id, TipoUsuarioEnum tpUsuario);

    Optional<Usuario> findByUsernameAndPassword(String username, String password);

    Optional<Usuario> findByToken(String token);

    Optional<Usuario> findByUsername(String username);

    Optional<Usuario> findById(Long aLong);
}
