package br.com.unifei.projetoclinica.services;

import br.com.unifei.projetoclinica.dto.request.VeterinarianRequest;
import br.com.unifei.projetoclinica.dto.response.VeterinarianResponse;
import br.com.unifei.projetoclinica.mappers.VeterinarianMapper;
import br.com.unifei.projetoclinica.repositories.ClinicRepository;
import br.com.unifei.projetoclinica.repositories.VeterinarianRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeterinarianService {

  @Autowired private ClinicRepository clinicRepository;
  @Autowired private VeterinarianRepository veterinarianRepository;

  @Autowired private VeterinarianMapper veterinarianMapper;

  // TODO: 11/14/2023 talvez criar interfaces para as assinaturas dos métodos
  public void createVeterinarian(VeterinarianRequest request, String clinicId) {
    var clinic =
        clinicRepository
            .findById(clinicId)
            .orElseThrow(
                () ->
                    new RuntimeException("Clinic not found.")); // // TODO: 11/14/2023 replace to BR

    var veterinarianEntity = veterinarianMapper.mapVeterinarianRequestToVeterinarianEntity(request);
    veterinarianEntity.setClinic(clinic);

    veterinarianRepository.save(veterinarianEntity);
  }

  public List<VeterinarianResponse> getAllVeterinarians() {

    return veterinarianMapper.mapVeterinarianEntityToVeterinarianResponse(veterinarianRepository.findAll());
  }
}
