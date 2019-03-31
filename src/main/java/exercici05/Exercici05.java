/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

import java.util.Arrays;

public class Exercici05 {
    private Inventario inventario = new Inventario();
    public Exercici05(){
        int eleccio = 0;
        Item madera = new Madera("madera alta",Rareza.LEGENDARIO,Personaje.CREEPER,50);
        Item piedra = new Piedra();
        Item pico = new Pico();
        System.out.println(madera.toString());
        System.out.println(pico.toString());
        System.out.println(piedra.toString());
        do {
            eleccio = inventario.addItem();
        }while (eleccio != 0);
        for (Item i : inventario.getItems()){
            try {
                System.out.println(i.toString());
            }
            catch (NullPointerException npe){
                System.out.println("Null");
            }
        }
    }
}
