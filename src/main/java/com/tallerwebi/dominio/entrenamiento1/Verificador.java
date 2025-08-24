package com.tallerwebi.dominio.entrenamiento1;

public final class Verificador {

    // - Menos de 8 caracteres Y no tiene caracteres especiales. INVALIDA
    /*- FUERTE:
    - Al menos 8 caracteres.
    - Al menos 4 números.
    - Al menos 1 carácter especial (no letra ni número). */
    public static String validarFortalezaPassword(String password) {
        if (password.length() < 8 && !tieneCaracterEspecial(password)) {
            return "INVALIDA";

        } 
        if (password.length() >= 8 && contarCantidadDeNumeros(password) >= 4 && tieneCaracterEspecial(password))
            return "FUERTE";

        if (password.length() >= 8)
            return "DEBIL";
            
        if (password.length() >= 4 && tieneCaracterEspecial(password))
            return "MEDIANA";

        
        return "";
    }

    private static int contarCantidadDeNumeros(String password) {
        int cantidadNum = 0;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i)))
                cantidadNum++;
        }
        return cantidadNum;
    }

    private static boolean tieneCaracterEspecial(String password) {
        String regex = "^(?=.*[!@#$%^&*()\\-_=+\\[\\]{}:;,.?/])[a-zA-Z0-9!@#$%^&*()\\-_=+\\[\\]{}:;,.?/]+$";

        return password.matches(regex);
    }

}
