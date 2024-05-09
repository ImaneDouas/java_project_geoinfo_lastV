package com.example.demo1.Model;



import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Achat {
    private int idAchat;
    private Article article;
    private Fournisseur fournisseur;
    private int quantiteAchat;
    private double prixUnitaire;
    private double prixTotal;
    private double prixVente;
    private Date dateAchat;
    private LocalDate dateActuelle;
    private long duree;


    public Achat(){}
    public Achat(int idAchat, Article article, Fournisseur fournisseur, int quantiteAchat, double prixUnitaire,
                 double prixTotal, double prixVente, Date dateAchat) {
        this.idAchat = idAchat;
        this.article = article;
        this.fournisseur = fournisseur;
        this.quantiteAchat = quantiteAchat;
        this.prixUnitaire = prixUnitaire;
        this.prixTotal = prixTotal;
        this.prixVente = prixVente;
        this.dateAchat = dateAchat;
        //this.statutAchat = statutAchat;
    }

  public Achat(int idAchat, Article article, Fournisseur fournisseur, int quantiteAchat, double prixUnitaire,
               double prixTotal, double prixVente, LocalDate dateAchat) {
      this.idAchat = idAchat;
      this.article = article;
      this.fournisseur = fournisseur;
      this.quantiteAchat = quantiteAchat;
      this.prixUnitaire = prixUnitaire;
      this.prixTotal = prixTotal;
      this.prixVente = prixVente;
      this.dateAchat = Date.valueOf(dateAchat);
      this.dateActuelle = LocalDate.now(); // Date actuelle
      this.duree = ChronoUnit.DAYS.between(dateAchat, this.dateActuelle); // Calcul de la durée
  }



    public int getIdAchat() {
        return idAchat;
    }

    public void setIdAchat(int idAchat) {
        this.idAchat = idAchat;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public int getQuantiteAchat() {
        return quantiteAchat;
    }

    public void setQuantiteAchat(int quantiteAchat) {
        this.quantiteAchat = quantiteAchat;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

   /* public String getStatutAchat() {
        return statutAchat;
    }

    public void setStatutAchat(String statutAchat) {
        this.statutAchat = statutAchat;
    }*/
    public int getIdArticle() {
        return this.article.getId(); // Supposant que votre classe Article possède une méthode getId() qui renvoie l'ID de l'article.
    }
    public int getIdFournisseur() {
        return this.fournisseur.getIdFournisseur(); // Supposant que votre classe Article possède une méthode getId() qui renvoie l'ID de l'article.
    }

    public LocalDate getDateActuelle() {
        return dateActuelle;
    }

    public void setDateActuelle(LocalDate dateActuelle) {
        this.dateActuelle = dateActuelle;
    }

    public long getDuree() {
        return duree;
    }

    public void setDuree(long duree) {
        this.duree = duree;
    }
    public static long calculerDureeEnJours(LocalDate dateAchat) {
        return ChronoUnit.DAYS.between(dateAchat, LocalDate.now());
    }

    public void afficherDuree() {
        System.out.println("Achat ID: " + idAchat + ", Durée: " + duree + " jours");
    }

}