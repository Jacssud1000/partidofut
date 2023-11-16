package br.com.meli.partidafutbol.Controller;

import br.com.meli.partidafutbol.Model.ClubModel;
import br.com.meli.partidafutbol.Service.ClubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/club")
public class ClubController {

 @Autowired
 private ClubService clubService;

    public ClubController() {
    }

    @GetMapping
    public ResponseEntity<List<ClubModel>> findAll() {
        List<ClubModel> list = this.clubService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<ClubModel> findById(@PathVariable Long id) {
        ClubModel obj = this.clubService.findByid(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/guardar")
    public ResponseEntity<ClubModel> agregarClub(@RequestBody @Valid ClubModel obj) {
        obj = clubService.agregarClub(obj);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping({"/{id}"})
    public ClubModel actualizarEstadio(@PathVariable Long id, @RequestBody ClubModel clubModel) {
        clubModel.setIdClub(id);
        return this.clubService.save(clubModel);
    }

    @DeleteMapping({"/{id}"})
    public void eliminarEstadio(@PathVariable Long id) {
        ClubService.deleteById(id);
    }

}
