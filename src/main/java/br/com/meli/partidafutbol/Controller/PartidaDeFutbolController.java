package br.com.meli.partidafutbol.Controller;

import br.com.meli.partidafutbol.Model.ClubModel;
import br.com.meli.partidafutbol.Model.PartidoDeFutbolModel;
import br.com.meli.partidafutbol.Service.PartidoDeFutbolService;

import java.time.LocalDateTime;
import java.util.List;

import br.com.meli.partidafutbol.Service.ValiacionesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/partido"})
public class PartidaDeFutbolController {
    @Autowired
    private PartidoDeFutbolService partidoDeFutbolService;
    @Autowired
    private ValiacionesService valiacionesService;

    @GetMapping
    public ResponseEntity<List<PartidoDeFutbolModel>> findAll() {
        List<PartidoDeFutbolModel> list = partidoDeFutbolService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<PartidoDeFutbolModel> findById(@PathVariable Long id) {
        PartidoDeFutbolModel obj = partidoDeFutbolService.findByid(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping("/guardar")
    public ResponseEntity<PartidoDeFutbolModel> agregarPartido(@RequestBody @Valid PartidoDeFutbolModel obj) {
        obj = partidoDeFutbolService.agregarPartido(obj);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PartidoDeFutbolModel> atualizarPartida(@PathVariable Long id, @RequestBody @Valid PartidoDeFutbolModel partidoDeFutbolModel) {
        partidoDeFutbolModel.setId(id);
        PartidoDeFutbolModel updatedPartido = partidoDeFutbolService.save(partidoDeFutbolModel);
        return ResponseEntity.ok(updatedPartido);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> removerPartida(@PathVariable Long id) {
        partidoDeFutbolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    /*@PostMapping("/agregar")
    public ResponseEntity<PartidoDeFutbolModel> agregarPartido(@RequestBody @Valid PartidoDeFutbolModel partidoDeFutbolModel) {
        String clubeCasa = partidoDeFutbolModel.getTimeCasa();
        String clubeVisitante = partidoDeFutbolModel.getTimeVisitante();

        LocalDateTime dataHoraPartida = partidoDeFutbolModel.getDataHoraPartida();

        if (valiacionesService.validarPartido(partidoDeFutbolModel) &&
                valiacionesService.validarDisponibilidadPartida(clubeCasa, dataHoraPartida) &&
                valiacionesService.validarDisponibilidadPartida(clubeVisitante, dataHoraPartida)) {
            PartidoDeFutbolModel savedPartido = partidoDeFutbolService.save(partidoDeFutbolModel);
            return ResponseEntity.ok(savedPartido);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }*/


}

