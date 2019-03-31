/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

abstract class ApilableTo16 extends ItemApilable{

    public ApilableTo16(String nombre, Rareza rareza,Personaje personaje, int nivelNecesario) {
        super(nombre, rareza,  personaje, nivelNecesario);
    }

    public ApilableTo16() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO);
    }
}
