package Clinic.med.API.medicals;

import Clinic.med.API.adress.Adress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name ="medicals")
@Entity(name = "medical")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medicals {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;

    private String crm;

    private String email;

    private String telefone;

    @Enumerated
    private Specialty especialidade;

    @Embedded
    private Adress endereco;

    public Medicals(MedicaslRegisterData data) {
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.crm = data.crm();
        this.especialidade = data.especialidade();
        this.endereco = new Adress(data.endereco());

    }
}
