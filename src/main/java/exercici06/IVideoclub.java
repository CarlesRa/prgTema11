/*
 * Copyright (c) Carles Ramos
 */

package exercici06;

import java.time.LocalDate;

public interface IVideoclub {
    void registrarMultimedia(Multimedia multimedia);
    void registrarSocio(Socio socio);
    void alquilarMultimedia(LocalDate fechaAlquiler, int idMultimedia, Socio socio);
    void recogerMultimedia(int idMultimedia);
    int calcularRecargo(Alquiler alquiler);
    void pagarRecargo(Alquiler alquiler);
}

