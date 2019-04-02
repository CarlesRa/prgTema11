/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

import java.util.Arrays;

public class Exercici05 {
    private Inventario inventario = new Inventario();
    public Exercici05(){
        int eleccio = 1;
        Item madera = new Madera("madera alta",Rareza.LEGENDARIO,Personaje.CREEPER,50);
        Item piedra = new Piedra();
        Item pico = new Pico();
        System.out.println(madera.toString());
        System.out.println(pico.toString());
        System.out.println(piedra.toString());
        do {
            System.out.println("Añadir");
            inventario.addItem();
            System.out.println("Borrar");
            inventario.borrarItem();

        }while (eleccio != 0);
    }
}
