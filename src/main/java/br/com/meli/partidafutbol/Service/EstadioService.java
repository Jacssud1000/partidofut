package br.com.meli.partidafutbol.Service;

import br.com.meli.partidafutbol.Model.EstadioModel;
import br.com.meli.partidafutbol.Repository.EstadioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadioService {
    @Autowired
    private EstadioRepository estadioRepository;

    public EstadioService() {
    }

    public List<EstadioModel> findAll() {
        return this.estadioRepository.findAll();
    }

    public EstadioModel findByid(Long id) {
        Optional<EstadioModel> obj = this.estadioRepository.findById(id);
        return (EstadioModel)obj.get();
    }

    public EstadioModel save(EstadioModel estadioModel) {
        return estadioModel;
    }

    public static void deleteById(Long id) {
    }
}
