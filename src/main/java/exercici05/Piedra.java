/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

public class Piedra extends ApilableTo64 {
    public Piedra(String nombre, Rareza rareza, Personaje personaje, int nivelNecesario) {
        super(nombre, rareza,  personaje, nivelNecesario);
    }

    public Piedra() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO);
    }
}
