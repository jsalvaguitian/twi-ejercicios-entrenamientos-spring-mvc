package com.tallerwebi.tdd_simple;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

import com.tallerwebi.presentacion.entrenamiento1.Verificador;

/*
 Implementá una función/metodo `validarFortaleza(password: string):
'FUERTE' | 'MEDIANA' | 'DEBIL' | 'INVALIDA'` que evalúe la fortaleza de
una contraseña según las siguientes reglas:
- INVÁLIDA:
  - Menos de 8 caracteres Y no tiene caracteres especiales.

- FUERTE:
  - Al menos 8 caracteres.
  - Al menos 4 números.
  - Al menos 1 carácter especial (no letra ni número).

- MEDIANA:
  - Al menos 4 caracteres Y
  - Tiene al menos 1 carácter especial.
  (pero no cumple los requisitos de 'FUERTE').

- DÉBIL:
  - Al menos 8 caracteres,
  - No cumple los requisitos de 'FUERTE'.
 */
public class Ejercicio1Test {


    @Test
    public void dadoUnaPWDConMenosDeOchoCaracteresYSinEspecialesCuandoLoValidoQueMeMuestreMensajeINVALIDO(){
    //Aplicando Patron AAA (Arrange-Act-Assert)
        //Preparacion
        String password = "hola";

        //ejecucion
        String resultado =Verificador.validarFortalezaPassword(password);

        //validacion
        assertThat("INVALIDO", equalTo(resultado));
        
    }

    @Test
    public void dadoUnaPWDCon8CaracteresYCuatroNumerosYUnCaracterEspecialCuandoLoValidoQueMeMuestreMensajeFUERTE(){
    //Aplicando BDD y AAA
    //GIVEN

    //WHEN

    //THEN
    }

    @Test
    public void dadoPWDTiene4CaracteresO1CaracterEspecial(){

    }
    


}
