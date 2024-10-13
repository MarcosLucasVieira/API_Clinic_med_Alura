package Clinic.med.API.domain.nurses;

import Clinic.med.API.domain.adress.Adress;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String telefone;

    @NotBlank
    private String coren;

    @Embedded
    private Adress endereco;

    private Boolean ativo;


    public Nurses(@Valid RegisterNursesData data) {
        this.ativo = true;
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.coren = data.coren();
        this.endereco = new Adress(data.endereco());
    }

    public void updateInfo(@Valid NurseUpdateData data) {
        if(data.nome() != null){
            this.nome = data.nome();
        }
        if(data.telefone() != null){
            this.telefone = data.telefone();
        }
        if(data.endereco() != null){
            this.endereco.updateInfo(data.endereco());
        }
    }

    public void delete() {
        this.ativo = false;
    }
}
