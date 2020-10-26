/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.utilities;
import java.io.*;

/**
 *
 * @author fallen
 */
public class Consola{

    public static <T> boolean escribirSaltarLinea(T parEtiqueta, boolean parDeseaMensaje) {
        try {
            System.out.println(parEtiqueta);
            if (parDeseaMensaje) {
                System.out.println("Se escribio correctamente");
            }
            return true;
        } catch (Exception e) {
            if (parDeseaMensaje) {
                System.out.println("no se pudo escribir correctamente debido a: " + e.getMessage());
            }
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T leer(T parVarlectura, boolean parDeseaMensaje) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String valor = "";
        try {
            valor = entrada.readLine();
            
            if (esNumerico("" + parVarlectura) && esNumerico(valor)) {
                /*if (parVarlectura.getClass().equals(Double.valueOf(valor).getClass())) {
                    parVarlectura = (T) Double.valueOf(valor);
                } else {
                    parVarlectura = (T) Integer.valueOf(valor);
                }*/
                parVarlectura = (T) Integer.valueOf(valor);
            } else if (!esNumerico("" + parVarlectura) && !esNumerico(valor)) {
                parVarlectura = (T) valor;
            }
            
            if (parDeseaMensaje) {
                System.out.print("Se leyo correctamente");
            }
        } catch (Exception e) {
            if (parDeseaMensaje) {
                System.out.println("No se pudo leer debido a el error: " + e.getMessage());
            }
            parVarlectura.getClass().isInstance(valor.getClass());
        }
        return parVarlectura;
    }

    public static <T> boolean leer(T[] parVector) {
        for (int varIndice = 0; varIndice < parVector.length; varIndice++) {
            leer(parVector[varIndice], false);
        }
        return true;
    }

    public static <T> boolean leer(T[] parVector, int parCapacidadVector) {
        for (int varIndice = 0; varIndice < parCapacidadVector; varIndice++) {
            leer(parVector[varIndice], false);
        }
        System.out.println("se leyo correctamente el vector");
        return true;
    }

    public static <T> T leer(String parEtiqueta, T parVariable, boolean parDeseaMensaje) {
        escribirSaltarLinea(parEtiqueta, parDeseaMensaje);
        return leer(parVariable, parDeseaMensaje);
    }

    public static <T> boolean escribirSaltarLinea(T[] parVector, boolean parMensaje) {
        for (int varIndice = 0; varIndice < parVector.length; varIndice++) {
            if (escribirSaltarLinea(parVector[varIndice], parMensaje) == false) {
                System.out.println("Existe un dato incorrecto del vector que no se puede mostrar");
                System.out.println(varIndice + "posicion del vector con el error");
            }
        }
        return true;
    }

    public static boolean esNumerico(String dato) {
        return dato.matches("[+-]?\\d*(\\.\\d+)?");
    }
    public static boolean es_P_D_F(String dato){
        return dato.matches("[FDP]");
    }
}
