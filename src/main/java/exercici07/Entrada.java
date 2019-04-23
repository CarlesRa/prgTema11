/*
 * Copyright (c) Carles Ramos
 */

package exercici07;

public abstract class Entrada {
    protected static int numAuto;
    protected int numEntrada;
    protected int idPartit;
    protected char zona;
    protected int fila;
    protected int numSeient;

    public Entrada(int idPartit, char zona, int fila, int numSeient) {
        numEntrada = ++numAuto;
        this.idPartit = idPartit;
        this.zona = zona;
        this.fila = fila;
        this.numSeient = numSeient;
    }
}
