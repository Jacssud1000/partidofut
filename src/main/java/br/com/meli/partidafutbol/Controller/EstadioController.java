package br.com.meli.partidafutbol.Controller;

import br.com.meli.partidafutbol.Model.EstadioModel;
import br.com.meli.partidafutbol.Service.EstadioService;

import java.util.Collections;
import java.util.List;

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
@RequestMapping({"/estadio"})
public class EstadioController {
    @Autowired
    private EstadioService estadioService;

    public EstadioController() {
    }

    @GetMapping
    public ResponseEntity<List<EstadioModel>> findAll() {
        List<EstadioModel> list = this.estadioService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<List<EstadioModel>> findById(@PathVariable Long IdEstadio) {
        EstadioModel obj = this.estadioService.findByid(IdEstadio);
        return ResponseEntity.ok().body(Collections.singletonList(obj));
    }

    @PostMapping("/guardar")
    private ResponseEntity<EstadioModel> agregarEstadio(@RequestBody @Valid EstadioModel estadioModel) {
        EstadioModel savedEstadio = this.estadioService.save(estadioModel);
        return ResponseEntity.ok(savedEstadio);
    }

    @PutMapping({"/{id}"})
    public EstadioModel actualizarEstadio(@PathVariable Long IdEstadio, @RequestBody EstadioModel estadioModel) {
        estadioModel.setIdEstadio(IdEstadio);
        return this.estadioService.save(estadioModel);
    }

    @DeleteMapping({"/{id}"})
    public void eliminarEstadio(@PathVariable Long IdEstadio) {
        EstadioService.deleteById(IdEstadio);
    }
}
