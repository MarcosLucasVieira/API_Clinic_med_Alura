package Clinic.med.API.domain.nurses;

import Clinic.med.API.domain.adress.Adress;


public record NursesDetailsData(Long id, String nome, String email, String coren, String telefone, Adress endereco ) {

    public NursesDetailsData (Nurses nurses){
        this(nurses.getId(), nurses.getNome(), nurses.getEmail(), nurses.getCoren(), nurses.getTelefone(), nurses.getEndereco());
    }
}
