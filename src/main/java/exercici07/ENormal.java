/*
 * Copyright (c) Carles Ramos
 */

package exercici07;

public class ENormal extends Entrada {
    private final int PREU_BASE = 30;
    private int numSorteig;

    public ENormal(Partit partit, int zona, int fila, int numSeient) {
        super(partit, zona, fila, numSeient);
        preuEntrada = calcularPreuEntrada(partit);
        numSorteig = numEntrada;
    }

    @Override
    public float calcularPreuEntrada(Partit partit) {
        float preu;
        if (partit.getTipus() == TipusPartit.ALTA_AFLUENCIA){
            preu = PREU_BASE * INCREMENT_ALTA_AFLUENCIA;
        }
        else if (partit.getTipus() == TipusPartit.BAIXA_AFLUENCIA){
            preu = PREU_BASE * DECREMENT_BAIXA_AFLUENCIA;
        }
        else{
            preu = PREU_BASE;
        }
        return preu;
    }

    @Override
    public String toString() {
        return super.toString() + " Numero sorteig= " + numSorteig;
    }
}
