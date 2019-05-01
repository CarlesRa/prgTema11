/*
 * Copyright (c) Carles Ramos
 */

package exercici07;

import java.time.LocalDate;

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

    }

    public int getIdPartit() {
        return idPartit;
    }

    public void setRecaudacio(float recaudacio) {
        this.recaudacio += recaudacio;
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

    public Grada getGrada() {
        return grada;
    }

    public boolean setSeient(int zona, int fila, int seient){
        try {
            grada.getZones()[zona].setSeient(fila, seient);
            return true;
        }
        catch (IndexOutOfBoundsException iobe){
            System.out.println("Dades incorrectes, revise el planol de les grades");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Partit{" +
                "idPartit=" + idPartit +
                ", tipus=" + tipus +
                ", dataPartit=" + dataPartit +
                ", equipLocal='" + equipLocal + '\'' +
                ", equipVisitant='" + equipVisitant + '\'' +
                 ", entrades LLiures=" + entradesLliures + '}';
    }
}


