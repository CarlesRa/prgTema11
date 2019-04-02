/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

public class Pico extends ItemNoApilable {
    private Tipo tipo;
    public Pico(String nombre, Rareza rareza,Personaje personaje, int nivelNecesario) {
        super(nombre, rareza, personaje, nivelNecesario,Tipo.PICO);
        tipo = Tipo.PICO;
    }

    public Pico() {
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO);
    }

    public int getCantidad(){
        return cantidad;
    }

    @Override
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
