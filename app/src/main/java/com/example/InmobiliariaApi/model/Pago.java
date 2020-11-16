package com.example.InmobiliariaApi.model;

public class Pago {
    private String NroPago;
    private String FechaPago;
    private double Importe;

    public Pago(String nroPago, String fechaPago, double importe) {

        NroPago = nroPago;
        FechaPago = fechaPago;
        Importe = importe;
    }

    public String getNroPago() {
        return NroPago;
    }

    public void setNroPago(String nroPago) {
        NroPago = nroPago;
    }

    public String getFechaPago() {
        return FechaPago;
    }

    public void setFechaPago(String fechaPago) {
        FechaPago = fechaPago;
    }

    public double getImporte() {
        return Importe;
    }

    public void setImporte(double importe) {
        Importe = importe;
    }
}
