/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

abstract class ApilableLow extends ItemApilable{

    public ApilableLow(String nombre, Rareza rareza, Personaje personaje, int nivelNecesario, Tipo tipo) {
        super(nombre, rareza,  personaje, nivelNecesario, tipo);
    }

    public ApilableLow() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO,TIPO_POR_DEFECTO);
    }
}
