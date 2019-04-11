/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import utils.Lib;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

//se encarga de guardar los productos y gestionar el alquiler/recogida de los mismos
public class Videoclub {
    private final int PERIODO_SIN_RECARGO = 3;
    private final int RECARGO_POR_DIA = 2;

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

    public void alquilarMultimedia(LocalDate fechaAlquiler, int idMultimedia, Socio socio){
        Alquiler alquiler;
        alquiler = new Alquiler(idMultimedia, fechaAlquiler);
        socio.getAlquilers().add(alquiler);
        System.out.println(socio.toString());
    }

    public void recogerMultimedia(int idMultimedia){
        //Fuerzo a que haya recargo
        int recargo = 0;
        Boolean estaMultimedia = false;
        for (int i=0; i<listadoSocios.size() || estaMultimedia == true; i++){
           for (int z = 0; z<listadoSocios.get(i).getZiceAlquilers() || estaMultimedia == true; z++){
               if (listadoSocios.get(i).getAlquilers().get(z).getIdProducto() == idMultimedia
               && listadoSocios.get(i).getAlquilers().get(z).getFechaDevolucion() == null){
                   LocalDate fachaDevolucion = LocalDate.of(2019, 04, 15);
                   listadoSocios.get(i).getAlquilers().get(z).setFechaDevolucion(fachaDevolucion);
                   recargo = calcularRecargo(listadoSocios.get(i).getAlquilers().get(z));
                   listadoSocios.get(i).getAlquilers().get(z).setRecargo(recargo);
                   estaMultimedia = true;
               }
           }
        }
        if (!estaMultimedia){
            System.out.println("El producto no esta alquilado");
            Lib.continuar();
        }
    }

    public ArrayList<Socio> getListadoSocios() {
        return listadoSocios;
    }

    public ArrayList<Multimedia> getListadoMultimedia() {
        return listadoMultimedia;
    }

    public int calcularRecargo(Alquiler alquiler){
        int resultado = 0;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaAlquiler = alquiler.getFechaAlquiler();
        LocalDate fechaDevolucion = alquiler.getFechaDevolucion();
        Period periodo = Period.between(fechaAlquiler, fechaDevolucion);
        if (periodo.getDays() > 3){
            resultado = (periodo.getDays() - PERIODO_SIN_RECARGO) * RECARGO_POR_DIA;
        }
        return resultado;
    }

    public void pagarRecargo(Alquiler alquiler){
        alquiler.setRecargo(0);
    }

    public void mostrarMultimedias(){
        for (Multimedia m : listadoMultimedia){
            System.out.println(m.toString());
        }
    }

    public void mostrarVideojocsPerAny(){
        ArrayList<Multimedia> videoJocs = new ArrayList<>();
        for (Multimedia m : listadoMultimedia){
            if (m instanceof VideoJoc){
                videoJocs.add(m);
            }
        }
        Collections.sort(videoJocs);
        System.out.println(videoJocs.toString());
    }

    public void mostrarPeliculesPerTitol(){
        ArrayList<Multimedia> pelicules = new ArrayList<>();
        for (Multimedia m : listadoMultimedia){
            if (m instanceof Pelicula){
                pelicules.add(m);
            }
        }
        Collections.sort(pelicules);
        System.out.println(pelicules.toString());
    }

    public void mostrarLlogersPerData(){

    }
}
