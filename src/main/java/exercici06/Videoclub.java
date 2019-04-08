/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Videoclub {
    private ArrayList <Multimedia> listadoMultimedia;
    private ArrayList <Socio> listadoSocios;

    public Videoclub(){
        listadoMultimedia = new ArrayList<>();
        listadoSocios = new ArrayList<>();
    }

    public void registrarMultimedia(Multimedia multimedia){
        listadoMultimedia.add(multimedia);
    }

    public void registrarSocio(Socio socio){
        listadoSocios.add(socio);
    }

    public void alquilarPelicula(){
        //Un soci no pot llogar si te recarregs
    }

    public void recogerPelicula(){

    }

    public int calcularRecargo(Socio socio){
        int resultado = 0;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaAlquiler = socio.getAlquilers().get(socio.alquilersSize()-1).getFechaAlquiler();
        LocalDate fechaDevolucion = socio.getAlquilers().get(socio.alquilersSize()-1).getFechaDevolucion();
        Period periodo = Period.between(fechaAlquiler, fechaDevolucion);
        if (periodo.getDays() > 3){
            resultado = (periodo.getDays() - 3) * 2;
        }
        return resultado;
    }
}
