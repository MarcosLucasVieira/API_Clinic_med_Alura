package Clinic.med.API.medicals;

public record DataListMedicals(String nome, String email, String crm, Specialty especialidade)  {

    public DataListMedicals(Medicals medical){
        this(medical.getNome(), medical.getEmail(), medical.getCrm(), medical.getEspecialidade());
    }
}
