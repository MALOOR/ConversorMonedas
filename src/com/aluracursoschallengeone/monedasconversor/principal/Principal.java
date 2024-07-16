package com.aluracursoschallengeone.monedasconversor.principal;

import com.aluracursoschallengeone.monedasconversor.modelos.DatosApi;
import com.aluracursoschallengeone.monedasconversor.service.ConsumirDatos;
import com.aluracursoschallengeone.monedasconversor.service.ConvertirDatos;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        int opcion = 0;
        DatosApi consulta = new DatosApi();
        ArrayList<ConsumirDatos> listaConversion = new ArrayList<>();
        System.out.println("--------------------------------------------------------------");
        System.out.println("////// Bienvent@ al conversor de monedas //// \n");
        while(opcion != 3){


        Menu muestraMenu =new Menu();
        muestraMenu.menuInicial();
        opcion = muestraMenu.menuOpcion();

        switch (opcion){

            case 1:
                   muestraMenu.mostrarMenu("Inicial");
                   String monedaBase = muestraMenu.leerOpcionMoneda();
                   muestraMenu.mostrarMenu("Final");
                   String monedaObjetivo = muestraMenu.leerOpcionMoneda();
                   Double cantidadACambiar =muestraMenu.leerCantidad();
                   ConvertirDatos conversor = consulta.buscarDatos(monedaBase);
                   Double tasaConversion = conversor.getConversion(monedaObjetivo.toUpperCase());
                   Double cantidadObtenida = muestraMenu.montoObtenido(monedaBase, cantidadACambiar, tasaConversion, monedaObjetivo);
                   ConsumirDatos nuevaConversion = new ConsumirDatos(monedaBase, monedaObjetivo, cantidadACambiar, cantidadObtenida);
                   listaConversion.add(nuevaConversion);
                   break;
            case 2:
                    muestraMenu.mostrarConversiones(listaConversion);
                    break;
            case 3:
                    System.out.println("Gracias por usar el conversor de monedas");
                    break;
            default:
                    System.out.println("Opcion invalida ingresada, ingrese una opcion valida");
        }

        }



    }
}
