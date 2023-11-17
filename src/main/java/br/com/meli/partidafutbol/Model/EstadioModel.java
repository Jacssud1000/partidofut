package br.com.meli.partidafutbol.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(
        name = "tb_estadios"
)
public class EstadioModel implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long IdEstadio;
    private String NomeDoEstadio;

    @OneToMany(mappedBy = "locals")
    private Set<PartidoDeFutbolModel> partidoDeFutbolModels = new HashSet<>();



    public EstadioModel(Long idEstadio, String nomeDoEstadio, Set<PartidoDeFutbolModel> partido) {
        this.IdEstadio = idEstadio;
        this.NomeDoEstadio = nomeDoEstadio;
        this.partidoDeFutbolModels = partido;
    }

    public EstadioModel() {
    }

    public Long getIdEstadio() {
        return this.IdEstadio;
    }

    public void setIdEstadio(Long idEstadio) {
        this.IdEstadio = idEstadio;
    }

    public String getNomeDoEstadio() {
        return this.NomeDoEstadio;
    }

    public void setNomeDoEstadio(String nomeDoEstadio) {
        this.NomeDoEstadio = nomeDoEstadio;
    }

    public List<PartidoDeFutbolModel> getPartido() {
        return (List<PartidoDeFutbolModel>) this.partidoDeFutbolModels;
    }

    public void setPartido(Set<PartidoDeFutbolModel> partidoDeFutbolModel) {
        this.partidoDeFutbolModels = (Set<PartidoDeFutbolModel>) partidoDeFutbolModel;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof EstadioModel) {
            EstadioModel that = (EstadioModel)o;
            return this.getIdEstadio().equals(that.getIdEstadio());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getIdEstadio()});
    }

    public Set<PartidoDeFutbolModel> getPartidoDeFutbolModels() {
        return partidoDeFutbolModels;
    }
}
