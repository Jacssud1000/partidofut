/* package br.com.meli.partidafutbol.futtest;

import br.com.meli.partidafutbol.Model.EstadioModel;
import br.com.meli.partidafutbol.Model.PartidoDeFutbolModel;
import br.com.meli.partidafutbol.Repository.EstadioRepository;
import br.com.meli.partidafutbol.Repository.PartidoDeFutbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

@Configuration
@Profile("test")
public class FutTest implements CommandLineRunner {

    @Autowired
    private PartidoDeFutbolRepository partidoDeFutbolRepository;
    @Autowired
    private EstadioRepository estadioRepository;

    @Override
    public void run(String... args) throws Exception {
        PartidoDeFutbolModel u1 = new PartidoDeFutbolModel(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        PartidoDeFutbolModel u2 = new PartidoDeFutbolModel(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        //EstadioModel o1 = new EstadioModel(null, "Maria Brown",);
        //EstadioModel o2 = new EstadioModel(null, "Maria Brown",);
        //EstadioModel o3 = new EstadioModel(null, "Maria Brown",);

        partidoDeFutbolRepository.saveAll(Arrays.asList(u1,u2));

        //estadioRepository.saveAll(Arrays.asList(o1, o2, o3));
    }

}
*/

/*package br.com.meli.partidafutbol.futtest;

import br.com.meli.partidafutbol.Model.ClubModel;
import br.com.meli.partidafutbol.Model.EstadioModel;
import br.com.meli.partidafutbol.Model.PartidoDeFutbolModel;
import br.com.meli.partidafutbol.Repository.ClubRepository;
import br.com.meli.partidafutbol.Repository.EstadioRepository;
import br.com.meli.partidafutbol.Repository.PartidoDeFutbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;

import java.util.Arrays;

@Configuration
@Profile("test")
public class FutTest implements CommandLineRunner {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private EstadioRepository estadioRepository;

    @Autowired
    private PartidoDeFutbolRepository partidoDeFutbolRepository;

    @Override
    public void run(String... args) throws Exception {

        ClubModel club1 = new ClubModel("Club A");
        ClubModel club2 = new ClubModel("Club B");

        EstadioModel estadio = new EstadioModel();
        estadio.setNomeDoEstadio("Estadio Principal");


        PartidoDeFutbolModel partido = new PartidoDeFutbolModel();
        partido.setTimeCasa("Club A");
        partido.setTimeVisitante("Club B");
        partido.setEstadio("Estadio Principal");
        partido.setResultado("2-1");

        LocalDateTime fechaHora = LocalDateTime.of(2023, 10, 20, 15, 30);
        partido.setFechaehora(fechaHora);

        partido.getClubs().add(club1);
        partido.getClubs().add(club2);
        partido.setLocals(estadio);

        clubRepository.saveAll(Arrays.asList(club1, club2));
        estadioRepository.save(estadio);
        partidoDeFutbolRepository.save(partido);
    }
}*/

package br.com.meli.partidafutbol.futtest;

import br.com.meli.partidafutbol.Model.ClubModel;
import br.com.meli.partidafutbol.Model.EstadioModel;
import br.com.meli.partidafutbol.Model.PartidoDeFutbolModel;
import br.com.meli.partidafutbol.Repository.ClubRepository;
import br.com.meli.partidafutbol.Repository.EstadioRepository;
import br.com.meli.partidafutbol.Repository.PartidoDeFutbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile(FutTest.TEST_PROFILE)
public class FutTest implements CommandLineRunner {

    static final String TEST_PROFILE = "test";

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private EstadioRepository estadioRepository;

    @Autowired
    private PartidoDeFutbolRepository partidoDeFutbolRepository;

    @Override
    public void run(String... args) {

        // Crear clubes
        ClubModel barcelona = new ClubModel("FC Barcelona");
        ClubModel realMadrid = new ClubModel("Real Madrid");
        ClubModel atleticoMadrid = new ClubModel("Atletico Madrid");
        ClubModel sevilla = new ClubModel("Sevilla FC");

        // Crear estadios
        EstadioModel campNou = new EstadioModel();
        campNou.setNomeDoEstadio("Camp Nou");

        EstadioModel santiagoBernabeu = new EstadioModel();
        santiagoBernabeu.setNomeDoEstadio("Santiago Bernabéu");

        // Crear partidos
        PartidoDeFutbolModel partido1 = createPartido(barcelona, realMadrid, campNou, "3-2", 2021, 8, 15, 20, 0);
        PartidoDeFutbolModel partido2 = createPartido(atleticoMadrid, sevilla, santiagoBernabeu, "2-1", 2021, 9, 5, 18, 30);
        PartidoDeFutbolModel partido3 = createPartido(realMadrid, sevilla, campNou, "4-0", 2021, 9, 20, 19, 45);

        // Guardar en repositorios
        clubRepository.saveAll(Arrays.asList(barcelona, realMadrid, atleticoMadrid, sevilla));
        estadioRepository.saveAll(Arrays.asList(campNou, santiagoBernabeu));
        partidoDeFutbolRepository.saveAll(Arrays.asList(partido1, partido2, partido3));
    }

    private PartidoDeFutbolModel createPartido(ClubModel clubLocal, ClubModel clubVisitante, EstadioModel estadio, String resultado, int year, int month, int day, int hour, int minute) {
        PartidoDeFutbolModel partido = new PartidoDeFutbolModel();
        partido.setTimeCasa(clubLocal.getNombreDelClub());
        partido.setTimeVisitante(clubVisitante.getNombreDelClub());
        partido.setEstadio(estadio.getNomeDoEstadio());
        partido.setResultado(resultado);

        LocalDateTime fechaHora = LocalDateTime.of(year, month, day, hour, minute);
        partido.setFechaehora(fechaHora);

        partido.getClubs().add(clubLocal);
        partido.getClubs().add(clubVisitante);
        partido.setLocals(estadio);

        return partido;
    }
}

