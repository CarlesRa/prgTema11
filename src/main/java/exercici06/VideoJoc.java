/*
 * Copyright (c) Carles Ramos
 */

package exercici06;


public class VideoJoc extends Multimedia{
    private Plataformas plataformas;


    public VideoJoc(String titol, String autor, Formats format, int any,Plataformas plataformas) {
        super(titol, autor, format, any);
        this.plataformas = plataformas;
    }

    public Plataformas getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(Plataformas plataformas) {
        this.plataformas = plataformas;
    }

    @Override
    public String toString() {
        return "VideoJoc: " + super.toString() +
                "plataformas=" + plataformas
                + "\n";
    }

    @Override
    int calcularPrecioAlquiler() {
        if (any < 2010){
            return PRECIO_REDUCIDO;
        }
        else{
            return PRECIO_BASE;
        }
    }

    @Override
    public int compareTo(Multimedia multimedia) {
        return this.any - multimedia.any;
    }
}
