package com.example.inmobiliaria2;

public class ItemInquilino {
    private String Dni;
    private String Apellido;
    private String Nombre;
    private String Direccion;
    private String Telefono;

    public ItemInquilino(String dni, String apellido, String nombre, String direccion, String telefono) {
        Dni = dni;
        Apellido = apellido;
        Nombre = nombre;
        Direccion = direccion;
        Telefono = telefono;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
}
