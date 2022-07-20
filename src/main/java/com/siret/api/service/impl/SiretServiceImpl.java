package com.siret.api.service.impl;

import com.siret.api.dto.CompanyResponseDTO;
import com.siret.api.service.SiretService;
import com.siret.api.utils.CSVUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class SiretServiceImpl implements SiretService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SiretServiceImpl.class);

    @Value("${sirets}")
    private String[] siretsNumbers;

    @Value("${sirene.api.url}")
    private String sireneApiUrl;

    @Value("${file.path}")
    private String filePath;

    private final RestTemplate restTemplate;

    public SiretServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<CompanyResponseDTO> getCompaniesInformationBySirets() {
        List<CompanyResponseDTO> companyResponseDTOS = new ArrayList<>();
        Arrays.asList(siretsNumbers).forEach(siret -> {
            CompanyResponseDTO companyResponseDTO = getCompany(siret);
            if (Objects.nonNull(companyResponseDTO)) {
                companyResponseDTOS.add(companyResponseDTO);
            }
        });
        try {
            CSVUtils.writeToCSVFile(companyResponseDTOS, Paths.get(filePath));
        } catch (Exception e) {
            LOGGER.error("ERROR while writing to the csv file", e.getMessage());
            throw new RuntimeException("ERROR while writing to the csv file", e);
        }
        return companyResponseDTOS;
    }

    private CompanyResponseDTO getCompany(String siret) {
        CompanyResponseDTO companyResponseDTO = null;
        try {
            companyResponseDTO = restTemplate.exchange(sireneApiUrl + siret, HttpMethod.GET, new HttpEntity<>(null), new ParameterizedTypeReference<CompanyResponseDTO>() {
            }).getBody();
        } catch (HttpClientErrorException httpClientErrorException) {
            LOGGER.error("Error calling sirene api :", httpClientErrorException.getMessage());
            if (HttpStatus.NOT_FOUND.equals(httpClientErrorException.getStatusCode())) {
                LOGGER.error("there is no company information where the siret " + siret);
            }
        }


        return companyResponseDTO;
    }
}
