package br.com.meli.partidafutbol.Service;
import br.com.meli.partidafutbol.Model.PartidoDeFutbolModel;
import br.com.meli.partidafutbol.Repository.PartidoDeFutbolRepository;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ValiacionesService {

    @Autowired
    private PartidoDeFutbolRepository partidoDeFutbolRepository;

    public boolean validarPartido(@NotNull PartidoDeFutbolModel partido) {
        return validarHoraPartido(partido.getdataHoraPartida()) && validarDisponibilidadEstadio(partido.getEstadio(), partido.getdataHoraPartida());
    }

    @Contract(pure = true)
    private boolean validarHoraPartido(@NotNull Date fechaehora) {
        long date = fechaehora.getTime();
        return date >= 8 && date <= 22;
    }

    private boolean validarDisponibilidadEstadio(String estadio, @NotNull Date dataHora) {
        long count = partidoDeFutbolRepository.countByEstadioAndDataHoraPartida(estadio, dataHora);
        return count == 0;
    }

    private final Map<String, LocalDateTime> ultimaPartidaPorClube = new HashMap<>();

    public boolean validarDisponibilidadPartida(String clube, LocalDateTime dataHora) {
        Optional<LocalDateTime> ultimaPartida = Optional.ofNullable(ultimaPartidaPorClube.get(clube));

        if (ultimaPartida.isPresent()) {
            Duration diferenca = Duration.between(ultimaPartida.get(), dataHora);

            if (diferenca.toDays() < 2) {
                return false;
            }
        }

        ultimaPartidaPorClube.put(clube, dataHora);
        return true;
    }
}
