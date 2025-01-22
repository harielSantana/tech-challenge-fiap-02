package com.fiap.tech_challenge_02.application.cadastro;

import com.fiap.tech_challenge_02.domain.cadastro.Endereco;
import com.fiap.tech_challenge_02.domain.cadastro.TipoUsuarioEnum;
import com.fiap.tech_challenge_02.domain.pagamento.TipoPagamentoEnum;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document
@Setter
public class UsuarioRequest {
    @NotBlank
    private String nome;
    @NotNull
    private String email;
    private Endereco endereco;
    private TipoUsuarioEnum tpUsuario;
    private String username;
    private String password;

    @NotNull
    @Parameter(name = "Forma de pagamento", example = "NO_ESTACIONAMENTO, CARTAO_CADASTRADO")
    private TipoPagamentoEnum tipoPagamento;
}
