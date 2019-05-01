/*
 * Copyright (c) Carles Ramos
 */


package exercici07;
import java.util.UUID;
public class EVip extends Entrada {
    private final int PREU_BASE = 40;
    private String passWd;

    public EVip(Partit partit, int zona, int fila, int numSeient) {
        super(partit, zona, fila, numSeient);
        this.passWd = generarPassWord();
        preuEntrada = calcularPreuEntrada(partit);
    }

    @Override
    public float calcularPreuEntrada(Partit partit) {
        float preu = 0;
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

    public static String generarPassWord(){
        String contrasenya = UUID.randomUUID().toString();
        return "passWd = " + contrasenya;
    }

    @Override
    public String toString() {
        return super.toString() + passWd;
    }
}
