package br.com.meli.partidafutbol.Service;

import br.com.meli.partidafutbol.Model.ClubModel;
import br.com.meli.partidafutbol.Repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;

    public ClubService() {
    }

    public List<ClubModel> findAll() {
        return this.clubRepository.findAll();
    }

    public ClubModel findByid(Long id) {
        Optional<ClubModel> obj = this.clubRepository.findById(id);
        return (ClubModel) obj.get();
    }
    public ClubModel agregarClub(ClubModel obj) {
        return clubRepository.save(obj);
    }

    public ClubModel save(ClubModel clubModel) {
        return clubModel;
    }

    public static void deleteById(Long id) {
    }

}

