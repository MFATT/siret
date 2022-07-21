package com.siret.api.service.impl;

import com.siret.api.config.SpringTestConfig;
import com.siret.api.dto.CompanyResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringTestConfig.class)
class SiretServiceImplTest {

    @Autowired
    private SiretServiceImpl siretService;

    @Test
    public void testGetCompaniesInformationBySirets() throws Exception {

        List<CompanyResponseDTO> companyResponseDTOS = this.siretService.getCompaniesInformationBySirets();
        assertThat(companyResponseDTOS).as("Company list is not empty").isNotNull();
    }

}