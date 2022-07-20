package com.siret.api.service;

import com.siret.api.dto.CompanyResponseDTO;

import java.util.List;

public interface SiretService {


    List<CompanyResponseDTO> getCompaniesInformationBySirets();
}
