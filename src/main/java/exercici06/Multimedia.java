/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import java.util.Comparator;

public abstract class Multimedia{
    protected static final int PRECIO_BASE = 4;
    protected static final int PRECIO_REDUCIDO = 3;
    protected static final int ID_BASE = 0;
    protected String titol;
    protected String autor;
    protected Formats format;
    protected int any;
    protected int precioAlquiler;
    protected static int autoId = ID_BASE;
    protected int id;

    public Multimedia(String titol, String autor, Formats format, int any) {
        this.titol = titol;
        this.autor = autor;
        this.format = format;
        this.any = any;
        id = ++autoId;
        precioAlquiler = calcularPrecioAlquiler();
    }

    protected String getTitol() {
        return titol;
    }

    protected String getAutor() {
        return autor;
    }

    protected Formats getFormat() {
        return format;
    }

    protected int getAny() {
        return any;
    }

    protected int getId() {
        return id;
    }

    protected void setFormat(Formats format) {
        this.format = format;
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
        return " id=" + id + " Precio de Alquiler=" + precioAlquiler +
                ", titol='" + titol + '\'' +
                ", autor='" + autor + '\'' +
                ", format=" + format +
                ", any=" + any;
    }

    abstract int calcularPrecioAlquiler();

    public static class ComparatorFecha implements Comparator <Multimedia>{
        @Override
        public int compare(Multimedia multimedia, Multimedia t1) {
            return multimedia.any - t1.any;
        }
    }

    public static class ComparatorNombre implements Comparator <Multimedia>{
        @Override
        public int compare(Multimedia multimedia, Multimedia t1) {
            return multimedia.titol.compareTo(t1.titol);
        }
    }

}
