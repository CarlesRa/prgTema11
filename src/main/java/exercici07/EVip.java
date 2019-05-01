/*
 * Copyright (c) Carles Ramos
 */


package exercici07;
import java.util.UUID;
public class EVip extends Entrada {
    private final int PREU_BASE = 40;
    private String passWd;

    public EVip(Partit partit, char zona, int fila, int numSeient) {
        super(partit, zona, fila, numSeient);
        this.passWd = generarPassWord();
        calcularPreuEntrada(partit);
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

    public static String generarPassWord(){
        String contrasenya = UUID.randomUUID().toString();
        return "passWd = " + contrasenya;
    }

    @Override
    public String toString() {
        return super.toString() + passWd;
    }
}
