/*
 * Copyright (c) Carles Ramos
 */

package exercici07;

public class EVip extends Entrada {
    private String passWd;

    public EVip(int numEntrada, int idPartit, char zona, int fila, int numSeient, String passWd) {
        super(idPartit, zona, fila, numSeient);
        this.passWd = passWd;
    }
}
