/*
 * Copyright (c) Carles Ramos
 */

package exercici07;

public class ENormal extends Entrada {
    private int numSorteig;

    public ENormal(int numEntrada, int idPartit, char zona, int fila, int numSeient, int numSorteig) {
        super(idPartit, zona, fila, numSeient);
        this.numSorteig = numSorteig;
    }
}
