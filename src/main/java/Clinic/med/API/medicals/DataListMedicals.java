package Clinic.med.API.medicals;

public record DataListMedicals(Long id,String nome, String email, String crm, Specialty especialidade)  {

    public DataListMedicals(Medicals medical){
        this(medical.getId(), medical.getNome(), medical.getEmail(), medical.getCrm(), medical.getEspecialidade());
    }
}
