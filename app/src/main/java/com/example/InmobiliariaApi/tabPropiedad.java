package com.example.InmobiliariaApi;

public class tabPropiedad {
    private String Tipo;
    private String Domicilio;
    private int Ambientes;
    private String Uso;
    private double Precio;
    private boolean Habilitada;

    public tabPropiedad(String tipo, String domicilio, int ambientes, String uso, double precio, boolean habilitada) {
        Tipo = tipo;
        Domicilio = domicilio;
        Ambientes = ambientes;
        Uso = uso;
        Precio = precio;
        Habilitada = habilitada;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String domicilio) {
        Domicilio = domicilio;
    }

    public int getAmbientes() {
        return Ambientes;
    }

    public void setAmbientes(int ambientes) {
        Ambientes = ambientes;
    }

    public String getUso() {
        return Uso;
    }

    public void setUso(String uso) {
        Uso = uso;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public boolean isDisponible() {
        return Habilitada;
    }

    public void setDisponible(boolean disponible) {
        Habilitada = disponible;
    }
}
