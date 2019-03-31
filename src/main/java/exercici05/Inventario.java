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
    private Madera madera = new Madera();
    private static int puntero;
    public Inventario(){
        items = new Item[7];
        lec = new Scanner(System.in);
        puntero = 0;

    }

    public void addItem(){
        Item item = new Madera() {
        };
        int num = 0;
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
                num = Integer.parseInt(lec.nextLine());
                esCorrecto = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Solo se aceptan numeros....");
                esCorrecto = false;
            }

            switch (num){
                case 1:{
                    item = new Espada();
                    break;
                }
                case 2:{
                    item = new Huevo();
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
                num = Integer.parseInt(lec.nextLine());
                esCorrecto = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Solo se aceptan numeros....");
                esCorrecto = false;
            }
        }while (!esCorrecto);
        if (item instanceof ApilableTo64){
                if (items[puntero] == null ){
                    items[puntero] = item;

                }
                for (int i=0; i<num; i++){
                    if (items[puntero].getCantidad() < MAX_HIGH_ACUMULABLE){
                        items[puntero].setCantidad();
                        System.out.println(items[puntero].getCantidad());
                    }
                    if (items[puntero].getCantidad() == MAX_HIGH_ACUMULABLE){
                        puntero++;
                        if (item.getTipo() == Tipo.MADERA){
                            items[puntero] = new Madera();
                            for (int z=i; z<num; z++){
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

}
