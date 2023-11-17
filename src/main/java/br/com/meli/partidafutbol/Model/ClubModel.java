package br.com.meli.partidafutbol.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(
        name = "tb_clubs"
)
public class ClubModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdClub;
    private String NombreDelClub;
    @ManyToMany
    /*@JoinTable(name = "tb_partidosFutbol_clubs",
            joinColumns = @JoinColumn(name = "clubs_id"),
            inverseJoinColumns = @JoinColumn(name = "partidos_id")
    )*/
    private Set<PartidoDeFutbolModel> partidoDeFutbolModels;

    public ClubModel(String nombreDelClub) {
        NombreDelClub = nombreDelClub;
    }

    public ClubModel() {

    }

    public Long getIdClub() {
        return IdClub;
    }

    public void setIdClub(Long idClub) {
        IdClub = idClub;
    }

    public String getNombreDelClub() {
        return NombreDelClub;
    }

    public void setNombreDelClub(String nombreDelClub) {
        NombreDelClub = nombreDelClub;
    }

    public Set<PartidoDeFutbolModel> getPartidoDeFutbolModels() {
        return partidoDeFutbolModels;
    }

    public void setPartidoDeFutbolModels(Set<PartidoDeFutbolModel> partidoDeFutbolModels) {
        this.partidoDeFutbolModels = partidoDeFutbolModels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClubModel clubModel)) return false;
        return Objects.equals(getIdClub(), clubModel.getIdClub()) && Objects.equals(getNombreDelClub(), clubModel.getNombreDelClub());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdClub(), getNombreDelClub());
    }
}
