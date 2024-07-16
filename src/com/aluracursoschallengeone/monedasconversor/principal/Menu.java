package com.aluracursoschallengeone.monedasconversor.principal;

import com.aluracursoschallengeone.monedasconversor.service.ConsumirDatos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

        private final String menuMonedas = """
                        
                MXN - Peso Mexicano
                COP - Peso Colombiano
                CLP - Peso Chileno
                ARS - Peso Argentino
                BRL - Real Brasileño
                USD - Dólar Estadounidense
                EUR - Euro
                """;

    public void menuInicial(){

        System.out.println("Ingrese la opción a realizar: \n");
        String opcionMenu = """
                    
                    1) Conversion.
                    2) Historial de Conversiones.
                    3) Salir.
                    
                    """;
        System.out.println(opcionMenu);

    }

    public int menuOpcion(){

        Scanner entrada = new Scanner(System.in);
        System.out.println("Elija una opción que sea valida");
        System.out.println("////////////////////////////////////////////////");
        return entrada.nextInt();

    }

    public void mostrarMenu(String denominacion){

        System.out.println("---------------------------------------------");
        System.out.println("Elija la denominación " + denominacion);
        System.out.println(menuMonedas);
        System.out.println("---------------------------------------------");

    }

    public String leerOpcionMoneda(){
        Scanner entrada = new Scanner(System.in);
        String opcion = entrada.nextLine().toLowerCase();
        while(!menuMonedas.toLowerCase().contains(opcion)){
            System.out.println("La opción seleccionada no esta disponible");
            System.out.println("Elige una opción que sea valida");
            System.out.println("---------------------------------------------");
            opcion = entrada.nextLine().toLowerCase();

        }

        return opcion.toUpperCase();
    }

    public Double leerCantidad(){
        System.out.println("---------------------------------------------");
        System.out.println("ingrese la cantidad que desea cambiar: \n");
        System.out.println("---------------------------------------------");
        Scanner entrada = new Scanner(System.in);
        double monto;

        while (!entrada.hasNextDouble()){

            System.out.println("---------------------------------------------");
            System.out.println("Ingrese una cantidad valida");
            System.out.println("---------------------------------------------");
            entrada.nextLine();
        }

        monto = entrada.nextDouble();
        entrada.nextLine();
        return monto;
    }


    public Double montoObtenido(String monedeBase, Double montoaCambiar, Double tasaDeConversion, String monedaPrincipal){
        double resultado = montoaCambiar * tasaDeConversion;
        System.out.println("---------------------------------------------");
        System.out.println(montoaCambiar + " " + monedeBase + " equivale a: " + resultado + " "+ monedaPrincipal);
        return resultado;
    }

    public void mostrarConversiones(ArrayList<ConsumirDatos> listaDeConversion){

        if(listaDeConversion.isEmpty()){
            System.out.println("No has hecho ninguna conversion.");
        }else {
            System.out.println("Conversiones realizadas");
            
            for(int i=0; i<listaDeConversion.size();i++){
                ConsumirDatos conversion = listaDeConversion.get(i);
                System.out.println("Conversion " + (i+1) + ":");
                System.out.println("Moneda base: " + conversion.getMonedaBase());
                System.out.println("Moneda objetivo: " + conversion.getMonedaPrincipal());
                System.out.println("Cantidad a cambiar: "+ conversion.getMontoCambiar());
                System.out.println("Cantidad obtenida: " + conversion.getMontoEnMonedaPrincipal());
                System.out.println("Fecha y hora: " + formatDateTime(conversion.getDateTime()));
                System.out.println("----------------------------------------------------------------");

            }
        }
    }

    private String formatDateTime(LocalDateTime dateTime){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }
}
