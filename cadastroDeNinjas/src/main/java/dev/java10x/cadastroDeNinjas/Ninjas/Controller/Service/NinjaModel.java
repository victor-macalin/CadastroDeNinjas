package dev.java10x.cadastroDeNinjas.Ninjas.Controller.Service;

import dev.java10x.cadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.security.PrivilegedAction;
import java.util.List;

@Entity
@Table(name = "tb-cadastro")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;
//    Essa anotacao sigifica que varios elementos dessa tabela podem
//    ser atribuidos, para um elemento da outra tabela
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private List<NinjaModel> ninjas;

    public NinjaModel() {
    }

    public NinjaModel(int age, String email, String name) {
        this.age = age;
        this.email = email;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
