/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

import java.util.Arrays;
import java.util.Scanner;

public class Inventario {
    private static final int MAX_HIGH_ACUMULABLE = 64;
    private static final int MAX_LOW_ACUMULABLE = 16;
    private static final int CANTIDAD_NO_APILABLE = 1;
    private Scanner lec;
    private Item [] items;
    private int puntero;
    private Tipo tipoAux;
    public Inventario(){
        items = new Item[7];
        items[0] = new Item();
        items[1] = new Item();
        items[2] = new Item();
        items[3] = new Item();
        items[4] = new Item();
        items[5] = new Item();
        items[6] = new Item();
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
                    puntero = calcularPosicionNoApilable(tipoAux);
                    System.out.println(item.toString());
                    break;
                }
                case 2:{
                    item = new Huevo();
                    tipoAux = Tipo.HUEVO;
                    puntero = calcularPosicion(tipoAux);
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
            for (int i=0; i<cuantos; i++){
                try {
                    if (items[puntero].getCantidad() == 0) {
                        items[puntero] = item;
                    }
                }catch (IndexOutOfBoundsException iobe){

                }
                try {
                    if (items[puntero].getCantidad() < MAX_LOW_ACUMULABLE) {
                        items[puntero].setCantidad();
                        //System.out.println(items[puntero].getCantidad());
                    }
                }catch (IndexOutOfBoundsException iobe){

                }
                try {
                    if (items[puntero].getCantidad() == MAX_LOW_ACUMULABLE) {
                        puntero = calcularPosicionApilable16(item.getTipo());
                        System.out.println(puntero);
                        try {
                            if (item.getTipo() == Tipo.PERLA_ENDER) {
                                items[puntero] = new PerlaEnder();
                            }
                        } catch (IndexOutOfBoundsException iobe) {

                        }
                        try {
                            if (item.getTipo() == Tipo.HUEVO) {
                                items[puntero] = new Huevo();
                            }
                        } catch (IndexOutOfBoundsException iobe) {

                        }
                    }
                }catch (IndexOutOfBoundsException iobe){

                }
            }
        }
        else if (item instanceof ItemNoApilable){
            for (int i=0; i<cuantos; i++){
                try {
                    if (items[puntero].getCantidad() == 0) {
                        items[puntero] = item;
                    }
                }catch (IndexOutOfBoundsException iobe){

                }
                try {
                    if (items[puntero].getCantidad() < CANTIDAD_NO_APILABLE) {
                        items[puntero].setCantidad();
                        //System.out.println(items[puntero].getCantidad());
                    }
                }catch (IndexOutOfBoundsException iobe){

                }
                try {
                    if (items[puntero].getCantidad() == CANTIDAD_NO_APILABLE) {
                        puntero = calcularPosicionNoApilable(item.getTipo());
                        System.out.println(puntero);
                        try {
                            if (item.getTipo() == Tipo.ESPADA) {
                                items[puntero] = new Espada();
                            }
                        } catch (IndexOutOfBoundsException iobe) {

                        }
                        try {
                            if (item.getTipo() == Tipo.PICO) {
                                items[puntero] = new Pico();
                            }
                        } catch (IndexOutOfBoundsException iobe) {

                        }
                    }
                }catch (IndexOutOfBoundsException iobe){

                }
            }
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
        for (int i=0; i<items.length; i++){
            try {
                if (items[i].getTipo() == tipo && items[i].getCantidad() < MAX_HIGH_ACUMULABLE
                || items[i].getCantidad() == 0) {
                    System.out.println(i);
                    return i;
                }
            }
            catch (NullPointerException npe){
                return i;
            }

        }
        return 7;
    }
    public int calcularPosicionNoApilable(Tipo tipo){
        for (int i=0; i<items.length; i++){
            try {
                if (items[i].getCantidad() == 0) {
                    return i;
                }
            }
            catch (NullPointerException npe){
                return i;
            }

        }
        return 7;
    }
    public int calcularPosicionApilable16(Tipo tipo){
        for (int i=0; i<items.length; i++){
            try {
                if (items[i].getTipo() == tipo && items[i].getCantidad() < MAX_LOW_ACUMULABLE ||items[i].getCantidad() == 0) {
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
