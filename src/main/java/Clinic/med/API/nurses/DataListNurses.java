package Clinic.med.API.nurses;

public record DataListNurses(String nome, String email, String coren) {

    public DataListNurses(Nurses nurse){
        this(nurse.getNome(), nurse.getEmail(), nurse.getCoren());
    }
}
