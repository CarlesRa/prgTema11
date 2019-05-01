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

    public Partit(TipusPartit tipus, LocalDate dataPartit, String equipLocal, String equipVisitant, Grada grada) {
        this.tipus = tipus;
        this.dataPartit = dataPartit;
        this.equipLocal = equipLocal;
        this.equipVisitant = equipVisitant;
        this.grada = grada;
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
                '}';
    }
}


