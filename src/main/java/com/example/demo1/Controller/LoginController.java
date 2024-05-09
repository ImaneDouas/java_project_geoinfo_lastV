package com.example.demo1.Controller;

import com.example.demo1.Model.DataBaseConnection;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;


import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;

import java.net.MalformedURLException;

import java.io.IOException;

import java.net.URI;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.net.URL;


public class LoginController implements Initializable {
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMsgLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView userNameImgView;
    @FXML
    private ImageView passwordImgView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextFiled;


    @FXML
    private Label adminText;
    @FXML
    private Label Achat;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //first image
        File brandingFile = new File("Images/solutions-GestionStock2.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        // dans login.fxml il ya l fx:id="brandingImageView"
        brandingImageView.setImage(brandingImage);
        // image icon userName
        File userNameFile = new File("Images/7153150.png");
        Image userNameImage = new Image(userNameFile.toURI().toString());
        userNameImgView.setImage(userNameImage);
        // image icon password
        File passwordFile = new File("Images/3408455.png");
        Image passwordImg = new Image(passwordFile.toURI().toString());
        passwordImgView.setImage(passwordImg);

        //hadi kantester biha âge admin qbl man3ml login role admin




    }

    public void loginButtonOnAction(ActionEvent event) {

        if (usernameTextField.getText().isBlank() == false && passwordTextFiled.getText().isBlank() == false) {
            //loginMsgLabel.setText("You try to login");

            validateLogin();
        } else {
            loginMsgLabel.setText("Please nter username and password");
        }
    }

    public void validateLogin() {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDb = connectNow.getConnection();

        String verifyLogin = "SELECT * FROM user WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordTextFiled.getText() + "'";

        try {
            Statement statement = connectDb.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            if (queryResult.next()) {
                String role = queryResult.getString("role");
                if (role.equals("administrateur")) {
                    loadAdminPage();
                } else {
                    Commercant_DashBoard();
                }
            } else {
                loginMsgLabel.setText("Invalid login, please try again!");
            }


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void Commercant_DashBoard() {
        try {
            // Charger le fichier FXML de la page d'administration
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo1/CommercantDashBoard.fxml"));
            // Créer une nouvelle scène avec la page d'administration chargée
            Scene scene = new Scene(root);

            // Récupérer la fenêtre actuelle
            Stage stage = new Stage();
            stage.setScene(scene);

            // Centrer la fenêtre sur l'écran

            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            stage.setX((screenBounds.getWidth() - stage.getWidth()) / 2);
            stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);

            // Afficher la fenêtre
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadAdminPage() {
        try {
            // Charger le fichier FXML de la page d'administration
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo1/admin.fxml"));
            // Créer une nouvelle scène avec la page d'administration chargée
            Scene scene = new Scene(root);

            // Récupérer la fenêtre actuelle
            Stage stage = new Stage();
            stage.setScene(scene);

            // Centrer la fenêtre sur l'écran

            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            stage.setX((screenBounds.getWidth() - stage.getWidth()) / 2);
            stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);

            // Afficher la fenêtre
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}