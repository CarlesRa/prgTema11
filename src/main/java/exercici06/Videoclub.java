/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

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

    }

    public void recogerPelicula(){

    }
}
