package com.siret.api.dto;

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

    public List<String[]> getLine() {
        List<String[]> lines= new ArrayList<>();
        String[] csvRows = new String[]{
                this.etablissement.getId().toString(),
                this.etablissement.getUnite_legale().getDenomination(),
                this.etablissement.getGeo_adresse(),
                this.etablissement.getNic(),
                this.etablissement.getNumero_tva_intra(),
                this.etablissement.getDate_creation().format(DateTimeFormatter.ISO_LOCAL_DATE)

        };
        lines.add(csvRows);
        return lines;
    }
}
