/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

import java.util.Scanner;

public class Exercici05 {
    private Inventario inventario = new Inventario();
    private Scanner lec = new Scanner(System.in);
    private int eleccio;
    public Exercici05(){
        do {
            eleccio = menuPrincipal();
            switch (eleccio){
                case 1:{
                    inventario.addItem();
                    break;
                }
                case 2:{
                    inventario.borrarItem();
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
}
