package com.tallerwebi.tdd_simple;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

import com.tallerwebi.dominio.entrenamiento1.Verificador;

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
  public void dadoUnaPWDConMenosDeOchoCaracteresYSinEspecialesCuandoLoValidoQueMeMuestreMensajeINVALIDO() {
    // Aplicando Patron AAA (Arrange-Act-Assert)
    // Preparacion
    String password = "hola";

    // ejecucion
    String resultado = Verificador.validarFortalezaPassword(password);

    // validacion
    assertThat(resultado, equalTo("INVALIDA"));

  }

  @Test
  public void dadoUnaPWDCon8CaracteresYCuatroNumerosYUnCaracterEspecialCuandoLoValidoQueMeMuestreMensajeFUERTE() {
    // Aplicando BDD y AAA
    // GIVEN
    String contraseniaAVerificar = givenUnaPWDCon8CaracteresYCuatroNumerosYUnCaracterEspecial();

    // WHEN
    String resultado = whenValidoPassword(contraseniaAVerificar);

    // THEN
    thenSeMuestraMensajeFUERTEExitosamente(resultado);
  }

  private void thenSeMuestraMensajeFUERTEExitosamente(String resultado) {
        assertThat(resultado, equalTo("FUERTE"));    
  }

  private String whenValidoPassword(String contraseniaAVerificar) {
    return Verificador.validarFortalezaPassword(contraseniaAVerificar);
  }

  private String givenUnaPWDCon8CaracteresYCuatroNumerosYUnCaracterEspecial() {
    return "hol@2222";
  }

  @Test
  public void dadoPWDTiene4CaracteresYTiene1CaracterEspecialCuandoVerificoEntoncesObtengoMensajeMEDIANA() {

    //Preparacion
    String password = "hola!";

    //Ejecucion
    String resultado = Verificador.validarFortalezaPassword(password);

    //Validacion
    assertThat(resultado, equalTo("MEDIANA"));

  }

  @Test
  public void queAlVerificarUnaContraseniaQueTieneAlmenosSolo8caracteresSeObtengaComoMensajeDEBIL(){
    String contraseniaAVerificar = givenUnaPWDConSolo8Caracteres();
    String resultado = whenValidoPassword(contraseniaAVerificar);
    thenSeMuestraMensajeDEBILExitosamente(resultado);

  }

  private void thenSeMuestraMensajeDEBILExitosamente(String resultado) {
    assertThat(resultado, equalTo("DEBIL"));
  }

  private String givenUnaPWDConSolo8Caracteres() {
    return "holamundo";
  }

}
