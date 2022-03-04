package com.example.exopays.model;

import java.io.Serializable;

public class Pays implements Serializable {
    private long id;
    private String continent;
    private String nom;
    private long nombreHabitants;
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

    public long getNombreHabitants() {
        return nombreHabitants;
    }

    public void setNombreHabitants(long nombreHabitants) {
        this.nombreHabitants = nombreHabitants;
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
                ", nombreHabitants=" + nombreHabitants +
                ", superficie=" + superficie +
                '}';
    }
}
