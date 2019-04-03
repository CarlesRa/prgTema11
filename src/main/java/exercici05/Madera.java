/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

public class Madera extends ApilableHi {
    public Madera(String nombre, Rareza rareza, Personaje personaje, int nivelNecesario) {
        super(nombre, rareza, personaje, nivelNecesario,Tipo.MADERA);

    }

    public Madera() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO);
    }

    @Override
    public void setCantidad(){
        cantidad += 1;
    }

    @Override
    public void quitarItems() {
        cantidad = cantidad - 1;
    }

    @Override
    public String toString() {
        return super.toString() +
                "tipo=" + tipo +
                ", cantidad=" + cantidad;
    }
}
