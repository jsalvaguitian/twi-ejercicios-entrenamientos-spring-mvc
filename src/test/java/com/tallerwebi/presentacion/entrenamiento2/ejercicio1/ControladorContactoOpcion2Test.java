package com.tallerwebi.presentacion.entrenamiento2.ejercicio1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

public class ControladorContactoOpcion2Test {
    private final String nombre = "Jesi";
    private final String mail = "jesi@mail.com";
    private final String mensaje = "Hola German";

    @Test
    public void conElNombreMailMensajeQueElContactoSeaExitoso() {
        // given()
        givenNoHayContacto();
        // when()
        ModelAndView vistaModelada = whenGeneroContacto(nombre, mail, mensaje);
        // then()
        thenContactoEsExitoso(vistaModelada);
    }

    @Test
    public void siNoHayNombreQueElContactoFalle() {
        // given()
        givenNoHayContacto();
        // when()
        ModelAndView vistaModelada = whenGeneroContacto("", mail, mensaje);
        // then()
        thenContactoFallaPorCampoNombreVacio(vistaModelada);
    }

    @Test
    public void siNoHayMailQueElContactoFalle() {
        // given()
        givenNoHayContacto();
        // when()
        ModelAndView vistaModelada = whenGeneroContacto(nombre, "", mensaje);
        // then()
        thenContactoFallaPorMail(vistaModelada);
    }


    @Test
    public void siNoHayMensajeQueElContactoFalle() {
        // given()
        givenNoHayContacto();
        // when()
        ModelAndView vistaModelada = whenGeneroContacto(nombre, mail, "");
        // then()
        thenContactoFallaPorMensaje(vistaModelada);
    }

    private void thenContactoFallaPorMensaje(ModelAndView vistaModelada) {
        assertTrue(vistaModelada.getModel().containsKey("error3"));

    }

    private void thenContactoFallaPorMail(ModelAndView vistaModelada) {
        assertTrue(vistaModelada.getModel().containsKey("error2"));
    }


    private void thenContactoFallaPorCampoNombreVacio(ModelAndView vistaModelada) {
        assertTrue(vistaModelada.getModel().containsKey("error1"));
    }

   
    private void thenContactoEsExitoso(ModelAndView vistaModelada) {
        assertThat("confirmacion2", equalTo(vistaModelada.getViewName()));
    }

    private ModelAndView whenGeneroContacto(String nombre, String mail, String mensaje) {
        ControladorContactoOp2 controladorContacto = new ControladorContactoOp2();

        ModelAndView vistaModelada = controladorContacto.procesarFormulario(new ContactoDto(nombre, mail, mensaje));

        return vistaModelada;
    }

    private void givenNoHayContacto() {
    }
}
