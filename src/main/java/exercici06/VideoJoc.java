/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import java.util.ArrayList;

public class VideoJoc extends Multimedia{
    private ArrayList<Plataformas> plataformas;


    public VideoJoc(String titol, String autor, Formats format, int any,ArrayList<Plataformas>plataformas) {
        super(titol, autor, format, any);
        this.plataformas = plataformas;
    }

    public ArrayList<Plataformas> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(ArrayList<Plataformas> plataformas) {
        this.plataformas = plataformas;
    }

    public void addPlataforma(Plataformas plataforma){
        plataformas.add(plataforma);
    }

    @Override
    public String toString() {
        return "VideoJoc{" + super.toString() +
                "plataformas=" + plataformas +
                '}';
    }
}
