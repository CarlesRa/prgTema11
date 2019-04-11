/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import java.time.LocalDate;

public class Alquiler implements Comparable<Alquiler>{
    private final int RECARGO_DEFECTO = 0;
    private int idProducto;
    private int idSocio;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
    private int recargo;

    public Alquiler(int idPelicula, int idSocio, LocalDate fechaAlquiler){
        this.idProducto = idPelicula;
        this.idSocio = idSocio;
        this.fechaAlquiler = fechaAlquiler;
        fechaDevolucion = null;
        recargo = RECARGO_DEFECTO;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public int getRecargo() {
        return recargo;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setRecargo(int recargo) {
        this.recargo = recargo;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "idProducto=" + idProducto +
                ", fechaAlquiler=" + fechaAlquiler +
                ", fechaDevolucion=" + fechaDevolucion +
                ", recargo=" + recargo + " Euros" +
                '}' + "\n";
    }

    @Override
    public int compareTo(Alquiler alquiler) {
        return this.fechaAlquiler.compareTo(alquiler.fechaAlquiler);
    }
}
