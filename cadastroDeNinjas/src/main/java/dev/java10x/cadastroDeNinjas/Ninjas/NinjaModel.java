package dev.java10x.cadastroDeNinjas.Ninjas;

import dev.java10x.cadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivilegedAction;
import java.util.List;
@Data
@Entity
@Table(name = "tb-cadastro")
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private int age;


    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;
}
