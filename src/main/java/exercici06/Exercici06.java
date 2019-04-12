/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import com.github.javafaker.Faker;
import utils.Lib;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Exercici06 {

    private Scanner lec;
    private int eleccio;
    private Videoclub videoclub;
    private Multimedia multimedia;
    private Socio socio;
    private Faker f = new Faker(new Locale("es"));

    //Clase "Main"
    public Exercici06(){
        int year;
        float durac = 120;
        lec = new Scanner(System.in);
        videoclub = new Videoclub();
        for (int i=0; i<20; i++){
            year = Lib.random(1900,2019);
            videoclub.getInventari().getListadoMultimedia().add(new Pelicula(f.name().fullName()
            ,f.artist().name(),Formats.BLU_RAY,year,durac,f.name().firstName(),f.name().firstName()));
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
        int idSocio;
        int idProducto;
        int posicionSocio = 0;
        char eleccion;
        LocalDate fechaAlquiler;
        boolean esCorrecto = false;
        //pido la id del socio
        idSocio = Lib.pedirIdSocio();
        for (int i=0; i<videoclub.getInventari().getListadoSocios().size(); i++){
            if (videoclub.getInventari().getListadoSocios().get(i).getiD() == idSocio){
                posicionSocio = i;
                esCorrecto = true;
                for (int z=0; z<videoclub.getInventari().getListadoSocios().get(i).getAlquilers().size(); z++) {
                    //compruebo si el socio tiene recargos
                    if (videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z).getRecargo() > 0) {
                        System.out.println("No puede alquilar tiene un recargo de: " +
                        videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z).getRecargo() +
                        " Euros," + " para el producto con id: " +
                        videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z).getIdProducto());
                        //pregunto si desea pagarlo
                        System.out.println("Desea pagarlo?");
                        eleccion = Lib.pedirSiNo();
                        esCorrecto = true;
                        if (eleccion == 's' || eleccion == 'S') {
                            videoclub.pagarRecargo(videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z));
                            esCorrecto = true;
                        }
                        else if (eleccion == 'n' || eleccion == 'N'){
                            return;
                        }
                    }
                }
            }
        }
        //si esta en la base de datos y no tiene recargo.
        if (esCorrecto){
            //pido la id del producto
            esCorrecto = false;
            idProducto = Lib.pedirIdProducto();
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
                //comprobamos si el producto esta alquilado
                for (int i=0; i<videoclub.getInventari().getListadoSocios().size(); i++){
                    if (videoclub.getInventari().getListadoSocios().get(i).getAlquilers().isEmpty()){
                        esCorrecto = false;
                    }
                    else if (videoclub.getInventari().getListadoSocios().get(i).getUltimoAlquiler().getIdProducto() ==
                            idProducto &&
                            videoclub.getInventari().getListadoSocios().get(i).getUltimoAlquiler().getFechaDevolucion()
                            == null){
                        System.out.println("\n\nEl producto esta alquilado por el socio: " +
                        videoclub.getInventari().getListadoSocios().get(i).toString());
                        Lib.continuar();
                        esCorrecto = false;
                        return;
                    }
                }
                //si esta disponible hacemos
                if (!esCorrecto){
                    fechaAlquiler = LocalDate.of(2019,04,Lib.random(6,12));
                    videoclub.alquilarMultimedia(fechaAlquiler, idProducto
                                ,videoclub.getInventari().getListadoSocios().get(posicionSocio));
                    System.out.println("\n\nAlquilado correctamente al socio: ");
                    System.out.println(videoclub.getInventari().getListadoSocios().get(posicionSocio).mostrarSocio());
                    Lib.continuar();
                    return;
                }
            }
        }
        //si no existe el socio en la base de datos.
        else{
            System.out.println("La persona no esta en la base de datos");
            System.out.println("Desea anyadirlo?");
            eleccion = Lib.pedirSiNo();
            lec.nextLine();
            if (eleccion == 's' || eleccion == 'S') {
                seleccionAltas(menuAltas());
            }
            else if (eleccion == 'n' || eleccion == 'N') {
                System.out.println("Volviendo al menu principal...");
                Lib.continuar();
            }
        }
    }


    /**
     * Metodo que recoge los datos para devolver producto
     */
    public void recogerMultimedia(){
        char eleccion;
        int idProducto;
        idProducto = Lib.pedirIdProducto();
        boolean esCorrecto = true;
        //llamo al metodo de la clase videoclub, el qual calculara el recargo
        videoclub.recogerMultimedia(idProducto);
        for (int i=0; i<videoclub.getInventari().getListadoSocios().size(); i++){
            for (int z = 0; z<videoclub.getInventari().getListadoSocios().get(i).getZiceAlquilers(); z++) {
                //miro si hay recargo
                if (videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z).getIdProducto()
                    == idProducto
                    && videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z).getRecargo() > 0) {
                    esCorrecto = false;
                    System.out.println("Usted tiene un recargo de: " +
                            videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z).getRecargo()
                        + " Euros," + " para el producto con id: "
                        + videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z).getIdProducto());
                    //pregunto si desea pagarlo
                    System.out.println("Desea pagarlo");
                    eleccion = Lib.pedirSiNo();
                    if (eleccion == 's' || eleccion == 'S') {
                        videoclub.pagarRecargo(videoclub.getInventari().getListadoSocios().get(i).getAlquilers().get(z));
                        System.out.println("Recargo pagado con exito!!");
                        Lib.continuar();
                    }
                    else if (eleccion == 'n' || eleccion == 'N') {
                        System.out.println("Volviendo al menu principal...");
                        Lib.continuar();
                    }

                }
            }
        }
        if (esCorrecto){
            System.out.println("Sin recargos!!");
            Lib.continuar();
        }
    }

    /**
     * muestra el menu principal
     * @return retorna la eleccion del menu
     */
    public int mostrarMenuPri(){
        boolean esCorrecto = false;
        int eleccio = 0;
        do {
            Lib.limpiarPantalla();
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
        boolean esCorrecto = false;
        do {
            Lib.limpiarPantalla();
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
        boolean esCorrecto = false;
        Calendar fechaActual = Calendar.getInstance();
        int anyoActual = fechaActual.get(Calendar.YEAR);
        float duracion = 0;
        String actorPrincipal;
        String actrizPrincipal;
        Plataformas plataforma = Plataformas.PC;
        String titulo;
        String autor;
        int anyo;
        int eleccion = 0;
        Formats formats;
        String fechaNacimiento;
        GregorianCalendar gregorianFechaNac;
        String nif;
        String nombre;
        String poblacion;
        switch (eleccioAltas){
            //nueva pelicula
            case 1:{
                titulo = Lib.introducirTitulo();
                autor = Lib.pedirAutor();
                formats = Lib.pedirFormato();
                do{
                    esCorrecto = false;
                    anyo = Lib.introducirAno();
                    //si el año es aterior al la primera pelicula o posterior al actual
                    if (anyo < 1895 || anyo > anyoActual){
                        System.out.println("El año tiene que ser posterior a 1884 " +
                                " y anterior al año actual");
                        Lib.continuar();
                        esCorrecto = false;
                    }
                    else{
                        esCorrecto = true;
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
            //nuevo videojuego
            case 2:{
                fechaActual = Calendar.getInstance();
                anyoActual = fechaActual.get(Calendar.YEAR);
                titulo = Lib.introducirTitulo();
                autor = Lib.pedirAutor();
                formats = Lib.pedirFormato();
                do{
                    anyo = Lib.introducirAno();
                    if (anyo < 1912 || anyo > anyoActual){
                        System.out.println("El año tiene que ser posterior a 1911 " +
                                " y anterior al año actual");
                        Lib.continuar();
                        esCorrecto = false;
                    }
                    else{
                        esCorrecto = true;
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
            //nuevo socio
            case 3:{
                fechaNacimiento = Lib.introducirFecha();
                if (Lib.calcularEdat(fechaNacimiento) < 18){
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
                    System.out.print("Introduce la poblacion: ");
                    poblacion = lec.nextLine();
                    socio = new Socio(nif,nombre,gregorianFechaNac,poblacion);
                    videoclub.registrarSocio(socio);
                }
                break;
            }
        }
    }

    /**
     * muestra el menu de listados
     * @return
     */
    public int menuListados(){
        int eleccio = 0;
        boolean esCorrecto = false;
        do {
            Lib.limpiarPantalla();
            System.out.println("1- Listado de productos");
            System.out.println("2- Listado de peliculas");//ordenades per titol
            System.out.println("3- Listado de videojuegos");//ordenats per any
            System.out.println("4- Listado total de alquileres de un socio");
            System.out.println("5- listado de alquileres actuales de un socio");//ordenats per data de lloguer
            System.out.println("6- Listado de socios con recargos");
            System.out.println("0- Volver al menu principal");
            System.out.print("Selecciona una opcion: ");
            try {
                eleccio = Integer.parseInt(lec.nextLine());
            }catch (NumberFormatException nfe6){
                esCorrecto = false;
            }
            if (eleccio >= 0 && eleccio <= 6){
                esCorrecto = true;
            }
            else{
                System.out.println("Solo se aceptan numeros del 0 al 6 ...");
                esCorrecto = false;
            }
        }while (!esCorrecto);
        return eleccio;
    }

    /**
     * recoge la eleccion del menu listados y ejecuta la accion seleccionada
     * @param eleccion
     */
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
                videoclub.getInventari().mostrarLloguers(Lib.pedirIdSocio());
                break;
            }
            case 5:{
                videoclub.getInventari().mostrarLloguersActuals(Lib.pedirIdSocio());
                break;
            }
            case 6:{
                videoclub.getInventari().mostrarsocisAmbRecarrec();
                break;
            }
        }
    }

}
