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
    private static final int ID_BASE = 0;
    private static int idSoci = ID_BASE;
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

    public int getiD() {
        return iD;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public ArrayList<Alquiler> getAlquilers() {
        return alquilers;
    }

    public int getZiceAlquilers(){
        return alquilers.size();
    }

    public Alquiler getUltimoAlquiler(){
        return alquilers.get(alquilers.size() - 1);
    }

    /**
     * calcula la edad del socio segun la fecha de nacimiento
     * @return
     */
    private  int calcularEdat(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaNac = LocalDate.parse(dataNaiximent.toString(), fmt);
        LocalDate ara = LocalDate.now();
        Period periodo = Period.between(fechaNac, ara);
        return periodo.getYears();
    }

    @Override
    public String toString() {
        return "Socio" +
                "id=" + iD +
                ", nif='" + nif + '\'' +
                ", nom='" + nom + '\'' +
                ", dataNaiximent=" + dataNaiximent.get(Calendar.DAY_OF_MONTH)+ "-"
                +  dataNaiximent.get(Calendar.MONTH) + "-" +
                + dataNaiximent.get(Calendar.YEAR) +
                ", poblacio='" + poblacio + '\'' +
                "\n" +alquilers.toString()+"\n";
    }

    /**
     * metodo para imprimir solo el socio sin mostrar el alquiler
     * @return
     */
    public String mostrarSocio() {
        return "Socio " +
                "id=" + iD +
                ", nif='" + nif + '\'' +
                ", nom='" + nom + '\'' +
                ", dataNaiximent=" + dataNaiximent.get(Calendar.DAY_OF_MONTH)+ "-"
                +  dataNaiximent.get(Calendar.MONTH) + "-" +
                + dataNaiximent.get(Calendar.YEAR) +
                ", poblacio='" + poblacio + '\'' +
                "\n";
    }
}
