package Clinic.med.API.domain.patients;

public record DataPatientsList(String nome, String email, String cpf ) {

    public DataPatientsList (patients patients){
        this(patients.getNome(), patients.getEmail(), patients.getCpf());
    }
}
