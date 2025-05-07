package com.tallerwebi.presentacion.entrenamiento2.ejercicio1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorContactoOp2 {

    @GetMapping("/contacto2")
    public ModelAndView mostrarFormulario() {
        ModelMap datosMap = new ModelMap();
        datosMap.put("contactoDto", datosMap);
        return new ModelAndView("contacto2", datosMap); 
    }

    @PostMapping("/contacto2")
    public ModelAndView procesarFormulario(@ModelAttribute("contactoDto")ContactoDto contactoDto) {
        ModelMap map = new ModelMap();

        if(contactoDto.getNombre().isBlank()){
            map.put("error", "El nombre es obligatorio");
            return new ModelAndView("contacto2", map);
        }
        if(contactoDto.getEmail().isBlank()){
            map.put("error", "El mail es obligatorio");
            return new ModelAndView("contacto2", map);
        }

        if(contactoDto.getMensaje().isBlank()){
            map.put("error", "El mensaje es obligario");
            return new ModelAndView("contacto2", map);
        }
        map.put("contactoDto", contactoDto);
        return new ModelAndView("confirmacion2",map);
    }

}
