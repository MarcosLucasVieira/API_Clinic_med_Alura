package Clinic.med.API.nurses;

import Clinic.med.API.adress.Adress;
import Clinic.med.API.adress.DataAdress;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "nurses")
@Entity(name = "nurse")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Nurses {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;

    private String email;

    private String telefone;

    private String coren;

    @Embedded
    private Adress endereco;


    public Nurses(@Valid RegisterNursesData data) {
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.coren = data.coren();
        this.endereco = new Adress(data.endereco());
    }
}
