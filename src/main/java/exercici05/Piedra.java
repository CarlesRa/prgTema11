/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

public class Piedra extends ApilableHi {
    public Piedra(String nombre, Rareza rareza, Personaje personaje, int nivelNecesario) {
        super(nombre, rareza,  personaje, nivelNecesario,Tipo.PIEDRA);
    }

    public Piedra() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO);
    }

    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(){
        cantidad += 1;
    }
    @Override
    public String toString() {
        return super.toString() +
                "tipo=" + tipo +
                ", cantidad=" + cantidad;
    }

    @Override
    public void quitarItems() {
        cantidad = cantidad - 1;
    }
}
