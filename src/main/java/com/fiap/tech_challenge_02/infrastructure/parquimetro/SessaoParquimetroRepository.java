package com.fiap.tech_challenge_02.infrastructure.parquimetro;

import com.fiap.tech_challenge_02.domain.parquimetro.SessaoParquimetro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessaoParquimetroRepository extends MongoRepository<SessaoParquimetro, String> {

    List<SessaoParquimetro> findByClienteVeiculoPlate(String vehiclePlate);

    List<SessaoParquimetro> findByParkingLotId(String parkingLotId);
}
