/*
 * Copyright (c) Carles Ramos
 */

package exercici07;

import utils.Lib;

public class Exercici07 {
    private static final int MAX_ZONES = 20;
    private static final int MAX_ZONES_VIP = 20;
    private static final int MAX_FILES = 100;
    private static final int MAX_SEIENTS = 200;
    private int numZonesNormals;
    private int numZonesVip;
    private int files;
    private int seientsPerFila;
    private Estadi estadi;
    private Zona zona;
    public Exercici07(){
        //utilitzem el metode per construir el estadi
        dadesStadi();
        estadi = new Estadi(numZonesNormals, numZonesVip);
        for (int i=0; i<(numZonesNormals + numZonesVip); i++){
            if (i <= numZonesNormals){
                zona = new ZonaNormal(files,seientsPerFila);
                estadi.addZona(i, zona);
            }
            else{
                zona = new ZonaVip(files,seientsPerFila);
                estadi.addZona(i, zona);
            }
        }

        for (int i=0; i<estadi.getZones().length; i++){
            System.out.println(estadi.getZones()[i].toString());
        }
    }

    public void dadesStadi(){
        do {
            System.out.print("Indique les zones normals que te l´estadi: ");
            numZonesNormals = Lib.introduirEnter();
            if (numZonesNormals < 0 || numZonesNormals > MAX_ZONES){
                System.out.println("hi ha un maxim de: " + MAX_ZONES);
            }
        }while(numZonesNormals < 0 || numZonesNormals > MAX_ZONES);

        do {
            System.out.print("Indique les zones VIP que te l´estadi: ");
            numZonesVip = Lib.introduirEnter();
            if (numZonesNormals < 0 || numZonesNormals > MAX_ZONES_VIP){
                System.out.println("hi ha un maxim de: " + MAX_ZONES_VIP);
            }
        }while(numZonesVip < 0 || numZonesVip > MAX_ZONES_VIP);

        do {
            System.out.print("Indique les files que hi ha per zona: ");
            files = Lib.introduirEnter();
            if (files < 0 || files > MAX_FILES){
                System.out.println("hi ha un maxim de: " + MAX_FILES);
            }
        }while(files < 0 || files > MAX_FILES);

        do {
            System.out.print("Indique els seients que hi ha per fila: ");
            seientsPerFila = Lib.introduirEnter();
            if (files < 0 || seientsPerFila > MAX_SEIENTS){
                System.out.println("hi ha un maxim de: " + MAX_SEIENTS);
            }
        }while(files < 0 || files > MAX_SEIENTS);
    }
}
