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

    public void alquilarMultimedia(LocalDate fechaAlquiler, int idMultimedia, int posicionSocio){
        Alquiler alquiler;
        alquiler = new Alquiler(idMultimedia, fechaAlquiler);
        listadoSocios.get(posicionSocio).getAlquilers().add(alquiler);
        System.out.println(listadoSocios.get(posicionSocio).toString());
    }

    public void recogerMultimedia(int  posicionSocio){
        //Fuerzo a que haya recargo
        LocalDate fachaDevolucion = LocalDate.of(2019,04,15);
        listadoSocios.get(posicionSocio).getUltimoAlquiler().setFechaDevolucion(fachaDevolucion);
        calcularRecargo(listadoSocios.get(posicionSocio));
        listadoSocios.get(posicionSocio).getUltimoAlquiler().setRecargo(calcularRecargo(listadoSocios.get(posicionSocio)));
        System.out.println(listadoSocios.get(posicionSocio).toString());
    }

    public ArrayList<Socio> getListadoSocios() {
        return listadoSocios;
    }

    public ArrayList<Multimedia> getListadoMultimedia() {
        return listadoMultimedia;
    }

    public int calcularRecargo(Socio socio){
        System.out.println("entra el recargo");
        int resultado = 0;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaAlquiler = socio.getAlquilers().get(socio.getAlquilers().size()-1).getFechaAlquiler();
        LocalDate fechaDevolucion = socio.getAlquilers().get(socio.getAlquilers().size()-1).getFechaDevolucion();
        Period periodo = Period.between(fechaAlquiler, fechaDevolucion);
        if (periodo.getDays() > 3){
            resultado = (periodo.getDays() - 3) * 2;
        }
        return resultado;
    }
}
