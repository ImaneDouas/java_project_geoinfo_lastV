package com.example.demo1.Controller;
import com.example.demo1.Model.Commercant;
import com.example.demo1.Model.DataBaseConnection;
import com.example.demo1.View.ActionsCell;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.control.*;
import java.sql.*;
import javafx.scene.control.TextField;


import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

   @FXML
   private ImageView imageUser;
   @FXML
   private ImageView imgPoint;
   @FXML
   private ImageView imgHome;
   @FXML
   private ImageView imgConfigIni;
   @FXML
   private ImageView imgDb;
   @FXML
   private ImageView graphe;
   @FXML
   private ImageView imgConfig2;
   @FXML
   private ImageView imgAlerte;
   @FXML
   private ImageView imgSearch;
   @FXML
   private ImageView imgPoint2;

   @FXML
   private ImageView imgPoint211;
   @FXML
   private ImageView imgPoint2111;
   @FXML
   private ImageView imgAchatDash;

   @FXML
   private ImageView updateCom;
   @FXML
   private ImageView add_comm;
   @FXML
   private ImageView deleteComm;
   @FXML
   private ImageView imgSearch1;

   @FXML
   private Pane id_pane;

   @FXML
   private Pane autre_pane;
   @FXML
   private Pane formulaireCom;
   @FXML
   private Button ajouterNvCom;


   @FXML
   private TableView<Commercant> tableView;
   @FXML
   private ImageView IconPlus;
   @FXML
   private TextField btn_search1;



   private Connection connection;
   private AdminController adminController = this;



   @FXML
   private TableColumn<Commercant, Void> Actions;
   @FXML
   private TextField NomC1,EmailC,TeleC,AdressC;

   @FXML
   private Button btn_addC;

   @FXML
   private TextField searchTextField;
   private FilteredList<Commercant> filteredData;
   @FXML
   private Label fournisseurNMBR;
   @FXML
   private Label ClientNMB;
   @FXML
   private Label commercantNMBR;
   @FXML
   private Label AchatNMBR;
   @FXML
   private Label articleNMBR;
   @FXML
   private ImageView imgCommdash;


   @Override
   public void initialize(URL url, ResourceBundle resourceBundle){

      ajouterNvCom.setVisible(true);
      formulaireCom.setVisible(false);
      //first image user
      File imageUserFile = new File("Images/userImage.png");
      Image imageUserImage = new Image(imageUserFile.toURI().toString());
      imageUser.setImage(imageUserImage);

      File imageFirstPointFile = new File("Images/imagePoint.png");
      Image imageeFirstPointImage = new Image(imageFirstPointFile.toURI().toString());
      imgPoint.setImage(imageeFirstPointImage);

      File imageHomeFile = new File("Images/imageHome.png");
      Image imageHomeImage = new Image(imageHomeFile .toURI().toString());
      imgHome.setImage(imageHomeImage);

      File imageConfigIniFile = new File("Images/imageConfigIni.png");
      Image imageConfigIni = new Image(imageConfigIniFile.toURI().toString());
      imgConfigIni.setImage(imageConfigIni);

      File imageDbFile = new File("Images/imageDb.png");
      Image imageDb = new Image(imageDbFile.toURI().toString());
      imgDb.setImage(imageDb);

      File imageSearFile = new File("Images/Search.png");
      Image imageSr = new Image(imageSearFile.toURI().toString());
      imgSearch1.setImage(imageSr);


      File imageSearchFile = new File("Images/imgSearch.png");
      Image imageSearch = new Image(imageSearchFile.toURI().toString());
      imgSearch.setImage(imageSearch);

      File imagePoint2File = new File("Images/costumer.png");
      Image imagePoint2 = new Image(imagePoint2File.toURI().toString());
      imgPoint2.setImage(imagePoint2);

//      File imagePoint3File = new File("Images/imagePoint.png");

      File imagePoint211File = new File("Images/items.png");
      Image imagePoint211 = new Image(imagePoint211File.toURI().toString());
      imgPoint211.setImage(imagePoint211);
      File imagePoint2111File = new File("Images/suppliers.png");
      Image imagePoint2111 = new Image(imagePoint2111File.toURI().toString());
      imgPoint2111.setImage(imagePoint2111);
      //end of new for dash
      File imageConfigFile = new File("Images/achat.jpeg");
      Image imageConfig = new Image(imageConfigFile.toURI().toString());
      imgAchatDash.setImage(imageConfig);
      File graphei = new File("Images/graphe.png");
      Image imgg = new Image(graphei.toURI().toString());
      graphe.setImage(imgg);
      File imageUpdateFile = new File("Images/update.png");
      Image imageUpdate = new Image(imageUpdateFile.toURI().toString());
      updateCom.setImage(imageUpdate);

      File imageAddFile = new File("Images/add.png");
      Image imageAdd = new Image(imageAddFile.toURI().toString());
      add_comm.setImage(imageAdd);

      File imgComD = new File("Images/commercantdash.png");
      Image img = new Image(imgComD.toURI().toString());
      imgCommdash.setImage(img);

      File imageDeleteFile = new File("Images/delete.png");
      Image imageDelete = new Image(imageDeleteFile.toURI().toString());
      deleteComm.setImage(imageDelete);

      File imagePlusFile = new File("Images/Plus.png");
      Image imagePlus = new Image(imagePlusFile.toURI().toString());
      IconPlus.setImage(imagePlus);
      btn_search1.textProperty().addListener((observable, oldValue, newValue) -> {
         if (newValue.isEmpty()) {
            // Afficher tous les éléments de la table
            tableView.setItems(tableView.getItems());
         } else {
            // Filtrer les éléments en fonction du texte de recherche
            filterTableView(newValue);
         }
      });



      DataBaseConnection databaseConnection = new DataBaseConnection();
      connection = databaseConnection.getConnection();

      //faire appel ou bien creer les  actions de a cellul actions


      Actions.setCellFactory(param -> new ActionsCell(adminController));
      // Ajouter un gestionnaire d'événement pour l'ImageView de recherche
      imgSearch1.setOnMouseClicked(event -> {
         searchCommercants();
      });

      fournisseurNMBR.setText(String.valueOf( countFour()));
      ClientNMB.setText(String.valueOf( countClient()));
      articleNMBR.setText(String.valueOf( countArticle()));
      commercantNMBR.setText(String.valueOf( countCommer()));
      AchatNMBR.setText(String.valueOf( countAchat()));


   }


   @FXML
   private void handleAjouterNvCom(ActionEvent event) {

      formulaireCom.setVisible(!formulaireCom.isVisible());
      if (formulaireCom.isVisible()) {
         tableView.setLayoutY(380.0);
         formulaireCom.setLayoutY(58.0);
      } else {
         tableView.setLayoutY(170.0);
      }
   }
   @FXML
   private void handleAjouterCommercant(ActionEvent event) {
      // Code pour ajouter le commerçant à la base de données
      String nom = NomC1.getText();
      String email = EmailC.getText();
      String telephone = TeleC.getText();
      String adresse = AdressC.getText();

      // Vérification des champs non vides avant d'ajouter à la base de données
      if (!nom.isEmpty() && !email.isEmpty() && !telephone.isEmpty() && !adresse.isEmpty()) {
         // Appel à la méthode pour ajouter le commerçant à la base de données
         ajouterCommercant(nom, email, telephone, adresse);

         // Effacer les champs du formulaire après l'ajout
         clearFormFields();
      } else {
         System.out.println("Erreur ...!");
      }
   }

   // Méthode pour ajouter un nouveau commerçant à la base de données
   private void ajouterCommercant(String nom, String email, String telephone, String adresse) {
      try {
         // Code pour insérer les données dans la base de données
         String query = "INSERT INTO commercants (nom, email, telephone, adresse) VALUES (?, ?, ?, ?)";
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, nom);
         preparedStatement.setString(2, email);
         preparedStatement.setString(3, telephone);
         preparedStatement.setString(4, adresse);

         // Exécuter la requête d'insertion
         preparedStatement.executeUpdate();

         // Recharger les commerçants dans le TableView après l'ajout
         loadCommercants();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   @FXML
   void onGestionCommercantsClicked(ActionEvent event) {
      id_pane.setVisible(false); // Masquer la Pane actuelle
      autre_pane.setVisible(true); // Afficher la nouvelle Pane
      loadCommercants();

   }
   // Méthode pour charger les commerçants depuis la base de données
   private void loadCommercants() {
      try {
         String query = "SELECT * FROM commercants";
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query);

         ArrayList<Commercant> commercants = new ArrayList<>();
         while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            String adresse = resultSet.getString("adresse");
            String email = resultSet.getString("email");
            String telephone = resultSet.getString("telephone");

            Commercant commercant = new Commercant(id, nom, adresse, email, telephone);
            commercants.add(commercant);
         }

         // Effacer les éléments précédents du TableView
         tableView.getItems().clear();
         // Afficher les commerçants dans le TableView
         tableView.getItems().addAll(commercants);

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }


   private void clearFormFields() {
      // Effacer les champs du formulaire après la modification
      NomC1.clear();
      EmailC.clear();
      TeleC.clear();
      AdressC.clear();
   }
   public void supprimerCommercant(Commercant commercant) {
      try {
         // Code pour supprimer le commerçant de la base de données en utilisant son ID
         String query = "DELETE FROM commercants WHERE id = ?";
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         preparedStatement.setInt(1, commercant.getId());
         // Exécuter la requête de suppression
         preparedStatement.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void showModificationForm(Commercant commercant) {
      // Remplir les champs du formulaire avec les données du commerçant
      NomC1.setText(commercant.getNom());
      EmailC.setText(commercant.getEmail());
      TeleC.setText(commercant.getTelephone());
      AdressC.setText(commercant.getAdresse());

      // Rendre le formulaire visible
      formulaireCom.setVisible(true);
      // Définir la position du formulaire

      formulaireCom.setLayoutY(170.0);

      // Ajouter un gestionnaire d'événement pour le bouton "Ajouter" du formulaire
      btn_addC.setOnAction(event -> {
         // Récupérer les nouvelles données du formulaire
         String nouveauNom = NomC1.getText();
         String nouveauEmail = EmailC.getText();
         String nouveauTelephone = TeleC.getText();
         String nouvelleAdresse = AdressC.getText();

         // Mettre à jour le commerçant dans la base de données
         updateCommercant(commercant.getId(), nouveauNom, nouveauEmail, nouveauTelephone, nouvelleAdresse);

         // Mettre à jour la ligne dans le TableView
         commercant.setNom(nouveauNom);
         commercant.setEmail(nouveauEmail);
         commercant.setTelephone(nouveauTelephone);
         commercant.setAdresse(nouvelleAdresse);
         tableView.refresh();

         // Masquer le formulaire
         formulaireCom.setVisible(false);
      });
   }

   public void updateCommercant(int id, String nom, String email, String telephone, String adresse) {
      try {
         String query = "UPDATE commercants SET nom=?, email=?, telephone=?, adresse=? WHERE id=?";
         PreparedStatement statement = connection.prepareStatement(query);
         statement.setString(1, nom);
         statement.setString(2, email);
         statement.setString(3, telephone);
         statement.setString(4, adresse);
         statement.setInt(5, id);

         // Exécuter la mise à jour dans la base de données
         int rowsAffected = statement.executeUpdate();

         // Vérifier si la mise à jour a réussi
         if (rowsAffected > 0) {
            System.out.println("Commerçant mis à jour avec succès.");
         } else {
            System.out.println("Échec de la mise à jour du commerçant.");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void searchCommercants() {
      String searchText = btn_search1.getText();
      filterTableView(searchText);

   }

   public void filterTableView(String searchText) {
      // Créer un FilteredList lié à la liste des commerçants de votre TableView
      FilteredList<Commercant> filteredData = new FilteredList<>(tableView.getItems(), p -> true);

      // Mettre à jour le filtre en fonction du texte de recherche
      filteredData.setPredicate(commercant -> {
         // Si le champ de recherche est vide, afficher tous les commerçants
         if (searchText == null || searchText.isEmpty()) {
            return true;
         }

         // Comparer le texte de recherche avec les attributs du commerçant (par exemple, nom, email, téléphone, adresse)
         String lowerCaseFilter = searchText.toLowerCase();
         if (commercant.getNom().toLowerCase().contains(lowerCaseFilter)
                 || commercant.getEmail().toLowerCase().contains(lowerCaseFilter)
                 || commercant.getTelephone().toLowerCase().contains(lowerCaseFilter)
                 || commercant.getAdresse().toLowerCase().contains(lowerCaseFilter)) {
            return true; // Afficher le commerçant si une correspondance est trouvée
         }
         return false; // Masquer le commerçant sinon
      });

      // Mettre à jour le TableView pour afficher les résultats filtrés
      tableView.setItems(filteredData);

   }
   @FXML
   void btn_home1(ActionEvent event){
      LoginController loginController= new LoginController();
      loginController.Commercant_DashBoard();
   }
   //dashboard
   public int countFour(){
      int nmbrFour=0;
      String selec="select count(*) from fournisseur";
      try {
         DataBaseConnection databaseConnection = new DataBaseConnection();
         connection = databaseConnection.getConnection();
         Statement st=connection.createStatement();
         ResultSet rs=st.executeQuery(selec);
         while(rs.next()){
            nmbrFour=rs.getInt("count(*)");
         }
         st.close();
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
      return nmbrFour;
   }
   public int countArticle(){
      int nmbrArticle=0;
      String selec="select count(*) from article";
      try {
         DataBaseConnection databaseConnection = new DataBaseConnection();
         connection = databaseConnection.getConnection();
         Statement st=connection.createStatement();
         ResultSet rs=st.executeQuery(selec);
         while(rs.next()){
            nmbrArticle=rs.getInt("count(*)");
         }
         st.close();
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
      return nmbrArticle;
   }
   public int countClient(){
      int nmbrClient=0;
      String selec="select count(*) from client";
      try {
         DataBaseConnection databaseConnection = new DataBaseConnection();
         connection = databaseConnection.getConnection();
         Statement st=connection.createStatement();
         ResultSet rs=st.executeQuery(selec);
         while(rs.next()){
            nmbrClient=rs.getInt("count(*)");
         }
         st.close();
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
      return nmbrClient;
   }
   public int countCommer(){
      int nmbrCommer=0;
      String selec="select count(*) from commercants";
      try {
         DataBaseConnection databaseConnection = new DataBaseConnection();
         connection = databaseConnection.getConnection();
         Statement st=connection.createStatement();
         ResultSet rs=st.executeQuery(selec);
         while(rs.next()){
            nmbrCommer=rs.getInt("count(*)");
         }
         st.close();
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
      return nmbrCommer;
   }
   public int countAchat(){
      int nmbrAchat=0;
      String selec="select count(*) from achats";
      try {
         DataBaseConnection databaseConnection = new DataBaseConnection();
         connection = databaseConnection.getConnection();
         Statement st=connection.createStatement();
         ResultSet rs=st.executeQuery(selec);
         while(rs.next()){
            nmbrAchat=rs.getInt("count(*)");
         }
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
      return nmbrAchat;
   }
   public int countVente(){
      int nmbrVente=0;
      String selec="select count(*) from vente";
      try {
         DataBaseConnection databaseConnection = new DataBaseConnection();
         connection = databaseConnection.getConnection();
         Statement st=connection.createStatement();
         ResultSet rs=st.executeQuery(selec);
         while(rs.next()){
            nmbrVente=rs.getInt("count(*)");
         }
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
      return nmbrVente;
   }
   @FXML
   void handleHomeButton(ActionEvent event){
      autre_pane.setVisible(false);
      id_pane.setVisible(true);
   }

}