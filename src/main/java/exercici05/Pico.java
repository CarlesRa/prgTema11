/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

public class Pico extends ItemNoApilable {

    public Pico(String nombre, Rareza rareza,Personaje personaje, int nivelNecesario) {
        super(nombre, rareza, personaje, nivelNecesario);
    }

    public Pico() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO);
    }
}
