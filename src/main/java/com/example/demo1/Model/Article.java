package com.example.demo1.Model;

public class Article {
    private int id;
    private static int compteur=0;
    private String libelle;
    private float prixUnitaire;
    private float prixVente;
    private int quantiteDisponible;
    public Article(){}
    public Article(String libelle, Float prixUnitaire, Float prixVente, Integer quantiteDisponible) {
        compteur++;
        this.id=compteur;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.prixVente = prixVente;
        this.quantiteDisponible = quantiteDisponible;
    }

    public Article(int id, String libelle, float prixUnitaire, float prixVente, int quantiteDisponible) {
        this.id = id;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.prixVente = prixVente;
        this.quantiteDisponible = quantiteDisponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCompteur() {
        return compteur;
    }

    public static void setCompteur(int compteur) {
        Article.compteur = compteur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public float getPrixVente() {
        return prixVente;
    }
    public void setPrixVente(float prixVente) {
        this.prixVente = prixVente;
    }

    public int getQuantiteDisponible() {
        return quantiteDisponible;
    }

    public void setQuantiteDisponible(int quantiteDisponible) {
        this.quantiteDisponible = quantiteDisponible;
    }
    public void updateQuntity(int qantity){
        this.quantiteDisponible+=qantity;
    }
    @Override
    public String toString() {
        return String.valueOf(id);
    }

}

