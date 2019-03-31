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
    private static int puntero;
    public Inventario(){
        items = new Item[7];
        /*items[0] = new Madera();
        items[1] = new Piedra();
        items[2] = new Huevo();
        items[3] = new PerlaEnder();
        items[4] = new Pico();
        items[5] = new Espada();*/
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
                    puntero = calcularPosicion(item.getTipo());
                    items[puntero] = new Espada();
                    System.out.println(items[puntero].toString());
                    break;
                }
                case 2:{
                    item = new Huevo();
                    puntero = calcularPosicion(item.getTipo());
                    items[puntero] = new Huevo();
                    System.out.println(items[puntero].toString());
                    break;
                }
                case 3:{
                    item = new Madera();
                    puntero = calcularPosicion(item.getTipo());
                    items[puntero] = new Madera();
                    System.out.println(items[puntero].toString());
                    break;
                }
                case 4:{
                    item = new PerlaEnder();
                    puntero = calcularPosicion(item.getTipo());
                    items[puntero] = new PerlaEnder();
                    System.out.println(items[puntero].toString());
                    break;
                }
                case 5:{
                    item = new Pico();
                    puntero = calcularPosicion(item.getTipo());
                    items[puntero] = new Pico();
                    System.out.println(items[puntero].toString());
                    break;
                }
                case 6:{
                    item = new Piedra();
                    puntero = calcularPosicion(item.getTipo());
                    items[puntero] = new Piedra();
                    System.out.println(items[puntero].toString());
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
                    if (items[puntero].getCantidad() < MAX_HIGH_ACUMULABLE){
                        items[puntero].setCantidad();
                        //System.out.println(items[puntero].getCantidad());
                    }
                    if (items[puntero].getCantidad() == MAX_HIGH_ACUMULABLE){
                        puntero = calcularPosicion(item.getTipo());
                        if (item.getTipo() == Tipo.MADERA){
                            items[puntero] = new Madera();
                            for (int z=i; z<cuantos; z++){
                                items[puntero].setCantidad(0);
                            }
                        }
                        if (item.getTipo() == Tipo.PIEDRA){
                            items[puntero] = new Piedra();
                            for (int z=i; z<cuantos; z++){
                                items[puntero].setCantidad(0);
                            }
                        }
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

    public void apilarItems(int cantidad){
        //TODO metode per a buscar lloc i apilar
    }

    public int calcularPosicion(Tipo tipo){
        int posicion = 0;
        for (int i=0; i<items.length; i++){
            try {
                if (items[i].getTipo() == tipo && items[i].getCantidad() < MAX_HIGH_ACUMULABLE) {
                    return i;
                }
                else if (items[i].getCantidad() == 0){
                    return i;
                }
            }
            catch (NullPointerException npe){
                return i;
            }
        }
        return posicion;
    }

}
