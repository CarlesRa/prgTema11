/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import utils.Lib;

import java.util.ArrayList;
import java.util.Collections;

public class Inventari implements IInventario{
    private ArrayList<Multimedia> listadoMultimedia;
    private ArrayList <Socio> listadoSocios;

    public Inventari() {
        listadoMultimedia = new ArrayList<>();
        listadoSocios = new ArrayList<>();
    }

    public ArrayList<Multimedia> getListadoMultimedia() {
        return listadoMultimedia;
    }

    public ArrayList<Socio> getListadoSocios() {
        return listadoSocios;
    }

    /**
     * muestra la lista de todos los productos
     */
    @Override
    public void mostrarMultimedias(){
        for (Multimedia m : listadoMultimedia){
            System.out.println(m.toString());
        }
    }
    //muestra los videojuegos ordenados por año
    @Override
    public void mostrarVideojocsPerAny(){
        listadoMultimedia.sort(new Multimedia.ComparatorFecha());
        for (Multimedia m : listadoMultimedia){
            if (m instanceof VideoJoc){
                System.out.println(m.toString());
            }
        }
    }

    /**
     * muestra los peliculas ordenados por titulo
     */
    @Override
    public void mostrarPeliculesPerTitol(){
        listadoMultimedia.sort(new Multimedia.ComparatorNombre());
        for (Multimedia m : listadoMultimedia){
            if (m instanceof Pelicula){
                System.out.println(m.toString());
            }
        }

    }

    /**
     * muestra el historico de alquileres de un socio
     * @param idSoci le pasamos la id del socio
     */
    @Override
    public void mostrarLloguers(int idSoci){
        for (int i=0; i<listadoSocios.size(); i++){
            if (listadoSocios.get(i).getiD() == idSoci) {
                for (int z = 0; z < listadoSocios.get(i).getAlquilers().size(); z++) {
                    System.out.println(listadoSocios.get(i).getAlquilers().get(z));
                }
            }
        }
    }

    /**
     * muestra los alquileres actuales de un socio
     * @param idSoci le pasamos la id del socio
     */
    @Override
    public void mostrarLloguersActuals(int idSoci){
        ArrayList<Alquiler> alquilers = new ArrayList<>();
        for (int i=0; i<listadoSocios.size(); i++){
            if (listadoSocios.get(i).getiD() == idSoci) {
                for (int z = 0; z < listadoSocios.get(i).getAlquilers().size(); z++) {
                    if (listadoSocios.get(i).getAlquilers().get(z).getFechaDevolucion() == null) {
                        alquilers.add(listadoSocios.get(i).getAlquilers().get(z));
                    }
                }
            }
        }
        Collections.sort(alquilers);
        System.out.println(alquilers.toString());
    }

    /**
     * muestra todos los socios con recargos pendientes
     */
    @Override
    public void mostrarsocisAmbRecarrec(){
        boolean esCorrecto = false;
        for (int i=0; i<listadoSocios.size(); i++){
            for (int z=0; z<listadoSocios.get(i).getAlquilers().size(); z++){
                if (listadoSocios.get(i).getAlquilers().get(z).getRecargo() > 0) {
                    System.out.println(listadoSocios.get(i).mostrarSocio());
                    esCorrecto = true;
                }
            }
        }
        if (!esCorrecto){
            System.out.println("Ningun recargo pendiente");
            Lib.continuar();
        }
    }



}
