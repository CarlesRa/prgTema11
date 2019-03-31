/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

abstract class ApilableTo64 extends ItemApilable {

    public ApilableTo64(String nombre, Rareza rareza, Personaje personaje, int nivelNecesario) {
        super(nombre, rareza,personaje, nivelNecesario);
    }

    public ApilableTo64() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO);
    }
}
