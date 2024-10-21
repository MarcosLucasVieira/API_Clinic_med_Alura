package Clinic.med.API.domain.query;



import Clinic.med.API.domain.ValidacaoException;
import Clinic.med.API.domain.medicals.Medicals;
import Clinic.med.API.domain.medicals.MedicalsRepository;

import Clinic.med.API.domain.nurses.Nurses;
import Clinic.med.API.domain.nurses.NursesRepository;
import Clinic.med.API.domain.patients.PatientsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentQuery {

    @Autowired
    private QueryRepository queryRepository;

    @Autowired
    private MedicalsRepository  medicalsRepository;

    @Autowired
    private NursesRepository nursesRepository;

    @Autowired
    private PatientsRepository patientsRepository;

    public void agendar(DataDetalsQuery data ){
        if(!patientsRepository.existsById(data.IdPatient())){
            throw new ValidacaoException("Id do Paciente  não existe");
        }

        if(data.idMedical() !=  null && !medicalsRepository.existsById(data.idMedical())){
            throw new ValidacaoException("Id do Medico(a)  não existe");
        }



        var medicals = chooseMedical(data);
        var patient = patientsRepository.getReferenceById(data.IdPatient());
        var query = new Query(null, medicals, patient, data.date());

        queryRepository.save(query);
    }



    private Medicals chooseMedical(DataDetalsQuery data) {
        if(data.idMedical() !=  null ){
            return medicalsRepository.getReferenceById(data.idMedical());
        }

        if(data.especialidade() == null ){
            throw new ValidacaoException("Especialidade é obrigatóiria quando o médico não for escolhido");
        }

        return medicalsRepository.chooseRandoMedicals(data.especialidade(), data.date());

    }

}
