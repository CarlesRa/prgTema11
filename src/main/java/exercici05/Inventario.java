/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

import java.util.Arrays;
import java.util.Scanner;

public class Inventario {
    private static final int MAX_HIGH_ACUMULABLE = 64;
    private static final int MAX_LOW_ACUMULABLE = 16;
    private Scanner lec;
    private Item [] items;
    private int puntero;
    private Tipo tipoAux;
    public Inventario(){
        items = new Item[7];
        items[0] = new Madera();
        items[1] = new Piedra();
        items[2] = new Huevo();
        items[3] = new PerlaEnder();
        items[4] = new Pico();
        items[5] = new Espada();
        items[6] = new Espada();
        lec = new Scanner(System.in);
        puntero = 0;


    }

    public int addItem(){
        int eleccio = 0;
        int cuantos = 0;
        boolean esCorrecto = false;
        Item item = new Pico();
        do {
            System.out.println("¿Que tipo de item desea añadir?");
            System.out.println("1- " + Tipo.ESPADA);
            System.out.println("2- " + Tipo.HUEVO);
            System.out.println("3- " + Tipo.MADERA);
            System.out.println("4- " + Tipo.PERLA_ENDER);
            System.out.println("5- " + Tipo.PICO);
            System.out.println("6- " + Tipo.PIEDRA);
            System.out.print("Selecciona una opción: ");

            try {
                eleccio = Integer.parseInt(lec.nextLine());
                esCorrecto = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Solo se aceptan numeros....");
                esCorrecto = false;
            }

            switch (eleccio){
                case 1:{
                    item = new Espada();
                    tipoAux = Tipo.ESPADA;
                    puntero = calcularPosicion(tipoAux);
                    System.out.println(item.toString());
                    break;
                }
                case 2:{
                    item = new Huevo();
                    tipoAux = Tipo.HUEVO;
                    puntero = calcularPosicion(tipoAux);
                    System.out.println(items[puntero].toString());
                    System.out.println(item.toString());
                    break;
                }
                case 3:{
                    item = new Madera();
                    tipoAux = Tipo.MADERA;
                    puntero = calcularPosicion(tipoAux);
                    System.out.println(item.toString());
                    break;
                }
                case 4:{
                    item = new PerlaEnder();
                    tipoAux = Tipo.PERLA_ENDER;
                    puntero = calcularPosicion(tipoAux);
                    System.out.println(item.toString());

                    break;
                }
                case 5:{
                    item = new Pico();
                    tipoAux = Tipo.PICO;
                    puntero = calcularPosicion(tipoAux);
                    System.out.println(item.toString());
                    break;
                }
                case 6:{
                    item = new Piedra();
                    tipoAux = Tipo.PIEDRA;
                    puntero = calcularPosicion(tipoAux);
                    System.out.println(item.toString());
                    break;
                }
                default:{
                    System.out.println("Selección incorrecta, prueba de nuevo....");
                    esCorrecto = false;
                }
            }
        }while (!esCorrecto);
        do {
            System.out.print("¿Cuentos quieres añadir?: ");
            try {
                cuantos = Integer.parseInt(lec.nextLine());
                esCorrecto = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Solo se aceptan numeros....");
                esCorrecto = false;
            }
        }while (!esCorrecto);
        if (item instanceof ApilableTo64){
                for (int i=0; i<cuantos; i++){
                    try {
                        if (items[puntero].getCantidad() == 0) {
                            items[puntero] = item;
                        }
                    }catch (IndexOutOfBoundsException iobe){

                    }
                    try {
                        if (items[puntero].getCantidad() < MAX_HIGH_ACUMULABLE) {
                            items[puntero].setCantidad();
                            //System.out.println(items[puntero].getCantidad());
                        }
                    }catch (IndexOutOfBoundsException iobe){

                    }
                    try {
                        if (items[puntero].getCantidad() == MAX_HIGH_ACUMULABLE) {
                            puntero = calcularPosicion(item.getTipo());
                            try {
                                if (item.getTipo() == Tipo.MADERA) {
                                    items[puntero] = new Madera();
                                }
                            } catch (IndexOutOfBoundsException iobe) {

                            }
                            try {
                                if (item.getTipo() == Tipo.PIEDRA) {
                                    items[puntero] = new Piedra();
                                }
                            } catch (IndexOutOfBoundsException iobe) {

                            }
                        }
                    }catch (IndexOutOfBoundsException iobe){

                    }
                }
        }
        else if (item instanceof ApilableTo16){
            System.out.println("Me apilo de 16");
        }
        else if (item instanceof ItemNoApilable){
            System.out.println("Me apilo de 1");
        }
        for (Item i : items){
            try {
                System.out.println(i.toString());
            }
            catch (NullPointerException npe){
                System.out.println("Null");
            }
        }
        System.out.print("Intro per continuar: ");
        lec.nextLine();
        return eleccio;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "items=" + Arrays.toString(items) +
                '}';
    }

    public Item[] getItems() {
        return items;
    }

    public int calcularPosicion(Tipo tipo){
        int posicion = 0;
        for (int i=0; i<items.length; i++){
            try {
                if (items[i].getTipo() == tipo && items[i].getCantidad() < MAX_HIGH_ACUMULABLE
                || items[i] == null || items[i].getCantidad() == 0) {
                    return i;
                }
            }
            catch (NullPointerException npe){
                return i;
            }

        }
        return 7;
    }

}
