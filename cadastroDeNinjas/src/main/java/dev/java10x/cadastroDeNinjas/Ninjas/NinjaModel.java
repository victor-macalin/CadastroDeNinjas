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
@Table(name = "TB_CADASTRO")
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "idade")
    private int age;


    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;
}
