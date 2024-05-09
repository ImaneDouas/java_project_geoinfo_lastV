package com.example.demo1.Model;

import java.sql.Date;

public class Vente {
    private int id_vente;
    private Article article;
    private Client client;
    private Date Date_vente;
    private int quantityVente;


    public Vente(int id_vente, Article article, Client client, Date date_vente, int quantityVente) {
        this.id_vente = id_vente;
        this.article = article;
        this.client = client;
        this.Date_vente = date_vente;
        this.quantityVente = quantityVente;
    }

    public int getId_vente() {
        return id_vente;
    }

    public void setId_vente(int id_vente) {
        this.id_vente = id_vente;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate_vente() {
        return Date_vente;
    }

    public void setDate_vente(Date date_vente) {
        Date_vente = date_vente;
    }

    public int getQuantityVente() {
        return quantityVente;
    }

    public void setQuantityVente(int quantityVente) {
        this.quantityVente = quantityVente;
    }

    public float getPrixTotaleVente() {
        return this.quantityVente*this.article.getPrixVente();
    }
    public int getIdClient(){
        return this.client.getId();
    }
    public int getIdArticle(){
        return this.article.getId();
    }


}