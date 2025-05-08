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
        datosMap.put("contactoDto", new ContactoDto());
        return new ModelAndView("contacto2", datosMap); 
    }

    @PostMapping("/contacto2")
    public ModelAndView procesarFormulario(@ModelAttribute("contactoDto")ContactoDto contactoDto) {
        ModelMap map = new ModelMap();

        if(contactoDto.getNombre().isBlank()) map.put("error1", "El nombre es obligatorio");

        if(contactoDto.getEmail().isBlank()) map.put("error2", "El mail es obligatorio");

        if(contactoDto.getMensaje().isBlank()) map.put("error3", "El mensaje es obligario");

        if(!contactoDto.getNombre().isBlank() && !contactoDto.getEmail().isBlank() && !contactoDto.getMensaje().isBlank()){
            map.put("contactoDto", contactoDto);
            return new ModelAndView("confirmacion2",map);
        }else{
            return new ModelAndView("contacto2", map);
        }
    }


}
