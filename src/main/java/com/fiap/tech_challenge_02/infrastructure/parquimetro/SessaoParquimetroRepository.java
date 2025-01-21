package com.fiap.tech_challenge_02.infrastructure.parquimetro;

import com.fiap.tech_challenge_02.domain.parquimetro.Parquimetro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessaoParquimetroRepository extends MongoRepository<Parquimetro, String> {
    List<Parquimetro> findByClienteVeiculoPlate(String vehiclePlate);
}
