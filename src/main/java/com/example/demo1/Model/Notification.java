package com.example.demo1.Model;

import java.time.LocalDateTime;

public class Notification {
    public int id;
    private String contenu;
    private LocalDateTime date;

    public Notification() {
    }

    // Constructeur
    public Notification(int id, String contenu, LocalDateTime date) {
        this.id = id;
        this.contenu = contenu;
        this.date = date;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
