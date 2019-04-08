/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import utils.Lib;

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

    public void alquilarMultimedia(LocalDate fechaAlquiler, int idMultimedia, int posicionSocio){
        Alquiler alquiler;
        if (listadoSocios.get(posicionSocio).getAlquilers().get(listadoSocios.get(posicionSocio).sizeAlquilers()-1)
        .getRecargo() > 0){
            System.out.println("Existen recargos, no es posible el alquiler para este socio...");
            Lib.continuar();
            return;
        }
        else{
            alquiler = new Alquiler(idMultimedia,fechaAlquiler);
        }
    }

    public void recogerMultimedia(){

    }

    public ArrayList<Socio> getListadoSocios() {
        return listadoSocios;
    }

    public ArrayList<Multimedia> getListadoMultimedia() {
        return listadoMultimedia;
    }

    public int calcularRecargo(Socio socio){
        int resultado = 0;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaAlquiler = socio.getAlquilers().get(socio.getAlquilers().size()-1).getFechaAlquiler();
        LocalDate fechaDevolucion = socio.getAlquilers().get(socio.getAlquilers().size()-1).getFechaDevolucion();
        Period periodo = Period.between(fechaAlquiler, fechaDevolucion);
        if (periodo.getDays() > 3){
            resultado = (periodo.getDays() - 3) * 2;
        }
        return resultado;
    }
}
