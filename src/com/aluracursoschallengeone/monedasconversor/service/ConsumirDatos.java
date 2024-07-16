package com.aluracursoschallengeone.monedasconversor.service;

import javax.print.DocFlavor;
import java.time.LocalDateTime;

public class ConsumirDatos {

        private String monedaPrincipal;
        private String monedaBase;
        private Double montoCambiar;
        private Double montoEnMonedaPrincipal;
        private LocalDateTime dateTime;


public ConsumirDatos(String monedaPrincipal, String monedaBase, Double montoCambiar, Double montoEnMonedaPrincipal){
        this.monedaPrincipal = monedaPrincipal;
        this.monedaBase = monedaBase;
        this.montoCambiar = montoCambiar;
        this.montoEnMonedaPrincipal = montoEnMonedaPrincipal;
        this.dateTime =LocalDateTime.now();


}
    public String getMonedaPrincipal() {
        return monedaPrincipal;
    }

    public void setMonedaPrincipal(String monedaPrincipal) {
        this.monedaPrincipal = monedaPrincipal;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public Double getMontoCambiar() {
        return montoCambiar;
    }

    public void setMontoCambiar(Double montoCambiar) {
        this.montoCambiar = montoCambiar;
    }

    public Double getMontoEnMonedaPrincipal() {
        return montoEnMonedaPrincipal;
    }

    public void setMontoEnMonedaPrincipal(Double montoEnMonedaPrincipal) {
        this.montoEnMonedaPrincipal = montoEnMonedaPrincipal;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
