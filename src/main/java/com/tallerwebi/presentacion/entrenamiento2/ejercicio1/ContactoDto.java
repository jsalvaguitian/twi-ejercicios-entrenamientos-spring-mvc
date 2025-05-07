package com.tallerwebi.presentacion.entrenamiento2.ejercicio1;

public class ContactoDto {
    private String nombre;
    private String email;
    private String mensaje;

    public ContactoDto() {
        
    }

    public ContactoDto(String nombre, String mail, String mensaje) {
        this.nombre = nombre;
        this.email = mail;
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEmail(String mail) {
        this.email = mail;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
