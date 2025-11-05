package dev.java10x.cadastroDeNinjas.Missoes;

import dev.java10x.cadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDaMissao;
    private DificuldadeMissoes rank;
    //    Essa anotacao significa que um elemento pode ser atribuido para varios elementos de outras tabelas.
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

    public MissoesModel() {

    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<NinjaModel> ninjas) {
        this.ninjas = ninjas;
    }

    public DificuldadeMissoes getRank() {
        return rank;
    }

    public void setRank(DificuldadeMissoes rank) {
        this.rank = rank;
    }

    public MissoesModel(long id, String nomeDaMissao, DificuldadeMissoes rank, NinjaModel ninja) {
        this.id = id;
        this.nomeDaMissao = nomeDaMissao;
        this.rank = rank;
        this.ninjas = ninjas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeDaMissao() {
        return nomeDaMissao;
    }

    public void setNomeDaMissao(String nomeDaMissao) {
        this.nomeDaMissao = nomeDaMissao;
    }


}

