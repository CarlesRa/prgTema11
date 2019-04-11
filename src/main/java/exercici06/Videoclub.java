/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

//se encarga de guardar los productos y gestionar el alquiler/recogida de los mismos
public class Videoclub {
    private final int PERIODO_SIN_RECARGO = 3;
    private final int RECARGO_POR_DIA = 2;

    private Inventari inventari;

    public Videoclub(){
        inventari = new Inventari();
    }

    public Inventari getInventari() {
        return inventari;
    }

    public void registrarMultimedia(Multimedia multimedia){
        inventari.getListadoMultimedia().add(multimedia);
    }

    public void registrarSocio(Socio socio){
        inventari.getListadoSocios().add(socio);
    }

    public void alquilarMultimedia(LocalDate fechaAlquiler, int idMultimedia, Socio socio){
        Alquiler alquiler;
        alquiler = new Alquiler(idMultimedia, socio.getiD(), fechaAlquiler);
        socio.getAlquilers().add(alquiler);
        System.out.println(socio.toString());
    }

    public void recogerMultimedia(int idMultimedia){
        //Fuerzo a que haya recargo
        int recargo = 0;
        for (int i=0; i<inventari.getListadoSocios().size(); i++){
           for (int z = 0; z<inventari.getListadoSocios().get(i).getAlquilers().size(); z++){
               if (inventari.getListadoSocios().get(i).getAlquilers().get(z).getFechaDevolucion() == null &&
                       inventari.getListadoSocios().get(i).getAlquilers().get(z).getIdProducto() == idMultimedia) {
                   LocalDate fachaDevolucion = LocalDate.of(2019, 04, 15);
                   inventari.getListadoSocios().get(i).getAlquilers().get(z).setFechaDevolucion(fachaDevolucion);
                   recargo = calcularRecargo(inventari.getListadoSocios().get(i).getAlquilers().get(z));
                   inventari.getListadoSocios().get(i).getAlquilers().get(z).setRecargo(recargo);
                   return;
               }
           }
        }
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
}
