/*
 * Copyright (c) Carles Ramos
 */

package exercici07;

public abstract class Entrada {
    protected static final float INCREMENT_ALTA_AFLUENCIA = 1.3f;
    protected static final float DECREMENT_BAIXA_AFLUENCIA = 0.75f;
    protected static int numAuto;
    protected int numEntrada;
    protected int idPartit;
    protected int zona;
    protected int fila;
    protected int numSeient;
    protected float preuEntrada;

    public Entrada(Partit partit, int zona, int fila, int numSeient) {
        numEntrada = ++numAuto;
        this.zona = zona;
        this.fila = fila;
        this.numSeient = numSeient;
        idPartit = partit.getIdPartit();
    }

    public float getPreuEntrada() {
        return preuEntrada;
    }

    public int getNumEntrada() {
        return numEntrada;
    }

    public int getZona() {
        return zona;
    }

    public int getFila() {
        return fila;
    }

    public int getNumSeient() {
        return numSeient;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "numEntrada=" + numEntrada +
                ", idPartit=" + idPartit +
                ", zona=" + zona +
                ", fila=" + fila +
                ", numSeient=" + numSeient +
                ", preuEntrada=" + preuEntrada +
                '}';
    }

    public abstract float calcularPreuEntrada(Partit partit);
}
