package utils;
import exercici06.Formats;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Lib {

    static Scanner lec = new Scanner(System.in);

    public static void limpiarPantalla() {
        System.out.print("\u001B[H\u001B[2J");
    }

    public static String letraRoja() {
        return "\u001B[31m";
    }

    public static String reiniciarColorLetra() {
        return "\u001B[0m";
    }

    public static void mensajeError() {
        System.out.print(letraRoja() +
                "Dada erronea, prega intro per continuar: " + reiniciarColorLetra());
        lec.nextLine();
    }


    public static void continuar() {
        System.out.print("Intro per continuar: ");
        lec.nextLine();
    }

    /**
     * Metode per validar dates.
     *
     * @param fecha entra un string amb la data.
     * @return
     */
    public static boolean validarFecha(String fecha) {

        try {

            SimpleDateFormat formatoFecha;
            formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

            formatoFecha.setLenient(false);

            formatoFecha.parse(fecha);

        } catch (ParseException e) {

            return false;

        }

        return true;

    }

    /**
     * Genera un numero random.
     *
     * @param min desde
     * @param max hasta
     * @return numero random generado
     */
    public static int random(int min, int max) {
        int aleatori;
        Random rnd = new Random();
        aleatori = rnd.nextInt(max - min + 1) + min;
        return aleatori;
    }

    /**
     * mostra una barra de carrega.
     *
     * @param num temps que tarda la barra en milisegons.
     */
    public static void barraCarrega(int num) {

        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(num);
            } catch (InterruptedException e) {
                // this part is executed when an exception (in this example
                // InterruptedException) occurs
            }
            System.out.print("\u001B[44m ");
        }
        System.out.println("\u001B[0m");
    }

    public static String calcularletraDni(int numeroDni) {
        int calcularLletra;
        char lletraNif;
        String stringLletraDni;
        String lletres = "TRWAGMYFPDXBNJZSQVHLCKE";
        calcularLletra = numeroDni % 23;
        lletraNif = lletres.charAt(calcularLletra);
        stringLletraDni = Character.toString(lletraNif);
        return stringLletraDni;
    }

    public static GregorianCalendar convertStringToGregorian(String fecha) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        GregorianCalendar cal = new GregorianCalendar();
        try {
            date = df.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(date);
        return cal;
    }

    public static int calcularEdat(String fechaNacimiento) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);
        LocalDate ara = LocalDate.now();
        Period periodo = Period.between(fechaNac, ara);
        return periodo.getYears();
    }

    public static int pedirIdProducto() {
        int idSocio = 0;
        boolean esCorrecto = false;
        do {
            System.out.print("Introduce el id del producto: ");
            try {
                idSocio = Integer.parseInt(lec.nextLine());
                esCorrecto = true;
            } catch (NumberFormatException nfe6) {
                System.out.println("solo se acepten numeros");
            }
        } while (!esCorrecto);
        return idSocio;
    }

    public static String introducirFecha() {
        String fechaNacimiento;
        do{
            System.out.print("Introduce la fecha de nacimiento (formato dd-MM-yyyy): ");
            fechaNacimiento = lec.nextLine();
            if (!validarFecha(fechaNacimiento)){
                System.out.println("fecha incorrecta...");
                Lib.continuar();
            }
        }while(!validarFecha(fechaNacimiento));
        return fechaNacimiento;
    }

    public static int introducirAno(){
        int anyo = 0;
        boolean esCorrecto = false;
        do {
            esCorrecto = false;
            System.out.print("Introduce el año: ");
            try {
                anyo = Integer.parseInt(lec.nextLine());
                esCorrecto = true;
            } catch (NumberFormatException nfe2) {
                System.out.println("Solo se aceptan numeros...");
                Lib.continuar();
                esCorrecto = false;
            }
        }while (!esCorrecto);
        return anyo;
    }

    public static char pedirSiNo(){
        boolean esCorrecto = false;
        char eleccion;
        do {
            System.out.print("Selccione S o N: ");
            eleccion = lec.next().charAt(0);
            lec.nextLine();
            if (eleccion == 's' || eleccion == 'S') {
                esCorrecto = true;
            }
            else if (eleccion == 'n' || eleccion == 'N') {
                esCorrecto = true;
            }
            else{
                System.out.println("Solo se acepta S o N");
                esCorrecto = false;
            }
        }while (!esCorrecto);
        return eleccion;
    }
    public static String introducirTitulo(){
        String titulo;
        System.out.print("Introduzca el título: ");{
            titulo = lec.nextLine();
        }
        return titulo;
    }

    public static String pedirAutor(){
        String autor;
        System.out.print("Introduce el autor: ");
        autor = lec.nextLine();
        return autor;
    }

    public static Formats pedirFormato(){
        Formats formats = Formats.BLU_RAY;
        int eleccion = 0;
        boolean esCorrecto;
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
        return formats;
    }
    public static int pedirIdSocio(){
        int idSocio = 0;
        boolean esCorrecto = false;
        do {
            System.out.print("Introduce el id del socio: ");
            try {
                idSocio = Integer.parseInt(lec.nextLine());
                esCorrecto = true;
            }
            catch (NumberFormatException nfe6){
                System.out.println("solo se acepten numeros");
            }
        }while (!esCorrecto);
        return idSocio;
    }
}