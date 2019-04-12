/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import utils.Lib;

import java.time.LocalDate;
import java.time.Period;

//se encarga de guardar los productos y gestionar el alquiler/recogida de los mismos
public class Videoclub implements IVideoclub{
    private final int PERIODO_SIN_RECARGO = 3;
    private final int RECARGO_POR_DIA = 2;
    private final int RECARGO_POR_DEFECTO = 0;

    private Inventari inventari;

    public Videoclub(){
        inventari = new Inventari();
    }

    public Inventari getInventari() {
        return inventari;
    }

    /**
     * registra los productos
     * @param multimedia le pasamos los productos
     */
    @Override
    public void registrarMultimedia(Multimedia multimedia){
        inventari.getListadoMultimedia().add(multimedia);
    }

    /**
     * registra los socios
     * @param socio le pasamos el socio
     */
    @Override
    public void registrarSocio(Socio socio){
        inventari.getListadoSocios().add(socio);
    }

    /**
     * metodo para alquilar productos
     * @param fechaAlquiler
     * @param idMultimedia
     * @param socio
     */
    @Override
    public void alquilarMultimedia(LocalDate fechaAlquiler, int idMultimedia, Socio socio){
        Alquiler alquiler;
        alquiler = new Alquiler(idMultimedia, socio.getiD(), fechaAlquiler);
        socio.getAlquilers().add(alquiler);
    }

    /**
     * metodo para recoger los productos traidos por los socios
     * @param idMultimedia
     */
    @Override
    public void recogerMultimedia(int idMultimedia){
        int recargo = 0;
        boolean esta = false;
        for (int i=0; i<inventari.getListadoSocios().size(); i++){
           for (int z = 0; z<inventari.getListadoSocios().get(i).getAlquilers().size(); z++){
               //compruebo que el id coincide y la fecha de devolucion es distinta a null
               if (inventari.getListadoSocios().get(i).getAlquilers().get(z).getFechaDevolucion() == null &&
                       inventari.getListadoSocios().get(i).getAlquilers().get(z).getIdProducto() == idMultimedia){
                   LocalDate fachaDevolucion = LocalDate.now();
                   inventari.getListadoSocios().get(i).getAlquilers().get(z).setFechaDevolucion(fachaDevolucion);
                   recargo = calcularRecargo(inventari.getListadoSocios().get(i).getAlquilers().get(z));
                   inventari.getListadoSocios().get(i).getAlquilers().get(z).setRecargo(recargo);
                   esta = true;
               }
           }
        }
        //si el producto no se encuentra
        if (!esta){
            System.out.println("No se ha encontrado producto");
            Lib.continuar();
        }
    }

    /**
     * calcula el recargo al devolver un producto
     * @param alquiler
     * @return el importe del recargo
     */
    @Override
    public int calcularRecargo(Alquiler alquiler){
        int resultado = 0;
        LocalDate fechaAlquiler = alquiler.getFechaAlquiler();
        LocalDate fechaDevolucion = alquiler.getFechaDevolucion();
        Period periodo = Period.between(fechaAlquiler, fechaDevolucion);
        if (periodo.getDays() > 3){
            resultado = (periodo.getDays() - PERIODO_SIN_RECARGO) * RECARGO_POR_DIA;
        }
        return resultado;
    }

    /**
     * metodo para pagar el recargo
     * @param alquiler le pasamos el alquiler que se devuelve
     */
    @Override
    public void pagarRecargo(Alquiler alquiler){
        alquiler.setRecargo(RECARGO_POR_DEFECTO);
    }
}
