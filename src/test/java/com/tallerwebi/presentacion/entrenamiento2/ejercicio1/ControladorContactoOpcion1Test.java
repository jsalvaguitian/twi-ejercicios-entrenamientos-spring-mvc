package com.tallerwebi.presentacion.entrenamiento2.ejercicio1;

import com.tallerwebi.dominio.entrenamiento2.ejercicio1.ServicioMensajeI;
import com.tallerwebi.dominio.entrenamiento2.ejercicio1.ServicioMensajeImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControladorContactoOpcion1Test {
    private ControladorContacto controladorContacto;
    private ServicioMensajeI servicioMensaje;

    @BeforeEach
    public void init() {
        servicioMensaje = new ServicioMensajeImpl();
        controladorContacto = new ControladorContacto();
    }

    @Test
    public void queSePuedaMostrarUnFormularioDeContacto() {
        // Preparacion de datos
        String vistaEsperada = "contacto";

        // Ejecucion
        ModelAndView modelAndView = controladorContacto.mostrarFormulario();
        ContactoDto contactoDto = (ContactoDto) modelAndView.getModel().get("contactoDto");

        // Validacion
        // valido si responde con el nombre de la vista esperada
        assertThat(vistaEsperada, equalTo(modelAndView.getViewName()));

        // valido si existe un objeto contacto en el modelo para bindear los datos, o
        // sea para tomar los valores del formulario
        assertTrue(modelAndView.getModel().containsKey("contactoDto"));
        assertNull(contactoDto.getNombre());
        assertNull(contactoDto.getEmail());
        assertNull(contactoDto.getMensaje());
    }

    @Test
    public void dadoUnFormularioContactoCuandoSeProceseLosDatosQueMuestreVistaConfirmacion() {
        // Preparacion
        ModelAndView modelAndView = controladorContacto.mostrarFormulario();
        ContactoDto contactoDto = new ContactoDto();
        contactoDto.setNombre("Jesica");
        contactoDto.setEmail("jesi@mail.com");
        contactoDto.setMensaje("Hola Ger, como estas?");

        String vistaEsperada = "confirmacion";

        // Ejecucion
        modelAndView = controladorContacto.procesarFormulario(contactoDto);

        // Verificacion
        // valido si me dio true cuando todos los campos se completo
        assertTrue(servicioMensaje.enviarMensaje(contactoDto));// duda
        assertThat(vistaEsperada, equalTo(modelAndView.getViewName()));
    }

    @Test
    public void dadoUnFormularioContactoCuandoNoSeCompleteTodosLosDatosQueMuestreMensajeDeError() {
        // Preparacion
        ModelAndView modelAndView = controladorContacto.mostrarFormulario();
        ContactoDto contactoDto = new ContactoDto();
        contactoDto.setNombre(" ");
        contactoDto.setEmail("");
        contactoDto.setMensaje("Hola Ger, como estas?");

        // Ejecucion
        modelAndView = controladorContacto.procesarFormulario(contactoDto);

        // Verificacion
        // valido si me dio false cuando hubo alguno sin completa
        assertFalse(servicioMensaje.enviarMensaje(contactoDto));// duda
        assertThat(modelAndView.getModel().get("error").toString(), equalTo("Hay campos vacios. Por favor complete el formulario"));
    }

}
