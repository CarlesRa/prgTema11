/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

public class Pelicula extends Multimedia {
    private float duracio;
    private String actorPrincipal;
    private String actriuPrincipal;

    public Pelicula(String titol, String autor, Formats format, int any, float duracio, String actorPrincipal, String actriuPrincipal) {
        super(titol, autor, format, any);
        this.duracio = duracio;
        this.actorPrincipal = actorPrincipal;
        this.actriuPrincipal = actriuPrincipal;
    }

    public float getDuracio() {
        return duracio;
    }

    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public String getActriuPrincipal() {
        return actriuPrincipal;
    }



    @Override
    public String toString() {
        return
                "Pelicula: " + super.toString() +
                "duracio=" + duracio +
                ", actorPrincipal='" + actorPrincipal +
                ", actriuPrincipal='" + actriuPrincipal
                + "\n";
    }

    @Override
    int calcularPrecioAlquiler(){
        if (any < 2012){
            return PRECIO_REDUCIDO;
        }
        else{
            return PRECIO_BASE;
        }
    }

    @Override
    public int compareTo(Multimedia multimedia) {
        return this.getTitol().compareTo(multimedia.getTitol());
    }
}
