/*
 * Copyright (c) Carles Ramos
 */

package exercici05;

public class Item {
    protected String nombre;
    protected static final String NOMBRE_POR_DEFECTO = "Item";
    protected Rareza rareza;
    protected static final Rareza RAREZA_POR_DEFECTO = Rareza.COMUN;
    protected Tipo tipo;
    protected static final Tipo TIPO_POR_DEFECTO = Tipo.AMULET;
    protected Personaje personaje;
    public static final Personaje PERSONAJE_POR_DEFECTO = Personaje.ENDERDRAGON;
    protected int nivelNecesario;
    protected static final int NIVEL_POR_DEFECTO = 0;

    public Item(String nombre, Rareza rareza, Tipo tipo, Personaje personaje, int nivelNecesario) {
        this.nombre = nombre;
        this.rareza = rareza;
        this.tipo = tipo;
        this.personaje = personaje;
        this.nivelNecesario = nivelNecesario;
    }
    public Item(){
        this(NOMBRE_POR_DEFECTO,RAREZA_POR_DEFECTO,TIPO_POR_DEFECTO,PERSONAJE_POR_DEFECTO,NIVEL_POR_DEFECTO);
    }

    public String getNombre() {
        return nombre;
    }

    public Rareza getRareza() {
        return rareza;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public int getNivelNecesario() {
        return nivelNecesario;
    }
}
