/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

    abstract class Item {
    protected String nombre;
    protected static final String NOMBRE_POR_DEFECTO = "Item";
    protected Rareza rareza;
    protected static final Rareza RAREZA_POR_DEFECTO = Rareza.COMUN;
    protected Personaje personaje;
    public static final Personaje PERSONAJE_POR_DEFECTO = Personaje.ENDERDRAGON;
    protected int nivelNecesario;
    protected static final int NIVEL_POR_DEFECTO = 0;
    protected int cantidad;
    protected static final int CANTIDAD_DEFECTO = 0;

    public Item(String nombre, Rareza rareza,Personaje personaje, int nivelNecesario) {
        this.nombre = nombre;
        this.rareza = rareza;
        this.personaje = personaje;
        this.nivelNecesario = nivelNecesario;
        this.cantidad = CANTIDAD_DEFECTO;
    }
    public Item(){
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO);
    }

    public String getNombre() {
        return nombre;
    }

    public Rareza getRareza() {
        return rareza;
    }


    public Personaje getPersonaje() {
        return personaje;
    }

        public int getNivelNecesario() {
        return nivelNecesario;
    }

        @Override
        public String toString() {
            return "Item: " +
                    "nombre='" + nombre + '\'' +
                    ", rareza=" + rareza +
                    ", personaje=" + personaje +
                    ", nivelNecesario=" + nivelNecesario +
                    ", cantidad=" + cantidad;
        }
    }
