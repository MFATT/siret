package com.siret.api.dto;

public class UniteLegalResponse {

    private String denomination;

    private String numero_tva_intra;

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getNumero_tva_intra() {
        return numero_tva_intra;
    }

    public void setNumero_tva_intra(String numero_tva_intra) {
        this.numero_tva_intra = numero_tva_intra;
    }
}
