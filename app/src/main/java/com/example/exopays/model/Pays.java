package com.example.exopays.model;

import java.io.Serializable;

public class Pays implements Serializable {
    private long id;
    private String continent;
    private String nom;
    private long nombre_habitants;
    private long superficie;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getNombre_habitants() {
        return nombre_habitants;
    }

    public void setNombre_habitants(long nombre_habitants) {
        this.nombre_habitants = nombre_habitants;
    }

    public long getSuperficie() {
        return superficie;
    }

    public void setSuperficie(long superficie) {
        this.superficie = superficie;
    }

    @Override
    public String toString() {
        return "Pays{" +
                "id=" + id +
                ", continent='" + continent + '\'' +
                ", nom='" + nom + '\'' +
                ", nombre_habitants=" + nombre_habitants +
                ", superficie=" + superficie +
                '}';
    }
}
