package com.api.hexagonal.domini.puertos.salida;

public interface UploadcareClientPort {
    String subirArchivo(byte[] archivo, String nombreArchivo);
}
