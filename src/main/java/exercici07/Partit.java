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
    private Estadi estadi;

    public Partit(TipusPartit tipus, LocalDate dataPartit, String equipLocal, String equipVisitant, Estadi estadi) {
        this.tipus = tipus;
        this.dataPartit = dataPartit;
        this.equipLocal = equipLocal;
        this.equipVisitant = equipVisitant;
        this.estadi = estadi;
        idPartit = ++idAutonumeric;
    }

    public int getIdPartit() {
        return idPartit;
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

    public Estadi getEstadi() {
        return estadi;
    }

    public void setEntrades(int zona, int fila, int seient){
        estadi.getZones()[zona].setSeient(fila,seient);
    }

    @Override
    public String toString() {
        return "Partit{" +
                "idPartit=" + idPartit +
                ", tipus=" + tipus +
                ", dataPartit=" + dataPartit +
                ", equipLocal='" + equipLocal + '\'' +
                ", equipVisitant='" + equipVisitant + '\'' +
                '}';
    }
}


