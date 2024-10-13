package Clinic.med.API.patients;

public record PatientsDetailsData(Long id, String nome, String email, String telefone, String cpf) {

    public PatientsDetailsData (patients patients){
        this(patients.getId(), patients.getNome(), patients.getEmail(), patients.getTelefone(), patients.getCpf());
    }
}
