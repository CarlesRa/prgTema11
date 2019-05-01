/*
 * Copyright (c) Carles Ramos
 */

package exercici07;

import utils.Lib;

import java.time.LocalDate;
import java.util.ArrayList;

public class Exercici07 {
    private int eleccio;
    private int eleccio2;
    private boolean esCorrecto;
    private Zona zona;
    private ArrayList<Partit> partits;
    private ArrayList<Entrada> entradesVenudes;
    public Exercici07(){
        partits = new ArrayList<>();
        entradesVenudes = new ArrayList<>();
        do{
            eleccio = mostrarMenu();
            if (eleccio < 0 || eleccio > 2){
                System.out.println("Selecció Incorrecta...");
            }
            else {
                switch (eleccio) {
                    case 1: {
                        nouPartit();
                        break;
                    }
                    case 2: {
                        do {
                            eleccio2 = menuGestio();
                            if (eleccio2 < 0 || eleccio2 > 4) {
                                System.out.println("Selecció Incorrecta...");
                            }
                            else{
                                switch (eleccio2){
                                    case 1:{
                                        vendaEntrades();
                                        break;
                                    }
                                    case 2:{
                                        break;
                                    }
                                    case 3:{
                                        break;
                                    }
                                    case 4:{
                                        break;
                                    }
                                    case 0:{
                                        esCorrecto = false;
                                    }
                                }
                            }
                        } while (eleccio2 < 0 || eleccio2 > 4);
                        break;
                    }
                    case 0:{
                        esCorrecto = true;
                    }
                }
            }
        }while (!esCorrecto);
    }

    /**
     * metode per demanar les dades de les grades
     */
    public Grada dadesGrades(){
        final int MAX_ZONES = 20;
        final int MAX_ZONES_VIP = 20;
        final int MAX_FILES = 100;
        final int MAX_SEIENTS = 200;
        int numZonesNormals;
        int numZonesVip;
        int files;
        int seientsPerFila;
        Grada grada;
        do {
            System.out.print("Indique les zones normals que te la grada: ");
            numZonesNormals = Lib.introduirEnter();
            if (numZonesNormals < 0 || numZonesNormals > MAX_ZONES){
                System.out.println("hi ha un maxim de: " + MAX_ZONES);
            }
        }while(numZonesNormals < 0 || numZonesNormals > MAX_ZONES);

        do {
            System.out.print("Indique les zones VIP que te la grada: ");
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

        grada = new Grada(numZonesNormals, numZonesVip);
        for (int i=0; i<(numZonesNormals + numZonesVip); i++){
            if (i < numZonesNormals){
                zona = new ZonaNormal(files,seientsPerFila);
                grada.addZona(i, zona);
            }
            else{
                zona = new ZonaVip(files,seientsPerFila);
                grada.addZona(i, zona);
            }
        }
        grada.mostrarEstadi();
        return grada;
    }

    public int mostrarMenu(){
        int eleccio = 0;
        System.out.println("** GESTI-FOOTBALL**");
        System.out.println("*******************");
        System.out.println("1-Nou partit");
        System.out.println("2-Gestio d'entrades");
        System.out.println("0-Eixir...");
        System.out.println("*******************");
        System.out.print("Seleccione una opció: ");
        eleccio = Lib.introduirEnter();
        return eleccio;
    }

    public int menuGestio(){
        int eleccio = 0;
        System.out.println("** GESTIÓ D'ENTRADES **");
        System.out.println("1-Venda entrades");
        System.out.println("2-Tornar entrada");
        System.out.println("3-Llistat de localitats");
        System.out.println("4-Mostrar recaudació del partit");
        System.out.println("0-Tornar al menu principal");
        System.out.print("Selecciona una opció: ");
        eleccio = Lib.introduirEnter();
        return eleccio;
    }

    public void nouPartit(){
        Partit partit;
        LocalDate dataPartit = LocalDate.now();
        String demanarData;
        String local;
        String visitant;
        TipusPartit tipusPartit = TipusPartit.MITJA_AFLUENCIA;
        System.out.println();
        Grada gradaPartit = dadesGrades();
        int seleccioTipus = 0;
        boolean esCorrecto = false;
        do{
            System.out.print("Introduix la data del partit: ");
            demanarData = Lib.lec.nextLine();
            if (Lib.validarFecha(demanarData)){
                dataPartit = Lib.convertToLocalDate(demanarData);
                if (dataPartit.isBefore(LocalDate.now())){
                    System.out.println("La data de partit no pot ser anterior a la actual..");
                    esCorrecto = false;
                }
                else{
                    esCorrecto = true;
                }
            }
        }while (!Lib.validarFecha(demanarData) || !esCorrecto);
        System.out.print("Equip local: ");
        local = Lib.introduirString();
        System.out.print("Equip visitant: ");
        visitant = Lib.introduirString();

        System.out.print("introduix el tipus de partit: ");
        do {
            System.out.println("** TIPUS PARTIT **");
            System.out.println("1-Alta afluencia");
            System.out.println("2-Mitja afluencia");
            System.out.println("3-Baixa afluencia");
            System.out.print("Tria una opció: ");
            seleccioTipus = Lib.introduirEnter();
            if (seleccioTipus < 1 || seleccioTipus > 3){
                System.out.println("Elecció incorrecta...");
                esCorrecto = false;
            }
            else{
                esCorrecto = true;
                switch (seleccioTipus){
                    case 1:{
                        tipusPartit = TipusPartit.ALTA_AFLUENCIA;
                        break;
                    }
                    case 2:{
                        tipusPartit = TipusPartit.MITJA_AFLUENCIA;
                        break;
                    }
                    case 3:{
                        tipusPartit = TipusPartit.BAIXA_AFLUENCIA;
                    }
                }
            }
        }while (!esCorrecto);
        partit = new Partit(tipusPartit,dataPartit,local,visitant, gradaPartit);
        System.out.println("Partit registrat amb exit!!!");
        System.out.println(partit.toString() + "\n");
        partits.add(partit);
    }

    public void vendaEntrades(){
        int numEntrades = 0;
        int idPartit = 0;
        int posicioPartit = 0;
        int zona = 0;
        int fila = 0;
        int seient = 0;
        int seleccio3 = 0;
        boolean esCorrecto2 = false;
        System.out.print("introduix el ID de partit: ");
        idPartit = Lib.introduirEnter();
        for (int i=0; i<partits.size(); i++){
            if (idPartit == partits.get(i).getIdPartit()){
                posicioPartit = i;
                esCorrecto2 = true;
            }
        }
        if (!esCorrecto2){
            System.out.println("Ningun partit amb eixa ID....");
            return;
        }
        System.out.println(partits.get(posicioPartit).toString());
        System.out.print("Moltes entrades dessitja vendre?: ");
        numEntrades = Lib.introduirEnter();
        for (int i=0; i<numEntrades; i++) {
            do {
                System.out.println("Selecciona el tipus d'entrada: ");
                System.out.println("1-Normal");
                System.out.println("2-VIP");
                seleccio3 = Lib.introduirEnter();
                if (seleccio3 < 1 || seleccio3 > 2) {
                    System.out.println("Selecció incorrecta....");
                    esCorrecto2 = false;
                }
                else if (seleccio3 >= 1 || seleccio3 <= 2){
                    esCorrecto2 = true;
                }
            } while (!esCorrecto2);
            switch (seleccio3) {
                case 1: {
                    System.out.println("Zones normals: ");
                    partits.get(posicioPartit).getGrada().mostrarZonesNormals();
                    break;
                }
                case 2: {
                    System.out.println("Zones VIP: ");
                    partits.get(posicioPartit).getGrada().mostrarZonesVip();
                    break;
                }
            }
            do {
                System.out.print("Selecciona la zona: ");
                zona = Lib.introduirEnter();
                System.out.print("Selecciona la fila: ");
                fila = Lib.introduirEnter();
                System.out.print("Selecciona el seient: ");
                seient = Lib.introduirEnter();
                if (partits.get(posicioPartit).getGrada().getZones()[zona].getZona()[fila][seient] == 0) {
                    partits.get(posicioPartit).setSeient(zona, fila, seient);
                    partits.get(posicioPartit).getGrada().mostrarEstadi();
                    esCorrecto2 = true;
                } else {
                    System.out.println("El seinent esta ocupat...");
                    esCorrecto2 = false;
                }
            }while (!esCorrecto2);
        }
    }


}
