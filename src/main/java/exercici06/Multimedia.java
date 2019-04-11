/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

public abstract class Multimedia implements Comparable<Multimedia>{
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

    public int getId() {
        return id;
    }

    public void setFormat(Formats format) {
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
        return "Multimedia{" + "id=" + id +
                ", titol='" + titol + '\'' +
                ", autor='" + autor + '\'' +
                ", format=" + format +
                ", any=" + any +
                '}';
    }

    abstract int calcularPrecioAlquiler();

    @Override
    public abstract int compareTo(Multimedia multimedia);


}
