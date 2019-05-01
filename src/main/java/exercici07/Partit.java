/*
 * Copyright (c) Carles Ramos
 */

package exercici07;

import java.time.LocalDate;
import java.util.ArrayList;

public class Partit {
    private static int idAutonumeric;
    private int idPartit;
    private TipusPartit tipus;
    private LocalDate dataPartit;
    private String equipLocal;
    private String equipVisitant;
    private Grada grada;
    private int entradesLliures;
    private int entradesTotals;
    private float recaudacio;
    private ArrayList<Entrada> entradesVenudes;
    public Partit(TipusPartit tipus, LocalDate dataPartit, String equipLocal, String equipVisitant, Grada grada
    , int entradesTotals) {
        this.tipus = tipus;
        this.dataPartit = dataPartit;
        this.equipLocal = equipLocal;
        this.equipVisitant = equipVisitant;
        this.grada = grada;
        idPartit = ++idAutonumeric;
        this.entradesTotals = entradesTotals;
        entradesLliures = entradesTotals;
        recaudacio = 0;
        entradesVenudes = new ArrayList<>();
    }

    public ArrayList<Entrada> getEntradesVenudes() {
        return entradesVenudes;
    }

    public int getIdPartit() {
        return idPartit;
    }

    public void sumarRecaudacio(float recaudacio) {
        this.recaudacio += recaudacio;
    }

    public void restarRecaudacio(float recaudacio){
        this.recaudacio -= recaudacio;
    }

    public TipusPartit getTipus() {
        return tipus;
    }

    public LocalDate getDataPartit() {
        return dataPartit;
    }

    public String getEquipLocal() {
        return equipLocal;
    }

    public String getEquipVisitant() {
        return equipVisitant;
    }

    public void descomptarEntrada() {
        entradesLliures--;
    }

    public void comptarEntrada() {
        entradesLliures++;
    }

    public int getEntradesLliures() {
        return entradesLliures;
    }

    public int getEntradesTotals() {
        return entradesTotals;
    }

    public float getRecaudacio() {
        return recaudacio;
    }

    public Grada getGrada() {
        return grada;
    }

    public boolean setSeientOcupat(int zona, int fila, int seient){
            grada.getZones()[zona].setSeientOcupat(fila, seient);
            return true;
    }

    public boolean setSeientLliure(int zona,int fila, int seient){
            grada.getZones()[zona].setSeientLiure(fila, seient);
            return true;
    }
    @Override
    public String toString() {
        return "Partit{" +
                "idPartit=" + idPartit +
                ", tipus=" + tipus +
                ", data Partit=" + dataPartit +
                ", equi pLocal='" + equipLocal + '\'' +
                ", equip Visitant='" + equipVisitant + '\'' +
                 ", entrades LLiures=" + entradesLliures + '}';
    }
}


