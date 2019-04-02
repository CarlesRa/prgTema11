/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

abstract class ItemApilable extends Item {
    protected int cantidad;

    public ItemApilable(String nombre, Rareza rareza, Personaje personaje, int nivelNecesario, Tipo tipo) {
        super(nombre, rareza, personaje, nivelNecesario,tipo);
    }

    public ItemApilable() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO,TIPO_POR_DEFECTO);
    }

    public int getCantidad() {
        return cantidad;
    }

}

