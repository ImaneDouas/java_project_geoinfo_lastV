package com.example.demo1;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private Connection connection;

    // Constructeur prenant une connexion à la base de données
    public NotificationService(Connection connection) {
        this.connection = connection;
    }

    public NotificationService() {

    }

    // Méthode pour récupérer les notifications du commerçant spécifié
    public List<String> getNotificationsForCommercant(int commercantId) {
        List<String> notifications = new ArrayList<>();
        try {
            // Requête SQL pour récupérer les notifications du commerçant depuis la base de données
            String query = "SELECT message FROM notifications WHERE commercant_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, commercantId);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Parcourir les résultats de la requête et ajouter les notifications à la liste
            while (resultSet.next()) {
                String message = resultSet.getString("message");
                notifications.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notifications;
    }
}
