/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

public class Madera extends ApilableTo64 {
    private int cantidad;
    public Madera(String nombre, Rareza rareza, Personaje personaje, int nivelNecesario) {
        super(nombre, rareza, personaje, nivelNecesario,Tipo.MADERA);

    }

    public Madera() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO);
    }

    public Madera(int cantidad) {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO);
        this.cantidad = cantidad;
    }


    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(){
        cantidad += 1;
    }
    public void setCantidad(int cantidad){
        this.cantidad += cantidad;
    }

    @Override
    public String toString() {
        return super.toString() +
                "tipo=" + tipo +
                ", cantidad=" + cantidad;
    }
}
