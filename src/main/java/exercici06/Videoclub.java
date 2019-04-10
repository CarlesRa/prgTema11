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

    public void alquilarMultimedia(LocalDate fechaAlquiler, int idMultimedia, Socio socio){
        Alquiler alquiler;
        alquiler = new Alquiler(idMultimedia, fechaAlquiler);
        socio.getAlquilers().add(alquiler);
        System.out.println(socio.toString());
    }

    public void recogerMultimedia(Socio socio, int posicionAlquiler){
        //Fuerzo a que haya recargo
        if (socio.getAlquilers().get(posicionAlquiler).getFechaDevolucion() == null) {
            LocalDate fachaDevolucion = LocalDate.of(2019, 04, 15);
            socio.getAlquilers().get(posicionAlquiler).setFechaDevolucion(fachaDevolucion);
            calcularRecargo(socio,posicionAlquiler);
            socio.getAlquilers().get(posicionAlquiler).setRecargo(calcularRecargo(socio,posicionAlquiler));
        }
    }

    public ArrayList<Socio> getListadoSocios() {
        return listadoSocios;
    }

    public ArrayList<Multimedia> getListadoMultimedia() {
        return listadoMultimedia;
    }

    public int calcularRecargo(Socio socio, int posicionAlquiler){
        int resultado = 0;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaAlquiler = socio.getAlquilers().get(posicionAlquiler).getFechaAlquiler();
        LocalDate fechaDevolucion = socio.getAlquilers().get(posicionAlquiler).getFechaDevolucion();
        Period periodo = Period.between(fechaAlquiler, fechaDevolucion);
        if (periodo.getDays() > 3){
            resultado = (periodo.getDays() - 3) * 2;
        }
        return resultado;
    }

    public void pagarRecargo(Alquiler alquiler){
        alquiler.setRecargo(0);
    }
}
