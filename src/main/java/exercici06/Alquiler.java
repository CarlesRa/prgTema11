/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import java.time.LocalDate;

public class Alquiler {
    private int idProducto;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
    private float recargo;

    public Alquiler(int idPelicula, LocalDate fechaAlquiler){
        this.idProducto = idPelicula;
        this.fechaAlquiler = fechaAlquiler;
        fechaDevolucion = null;
        recargo = 0;
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

    /*public float calcularRecargo(){
        float recargo = 0;
        return recargo;
        //TODO calcular el recargo
    }*/

    @Override
    public String toString() {
        return "Alquiler{" +
                "idProducto=" + idProducto +
                ", fechaAlquiler=" + fechaAlquiler +
                ", fechaDevolucion=" + fechaDevolucion +
                ", recargo=" + recargo +
                '}';
    }
}
