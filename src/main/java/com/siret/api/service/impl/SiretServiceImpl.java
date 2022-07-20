package com.siret.api.service.impl;

import com.siret.api.dto.CompanyResponseDTO;
import com.siret.api.service.SiretService;
import com.siret.api.utils.CSVUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class SiretServiceImpl implements SiretService {

    @Value("${sirets}")
    private String[] sirets;

    @Value("${sirene.api.url}")
    private String sireneApiUrl;

    @Value("${file.path}")
    private String filePath;

    private final RestTemplate restTemplate;

    public SiretServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void getSirets() throws Exception {
        List<CompanyResponseDTO> companyResponseDTOS = new ArrayList<>();
        Arrays.asList(sirets).forEach(siret -> {
            CompanyResponseDTO companyResponseDTO = getCompany(siret);
            if (Objects.nonNull(companyResponseDTO)) {
                companyResponseDTOS.add(companyResponseDTO);
            }
        });
        CSVUtils.writeToCSVFile(companyResponseDTOS, Paths.get(filePath));
    }

    private CompanyResponseDTO getCompany(String siret) {
        CompanyResponseDTO companyResponseDTO = null;
        try {
            companyResponseDTO = restTemplate.exchange(sireneApiUrl + siret, HttpMethod.GET, new HttpEntity<>(null), new ParameterizedTypeReference<CompanyResponseDTO>() {
            }).getBody();
        } catch (Exception e) {
            /**
             * TODO add log and exception handling
             */
        }


        return companyResponseDTO;
    }
}
