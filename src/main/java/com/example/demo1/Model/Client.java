package com.example.demo1.Model;

public class Client {
    private int id;
    private String nom;
    private String adresse;
    private String numeroTelephone;

    public Client() {
    }

    public Client(String nom, String adresse, String numeroTelephone) {
        this.nom = nom;
        this.adresse = adresse;
        this.numeroTelephone = numeroTelephone;
    }

    public Client(int id, String nom, String adresse, String numeroTelephone) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.numeroTelephone = numeroTelephone;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
}
}