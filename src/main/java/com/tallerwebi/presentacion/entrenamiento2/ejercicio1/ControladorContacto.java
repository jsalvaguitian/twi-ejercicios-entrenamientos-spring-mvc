package com.tallerwebi.presentacion.entrenamiento2.ejercicio1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tallerwebi.dominio.entrenamiento2.ejercicio1.ServicioMensajeImpl;
import com.tallerwebi.dominio.entrenamiento2.ejercicio1.ServicioMensajeI;


@Controller
public class ControladorContacto {

    private ServicioMensajeI servicioMensajeInterfaz;
    
    public ControladorContacto() {
        this.servicioMensajeInterfaz = new ServicioMensajeImpl();
    }

    @GetMapping("/contacto")
    public ModelAndView mostrarFormulario() {
        ModelMap datosAMostrarEnLaVista = new ModelMap();
        datosAMostrarEnLaVista.put("contactoDto", new ContactoDto());
        return new ModelAndView("contacto", datosAMostrarEnLaVista);// (vista.html + datos)
    }

    @PostMapping("/contacto")
    public ModelAndView procesarFormulario(@ModelAttribute("contactoDto")ContactoDto contactoDto) {
        ModelMap datosMap = new ModelMap();

        boolean enviado = servicioMensajeInterfaz.enviarMensaje(contactoDto);

        if(enviado){
            datosMap.put("contactoDto", contactoDto);
            return new ModelAndView("confirmacion", datosMap); //(vista.html + modelMap)
        }else{
            datosMap.put("error", "Hay campos vacios. Por favor complete el formulario");//la key debe coincidir con lo que se puso en el html
            return new ModelAndView("contacto", datosMap);
        }
    }
}
