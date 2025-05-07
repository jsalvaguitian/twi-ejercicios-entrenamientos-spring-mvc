package com.tallerwebi.presentacion.entrenamiento2.ejercicio2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorProducto {

    @GetMapping("/productos")
    public ModelAndView listarProductos() {

        List<ProductoDto>productos = crearUnaListaProductosHarcodeados();
        ModelMap datos = new ModelMap();
        datos.put("listaProductos", productos);

        ModelAndView vistaModelada = new ModelAndView("productos", datos);
        return vistaModelada;
    }

    private List<ProductoDto> crearUnaListaProductosHarcodeados() {
        List<ProductoDto>productos = new ArrayList<>();
        productos.add(new ProductoDto(1,"Remera", "manga corta y color roja",200.34));
        productos.add(new ProductoDto(2,"Campera", "color negra y cuero ecologico", 235.32));
        productos.add(new ProductoDto(3,"Frutilla", "Cantidad 2 kilos", 1092.3));
        productos.add(new ProductoDto(4,"Sandia", "tirando fruta", 989.3));
        productos.add(new ProductoDto(5,"Banana", "amarilla etc",1654.2));
        return productos;
    }

}
