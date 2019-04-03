/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

import java.util.Scanner;

public class Exercici05 {
    private Inventario inventario = new Inventario();
    private Scanner lec = new Scanner(System.in);
    private int eleccio;
    private int cuantos;
    public Exercici05(){
        do {
            eleccio = menuPrincipal();
            switch (eleccio){
                case 1:{
                    Item item = seleccionarTipo();
                    cuantos = cuantosAnyadir();
                    inventario.addItem(item, cuantos);
                    break;
                }
                case 2:{
                    Item item = seleccionarTipo();
                    cuantos = cuantosBorrar();
                    inventario.borrarItem(item, cuantos);
                    break;
                }
                case 3:{
                    inventario.mostrarInventario();
                    break;
                }
                case 0:{
                    break;
                }
                default:{
                    System.out.println("Seleccion incorrecta...");
                    break;
                }
            }
        }while (eleccio != 0);
    }
    public int menuPrincipal(){
        int eleccio2 = 0;
        System.out.println("***////*MINECRAFT*////***");
        System.out.println("1- Anyadir al inventario");
        System.out.println("2- Eliminar del inventario");
        System.out.println("3- Mostrar inventario");
        System.out.println("0- Salir....");
        System.out.println("**************************");
        System.out.print("Selecciona una opcion: ");
        try{
            eleccio2 = Integer.parseInt(lec.nextLine());
        }
        catch (NumberFormatException nfe){
            System.out.println("sole se aceptan numero nene....");
            return 8;
        }
        return eleccio2;
    }

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
                esCorrecto = false;
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
                break;

            }
        }
        return item;
    }
    public int cuantosAnyadir(){
        int cuantos = 0;
        boolean esCorrecto = false;
        /* Item item = seleccionarTipo();*/

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
        return cuantos;
    }

    public int cuantosBorrar(){
        int cuantos = 0;
        boolean esCorrecto = false;
        /* Item item = seleccionarTipo();*/

        do {
            System.out.print("¿Cuentos quieres borrar?: ");
            try {
                cuantos = Integer.parseInt(lec.nextLine());
                esCorrecto = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Solo se aceptan numeros....");
                esCorrecto = false;
            }
        }while (!esCorrecto);
        return cuantos;
    }

}
