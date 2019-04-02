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
                            puntero = posicionApilableHi(item.getTipo());
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
                }catch (IndexOutOfBoundsException iobe1){
                    System.out.println("No hay espacio en el inventario...");
                    return;
                }
                try {
                    if (items[puntero].getCantidad() == MAX_LOW_ACUMULABLE) {
                        puntero = posicionApilableLow(item.getTipo());
                        System.out.println(puntero);

                            if (item.getTipo() == Tipo.PERLA_ENDER) {
                                items[puntero] = new PerlaEnder();
                            }


                            if (item.getTipo() == Tipo.HUEVO) {
                                items[puntero] = new Huevo();
                            }
                    }
                }catch (IndexOutOfBoundsException iobe2){
                    System.out.println("No hay espacio en el inventario...");
                    return;
                }
            }
        }
        else if (item instanceof ItemNoApilable){
            for (int i=0; i<cuantos; i++){
                if (items[puntero] == null){
                    items[puntero] = item;
                }
                puntero = posicionNoApilable(tipoAux);
                System.out.println(puntero);
                try {
                    if (items[i].getCantidad() == 0) {
                        items[puntero] = item;
                    }
                }catch (IndexOutOfBoundsException iobe3){
                    System.out.println("No hay espacio en el inventario...");
                }
                try {
                    if (item.getCantidad() == CANTIDAD_NO_APILABLE) {
                        puntero = posicionNoApilable(item.getTipo());
                        items[puntero] = item;
                    }
                } catch (IndexOutOfBoundsException iobe) {
                    System.out.println("No hay espacio en el inventario...");
                    return;
                }
                try {
                    if (item.getTipo() == Tipo.PICO) {
                        items[puntero] = new Pico();
                    }
                } catch (IndexOutOfBoundsException iobe) {
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
    public Item[] getItems() {
        return items;
    }
    public int posicionApilableHi(Tipo tipo){
        for (int i=0; i<items.length; i++){
            try {
                if (items[i] == null || items[i].getTipo() == tipo && items[i].getCantidad() < MAX_HIGH_ACUMULABLE) {
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

    public int posicionApilableLow(Tipo tipo){
        for (int i=0; i<items.length; i++){
            try {
                if (items[i].getCantidad() == 0 || items[i].getTipo() == tipo
                        && items[i].getCantidad() < MAX_LOW_ACUMULABLE ) {
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

    public int posicionNoApilable(Tipo tipo){
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
        return 7;
    }

    public void borrarItem(){
        int seleccion;
        Item item = seleccionarTipo();

    }

    public Item seleccionarTipo(){
        Item item = new Pico();
        int eleccio = 0;
        boolean esCorrecto = false;
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
            //segons la eleccion del usuario se iniciara el item con el tipo correspondiente

        }while (!esCorrecto);
        switch (eleccio){
            case 1:{
                item = new Espada();
                tipoAux = Tipo.ESPADA;
                break;
            }
            case 2:{
                item = new Huevo();
                tipoAux = Tipo.HUEVO;
                puntero = posicionApilableHi(tipoAux);
                System.out.println(item.toString());
                break;
            }
            case 3:{
                item = new Madera();
                tipoAux = Tipo.MADERA;
                puntero = posicionApilableHi(tipoAux);
                System.out.println(item.toString());
                break;
            }
            case 4:{
                item = new PerlaEnder();
                tipoAux = Tipo.PERLA_ENDER;
                puntero = posicionApilableHi(tipoAux);
                System.out.println(item.toString());

                break;
            }
            case 5:{
                item = new Pico();
                tipoAux = Tipo.PICO;
                puntero = posicionApilableHi(tipoAux);
                System.out.println(item.toString());
                break;
            }
            case 6:{
                item = new Piedra();
                tipoAux = Tipo.PIEDRA;
                puntero = posicionApilableHi(tipoAux);
                System.out.println(item.toString());
                break;
            }
            default:{
                System.out.println("Selección incorrecta, prueba de nuevo....");

            }
        }
        return item;
    }

}
