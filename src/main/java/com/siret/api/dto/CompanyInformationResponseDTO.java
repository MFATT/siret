package com.siret.api.dto;

import java.time.LocalDate;

public class CompanyInformationResponseDTO {

    private Long id;
    private String nic;
    private LocalDate date_creation;
    private String geo_adresse;
    private String name;
    private String numero_tva_intra;
    private UniteLegalResponse unite_legale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public LocalDate getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(LocalDate date_creation) {
        this.date_creation = date_creation;
    }

    public String getGeo_adresse() {
        return geo_adresse;
    }

    public void setGeo_adresse(String geo_adresse) {
        this.geo_adresse = geo_adresse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumero_tva_intra() {
        return numero_tva_intra;
    }

    public void setNumero_tva_intra(String numero_tva_intra) {
        this.numero_tva_intra = numero_tva_intra;
    }

    public UniteLegalResponse getUnite_legale() {
        return unite_legale;
    }

    public void setUnite_legale(UniteLegalResponse unite_legale) {
        this.unite_legale = unite_legale;
    }
}
