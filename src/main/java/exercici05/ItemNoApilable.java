/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

abstract class ItemNoApilable extends Item {
    protected int cantidad;
    protected static final int CANTIDAD_NO_API_DEF = 1;
    public ItemNoApilable(String nombre, Rareza rareza, Personaje personaje, int nivelNecesario) {
        super(nombre, rareza, personaje, nivelNecesario);

    }

    public ItemNoApilable() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO);
    }

    public int getCantidad() {
        return cantidad;
    }
}
