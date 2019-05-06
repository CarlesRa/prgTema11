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
    private int posicioPartit;
    private boolean esCorrecto;
    private Zona zona;
    private ArrayList<Partit> partits;

    public Exercici07(){
        partits = new ArrayList<>();
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
                        posicioPartit = mostrarLlistaPartits();
                        if (posicioPartit >= 0) {
                            do {
                                eleccio2 = menuGestio();
                                if (eleccio2 < 0 || eleccio2 > 5) {
                                    System.out.println("Selecció Incorrecta...");
                                } else {
                                    switch (eleccio2) {
                                        case 1: {
                                            vendaEntrades();
                                            break;
                                        }
                                        case 2: {
                                            tornarEntrada();
                                            break;
                                        }
                                        case 3: {
                                            mostrarLocalitats();
                                            break;
                                        }
                                        case 4: {
                                            mostrarRecaudacio();
                                            break;
                                        }
                                        case 5: {
                                            generarSorteig();
                                            break;
                                        }
                                        case 0: {
                                            esCorrecto = false;
                                        }
                                    }
                                }
                            } while (eleccio2 < 0 || eleccio2 > 5);
                        }
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
     * mostra el menu principal
     * @return retorna la elecció del menu
     */
    private int mostrarMenu(){
        int eleccio;
        Lib.limpiarPantalla();
        System.out.println("** GESTI-FOOTBALL**");
        System.out.println("*******************");
        System.out.println("1-Nou partit");
        System.out.println("2-Gestio de partit");
        System.out.println("0-Eixir...");
        System.out.println("*******************");
        System.out.print("Seleccione una opció: ");
        eleccio = Lib.introduirEnter();
        return eleccio;
    }

    /**
     * demana les dades per introduir un nou partit
     */
    private void nouPartit(){
        Partit partit;
        LocalDate dataPartit = LocalDate.now();
        String demanarData;
        String local;
        String visitant;
        TipusPartit tipusPartit = TipusPartit.MITJA_AFLUENCIA;
        Grada gradaPartit = dadesGrades();
        int seleccioTipus;
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

        System.out.println("introduix el tipus de partit: ");
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
        partit = new Partit(tipusPartit,dataPartit,local.toUpperCase()
        ,visitant.toUpperCase(), gradaPartit,gradaPartit.getEntradesTotals());
        System.out.println("Partit registrat amb exit!!!");
        System.out.println(partit.toString() + "\n");
        partits.add(partit);
    }

    /**
     * mostra el partirs no jugats
     * @return retorna la posicio del partit seleccionat
     */
    private int mostrarLlistaPartits(){
        boolean esCorrecte;
        int idPartit;
        int posicioPartit = 0;
        //imprimim els partits
        for (int i=0; i<partits.size(); i++){
            if (partits.get(i).getDataPartit().isAfter(LocalDate.now())
            || partits.get(i).getDataPartit().isEqual(LocalDate.now())){
                System.out.println(partits.get(i).toString());
            }
        }
        do {
            System.out.print("Seleccione la id del partit que desitja gestionar: ");
            //posicioPartit = localitzarPartit(Lib.introduirEnter());
            idPartit = Lib.introduirEnter();
            esCorrecte = false;
            //comprovem que existix el partit
            for (int i=0; i<partits.size(); i++){
                if (idPartit == partits.get(i).getIdPartit()){
                    posicioPartit = i;
                    esCorrecte = true;
                }
            }
            if (!esCorrecte){
                System.out.println("Ningun partit amb eixa ID....");
                return -1;
            }
        }while (!esCorrecte);
        return posicioPartit;
    }

    /**
     * mostra el menu de gestió
     * @return la elecció del menu
     */
    private int menuGestio(){
        int eleccio;
        Lib.limpiarPantalla();
        System.out.println("** GESTIÓ DE PARTIT **");
        System.out.println("1-Venda entrades");
        System.out.println("2-Tornar entrada");
        System.out.println("3-Llistat de localitats");
        System.out.println("4-Mostrar recaudació del partit");
        System.out.println("5-Fer el sorteig del partit");
        System.out.println("0-Tornar al menu principal");
        System.out.print("Selecciona una opció: ");
        eleccio = Lib.introduirEnter();
        return eleccio;
    }

    /**
     * Metode per vendre entrades per a un partit en concret
     */
    private void vendaEntrades(){
        Entrada entrada;
        int numEntrades;
        int zona = 0;
        int fila = 0;
        int seient = 0;
        int seleccio3;
        boolean esCorrecto2;
        if (posicioPartit >= 0) {
            //demanem el nombre dentrades a vendre
            System.out.print("Moltes entrades dessitja vendre?: ");
            numEntrades = Lib.introduirEnter();
            for (int i = 0; i < numEntrades; i++) {
                do {
                    System.out.println("Selecciona el tipus d'entrada: ");
                    System.out.println("1-Normal");
                    System.out.println("2-VIP");
                    seleccio3 = Lib.introduirEnter();
                    esCorrecto2 = true;
                    if (seleccio3 < 1 || seleccio3 > 2) {
                        System.out.println("Selecció incorrecta....");
                        esCorrecto2 = false;
                    }
                } while (!esCorrecto2);
                //mostrem les zones disponibles per al tipus dentrada seleccionat
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
                //demanem les dades de lentrada i tractem les exepcions
                do {
                    do {
                        System.out.print("Selecciona la zona: ");
                        try {
                            zona = Integer.parseInt(Lib.lec.nextLine());
                            if (seleccio3 == 1 && partits.get(posicioPartit).getGrada().getZones()[zona]
                                    instanceof ZonaNormal){
                                esCorrecto2 = true;
                            }
                            else if (seleccio3 == 1 && partits.get(posicioPartit).getGrada().getZones()[zona]
                                    instanceof ZonaVip){
                                System.out.println("La zona no correspon al tipus d'entrada");
                                esCorrecto2 = false;
                            }
                            else if (seleccio3 == 2 && partits.get(posicioPartit).getGrada().getZones()[zona]
                                    instanceof ZonaVip){

                                esCorrecto2 = true;
                            }
                            else if (seleccio3 == 2 && partits.get(posicioPartit).getGrada().getZones()[zona]
                                    instanceof ZonaNormal){
                                System.out.println("La zona no correspon al tipus d'entrada");
                                esCorrecto2 = false;
                            }
                        } catch (NumberFormatException nfe1) {
                            esCorrecto2 = false;
                        }
                        if (partits.get(posicioPartit).getGrada().getZones().length - 1 < zona) {
                            System.out.println("No existix aquesta zona...");
                            esCorrecto2 = false;
                        }
                    } while (!esCorrecto2);
                    do {
                        System.out.print("Selecciona la fila: ");
                        try {
                            fila = Integer.parseInt(Lib.lec.nextLine());
                            esCorrecto2 = true;
                        } catch (NumberFormatException nfe1) {
                            esCorrecto2 = false;
                        }
                        if (partits.get(posicioPartit).getGrada().getZones()[0].getZona().length - 1
                                < fila) {
                            System.out.println("Nombre de fila incorrecte...");
                            esCorrecto2 = false;
                        }
                    } while (!esCorrecto2);
                    do {
                        System.out.print("Selecciona el seient: ");
                        try {
                            seient = Integer.parseInt(Lib.lec.nextLine());
                            esCorrecto2 = true;
                        } catch (NumberFormatException nfe1) {
                            esCorrecto2 = false;
                        }
                        if (partits.get(posicioPartit).getGrada().getZones()[0].getZona()[0].length < seient) {
                            System.out.println("Nombre de seient incorrecte...");
                            esCorrecto2 = false;
                        }
                    } while (!esCorrecto2);
                    // si tot es correcte comprovem si el seient esta lliure
                    if (partits.get(posicioPartit).getGrada().getZones()[zona].getZona()[fila][seient] == 0) {
                        //marquem el seient com a ocupat
                        partits.get(posicioPartit).setSeientOcupat(zona, fila, seient);
                        //mostrem les grades
                        partits.get(posicioPartit).getGrada().mostarGrada();
                        //filtrem segons la eleccio, per a que es pugurn seleccionar les zones correctes
                        if (seleccio3 == 1) {
                            entrada = new ENormal(partits.get(posicioPartit), zona, fila, seient
                            , partits.get(posicioPartit).getSorteig().numeroSorteigEntrada());
                        } else {
                            entrada = new EVip(partits.get(posicioPartit), zona, fila, seient);
                        }
                        //anyadim la entrada a la llista dentrades venudes
                        partits.get(posicioPartit).getEntradesVenudes().add(entrada);
                        System.out.println("Entrada registrada amb exit!!");
                        //mostrem lentrada
                        System.out.println(entrada.toString());
                        // sumem la recaudacio
                        partits.get(posicioPartit).sumarRecaudacio(entrada.getPreuEntrada());
                        // descomptem la entrada de les entrades lliures del partit
                        partits.get(posicioPartit).descomptarEntrada();
                        Lib.continuar();
                        esCorrecto2 = true;
                    }
                    //informem en cas que el seient estiga ocupat
                    else {
                        System.out.println("El seinent esta ocupat...");
                        Lib.continuar();
                        esCorrecto2 = false;
                    }
                } while (!esCorrecto2);
            }
        }
    }

    /**
     * metode per tornar entrades de un partit en concret
     */
    private void tornarEntrada(){
        int numEntrada = 0;
        boolean esCorrecto4;
        if (posicioPartit >= 0) {
            partits.get(posicioPartit).mostrarEntradesVenudes();
            do {
                System.out.print("Introduix el numero d'entrada: ");
                try {
                    numEntrada = Lib.introduirEnter();
                    esCorrecto4 = true;
                } catch (NumberFormatException nfe5) {
                    System.out.println("Dades incorrectes....");
                    esCorrecto4 = false;
                }
            }while (!esCorrecto4);
            for (int i = 0; i < partits.get(posicioPartit).getEntradesVenudes().size(); i++) {
                //comprovem que la entrada existix
                if (partits.get(posicioPartit).getEntradesVenudes().get(i).getNumEntrada() == numEntrada) {
                    //pujem el compte dentrades venudes
                    partits.get(posicioPartit).comptarEntrada();
                    //decrementem la recaudacio
                    partits.get(posicioPartit).restarRecaudacio(partits.get(posicioPartit).getEntradesVenudes().get(i)
                    .getPreuEntrada());
                    //marquem el seient com a lliure
                    partits.get(posicioPartit).setSeientLliure(partits.get(posicioPartit).getEntradesVenudes()
                    .get(i).getZona(), partits.get(posicioPartit).getEntradesVenudes().get(i).getFila()
                    , partits.get(posicioPartit).getEntradesVenudes().get(i).getNumSeient());
                    //en cas de entrada normal tornem a ficar el numero de sorteig al bombo
                    if (partits.get(posicioPartit).getEntradesVenudes().get(i) instanceof ENormal) {
                        partits.get(posicioPartit).getSorteig().addnombresSorteigEntrada(partits.get(posicioPartit)
                                .getEntradesVenudes().get(i).getNumSorteig());
                    }
                    //llevem lentrada de la llista de les entrades venudes
                    partits.get(posicioPartit).getEntradesVenudes().remove(i);
                }
            }
            System.out.println("Entrada tornada amb exirt!!");
            Lib.continuar();
        }
    }

    /**
     * Mostra les localitas de un partit en concret
     */
    private void mostrarLocalitats(){
        if (posicioPartit >= 0) {
            partits.get(posicioPartit).getGrada().mostarGrada();
            Lib.continuar();
        }
    }

    /**
     * mostra la recaudacio de el partit solicitat
     */
    private void mostrarRecaudacio(){
        if (posicioPartit >= 0){
            System.out.println(partits.get(posicioPartit).toString());
            System.out.println("Hi ha una recaudació de: " + partits.get(posicioPartit).getRecaudacio() + "Euros");
            Lib.continuar();
        }
    }

    /**
     * genera el sorteig del partit que li demanem, mostra el premiat
     */
    private void generarSorteig(){
        int numSorteig;
        boolean esCorrecte = false;
        if (posicioPartit >= 0){
            numSorteig = partits.get(posicioPartit).getSorteig().generarSorteig();
            for (int i=0; i<partits.get(posicioPartit).getEntradesVenudes().size(); i++){
                if (partits.get(posicioPartit).getEntradesVenudes().get(i).getNumSorteig() == numSorteig){
                    System.out.println("La entrada guanyadora per al nombre " + numSorteig
                            + " Es:");
                    System.out.println(partits.get(posicioPartit).getEntradesVenudes().get(i).toString());
                    System.out.println("ENORABONA!!!!");
                    Lib.continuar();
                    esCorrecte = true;
                }
            }
            if (!esCorrecte){
                System.out.println(Lib.letraRoja() + "Ninguna entrada premiada...." + Lib.reiniciarColorLetra());
                Lib.continuar();
            }
        }

    }

    /**
     * metode per demanar les dades de les grades
     */
    private Grada dadesGrades(){
        final int MAX_ZONES = 20;
        final int MAX_ZONES_VIP = 10;
        final int MAX_FILES = 100;
        final int MAX_SEIENTS = 200;
        int numZonesNormals;
        int numZonesVip;
        int files;
        int seientsPerFila;
        int entradesTotals;
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
            if (numZonesNormals <= 0 || numZonesNormals > MAX_ZONES_VIP){
                System.out.println("hi ha un maxim de: " + MAX_ZONES_VIP);
            }
        }while(numZonesVip <= 0 || numZonesVip > MAX_ZONES_VIP);

        do {
            System.out.print("Indique les files que hi ha per zona: ");
            files = Lib.introduirEnter();
            if (files <= 0 || files > MAX_FILES){
                System.out.println("hi ha un maxim de: " + MAX_FILES);
            }
        }while(files <= 0 || files > MAX_FILES);

        do {
            System.out.print("Indique els seients que hi ha per fila: ");
            seientsPerFila = Lib.introduirEnter();
            if (seientsPerFila <= 0 || seientsPerFila > MAX_SEIENTS){
                System.out.println("hi ha un maxim de: " + MAX_SEIENTS);
            }
        }while(seientsPerFila <= 0 || seientsPerFila > MAX_SEIENTS);
        //calcule les entrades totals que es poden vendre
        entradesTotals = (numZonesNormals + numZonesVip) * (files * seientsPerFila);
        grada = new Grada(numZonesNormals, numZonesVip, entradesTotals);
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
        grada.mostarGrada();
        return grada;
    }

    /**
     * localitza el partit i comprobva si existeix
     * @return retorna la posicio del partit
     */

}
