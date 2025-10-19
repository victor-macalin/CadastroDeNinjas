package dev.java10x.cadastroDeNinjas.Missoes;

import dev.java10x.cadastroDeNinjas.Ninjas.Controller.Service.NinjaModel;
import jakarta.persistence.*;

import java.util.Scanner;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeDaMissao;
    private DificuldadeMissoes rank;
//    Essa anotacao significa que um elemento pode ser atribuido para varios elemntos de outras tabelas.
    @OneToMany(mappedBy = "missoes")
    private NinjaModel ninja;

    public MissoesModel() {

    }

    public DificuldadeMissoes getRank() {
        return rank;
    }

    public void setRank(DificuldadeMissoes rank) {
        this.rank = rank;
    }

    public NinjaModel getNinja() {
        return ninja;
    }

    public void setNinja(NinjaModel ninja) {
        this.ninja = ninja;
    }

    public MissoesModel(long id, String nomeDaMissao, DificuldadeMissoes rank, NinjaModel ninja) {
        this.id = id;
        this.nomeDaMissao = nomeDaMissao;
        this.rank = rank;
        this.ninja = ninja;
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

