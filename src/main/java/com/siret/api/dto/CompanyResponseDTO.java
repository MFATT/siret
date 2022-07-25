package com.siret.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CompanyResponseDTO {

    private CompanyInformationResponseDTO etablissement;

    public CompanyInformationResponseDTO getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(CompanyInformationResponseDTO etablissement) {
        this.etablissement = etablissement;
    }

    @JsonIgnore
    public List<String[]> getLine() {
        List<String[]> lines = new ArrayList<>();
        String[] csvRows = new String[]{
                this.etablissement.getId() != null ? this.etablissement.getId().toString() : "",
                this.etablissement.getUnite_legale().getDenomination(),
                this.etablissement.getGeo_adresse(),
                this.etablissement.getNic(),
                this.etablissement.getUnite_legale().getNumero_tva_intra(),
                this.etablissement.getDate_creation() != null ? this.etablissement.getDate_creation().format(DateTimeFormatter.ISO_LOCAL_DATE) : null

        };
        lines.add(csvRows);
        return lines;
    }
}
