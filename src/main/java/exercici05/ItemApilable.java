/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

abstract class ItemApilable extends Item {
    protected int cantidad;
    protected static final int CANTIDAD_POR_DEFECTO = 1;

    public ItemApilable(String nombre, Rareza rareza, Personaje personaje, int nivelNecesario) {
        super(nombre, rareza, personaje, nivelNecesario);
    }

    public ItemApilable() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO);
    }

    public int getCantidad() {
        return cantidad;
    }

}

