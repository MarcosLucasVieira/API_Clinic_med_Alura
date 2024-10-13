package Clinic.med.API.patients;


import Clinic.med.API.adress.Adress;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "patients")
@Entity(name = "patient")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String telefone;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String cpf;

    @Embedded
    private Adress endereco;

    private Boolean ativo;

    public patients(@Valid RegisterPatientsData data) {
        this.ativo = true;
        this.nome = data.nome();
        this.telefone = data.telefone();
        this.email = data.email();
        this.cpf = data.cpf();
        this.endereco = new Adress(data.endereco());
    }

    public void updateInfo(@Valid PatientsUpdateData data) {
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
