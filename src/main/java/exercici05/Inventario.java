/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Inventario {
    private static final int MAX_HIGH_ACUMULABLE = 64;
    private static final int MAX_LOW_ACUMULABLE = 16;
    private Scanner lec;
    private Item [] items;
    private Madera madera = new Madera();
    public Inventario(){
        items = new Item[7];
        lec = new Scanner(System.in);

    }

    public void addItem(){
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
                    Item item = new Espada();
                    break;
                }
                case 2:{
                    Item item = new Huevo();
                    break;
                }
                case 3:{
                    Item item = new Madera();
                    break;
                }
                case 4:{
                    Item item = new PerlaEnder();
                    break;
                }
                case 5:{
                    Item item = new Pico();
                    break;
                }
                case 6:{
                    Item item = new Piedra();
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
