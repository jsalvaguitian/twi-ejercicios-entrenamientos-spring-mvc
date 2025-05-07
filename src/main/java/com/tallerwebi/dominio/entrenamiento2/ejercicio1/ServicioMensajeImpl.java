package com.tallerwebi.dominio.entrenamiento2.ejercicio1;

import com.tallerwebi.presentacion.entrenamiento2.ejercicio1.ContactoDto;


public class ServicioMensajeImpl implements ServicioMensajeI{

    @Override
    public Boolean enviarMensaje(ContactoDto contactoDto) {
        return !contactoDto.getNombre().isBlank() && !contactoDto.getEmail().isBlank() && !contactoDto.getMensaje().isBlank();

    }
}
