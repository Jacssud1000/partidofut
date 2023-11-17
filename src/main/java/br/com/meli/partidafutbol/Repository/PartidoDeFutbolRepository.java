package br.com.meli.partidafutbol.Repository;


import br.com.meli.partidafutbol.Model.PartidoDeFutbolModel;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PartidoDeFutbolRepository extends JpaRepository<PartidoDeFutbolModel, Long> {
    long countByEstadioAndDataHoraPartida(@Param("estadio") String estadio, @Param("fechaehora") @NotNull Date dataHora);
}
