package com.siret.api.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siret.api.config.SpringTestConfig;
import com.siret.api.dto.CompanyInformationResponseDTO;
import com.siret.api.dto.CompanyResponseDTO;
import com.siret.api.dto.UniteLegalResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringTestConfig.class)
class SiretServiceImplTest {

    @Autowired
    private SiretServiceImpl siretService;

    @Autowired
    private RestTemplate restTemplate;

    private MockRestServiceServer mockServer;
    
    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void testGetCompaniesInformationBySirets() throws Exception {
        CompanyResponseDTO responseEntity = new CompanyResponseDTO();
        CompanyInformationResponseDTO companyInformationResponseDTO = new CompanyInformationResponseDTO();
        companyInformationResponseDTO.setGeo_adresse("261 Chemin des Colles 06140 Vence");
        companyInformationResponseDTO.setId(1591844663L);
        companyInformationResponseDTO.setNic("00017");
        UniteLegalResponse uniteLegalResponse = new UniteLegalResponse();
        uniteLegalResponse.setDenomination("SOC EXPL PEPINIERES GAUDISSART");
        uniteLegalResponse.setNumero_tva_intra("FR96313029795");
        companyInformationResponseDTO.setUnite_legale(uniteLegalResponse);
        responseEntity.setEtablissement(companyInformationResponseDTO);

        mockServer.expect(ExpectedCount.manyTimes(), anything())
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(responseEntity))
                );
        List<CompanyResponseDTO> companyResponseDTOS = this.siretService.getCompaniesInformationBySirets();
        assertThat(companyResponseDTOS).as("Company list is not empty").isNotNull();
    }

}