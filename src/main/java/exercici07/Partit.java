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

    public Partit(TipusPartit tipus, LocalDate dataPartit, String equipLocal, String equipVisitant) {
        this.tipus = tipus;
        this.dataPartit = dataPartit;
        this.equipLocal = equipLocal;
        this.equipVisitant = equipVisitant;
        idPartit = ++idAutonumeric;
    }
}


