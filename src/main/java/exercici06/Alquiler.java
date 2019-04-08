/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Alquiler {
    private String nombrePelicula;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
    private float recargo;

    public Alquiler(String nombrePelicula, LocalDate fechaAlquiler){
        this.nombrePelicula = nombrePelicula;
        this.fechaAlquiler = fechaAlquiler;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public float getRecargo() {
        return recargo;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
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
