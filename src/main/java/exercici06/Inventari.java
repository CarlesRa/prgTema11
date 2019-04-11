/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

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
    @Override
    public void mostrarMultimedias(){
        for (Multimedia m : listadoMultimedia){
            System.out.println(m.toString());
        }
    }
    @Override
    public void mostrarVideojocsPerAny(){
        listadoMultimedia.sort(new Multimedia.ComparatorFecha());
        for (Multimedia m : listadoMultimedia){
            if (m instanceof VideoJoc){
                System.out.println(m.toString());
            }
        }
    }
    @Override
    public void mostrarPeliculesPerTitol(){
        listadoMultimedia.sort(new Multimedia.ComparatorNombre());
        for (Multimedia m : listadoMultimedia){
            if (m instanceof Pelicula){
                System.out.println(m.toString());
            }
        }

    }
    @Override
    public void mostrarLloguers(){
        for (int i=0; i<listadoSocios.size(); i++){
            for (int z=0; z<listadoSocios.get(i).getAlquilers().size(); z++){
                System.out.println(listadoSocios.get(i).getAlquilers().get(z));
            }
        }
    }
    @Override
    public void mostrarLloguersActuals(){
        ArrayList<Alquiler> alquilers = new ArrayList<>();
        for (int i=0; i<listadoSocios.size(); i++){
            for (int z=0; z<listadoSocios.get(i).getAlquilers().size(); z++){
                if (listadoSocios.get(i).getAlquilers().get(z).getFechaDevolucion() == null) {
                    alquilers.add(listadoSocios.get(i).getAlquilers().get(z));
                }
            }
        }
        Collections.sort(alquilers);
        System.out.println(alquilers.toString());
    }
    @Override
    public void mostrarsocisAmbRecarrec(){
        for (int i=0; i<listadoSocios.size(); i++){
            for (int z=0; z<listadoSocios.get(i).getAlquilers().size(); z++){
                if (listadoSocios.get(i).getAlquilers().get(z).getRecargo() > 0) {
                    System.out.println(listadoSocios.get(i).mostrarSocio());
                }
            }
        }
    }
}
