package br.com.meli.partidafutbol.Repository;

import br.com.meli.partidafutbol.Model.EstadioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadioRepository extends JpaRepository<EstadioModel, Long> {
}
