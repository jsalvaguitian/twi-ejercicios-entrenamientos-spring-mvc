package com.tallerwebi.presentacion.entrenamiento2.ejercicio2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

public class ControladorProductoOpcion1Test {
    private ControladorProducto controladorProducto;
    

    @BeforeEach
    public void init(){
        controladorProducto = new ControladorProducto();
    }

    @Test
    public void queSePuedaMostrarUnaListaDeProductos(){
        //preparacion
        String vistaEsperada = "productos";

        //ejecucion
        ModelAndView vistaModelada = controladorProducto.listarProductos();
        //validacion
        assertThat(vistaEsperada, equalTo(vistaModelada.getViewName()));
        assertTrue(vistaModelada.getModel().containsKey("ListaProductos"));
    }

    

}
