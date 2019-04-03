/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

import java.util.Scanner;

public class Inventario {
    private static final int MAX_HIGH_ACUMULABLE = 64;
    private static final int MAX_LOW_ACUMULABLE = 16;
    private Scanner lec;
    private Item [] items;
    private int puntero;
    public Inventario(){
        items = new Item[7];
        lec = new Scanner(System.in);
        puntero = 0;
    }

    /**
     * metodo para añadir items al inventario
     *filtrados segun el padre el que pertenecen
     */
    public void addItem(){
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
                if (items[puntero].getCantidad() == 0){
                    items[puntero] = null;
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
                        try {
                            if (item instanceof PerlaEnder) {
                                items[puntero] = new PerlaEnder();
                            }
                        } catch (IndexOutOfBoundsException iobe) {

                        }

                        if (item instanceof Huevo) {
                            items[puntero] = new Huevo();
                        }
                    }
                }catch (IndexOutOfBoundsException iobe){
                    System.out.println("No hay espacio en el inventario...");
                    return;
                }
            }
            if (items[puntero].getCantidad() == 0){
                items[puntero] = null;
            }
        }
        else if (item instanceof ItemNoApilable){
            for (int i=0; i<cuantos; i++){
                try {
                    if (items[puntero] == null) {
                        if (item instanceof Espada){
                            items[puntero] = new Espada();
                        }
                        else if (item instanceof Pico){
                            items[puntero] = new Pico();
                        }
                    }
                    puntero = punteroApilar(item);
                }catch (IndexOutOfBoundsException iobe3){
                    System.out.println("No hay espacio en el inventario...");
                    return;
                }
            }
            try {
                if (items[puntero].getCantidad() == 0) {
                    items[puntero] = null;
                }
            }catch (NullPointerException npe5){

            }catch (IndexOutOfBoundsException iobe){

            }
        }
        System.out.print("Item apilado con exito!! intro para continuar: ");
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
                puntero = punteroBorrar(item);
                System.out.print(puntero);
                try {
                    if (items[puntero].getTipo() == item.getTipo() && items[puntero].getCantidad() < MAX_HIGH_ACUMULABLE
                    && items[puntero].getCantidad() >0){
                        items[puntero].quitarItems();
                        if (items[puntero].getCantidad() == 0) {
                            items[puntero] = null;
                        }
                    }
                    if (items[puntero].getTipo() == item.getTipo() && items[puntero].getCantidad() == MAX_HIGH_ACUMULABLE
                            && items[puntero].getCantidad() >0){
                        items[puntero].quitarItems();
                    }
                }catch (NullPointerException npe1){

                }
                catch (IndexOutOfBoundsException iobe){

                }
            }
            try {
                if (items[puntero].getCantidad() == 0) {
                    items[puntero] = null;
                }
            }catch (IndexOutOfBoundsException iobe){

            }
        }
        if (item instanceof ApilableLow){
            for (int i=0; i<cuantos; i++){
                puntero = punteroBorrar(item);
                System.out.println(puntero);
                try {
                    if (items[puntero].getTipo() == item.getTipo() && items[puntero].getCantidad() <= MAX_LOW_ACUMULABLE
                            && items[puntero].getCantidad() >0){
                        items[puntero].quitarItems();
                        if (items[puntero].getCantidad() == 0){
                            items[puntero] = null;
                        }
                    }
                }catch (NullPointerException npe1){

                }
            }
        }
        if (item instanceof ItemNoApilable){
            for (int i=0; i<cuantos; i++){
                puntero = punteroBorrar(item);
                System.out.println(puntero);
                try {
                    if (items[puntero].getTipo() == item.getTipo()){
                        items[puntero].quitarItems();
                        if (items[puntero].getCantidad() != 1){
                            items[puntero] = null;
                        }
                    }
                }catch (NullPointerException npe1){

                }catch (IndexOutOfBoundsException iobe){

                }
            }

        }
        System.out.println("Items borrados con éxito!! intro para continuar...");
        lec.nextLine();
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
                if (eleccio >= 0 && eleccio <=6){
                    esCorrecto = true;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Solo se aceptan numeros....");
                esCorrecto = true;
            }
        }while (!esCorrecto);

        //segons la eleccion del usuario se iniciara el item con el tipo correspondiente.
        switch (eleccio){
            case 1:{
                item = new Espada();
                break;
            }
            case 2:{
                item = new Huevo();;
                break;
            }
            case 3:{
                item = new Madera();
                break;
            }
            case 4:{
                item = new PerlaEnder();
                break;
            }
            case 5:{
                item = new Pico();
                break;
            }
            case 6:{
                item = new Piedra();
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
        if (item instanceof ItemApilable) {
            for (int i = 0; i < items.length; i++) {
                try {
                    if (items[i].getTipo() == item.getTipo() && items[i].getCantidad() < MAX_HIGH_ACUMULABLE && items[i].getCantidad() > 0) {
                        return i;
                    }
                } catch (NullPointerException npe) {

                }
            }
            for (int i = 0; i < items.length; i++) {
                try {
                    if (items[i].getTipo() == item.getTipo() && items[i].getCantidad() == MAX_HIGH_ACUMULABLE) {
                        return i;
                    }

                } catch (NullPointerException npe) {

                }
            }
            return 7;
        }
        else{
            for (int i = 0; i < items.length; i++) {
                try {
                    if (items[i].getTipo() == item.getTipo()) {
                        return i;
                    }
                } catch (NullPointerException npe) {

                }
            }
            return 7;
        }
    }

    public void mostrarInventario(){
        for (Item i : items){
            try {
                System.out.println(i.toString());
            }
            catch (NullPointerException npe){
                System.out.println("Null");
            }
        }
    }

}
