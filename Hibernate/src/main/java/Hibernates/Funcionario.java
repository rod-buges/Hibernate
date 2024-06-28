package Hibernates;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funcionario {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true, nullable=false,length=50,name="nome")
    private String nome;
    @Column(name = "salario")
    private Double salario;
    @ManyToOne(fetch = FetchType.EAGER)
    private Departamento departamento;

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", salario=" + salario +
                ", departamento=" + departamento +
                '}';
    }
}
