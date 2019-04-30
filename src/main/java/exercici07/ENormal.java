/*
 * Copyright (c) Carles Ramos
 */

package exercici07;

public class ENormal extends Entrada {
    private final int PREU_BASE = 30;
    private int numSorteig;

    public ENormal(Partit partit, char zona, int fila, int numSeient) {
        super(partit, zona, fila, numSeient);
        numSorteig = numEntrada;
    }

    @Override
    public void calcularPreuEntrada(Partit partit) {
        if (partit.getTipus() == TipusPartit.ALTA_AFLUENCIA){
            preuEntrada = PREU_BASE * INCREMENT_ALTA_AFLUENCIA;
        }
        else if (partit.getTipus() == TipusPartit.BAIXA_AFLUENCIA){
            preuEntrada = PREU_BASE * INCREMENT_BAIXA_AFLUENCIA;
        }
        else{
            preuEntrada = PREU_BASE;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Numero sorteig= " + numSorteig;
    }
}
