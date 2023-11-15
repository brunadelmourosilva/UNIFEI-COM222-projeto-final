package br.com.unifei.projetoclinica.controllers;

import java.util.List;

import br.com.unifei.projetoclinica.services.ClinicService;
import br.com.unifei.projetoclinica.dto.response.ClinicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinics")
public class ClinicController {

  @Autowired private ClinicService clinicService;

  @GetMapping
  public ResponseEntity<List<ClinicResponse>> getAllClinics() {

    return new ResponseEntity<>(clinicService.getAllClinics(), HttpStatus.OK);
  }
}
