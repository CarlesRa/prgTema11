/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

public class PerlaEnder extends ApilableLow {
    private Tipo tipo;
    public PerlaEnder(String nombre, Rareza rareza, Personaje personaje, int nivelNecesario) {
        super(nombre, rareza, personaje, nivelNecesario,Tipo.PERLA_ENDER);
        tipo = Tipo.PERLA_ENDER;
    }

    public PerlaEnder() {
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
}
