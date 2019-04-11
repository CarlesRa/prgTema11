/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import java.util.ArrayList;
import java.util.Collections;

public class Inventari {
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

    public void mostrarLloguers(){
        for (int i=0; i<listadoSocios.size(); i++){
            for (int z=0; z<listadoSocios.get(i).getAlquilers().size(); z++){
                System.out.println(listadoSocios.get(i).getAlquilers().get(z));
            }
        }
    }

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
