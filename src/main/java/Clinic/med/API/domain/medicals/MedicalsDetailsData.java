package Clinic.med.API.domain.medicals;

import Clinic.med.API.domain.adress.Adress;

public record MedicalsDetailsData(Long id, String nome, String email, String crm,String telefone, Specialty especialidade, Adress endereco) {

    public MedicalsDetailsData (Medicals medicals){
        this(medicals.getId(), medicals.getNome(), medicals.getEmail(), medicals.getCrm(), medicals.getTelefone(), medicals.getEspecialidade(), medicals.getEndereco());

    }
}
