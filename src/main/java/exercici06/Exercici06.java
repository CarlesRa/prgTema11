/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import com.github.javafaker.Faker;
import utils.Lib;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Exercici06 {
    private Scanner lec;
    private int eleccio;
    private Videoclub videoclub;
    private Multimedia multimedia;
    private String titulo;
    private String autor;
    private Formats formats;
    private int anyo;
    private Calendar fechaActual;
    private int anyoActual;
    private boolean esCorrecto = false;
    private Socio socio;
    private Faker f = new Faker(new Locale("es"));
    //Clase Controladora
    public Exercici06(){
        int year;
        float durac = 120;
        lec = new Scanner(System.in);
        videoclub = new Videoclub();
        for (int i=0; i<20; i++){
            year = Lib.random(1900,2019);
            videoclub.getInventari().getListadoMultimedia().add(new Pelicula(f.name().fullName()
                    ,f.artist().name(),Formats.BLU_RAY,year,durac,f.name().firstName()
            ,f.name().firstName()));
            videoclub.getInventari().getListadoMultimedia().add(new VideoJoc(f.name().username()
                    ,f.name().firstName(),Formats.BLU_RAY,year,Plataformas.PS4));
            videoclub.getInventari().getListadoSocios().add(new Socio("53215474y",f.name().fullName()
                    ,new GregorianCalendar(),f.lordOfTheRings().location()));
        }
        do {
            eleccio = mostrarMenuPri();
            switch (eleccio){
                case 1:{
                    seleccionAltas(menuAltas());
                    break;
                }
                case 2:{
                    alquilarMultimedia();
                    break;
                }
                case 3:{
                    recogerMultimedia();
                    break;
                }
                case 4:{
                    seleccionListados(menuListados());
                    break;
                }
                case 0:{
                    System.out.println("Hasta pronto!!");
                    break;
                }
            }
        }while (eleccio != 0);
    }

    /**
     * Metodo que recoge los datos para alquilar producto
     */
    public void alquilarMultimedia(){
        int idSocio = Integer.MAX_VALUE;
        int idProducto = Integer.MAX_VALUE;
        int posicionSocio = 0;
        char eleccion;
        LocalDate fechaAlquiler;
        do{
            //pido la id del socio
            System.out.print("Introduce el ID del socio: ");
            try {
                idSocio = Integer.parseInt(lec.nextLine());
                esCorrecto = true;
            }
            catch (NumberFormatException nfe4){
                System.out.println("Solo se aceptan numeros");
                Lib.continuar();
                esCorrecto = false;
            }
            esCorrecto = false;
            for (int i=0; i<videoclub.getInventari().getListadoSocios().size(); i++){
                if (videoclub.getInventari().getListadoSocios().get(i).getiD() == idSocio){
                    posicionSocio = i;
                    for (int z=0; z<videoclub.getInventari().getListadoSocios().get(i).getAlquilers().size(); z++) {
                        if (videoclub.getInventari().getListadoSocios().get(i).getAlquilers().isEmpty()) {
                            esCorrecto = false;
                        }
                        //compruebo si el socio tiene recargos
                        else if (videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z).getRecargo() > 0) {
                            do {
                                System.out.println("No puede alquilar tiene un recargo de: " +
                                videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z).getRecargo()
                                + " Euros," + " para el producto con id: "
                                + videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z).getIdProducto());
                                //pregunto si desea pagarlo
                                System.out.print("Desea pagarlo? selccione S o N: ");
                                eleccion = lec.next().charAt(0);
                                lec.nextLine();
                                if (eleccion == 's' || eleccion == 'S') {
                                    videoclub.pagarRecargo(videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z));
                                    esCorrecto = true;
                                } else if (eleccion == 'n' || eleccion == 'N') {
                                    System.out.println("Volviendo al menu principal...");
                                    Lib.continuar();
                                    esCorrecto = true;
                                } else {
                                    System.out.println("Solo se acepta S o N");
                                    Lib.continuar();
                                    esCorrecto = false;
                                }
                            }while (!esCorrecto);

                            return;
                        }
                    }
                    esCorrecto = true;
                }
            }
            //si esta en la base de datos.
            if (esCorrecto){
                //pido la id del producto
                esCorrecto = false;
                System.out.print("Introduce la ID del Producto: ");
                try {
                    idProducto = Integer.parseInt(lec.nextLine());
                    esCorrecto = true;
                }
                catch (NumberFormatException nfe4){
                    System.out.println("Solo se aceptan numeros");
                    Lib.continuar();
                    esCorrecto = false;
                }
                esCorrecto = false;
                //comprobamos que el producto esta en la base de datos.
                for (int i=0; i<videoclub.getInventari().getListadoMultimedia().size(); i++){
                    if (videoclub.getInventari().getListadoMultimedia().get(i).getId() == idProducto){
                        esCorrecto = true;
                    }
                }
                if (!esCorrecto){
                    System.out.println("\n\nEl producto no esta en la base de datos");
                    Lib.continuar();
                    return;
                }
                if (esCorrecto){
                    esCorrecto = false;
                    //comprobamos si el producto esta alquilado y no ha sido devuelto
                    for (int i=0; i<videoclub.getInventari().getListadoSocios().size(); i++){
                        if (videoclub.getInventari().getListadoSocios().get(i).getAlquilers().isEmpty()){
                            esCorrecto = false;
                        }
                        else if (videoclub.getInventari().getListadoSocios().get(i).getUltimoAlquiler().getIdProducto() == idProducto
                            && videoclub.getInventari().getListadoSocios().get(i).getUltimoAlquiler().getFechaDevolucion() == null){
                            System.out.println("\n\nEl producto esta alquilado por el socio: "
                            + videoclub.getInventari().getListadoSocios().get(i).toString());
                            Lib.continuar();
                            return;
                        }
                    }
                    //si esta disponible hacemos
                    if (!esCorrecto){
                        fechaAlquiler = LocalDate.now();
                        System.out.println("\n\nAlquilado correctamente al socio: ");
                        videoclub.alquilarMultimedia(fechaAlquiler, idProducto
                                ,videoclub.getInventari().getListadoSocios().get(posicionSocio));
                        return;
                    }
                }
            }
            //si no existe el socio en la base de datos.
            else{
                do {
                    System.out.println("La persona no esta en la base de datos");
                    System.out.print("Desea anyadirlo? selccione S o N: ");
                    eleccion = lec.next().charAt(0);
                    lec.nextLine();
                    if (eleccion == 's' || eleccion == 'S') {
                        seleccionAltas(menuAltas());
                        esCorrecto = true;
                    } else if (eleccion == 'n' || eleccion == 'N') {
                        System.out.println("Volviendo al menu principal...");
                        Lib.continuar();
                        esCorrecto = true;
                    } else {
                        System.out.println("Solo se acepta S o N");
                        Lib.continuar();
                        esCorrecto = false;
                    }
                }while (!esCorrecto);
            }
        }while (!esCorrecto);
    }


    /**
     * Metodo que recoge los datos para devolver producto
     */
    public void recogerMultimedia(){
        char eleccion;
        int idProducto = 0;
        do{
            System.out.print("Introduce el ID del producto: ");
            try {
                idProducto = Integer.parseInt(lec.nextLine());
                esCorrecto = true;
            }
            catch (NumberFormatException nfe4){
                System.out.println("Solo se aceptan numeros");
                Lib.continuar();
                esCorrecto = false;
            }
        }while (!esCorrecto);
        for (int i=0; i<videoclub.getInventari().getListadoSocios().size(); i++){
            for (int z = 0; z<videoclub.getInventari().getListadoSocios().get(i).getZiceAlquilers(); z++) {
                    //llamo al metodo de la clase videoclub, el qual calculara el recargo
                    videoclub.recogerMultimedia(idProducto);
                    //miro si hay recargo
                    if (videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z).getRecargo() > 0) {
                        System.out.println("Usted tiene un recargo de: " +
                        videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z).getRecargo()
                        + " Euros," + " para el producto con id: "
                        + videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z).getIdProducto());
                        //pregunto si desea pagarlo
                        do {
                            System.out.print("Desea pagarlo? selccione S o N: ");
                            eleccion = lec.next().charAt(0);
                            lec.nextLine();
                            if (eleccion == 's' || eleccion == 'S') {
                                //videoclub.pagarRecargo(videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z));
                                videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z).setRecargo(0);
                                System.out.println(videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z));
                                System.out.println("Recargo pagado con exito!!");
                                Lib.continuar();
                                esCorrecto = true;
                            } else if (eleccion == 'n' || eleccion == 'N') {
                                System.out.println("Volviendo al menu principal...");
                                Lib.continuar();
                                esCorrecto = true;
                            } else {
                                System.out.println("Solo se acepta S o N");
                                Lib.continuar();
                                esCorrecto = false;
                            }
                        }while (!esCorrecto);
                    }
            }
        }
    }


    /**
     * muestra el menu principal
     * @return retorna la eleccion del menu
     */
    public int mostrarMenuPri(){
        int eleccio = 0;
        do {
            System.out.println("*******VIDEOCLUB******");
            System.out.println("**********************");
            System.out.println("1- Altas");
            System.out.println("2- Alquilar Multimedia");
            System.out.println("3- Devolver Multimadia");
            System.out.println("4- Listados");
            System.out.println("**********************");
            System.out.println("0- Salir");
            System.out.print("Selecciona una opción: ");
            try {
                eleccio = Integer.parseInt(lec.nextLine());
                esCorrecto = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Eleccion incorrecta....");
                Lib.continuar();
            }
            if (eleccio < 0 || eleccio > 4){
                esCorrecto = false;
            }
        }while (!esCorrecto);
        return eleccio;
    }

    /**
     * muestra el menu de la seccion altas
     * @return la eleccion del menu
     */
    public int menuAltas(){
        int eleccio = 0;
        do {
            System.out.println("*********ALTAS********");
            System.out.println("**********************");
            System.out.println("1- Nueva película");
            System.out.println("2- Nuevo videojuego");
            System.out.println("3- Nuevo socio");
            System.out.println("**********************");
            System.out.println("0- Salir");
            System.out.print("Selecciona una opción: ");
            try {
                eleccio = Integer.parseInt(lec.nextLine());
                esCorrecto = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Eleccion incorrecta....");
                Lib.continuar();
            }
            if (eleccio < 0 || eleccio > 3){
                esCorrecto = false;
            }
        }while (!esCorrecto);
        return eleccio;
    }

    /**
     * recoge la eleccion del menu altas y hace la accion seleccionada
     * @param eleccioAltas
     */
    public void seleccionAltas(int eleccioAltas){
        switch (eleccioAltas){
            case 1:{
                fechaActual = Calendar.getInstance();
                anyoActual = fechaActual.get(Calendar.YEAR);
                float duracion = 0;
                String actorPrincipal = "";
                String actrizPrincipal = "";
                datosAltas();
                do{
                    esCorrecto = false;
                    System.out.print("Introduce el año: ");
                    try{
                        anyo = Integer.parseInt(lec.nextLine());
                        esCorrecto = true;
                    }
                    catch (NumberFormatException nfe2){
                        System.out.println("Solo se aceptan numeros...");
                        Lib.continuar();
                        esCorrecto = false;
                    }
                    if (anyo < 1895 || anyo > anyoActual){
                        System.out.println("El año tiene que ser posterior a 1884 " +
                                " y anterior al año actual");
                        Lib.continuar();
                        esCorrecto = false;
                    }
                }while (!esCorrecto);
                do {
                    System.out.print("Introduce la duración: ");
                    try{
                        duracion = Float.parseFloat(lec.nextLine());
                        esCorrecto = true;
                    }
                    catch (NumberFormatException nfe3){
                        System.out.println("Solo se aceptan números");
                        Lib.continuar();
                        esCorrecto = false;
                    }
                }while (!esCorrecto);
                System.out.print("Introduce el Actor principal: ");
                actorPrincipal = lec.nextLine();
                System.out.print("Introduce la Actriz principal: ");
                actrizPrincipal = lec.nextLine();
                multimedia = new Pelicula(titulo,autor,formats,anyo,duracion,actorPrincipal,actrizPrincipal);
                videoclub.registrarMultimedia(multimedia);
                break;
            }
            case 2:{
                int eleccion = 0;
                fechaActual = Calendar.getInstance();
                anyoActual = fechaActual.get(Calendar.YEAR);
                Plataformas plataforma = Plataformas.PC;
                datosAltas();
                do{
                    esCorrecto = false;
                    System.out.print("Introduce el año: ");
                    try{
                        anyo = Integer.parseInt(lec.nextLine());
                        esCorrecto = true;
                    }
                    catch (NumberFormatException nfe2){
                        System.out.println("Solo se aceptan numeros...");
                        Lib.continuar();
                        esCorrecto = false;
                    }
                    if (anyo < 1912 || anyo > anyoActual){
                        System.out.println("El año tiene que ser posterior a 1911 " +
                                " y anterior al año actual");
                        Lib.continuar();
                        esCorrecto = false;
                    }
                }while (!esCorrecto);
                do {
                    System.out.println("Selecciona la plataforma: ");
                    System.out.println("1- PS4");
                    System.out.println("2- XBOX");
                    System.out.println("3- NINTENDO");
                    System.out.println("4- PC");
                    try {
                        eleccion = Integer.parseInt(lec.nextLine());
                        esCorrecto = true;
                    }
                    catch (NumberFormatException nfe1){
                        System.out.println("Eleccion Incorrecta...");
                        Lib.continuar();
                        esCorrecto = false;
                    }
                    if (eleccion < 1 || eleccion > 4){
                        System.out.println("Eleccion incorrecta...");
                        esCorrecto = false;
                    }
                    switch (eleccion){
                        case 1:{
                            plataforma = Plataformas.PS4;
                            break;
                        }
                        case 2:{
                            plataforma = Plataformas.XBOX;
                            break;
                        }
                        case 3:{
                            plataforma = Plataformas.NINTENDO;
                            break;
                        }
                        case 4:{
                            plataforma = Plataformas.PC;
                            break;
                        }
                    }
                }while (!esCorrecto);
                multimedia = new VideoJoc(titulo,autor,formats,anyo,plataforma);
                videoclub.registrarMultimedia(multimedia);
                break;
            }
            case 3:{
                String fechaNacimiento;
                GregorianCalendar gregorianFechaNac;
                String nif;
                String nombre;
                String poblacion;
                do {
                    System.out.print("Introduce la fecha de nacimiento (formato dd-MM-yyyy): ");
                    fechaNacimiento = lec.nextLine();
                }while (!Lib.validarFecha(fechaNacimiento));
                if (calcularEdat(fechaNacimiento) < 18){
                    System.out.println("Solo se aceptan socios mayores de edad...");
                    Lib.continuar();
                }
                else{
                    gregorianFechaNac = Lib.convertStringToGregorian(fechaNacimiento);
                    do{
                        System.out.print("Introduce el NIF: ");
                        nif = lec.nextLine();
                        if (nif.length() == 9
                        && Character.isLetter(nif.charAt(nif.length()-1))){
                            esCorrecto = true;
                        }
                        else{
                            System.out.println("NIF no valido...");
                            Lib.continuar();
                            esCorrecto = false;
                        }
                    }while (!esCorrecto);
                    System.out.print("Introduce el nombre: ");
                    nombre = lec.nextLine();
                    System.out.println("Introduce la poblacion: ");
                    poblacion = lec.nextLine();
                    socio = new Socio(nif,nombre,gregorianFechaNac,poblacion);
                    videoclub.registrarSocio(socio);
                }
                break;
            }
        }
    }

    public int menuListados(){
        int eleccio = 0;
        do {
            System.out.println("1- Listado de productos");
            System.out.println("2- Listado de peliculas");//ordenades per titol
            System.out.println("3- Listado de videojuegos");//ordenats per any
            System.out.println("4- Listado total de alquileres");
            System.out.println("5- listado de alquileres actuales");//ordenats per data de lloguer
            System.out.println("6- Listado de socios con recargos");
            System.out.println("0- Volver al menu principal");
            try {
                eleccio = Integer.parseInt(lec.nextLine());
            }catch (NumberFormatException nfe6){
                System.out.println("Solo se aceptan numeros del 0 al 6 ...");
            }
            if (eleccio >= 0 && eleccio <= 6){
                esCorrecto = true;
            }
            else{
                esCorrecto = false;
            }
        }while (!esCorrecto);
        return eleccio;
    }

    public void seleccionListados(int eleccion){
        switch (eleccion){
            case 1: {
                videoclub.getInventari().mostrarMultimedias();
                break;
            }
            case 2:{
                videoclub.getInventari().mostrarPeliculesPerTitol();
                break;
            }
            case 3:{
                videoclub.getInventari().mostrarVideojocsPerAny();
                break;
            }
            case 4:{
                videoclub.getInventari().mostrarLloguers();
                break;
            }
            case 5:{
                videoclub.getInventari().mostrarLloguersActuals();
                break;
            }
            case 6:{
                videoclub.getInventari().mostrarLloguersAmbRecarrec();
                break;
            }
        }
    }

    /**
     * rellena los datos que tienen en comun los Multimedia
     */
    public void datosAltas(){
        int eleccion = 0;
        System.out.print("Introduce el Titulo: ");
        titulo = lec.nextLine();
        System.out.print("Introduce el Autor: ");
        autor = lec.nextLine();
        do {
            System.out.println("Selecciona el formato: ");
            System.out.println("1- CD");
            System.out.println("2- DVD");
            System.out.println("3- BLU-RAY");
            System.out.println("4- ARCHIVO");
            try {
                eleccion = Integer.parseInt(lec.nextLine());
                esCorrecto = true;
            }
            catch (NumberFormatException nfe1){
                System.out.println("Eleccion Incorrecta...");
                Lib.continuar();
                esCorrecto = false;
            }
            if (eleccion < 1 || eleccion > 4){
                System.out.println("Eleccion incorrecta...");
                esCorrecto = false;
            }
        }while (!esCorrecto);
        switch (eleccion){
            case 1:{
                formats = Formats.CD;
                break;
            }
            case 2:{
                formats = Formats.DVD;
                break;
            }
            case 3:{
                formats = Formats.BLU_RAY;
                break;
            }
            case 4:{
                formats = Formats.ARXIU;
                break;
            }
        }
    }

    /**
     * calcula la edad del posible nuevo socio
     * @param fechaNacimiento
     * @return
     */
    public  int calcularEdat(String fechaNacimiento){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);
        LocalDate ara = LocalDate.now();
        Period periodo = Period.between(fechaNac, ara);
        return periodo.getYears();
    }
}
