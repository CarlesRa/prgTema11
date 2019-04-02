/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

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
        lec = new Scanner(System.in);
        puntero = 0;
    }

    /**
     * metodo para añadir items al inventario
     *
     */
    public void addItem(){
        int eleccio = 0;
        int cuantos = 0;
        boolean esCorrecto = false;
        Item item = seleccionarTipo();
        puntero = punteroApilar(item);
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
        if (item instanceof ApilableHi){
                for (int i=0; i<cuantos; i++){
                    try {
                        if (items[puntero] == null) {
                            items[puntero] = item;
                        }

                    }catch (IndexOutOfBoundsException iobe){

                    }
                    try {
                        if (items[puntero].getCantidad() < MAX_HIGH_ACUMULABLE) {
                            items[puntero].setCantidad();
                        }
                    }catch (IndexOutOfBoundsException iobe){

                    }
                    try {
                        if (items[puntero].getCantidad() == MAX_HIGH_ACUMULABLE) {
                            puntero = punteroApilar(item);
                            System.out.println(puntero);
                            try {
                                if (item.getTipo() == Tipo.MADERA) {
                                    items[puntero] = new Madera();
                                }
                            } catch (IndexOutOfBoundsException iobe) {

                            }

                                if (item.getTipo() == Tipo.PIEDRA) {
                                    items[puntero] = new Piedra();
                                }
                        }
                    }catch (IndexOutOfBoundsException iobe){
                        System.out.println("No hay espacio en el inventario...");
                        return;
                    }
                }
        }
        else if (item instanceof ApilableLow){
            for (int i=0; i<cuantos; i++){
                try {
                    if (items[puntero] == null) {
                        items[puntero] = item;
                    }

                }catch (IndexOutOfBoundsException iobe){

                }
                try {
                    if (items[puntero].getCantidad() < MAX_LOW_ACUMULABLE) {
                        items[puntero].setCantidad();
                    }
                }catch (IndexOutOfBoundsException iobe){

                }
                try {
                    if (items[puntero].getCantidad() == MAX_LOW_ACUMULABLE) {
                        puntero = punteroApilar(item);
                        System.out.println(puntero);
                        try {
                            if (item.getTipo() == Tipo.PERLA_ENDER) {
                                items[puntero] = new PerlaEnder();
                            }
                        } catch (IndexOutOfBoundsException iobe) {

                        }

                        if (item.getTipo() == Tipo.HUEVO) {
                            items[puntero] = new Huevo();
                        }
                    }
                }catch (IndexOutOfBoundsException iobe){
                    System.out.println("No hay espacio en el inventario...");
                    return;
                }
            }
        }
        else if (item instanceof ItemNoApilable){
            for (int i=0; i<cuantos; i++){
                try {
                    if (items[puntero] == null) {
                        items[puntero] = item;
                    }
                }catch (IndexOutOfBoundsException iobe4){
                    System.out.println("No hay espacio en el inventario...");
                    return;
                }
                puntero = punteroApilar(item);
                System.out.println(puntero);
                try {
                    if (items[i].getCantidad() == 0) {
                        items[puntero] = item;
                    }
                }catch (IndexOutOfBoundsException iobe3){
                    System.out.println("No hay espacio en el inventario...");
                    return;
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
    }




    public void borrarItem(){
        int cuantos = 0;
        boolean esCorrecto = false;
        Item item = seleccionarTipo();
        puntero = punteroBorrar(item);
        do {
            System.out.print("¿Cuentos quieres quieres quitar?: ");
            try {
                cuantos = Integer.parseInt(lec.nextLine());
                esCorrecto = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Solo se aceptan numeros....");
                esCorrecto = false;
            }
        }while (!esCorrecto);
        if (item instanceof ApilableHi){
            for (int i=0; i<cuantos; i++){
                try {
                    if (items[puntero].getTipo() == item.getTipo() && items[puntero].getCantidad() <= MAX_HIGH_ACUMULABLE
                    && items[puntero].getCantidad() >0){
                        items[puntero].quitarItems();
                    }
                }catch (NullPointerException npe1){

                }
            }
            if (items[puntero].getCantidad() == 0){
                items[puntero] = null;
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
    }
    //pide al usuario el tipo de item con el que desea trabajar.
    public Item seleccionarTipo(){
        Item item = new Pico();
        int eleccio = 0;
        boolean esCorrecto = false;
        do {
            System.out.println("¿Que tipo de item desea?");
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
        }while (!esCorrecto);

        //segons la eleccion del usuario se iniciara el item con el tipo correspondiente.
        switch (eleccio){
            case 1:{
                item = new Espada();
                tipoAux = Tipo.ESPADA;
                break;
            }
            case 2:{
                item = new Huevo();
                tipoAux = Tipo.HUEVO;
                System.out.println(item.toString());
                break;
            }
            case 3:{
                item = new Madera();
                tipoAux = Tipo.MADERA;
                System.out.println(item.toString());
                break;
            }
            case 4:{
                item = new PerlaEnder();
                tipoAux = Tipo.PERLA_ENDER;
                System.out.println(item.toString());

                break;
            }
            case 5:{
                item = new Pico();
                tipoAux = Tipo.PICO;
                System.out.println(item.toString());
                break;
            }
            case 6:{
                item = new Piedra();
                tipoAux = Tipo.PIEDRA;
                System.out.println(item.toString());
                break;
            }
            default:{
                System.out.println("Selección incorrecta, prueba de nuevo....");

            }
        }
        return item;
    }

    public int punteroApilar(Item item){
        if (item instanceof ApilableHi){
            for (int i=0; i<items.length; i++){
                try {
                    if (items[i] == null || items[i].getTipo() == item.getTipo()
                            && items[i].getCantidad() < MAX_HIGH_ACUMULABLE) {
                        System.out.println(i);
                        return i;
                    }
                }
                catch (NullPointerException npe){
                    return i;
                }

            }
        }
        else if (item instanceof ApilableLow){
            for (int i=0; i<items.length; i++){
                try {
                    if (items[i] == null || items[i].getTipo() == item.getTipo()
                            && items[i].getCantidad() < MAX_LOW_ACUMULABLE) {
                        System.out.println(i);
                        return i;
                    }
                }
                catch (NullPointerException npe){
                    return i;
                }

            }
        }
        else if (item instanceof ItemNoApilable){
            for (int i=0; i<items.length; i++){
                try {
                    if (items[i] == null){
                        return i;
                    }
                }
                catch (NullPointerException npe){
                    return i;
                }

            }
        }
        return 7;
    }
    public int punteroBorrar(Item item){
        System.out.println(item.toString());
        for (int i=0; i<items.length; i++){
            try {
                if (items[i].getTipo() == item.getTipo() && items[i].getCantidad() < MAX_HIGH_ACUMULABLE) {
                    System.out.println(i);
                    return i;
                }
                else if(items[i].getTipo() == item.getTipo() && items[i].getCantidad() == MAX_HIGH_ACUMULABLE){
                    System.out.println(i);
                    return i;
                }

            }
            catch (NullPointerException npe){

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
        return 0;
    }

}
