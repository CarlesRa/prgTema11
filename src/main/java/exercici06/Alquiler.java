/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Alquiler {
    private String nombrePelicula;
    private Calendar fechaAlquiler;
    private Calendar fechaDevolucion;
    private float recargo;

    public Alquiler(String nombrePelicula, Calendar fechaAlquiler){
        this.nombrePelicula = nombrePelicula;
        this.fechaAlquiler = fechaAlquiler;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public Calendar getFechaAlquiler() {
        return fechaAlquiler;
    }

    public Calendar getFechaDevolucion() {
        return fechaDevolucion;
    }

    public float getRecargo() {
        return recargo;
    }

    public void setFechaAlquiler(GregorianCalendar fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void setFechaDevolucion(GregorianCalendar fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setRecargo(float recargo) {
        this.recargo = recargo;
    }

    public float calcularRecargo(){
        float recargo = 0;
        return recargo;
        //TODO calcular el recargo
    }
}
