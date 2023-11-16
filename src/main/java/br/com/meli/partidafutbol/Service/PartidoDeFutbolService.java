package br.com.meli.partidafutbol.Service;

import br.com.meli.partidafutbol.Model.ClubModel;
import br.com.meli.partidafutbol.Model.PartidoDeFutbolModel;
import br.com.meli.partidafutbol.Repository.ClubRepository;
import br.com.meli.partidafutbol.Repository.PartidoDeFutbolRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidoDeFutbolService {
    @Autowired
    private PartidoDeFutbolRepository partidoDeFutbolRepository;

    public PartidoDeFutbolService() {
    }

    public List<PartidoDeFutbolModel> findAll() {
        return this.partidoDeFutbolRepository.findAll();
    }

    public PartidoDeFutbolModel findByid(Long id) {
        Optional<PartidoDeFutbolModel> obj = this.partidoDeFutbolRepository.findById(id);
        return obj.get();
    }

    public PartidoDeFutbolModel save(PartidoDeFutbolModel partidoDeFutbolModel) {
        return partidoDeFutbolRepository.save(partidoDeFutbolModel);
    }

    public PartidoDeFutbolModel agregarPartido(PartidoDeFutbolModel obj) {
        return partidoDeFutbolRepository.save(obj);
    }

    public void deleteById(Long id) {
        partidoDeFutbolRepository.deleteById(id);
    }
}
