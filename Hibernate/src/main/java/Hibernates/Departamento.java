package Hibernates;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Departamento {
    @Id
    @Column(name="id",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true, name="nome", nullable=false)
    private String nome;
    @OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios;

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nome=" + nome +
                ", funcionarios=" + funcionarios +
                '}';
    }
}
