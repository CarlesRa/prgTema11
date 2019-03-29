/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

abstract class ItemNoApilable extends Item {
    public ItemNoApilable(String nombre, Rareza rareza, Tipo tipo, Personaje personaje, int nivelNecesario) {
        super(nombre, rareza, tipo, personaje, nivelNecesario);
    }

    public ItemNoApilable() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,TIPO_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO);
    }
}
