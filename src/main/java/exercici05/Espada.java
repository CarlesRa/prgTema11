/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

public class Espada extends ItemNoApilable {
    private Tipo tipo;
    public Espada(String nombre, Rareza rareza, Personaje personaje, int nivelNecesario) {
        super(nombre, rareza, personaje, nivelNecesario);
        tipo = Tipo.ESPADA;
    }

    public Espada() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO);
    }

    @Override
    public String toString() {
        return super.toString()+", Tipo="
                +tipo;

    }
}

