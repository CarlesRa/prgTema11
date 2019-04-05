/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

public abstract class Multimedia {
    protected String titol;
    protected String autor;
    protected Formats format;
    protected int any;
    protected boolean estaDisponible;

    public Multimedia(String titol, String autor, Formats format, int any) {
        this.titol = titol;
        this.autor = autor;
        this.format = format;
        this.any = any;
        estaDisponible = true;
    }

    public String getTitol() {
        return titol;
    }

    public String getAutor() {
        return autor;
    }

    public Formats getFormat() {
        return format;
    }

    public int getAny() {
        return any;
    }

    public boolean getEstaDisponible() {
        return estaDisponible;
    }

    public void setFormat(Formats format) {
        this.format = format;
    }

    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Multimedia)) return false;
        Multimedia that = (Multimedia) o;
        return getTitol().equals(that.getTitol()) &&
                getAutor().equals(that.getAutor());
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "titol='" + titol + '\'' +
                ", autor='" + autor + '\'' +
                ", format=" + format +
                ", any=" + any +
                '}';
    }
}
