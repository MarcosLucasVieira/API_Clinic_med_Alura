package Clinic.med.API.medicals;

import Clinic.med.API.adress.Adress;

public record MedicalsDetailsData(Long id, String nome, String email, String crm,String telefone, Specialty especialidade, Adress endereco) {

    public MedicalsDetailsData (Medicals medicals){
        this(medicals.getId(), medicals.getNome(), medicals.getEmail(), medicals.getCrm(), medicals.getTelefone(), medicals.getEspecialidade(), medicals.getEndereco());

    }
}
