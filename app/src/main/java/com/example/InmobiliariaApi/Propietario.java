package com.example.InmobiliariaApi;

public class Propietario {
    private int IdPropietario;
    private String Dni;
    private String Apellido;
    private String Nombre;
    private String Telefono;
    private String Email;
    private String Password;

    public Propietario(int idPropietario, String dni, String apellido, String nombre, String telefono, String email, String password) {
        IdPropietario = idPropietario;
        Dni = dni;
        Apellido = apellido;
        Nombre = nombre;
        Telefono = telefono;
        Email = email;
        Password = password;
    }

    public int getIdPropietario() {
        return IdPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        IdPropietario = idPropietario;
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

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
