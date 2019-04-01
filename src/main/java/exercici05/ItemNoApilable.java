/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

abstract class ItemNoApilable extends Item {
    protected int cantidad;
    protected static final int CANTIDAD_NO_API_DEF = 1;
    public ItemNoApilable(String nombre, Rareza rareza, Personaje personaje, int nivelNecesario, Tipo tipo) {
        super(nombre, rareza, personaje, nivelNecesario,tipo);
        this.cantidad = CANTIDAD_NO_API_DEF;
    }

    public ItemNoApilable() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,
                PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO,TIPO_POR_DEFECTO);
    }

    public int getCantidad() {
        return cantidad;
    }
}
