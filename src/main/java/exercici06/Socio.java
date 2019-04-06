/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Socio {
    private static int idSoci;
    private int iD;
    private String nif;
    private String nom;
    private GregorianCalendar dataNaiximent;
    private String poblacio;
    private ArrayList <Alquiler> alquilers;

    public Socio(String nif, String nom, GregorianCalendar dataNaiximent, String poblacio) {
        iD = ++idSoci;
        this.nif = nif;
        this.nom = nom;
        this.dataNaiximent = dataNaiximent;
        this.poblacio = poblacio;
        alquilers = new ArrayList<>();
    }

    public String getNif() {
        return nif;
    }

    public String getNom() {
        return nom;
    }

    public GregorianCalendar getDataNaiximent() {
        return dataNaiximent;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public int getEdat(){
        return calcularEdat();
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public int calcularEdat(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(dataNaiximent.toString(), fmt);
        LocalDate ara = LocalDate.now();
        Period periodo = Period.between(fechaNac, ara);
        return periodo.getYears();
    }

    @Override
    public String toString() {
        return "Socio{" +
                "nif='" + nif + '\'' +
                ", nom='" + nom + '\'' +
                ", dataNaiximent=" + dataNaiximent.get(Calendar.DAY_OF_MONTH)
                + dataNaiximent.get(Calendar.MONTH)
                + dataNaiximent.get(Calendar.YEAR) +
                ", poblacio='" + poblacio + '\'' +
                '}';
    }
}
