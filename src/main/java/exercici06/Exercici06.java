/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import utils.Lib;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Exercici06 {
    private Scanner lec;
    private int eleccio;
    private int eleccioAltas;
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
    //Clase para administrar los datos
    public Exercici06(){
        lec = new Scanner(System.in);
        videoclub = new Videoclub();
        do {
            eleccio = mostrarMenuPri();
            switch (eleccio){
                case 1:{
                    seleccionAltas(eleccioAltas = menuAltas());
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
                    System.out.println("Hasta pronto!!");
                    break;
                }
            }
        }while (eleccio != 0);
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
                System.out.println("Introduce el Actor principal");
                actorPrincipal = lec.nextLine();
                System.out.println("Introduce la Actriz principal");
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
                        if (nif.length() < 8
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

    public  int calcularEdat(String fechaNacimiento){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);
        LocalDate ara = LocalDate.now();
        Period periodo = Period.between(fechaNac, ara);
        return periodo.getYears();
    }
}
