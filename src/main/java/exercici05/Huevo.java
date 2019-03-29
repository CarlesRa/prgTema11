/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

public class Huevo extends ItemApilable {

    public Huevo(String nombre, Rareza rareza, Tipo tipo, Personaje personaje, int nivelNecesario, int cantidad) {
        super(nombre, rareza, tipo, personaje, nivelNecesario, cantidad);
    }

    public Huevo() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,TIPO_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO,CANTIDAD_POR_DEFECTO);
    }
}
