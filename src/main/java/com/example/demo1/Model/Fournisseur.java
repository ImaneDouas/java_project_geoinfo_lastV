package com.example.demo1.Model;

public class Fournisseur {
    private int idFournisseur;
    private String nomPrenom;
    private String adresse;
    private String telephone;
    private String fax;
    private String commentaire;

    public Fournisseur(){}

    public Fournisseur(int idFournisseur,String nomPrenom,String telephone,String fax,String adresse,String commentaire){
        this.idFournisseur=idFournisseur;
        this.nomPrenom=nomPrenom;
        this.adresse=adresse;
        this.telephone=telephone;
        this.fax=fax;
        this.commentaire=commentaire;
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return String.valueOf(idFournisseur);
    }

}
