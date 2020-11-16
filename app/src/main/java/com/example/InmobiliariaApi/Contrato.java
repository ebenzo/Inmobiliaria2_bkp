package com.example.InmobiliariaApi;

public class Contrato {
    private int IdContrato;
    private String FechaInicio;
    private String FechaFin;
    private double Importe;

    public Contrato(int idContrato, String fechaInicio, String fechaFin, double importe) {
        IdContrato = idContrato;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        Importe = importe;
    }

    public int getIdContrato() {
        return IdContrato;
    }

    public void setIdContrato(int idContrato) {
        IdContrato = idContrato;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String fechaFin) {
        FechaFin = fechaFin;
    }

    public double getImporte() {
        return Importe;
    }

    public void setImporte(double importe) {
        Importe = importe;
    }
}
