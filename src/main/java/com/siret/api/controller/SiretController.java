package com.siret.api.controller;

import com.siret.api.service.SiretService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/siret")
public class SiretController {

    private final SiretService siretService;

    public SiretController(SiretService siretService) {
        this.siretService = siretService;
    }

    @GetMapping
    public void getCompanies() throws Exception {

         this.siretService.getSirets();
    }
}
