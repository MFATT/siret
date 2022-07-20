package com.siret.api.controller;

import com.siret.api.dto.CompanyResponseDTO;
import com.siret.api.service.SiretService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/siret")
public class SiretController {

    private final SiretService siretService;

    public SiretController(SiretService siretService) {
        this.siretService = siretService;
    }

    @GetMapping
    public List<CompanyResponseDTO> getCompanies() {

        return this.siretService.getCompaniesInformationBySirets();
    }
}
