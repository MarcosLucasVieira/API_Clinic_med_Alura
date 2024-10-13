package Clinic.med.API.nurses;

public record DataListNurses(Long id, String nome, String email, String coren) {

    public DataListNurses(Nurses nurse){
        this(nurse.getId(), nurse.getNome(), nurse.getEmail(), nurse.getCoren());
    }
}
