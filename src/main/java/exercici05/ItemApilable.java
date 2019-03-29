/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

abstract class ItemApilable extends Item {
    private int cantidad;
    protected static final int CANTIDAD_POR_DEFECTO = 1;

    public ItemApilable(String nombre, Rareza rareza, Tipo tipo, Personaje personaje, int nivelNecesario, int cantidad) {
        super(nombre, rareza, tipo, personaje, nivelNecesario);
        this.cantidad = cantidad;
    }

    public ItemApilable() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,TIPO_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO,CANTIDAD_POR_DEFECTO);
    }

    public int getCantidad() {
        return cantidad;
    }

}

