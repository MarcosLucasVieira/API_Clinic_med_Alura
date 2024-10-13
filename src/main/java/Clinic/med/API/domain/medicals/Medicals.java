package Clinic.med.API.domain.medicals;

import Clinic.med.API.domain.adress.Adress;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private String nome;

    @NotBlank
    private String crm;

    @NotBlank @Email
    private String email;

    @NotBlank
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Specialty especialidade;

    @Embedded
    private Adress endereco;

    private Boolean ativo;


    public Medicals(MedicaslRegisterData data) {
        this.ativo = true;
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.crm = data.crm();
        this.especialidade = data.especialidade();
        this.endereco = new Adress(data.endereco());

    }

    public void updateInfo(@Valid MedicaslUpdateData data) {
        if(data.nome() != null){
            this.nome = data.nome();
        }
        if (data.telefone() != null){
            this.telefone = data.telefone();
        }
        if(data.endereco() != null){
            this.endereco.updateInfo(data.endereco());}
    }

    public void delete() {
        this.ativo = false;
    }
}
