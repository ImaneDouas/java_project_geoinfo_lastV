package com.example.demo1.Controller;

import com.example.demo1.View.ActionsCellFournisseur;
import com.example.demo1.Model.*;
import com.example.demo1.View.*;
import javafx.beans.property.SimpleFloatProperty;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.print.PrinterJob;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


import javafx.scene.layout.Pane;
import javafx.scene.text.TextFlow;
import javafx.util.Callback;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class CommercantDashBoard implements Initializable {
    @FXML
    private ImageView logoImageView;
    @FXML
    private ImageView DashImageView;
    @FXML
    private ImageView ItemImageView;
    @FXML
    private ImageView CustomerImageView;
    @FXML
    private ImageView BuyImageView;
    @FXML
    private ImageView SellImageView;
    @FXML
    private ImageView SupplierImageView;
    @FXML
    private ImageView IconImageView;
    @FXML
    private ImageView loggedImageView;
    @FXML
    private ImageView RapportImageView;
    @FXML
    private ImageView IconPlus;
    @FXML
    private ImageView AddAc;
    @FXML
    private ImageView deleteAc;
    @FXML
    private ImageView updateAc;


    @FXML
    private AnchorPane fournisseur_form;

    @FXML
    private Button fournisseur_ajouterBTN;
    @FXML
    private TextArea notificationsTextArea;


    @FXML
    private TableView<Fournisseur> tableau_fournisseur;
    @FXML
    private TableColumn<Fournisseur, Integer> identi;
    @FXML
    private TableColumn<Fournisseur, String> adr_four;
    @FXML
    private TableColumn<Fournisseur, String> comm_four;
    @FXML
    private TableColumn<Fournisseur, String> fax_four;
    @FXML
    private TableColumn<Fournisseur, String> nom_four;
    @FXML
    private TableColumn<Fournisseur, String> num_four;


    @FXML
    private ImageView imgSearch1;
    @FXML
    TableColumn<Fournisseur, Void> Actionss;
    private CommercantDashBoard commercantDashBoard = this;

    @FXML
    private TextField teleF;
    @FXML
    private TextField nomF;
    @FXML
    private TextField FaxF;
    @FXML
    private TextField adressF;
    @FXML
    private TextField comm;
    @FXML
    private Pane formulaireFour;
    @FXML
    private Button btn_addF;

    private Connection connection;


    @FXML
    private Button Add_Achat;
    @FXML
    private Button Modifier_Achat;

    @FXML
    private TextField quantiteField;
    @FXML
    private TextField prixUnitaireField;
    @FXML
    private TextField PrixV;
    @FXML
    private DatePicker dateAchatPicker;

    @FXML
    private Pane formulaireAddAchat;
    @FXML
    private Pane rapports_achats;
    @FXML
    private Pane rapports_ventes;


    @FXML
    private TableView<Achat> tableView;

    @FXML
    private TableColumn<Achat, Integer> numAchatCol;
    @FXML
    private TableColumn<Achat, Integer> idArticleCol;
    @FXML
    private TableColumn<Achat, Integer> idFournisseurCol;
    @FXML
    private TableColumn<Achat, Integer> qtyAchatCol;
    @FXML
    private TableColumn<Achat, Double> prixUnitaireCol;
    @FXML
    private TableColumn<Achat, Double> prixTotalCol;
    @FXML
    private TableColumn<Achat, Double> prixVenteCol;
    @FXML
    private TableColumn<Achat, Date> dateAchatCol;

    @FXML
    private ComboBox<Fournisseur> fournisseurComboBox;

    @FXML
    private ComboBox<Article> articleComboBox;

    @FXML
    private TableColumn<Achat, Void> ActionsCol;
    @FXML
    private DatePicker dateDebutPicker;

    @FXML
    private DatePicker dateFinPicker;

    @FXML
    private Button genererRapportButton;
    @FXML
    private TableColumn<Achat, LocalDate> dateActuelleCol;


    @FXML
    private TableView<Achat> tableViewAR;

    @FXML
    private TableColumn<Achat, Integer> numAchatColR;
    @FXML
    private TableColumn<Achat, Integer> idArticleColR;
    @FXML
    private TableColumn<Achat, Integer> idFournisseurColR;

    @FXML
    private TableColumn<Achat, Integer> qtyAchatColR;
    @FXML
    private TableColumn<Achat, Double> prixUnitaireColR;
    @FXML
    private TableColumn<Achat, Double> prixTotalColR;
    @FXML
    private TableColumn<Achat, Double> prixVenteColR;
    @FXML
    private TableColumn<Achat, LocalDate> dureeR;
    @FXML
    private TableColumn<Achat, Date> dateAchatColR;


    private List<Fournisseur> fournisseurs;
    private ObservableList<Achat> achatsList;

    @FXML
    private TextField btn_search1;
    @FXML
    private Pane autre_pane;
    //ventes elements
    ////////////////////////////////
    @FXML
    private TableColumn<Vente, Void> ActionVente;

    @FXML
    private ImageView AddVe;
    @FXML
    private ImageView AddFo;

    @FXML
    private Button Add_Vente;

    @FXML
    private ComboBox<Client> ClientComboBox;

    @FXML
    private TableColumn<Vente, LocalDate> DateVente;

    @FXML
    private ImageView IconPlus2;
    @FXML
    private ImageView IconPlus1;

    @FXML
    private TableColumn<Vente, Integer> IdClientVEnte;

    @FXML
    private Button Modifier_Vente;

    @FXML
    private TableColumn<Vente, Integer> NumVente;

    @FXML
    private TableColumn<Vente, Float> PrixVenteTot;

    @FXML
    private TextField PrixVenteTotle;

    @FXML
    private ComboBox<Article> articleComboBox_;



    @FXML
    private DatePicker dateVEntePicker;
    @FXML
    private Button btn_Sell;

    @FXML
    private ImageView deleteComm;

    @FXML
    private TextField btn_searchV;
    @FXML
    private TextField btn_searchF;

    @FXML
    private ImageView deleteVe;

    @FXML
    private Button fermer;

    @FXML
    private Button fermerV;

    @FXML
    private Button fermerForm;

    @FXML
    private Pane formulaireAddVent;

    @FXML
    private TableColumn<Vente,Integer> idArticle;

    @FXML
    private ImageView imgSearchV;
    @FXML
    private ImageView imgSearchF;

    @FXML
    private Label labelGestionAchat;

    @FXML
    private Label labelGestionVEnte;

    @FXML
    private Pane pane_Vente;

    @FXML
    private TextField prixUnitaireFieldV;

    @FXML
    private TableColumn<Vente, Float> prixUnitaireVente;

    @FXML
    private TableColumn<Vente, Integer> qtyVente;

    @FXML
    private TextField quantiteVenteField;

    @FXML
    private TableView<Vente> tableVente;

    @FXML
    private ImageView updateCom;

    @FXML
    private ImageView updateVe;

    @FXML
    private ImageView IconPlusA;
    @FXML
    private ImageView add_commA;
    @FXML
    private ImageView updateComA;
    @FXML
    private ImageView deleteCommA;
    @FXML
    private ImageView IconPlusC;
    @FXML
    private ImageView updateComC;
    @FXML
    private ImageView deleteCommC;
    @FXML
    private ImageView add_commC;
    @FXML
    private AnchorPane article_form;
    @FXML
    private AnchorPane client_form;
    @FXML
    private Button article_ajouterBTN;
    @FXML
    private Button client_ajouterBTN;
    @FXML
    private TableView<Client> tableau_client;
    @FXML
    private TableColumn<Client, Integer> idC;
    @FXML
    private TableColumn<Client, String> adrC;
    @FXML
    private TableColumn<Client, String> nomC;
    @FXML
    private TableColumn<Client, String> numTC;
    @FXML
    private Label fournisseurNMBR;
    @FXML
    private Label ClientNMB;
    @FXML
    private Label venteNMB;
    @FXML
    private Label achatNMB;
    @FXML
    private Pane id_pane;
    @FXML
    private ImageView imgPoint2;
    @FXML
    private ImageView imgPoint21;
    @FXML
    private ImageView imgPoint211;
    @FXML
    private ImageView imgPoint2111;

    @FXML
    private TableView<Article> tableau_article;
    @FXML
    private TableColumn<Article, Integer> id;
    @FXML
    private TableColumn<Article, String> libArt;
    @FXML
    private TableColumn<Article, Float> prix_unArt;
    @FXML
    private TableColumn<Article, Integer> qte_stockArt;
    @FXML
    private TableColumn<Article, Float> prix_veArt;
    //@FXML
   // private ImageView imgSearch1;
    @FXML TableColumn<Article, Void> ActionssA;
    private CommercantDashBoard commercantDashBoardA = this;
    @FXML TableColumn<Client, Void> ActionssC;
    private CommercantDashBoard commercantDashBoardC=this;
    @FXML
    private Pane formulaireAr;
    @FXML
    private Button btn_addA;
    @FXML
    private TextField libAr;
    @FXML
    private TextField prix_unAr;
    @FXML
    private TextField qte_stockAr;
    @FXML
    private TextField prix_veAr;
    @FXML
    private Pane formulaireC;
    @FXML
    private Button btn_addC;
    @FXML
    private TextField nomCl;
    @FXML
    private TextField adrCl;
    @FXML
    private TextField numTCl;

    private ObservableList<Article> articles;
    @FXML

    private ObservableList<Client>clients;



    @FXML
    private void handleBtnBuyClick() {
        autre_pane.setVisible(true);
        rapports_achats.setVisible(false);
        fournisseur_form.setVisible(false);
        client_form.setVisible(false);
        article_form.setVisible(false);
        pane_Vente.setVisible(false);
        id_pane.setVisible(false);

    }
    @FXML
    private void handleRapportClick() {
        autre_pane.setVisible(false);
        fournisseur_form.setVisible(false);
        rapports_achats.setVisible(true);
        pane_Vente.setVisible(false);
        client_form.setVisible(false);
        article_form.setVisible(false);
        autre_pane.setVisible(false);
        fournisseur_form.setVisible(false);
        rapports_achats.setVisible(true);
        client_form.setVisible(false);
        article_form.setVisible(false);
        id_pane.setVisible(false);

    }
    //this part is for the sell traitement only
    @FXML
    //when you click on  the button that takes you to the sell interface
    void handleSellClick(ActionEvent event) {
        tableVente.refresh();
        pane_Vente.setVisible(true);
        fournisseur_form.setVisible(false);
        client_form.setVisible(false);
        article_form.setVisible(false);
        id_pane.setVisible(false);
        autre_pane.setVisible(false);
        rapports_achats.setVisible(false);
        client_form.setVisible(false);


    }
    @FXML
    private void handleRapportVClick() {
        autre_pane.setVisible(false);
        fournisseur_form.setVisible(false);
        rapports_achats.setVisible(false);
        pane_Vente.setVisible(false);
        client_form.setVisible(false);
        article_form.setVisible(false);
        rapports_ventes.setVisible(true);
        id_pane.setVisible(false);
    }

    @FXML
    public void onfournisseurClick(javafx.event.ActionEvent event) {

        autre_pane.setVisible(false);
        fournisseur_form.setVisible(true);
        rapports_achats.setVisible(false);
        pane_Vente.setVisible(false);
        client_form.setVisible(false);
        article_form.setVisible(false);
        id_pane.setVisible(false);
        showFournisseur();

    }
    @FXML
    public void onarticleClick(javafx.event.ActionEvent event) {
        client_form.setVisible(false);
        pane_Vente.setVisible(false);
        article_form.setVisible(true);
        autre_pane.setVisible(false);
        fournisseur_form.setVisible(false);
        rapports_achats.setVisible(false);
        id_pane.setVisible(false);
        showArticle();

    }
    @FXML
    public void onclientClick(javafx.event.ActionEvent event) {
        article_form.setVisible(false);
        fournisseur_form.setVisible(false);
        autre_pane.setVisible(false);
        client_form.setVisible(true);
        rapports_achats.setVisible(false);
        pane_Vente.setVisible(false);
        id_pane.setVisible(false);
        showClient();

    }
    @FXML
    void handleHomeButton(ActionEvent event){
        autre_pane.setVisible(false);
        fournisseur_form.setVisible(false);
        pane_Vente.setVisible(false);
        client_form.setVisible(false);
        rapports_achats.setVisible(false);
        pane_Vente.setVisible(false);
        id_pane.setVisible(true);

}
    // Méthode appelée lorsque l'utilisateur clique sur le bouton d'ajout
    @FXML
    public void ajouterAchat() {

        // Récupérer les valeurs sélectionnées dans les ComboBox
        Article selectedArticle = articleComboBox.getValue();
        Fournisseur selectedFournisseur = fournisseurComboBox.getValue();

        // Vérifier si les champs obligatoires sont remplis
        if (selectedArticle == null || selectedFournisseur == null || quantiteField.getText().isEmpty() || prixUnitaireField.getText().isEmpty() || dateAchatPicker.getValue() == null || PrixV.getText().isEmpty()) {
            System.out.println("veuillez remplir tt les champs svp ");
            return;
        }

        // Récupérer les autres valeurs des champs
        int quantiteAchat = Integer.parseInt(quantiteField.getText());
        double prixUnitaire = Double.parseDouble(prixUnitaireField.getText());
        double prixTotal = quantiteAchat * prixUnitaire;
        double prixVente = Double.parseDouble(PrixV.getText());
        LocalDate dateAchat = dateAchatPicker.getValue();


        // Créer un nouvel achat avec les valeurs récupérées
        Achat nouvelAchat = new Achat(
                0, // Laissez l'ID de l'achat à 0 pour qu'il soit généré automatiquement dans la base de données
                selectedArticle, // Passer l'objet Article sélectionné
                selectedFournisseur, // Passer l'objet Fournisseur sélectionné
                quantiteAchat,
                prixUnitaire,
                prixTotal,
                prixVente,
                Date.valueOf(dateAchat)

        );

        // Ajouter l'achat à la base de données
        ajouterAchatBDD(nouvelAchat);

        // Afficher les achats dans la TableView
        afficherAchats();
        // Masquer le bouton "Modifier" et afficher le bouton "Ajouter"

    }

    @FXML
    private void handleRechercheAchat() {
        // Récupérer le terme de recherche saisi par l'utilisateur
        String termeRecherche = btn_search1.getText().trim().toLowerCase();

        // Si le terme de recherche est vide, afficher toutes les lignes de la TableView
        if (termeRecherche.isEmpty()) {
            tableView.setItems(FXCollections.observableArrayList(tableView.getItems()));
            return;
        }

        // Filtrer les éléments de TableView
        FilteredList<Achat> filteredList = new FilteredList<>(tableView.getItems(), achat -> achatMatches(achat, termeRecherche));

        // Mettre à jour les éléments affichés dans la TableView avec la liste filtrée
        tableView.setItems(filteredList);
    }

    private boolean achatMatches(Achat achat, String termeRecherche) {
        // Vérifier si le terme de recherche correspond à l'ID du fournisseur, de l'article ou au numéro d'achat
        return String.valueOf(achat.getFournisseur().getIdFournisseur()).equals(termeRecherche) ||
                String.valueOf(achat.getArticle().getId()).equals(termeRecherche) ||
                String.valueOf(achat.getIdAchat()).equals(termeRecherche);
    }


    // Méthode pour ajouter un achat à la base de données
    public void ajouterAchatBDD(Achat nouvelAchat) {
        try {
            DataBaseConnection connection = new DataBaseConnection();
            Connection conn = connection.getConnection();

            // Préparer la requête SQL pour insérer l'achat dans la table "achats"
            String query = "INSERT INTO achats (idArticle, idFournisseur, quantiteAchat, prixUnitaire, prixTotal, prixVente, dateAchat) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, nouvelAchat.getIdArticle());
            stmt.setInt(2, nouvelAchat.getIdFournisseur());
            stmt.setInt(3, nouvelAchat.getQuantiteAchat());
            stmt.setDouble(4, nouvelAchat.getPrixUnitaire());
            stmt.setDouble(5, nouvelAchat.getPrixTotal());
            stmt.setDouble(6, nouvelAchat.getPrixVente());
            stmt.setDate(7, nouvelAchat.getDateAchat());

            // Exécuter la requête
            stmt.executeUpdate();

            // Fermer la connexion et le statement
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'erreur de l'ajout à la base de données
        }
    }

    // Méthode pour effacer les champs après la modification
    private void clearFields() {
        quantiteField.clear();
        prixUnitaireField.clear();
        PrixV.clear();
        //statut.clear();
        dateAchatPicker.setValue(null);
    }


    //l emplacement de formulaire lors de clique sur le button ajouter AChat
    @FXML
    private void handleAjouterNvAchat(javafx.event.ActionEvent event) {
        Modifier_Achat.setVisible(false);
        Add_Achat.setVisible(true);

        formulaireAddAchat.setVisible(!formulaireAddAchat.isVisible());
        if (formulaireAddAchat.isVisible()) {
            tableView.setLayoutY(370.0);
            formulaireAddAchat.setLayoutY(170.0);
        } else {
            tableView.setLayoutY(170.0);
        }
    }

    @FXML
    private void initialize() {
        afficherAchats();

        // Écouteur pour la sélection d'une ligne dans la TableView
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                remplirChamps(newSelection);
            }
        });

        // Définir une cell factory pour la colonne "Duree"
        dureeR.setCellValueFactory(new PropertyValueFactory<>("dateAchat"));
        dureeR.setCellFactory(col -> new TableCell<Achat, LocalDate>() {
            @Override
            protected void updateItem(LocalDate dateAchat, boolean empty) {
                super.updateItem(dateAchat, empty);
                if (empty || dateAchat == null) {
                    setText(null);
                } else {
                    // Rechercher l'objet Achat correspondant à la dateAchat
                    Achat achat = getTableView().getItems().stream()
                            .filter(a -> a.getDateAchat().equals(dateAchat))
                            .findFirst()
                            .orElse(null);
                    if (achat != null) {
                        setText("Achat ID: " + achat.getIdAchat() + ", Durée: " + achat.getDuree() + " jours");
                    } else {
                        setText(null);
                    }
                }
            }
        });
    }

    public void afficherAchatsRapport() {
        ObservableList<Achat> achatsList = FXCollections.observableArrayList();

        try {
            DataBaseConnection connection = new DataBaseConnection();
            Connection conn = connection.getConnection();
            String query = "SELECT * FROM achats";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Article article = getArticleById(rs.getInt("idArticle"));
                Fournisseur fournisseur = getFournisseurById(rs.getInt("idFournisseur"));

                LocalDate dateAchat = rs.getDate("dateAchat").toLocalDate();
                LocalDate dateActuelle = LocalDate.now();
                long duree = ChronoUnit.DAYS.between(dateAchat, dateActuelle);

                Achat achat = new Achat(
                        rs.getInt("idAchat"),
                        article,
                        fournisseur,
                        rs.getInt("quantiteAchat"),
                        rs.getDouble("prixUnitaire"),
                        rs.getDouble("prixTotal"),
                        rs.getDouble("prixVente"),
                        dateAchat
                );

                achatsList.add(achat);
                achat.afficherDuree(); // Afficher la durée pour chaque objet Achat
            }

            // Ajouter les achats à la TableView
            tableViewAR.setItems(achatsList);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afficherAchats() {
        ObservableList<Achat> achatsList = FXCollections.observableArrayList();

        try {
            DataBaseConnection connection = new DataBaseConnection();
            Connection conn = connection.getConnection();
            String query = "SELECT * FROM achats";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Article article = getArticleById(rs.getInt("idArticle"));
                Fournisseur fournisseur = getFournisseurById(rs.getInt("idFournisseur"));
                LocalDate dateAchat = rs.getDate("dateAchat").toLocalDate();
                long duree = Achat.calculerDureeEnJours(dateAchat);

                Achat achat = new Achat(
                        rs.getInt("idAchat"),
                        article,
                        fournisseur,
                        rs.getInt("quantiteAchat"),
                        rs.getDouble("prixUnitaire"),
                        rs.getDouble("prixTotal"),
                        rs.getDouble("prixVente"),
                        dateAchat
                );
                achatsList.add(achat);
            }

            // Ajouter les achats à la TableView
            tableView.setItems(achatsList);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    // Méthode pour initialiser le ComboBox des fournisseurs
    public void initialiserComboBoxFournisseurs() {
        try {
            DataBaseConnection connection = new DataBaseConnection();
            Connection conn = connection.getConnection();
            String query = "SELECT * FROM fournisseur";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ObservableList<Fournisseur> fournisseurs = FXCollections.observableArrayList();

            while (rs.next()) {
                Fournisseur fournisseur = new Fournisseur(
                        rs.getInt("id_fournisseur"),
                        rs.getString("nom"),
                        rs.getString("adresse"),
                        rs.getString("numero_telephone"),
                        rs.getString("fax"),
                        rs.getString("commentaire")
                );
                fournisseurs.add(fournisseur);
            }

            fournisseurComboBox.setItems(fournisseurs);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'erreur de récupération des fournisseurs depuis la base de données
        }
    }

    // Méthode pour initialiser le ComboBox des articles
    private void initialiserComboBoxArticles() {
        ObservableList<Article> articles = FXCollections.observableArrayList();

        try {
            DataBaseConnection connection = new DataBaseConnection();
            Connection conn = connection.getConnection();
            String query = "SELECT * FROM article";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Article article = new Article(
                        rs.getInt("reference"),
                        rs.getString("libelle"),
                        rs.getFloat("prix_unitaire"),
                        rs.getFloat("prix_vente"),
                        rs.getInt("quantite_stock")
                );
                articles.add(article);
            }

            articleComboBox.setItems(articles);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'erreur de récupération des articles depuis la base de données
        }
    }


    // Méthode pour modifier un achat dans la base de données
    public void modifierAchatBDD(Achat achat) {
        try {
            DataBaseConnection connection = new DataBaseConnection();
            Connection conn = connection.getConnection();

            // Préparer la requête SQL pour mettre à jour l'achat dans la table "achats"
            String query = "UPDATE achats SET quantiteAchat=?, prixUnitaire=?, prixTotal=?, prixVente=?, dateAchat=? WHERE idAchat=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, achat.getQuantiteAchat());
            stmt.setDouble(2, achat.getPrixUnitaire());
            stmt.setDouble(3, achat.getPrixTotal());
            stmt.setDouble(4, achat.getPrixVente());
            stmt.setDate(5, achat.getDateAchat());
            //stmt.setString(6, achat.getStatutAchat());
            stmt.setInt(6, achat.getIdAchat());

            // Exécuter la requête
            stmt.executeUpdate();

            // Fermer la connexion et le statement
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'erreur de la modification dans la base de données
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadImage("Images/userImage.png", logoImageView);
        loadImage("Images/home.png", DashImageView);
        loadImage("Images/items.png", ItemImageView);
        loadImage("Images/costumer.png", CustomerImageView);
        loadImage("Images/sell.png", BuyImageView);
        loadImage("Images/sell.png", SellImageView);
        loadImage("Images/suppliers.png", SupplierImageView);
        loadImage("Images/points.png", IconImageView);
        loadImage("Images/logged.png", loggedImageView);
        loadImage("Images/rapport.png", RapportImageView);
        loadImage("Images/Search.png", imgSearch1);
        loadImage("Images/plus.png", IconPlus);
        loadImage("Images/add.png", AddAc);
        loadImage("Images/delete.png", deleteAc);
        loadImage("Images/update.png", updateAc);
        loadImage("Images/iconplus.png", IconPlus);
        loadImage("Images/userImage.png", logoImageView);
        loadImage("Images/home.png", DashImageView);
        loadImage("Images/items.png", ItemImageView);
        loadImage("Images/costumer.png", CustomerImageView);
        loadImage("Images/sell.png", BuyImageView);
        loadImage("Images/sell.png", SellImageView);
        loadImage("Images/suppliers.png", SupplierImageView);
        loadImage("Images/points.png", IconImageView);
        loadImage("Images/logged.png", loggedImageView);
        loadImage("Images/rapport.png", RapportImageView);
        loadImage("Images/Search.png", imgSearch1);
        loadImage("Images/Search.png", imgSearchV);
        loadImage("Images/Search.png", imgSearchF);
        loadImage("Images/plus.png", IconPlus);
        loadImage("Images/plus.png", IconPlus1);
        loadImage("Images/add.png",AddAc);
        loadImage("Images/add.png",AddVe);
        loadImage("Images/add.png",AddFo);
        loadImage("Images/delete.png",deleteAc);
        loadImage("Images/update.png",updateAc);
        loadImage("Images/delete.png",deleteVe);
        loadImage("Images/update.png",updateVe);
        loadImage("Images/iconplus.png",IconPlus2);
        loadImage("Images/delete.png",deleteComm);
        //loadImage("Images/add.png",add_comm);
        loadImage("Images/update.png",updateCom);
        loadImage("Images/Search.png",imgSearch1);
        loadImage("Images/add.png",AddAc);
        loadImage("Images/delete.png",deleteAc);
        loadImage("Images/update.png",updateAc);
        loadImage("Images/iconplus.png",IconPlus);


        //loadImage("Images/Search.png",imgSearch2);
        //loadImage("Images/Search.png",imgSearch);
        loadImage("Images/iconplus.png",IconPlusA);
        loadImage("Images/delete.png",deleteCommA);
        loadImage("Images/add.png",add_commA);
        loadImage("Images/add.png",add_commC);
        loadImage("Images/update.png",updateComA);
        loadImage("Images/iconplus.png",IconPlusC);
        loadImage("Images/delete.png",deleteCommC);
        loadImage("Images/update.png",updateComC);
        loadImage("Images/costumer.png",imgPoint2);
        loadImage("Images/sell.png",imgPoint21);
        loadImage("Images/Sell.png",imgPoint211);
        loadImage("Images/suppliers.png",imgPoint2111);
        //loadImage("Images/delete.png",deleteComm);
        //loadImage("Images/add.png",add_comm);
        //loadImage("Images/update.png",updateCom);
        //loadImage("Images/Search.png",imgSearch1);

        //objet de la class de creation de connection avec la base de donnee
        DataBaseConnection DBConnection = new DataBaseConnection();
        connection = DBConnection.getConnection();
        Actionss.setCellFactory(param -> new ActionsCellFournisseur(commercantDashBoard));

        fournisseurs = getFournisseur();



        // Définition des valeurs de cellules pour les colonnes
        numAchatCol.setCellValueFactory(new PropertyValueFactory<>("idAchat"));
        idArticleCol.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getArticle().getId()).asObject());
        idFournisseurCol.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getFournisseur().getIdFournisseur()).asObject());
        qtyAchatCol.setCellValueFactory(new PropertyValueFactory<>("quantiteAchat"));
        prixUnitaireCol.setCellValueFactory(new PropertyValueFactory<>("prixUnitaire"));
        prixTotalCol.setCellValueFactory(new PropertyValueFactory<>("prixTotal"));
        prixVenteCol.setCellValueFactory(new PropertyValueFactory<>("prixVente"));
        dateAchatCol.setCellValueFactory(new PropertyValueFactory<>("dateAchat"));


        //statutAchatCol.setCellValueFactory(new PropertyValueFactory<>("statutAchat"));
        // Initialiser les ComboBox avec les données des fournisseurs et des articles depuis la base de données
        initialiserComboBoxFournisseurs();
        initialiserComboBoxArticles();

        // Configuration du gestionnaire d'événements pour le bouton "Ajouter Achat"
        //ajouterNvAchat.setOnAction(this::handleAjouterAchat);

        // Configuration de la cellule personnalisée pour la colonne "Actions"
        ActionsCol.setCellFactory(new Callback<TableColumn<Achat, Void>, TableCell<Achat, Void>>() {
            @Override
            public TableCell<Achat, Void> call(TableColumn<Achat, Void> param) {
                return new ActionsCellAchat(CommercantDashBoard.this); // Passer la référence à AchatController
            }
        });


        // Appel de la méthode pour afficher les achats
        afficherAchats();

        numAchatColR.setCellValueFactory(new PropertyValueFactory<>("idAchat"));
        idArticleColR.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getArticle().getId()).asObject());
        idFournisseurColR.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getFournisseur().getIdFournisseur()).asObject());
        qtyAchatColR.setCellValueFactory(new PropertyValueFactory<>("quantiteAchat"));
        prixUnitaireColR.setCellValueFactory(new PropertyValueFactory<>("prixUnitaire"));
        prixTotalColR.setCellValueFactory(new PropertyValueFactory<>("prixTotal"));
        prixVenteColR.setCellValueFactory(new PropertyValueFactory<>("prixVente"));
        dateAchatColR.setCellValueFactory(new PropertyValueFactory<>("dateAchat"));
       // DureeR.setCellFactory(new DureeCellFactory());

        afficherAchatsRapport();

        genererRapportButton.setOnAction(actionEvent -> {
            PDFPrinter.printTableViewToPDF(tableViewAR, "rapport.pdf");
        });
        //vente
        ///////////////
        // Définition des valeurs de cellules pour les colonnes
        NumVente.setCellValueFactory(new PropertyValueFactory<>("id_vente"));
        DateVente.setCellValueFactory(new PropertyValueFactory<>("Date_vente"));
        qtyVente.setCellValueFactory(new PropertyValueFactory<>("quantityVente"));
        idArticle.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getArticle().getId()).asObject());
        IdClientVEnte.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getClient().getId()).asObject());
        prixUnitaireVente.setCellValueFactory(data-> new SimpleFloatProperty( data.getValue().getArticle().getPrixVente()).asObject());
        PrixVenteTot.setCellValueFactory(data -> {
            float prixTotalVente = data.getValue().getPrixTotaleVente();
            return new SimpleFloatProperty(prixTotalVente).asObject();
        });

        //afficher les 2 Action supprimer et modifer dans le tableau de vente
        ActionVente.setCellFactory(param ->new ActionCellVente(commercantDashBoard));

        //initialize the client combox
        initialiserComboBoxClient();
        //initialize the client combox(fill it in)
        initialiserComboBoxArticle();
        //methode pour afficher les ventes
        afficherVentes();
        btn_searchV.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                afficherVentes();
                tableVente.setItems(tableVente.getItems());
            }
            else{
                handleRechercheVente(newValue);
            }
        });

        //vente end

        ActionssC.setCellFactory(param ->new ActionsCellClient(commercantDashBoard));
        clients = getClient();

        ActionssA.setCellFactory(param ->new ActionsCellArticle(commercantDashBoardA));
        articles = getArticle();

        AdminController ac=new AdminController();
        fournisseurNMBR.setText(String.valueOf(ac.countFour()));
        ClientNMB.setText(String.valueOf(ac.countClient()));
        venteNMB.setText(String.valueOf(ac.countVente()));
        achatNMB.setText(String.valueOf(ac.countAchat()));

    }


    private void loadImage(String imagePath, ImageView imageView) {
        try {
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                Image image = new Image(imageFile.toURI().toString());
                imageView.setImage(image);
            } else {
                System.err.println("Image file not found: " + imagePath);
            }
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @FXML
    private void handleAjouterFournisseur(ActionEvent event) {
        // Code pour ajouter le commerçant à la base de données
        String nomFo = nomF.getText();
        String teleFo = teleF.getText();
        String FaxFo = FaxF.getText();
        String AdreF = adressF.getText();
        String com = comm.getText();
//        System.out.println(nomFo+teleFo+FaxFo);


        // Vérification des champs non vides avant d'ajouter à la base de données
        if (!nomFo.isEmpty() && !teleFo.isEmpty() && !FaxFo.isEmpty() && !AdreF.isEmpty() && !com.isEmpty()) {
            // Appel à la méthode pour ajouter le commerçant à la base de données

            ajouter_fournisseur(nomFo, teleFo, FaxFo, AdreF, com);

            // Effacer les champs du formulaire après l'ajout
            clearFormFields();
            formulaireFour.setVisible(false);
            tableau_fournisseur.setLayoutY(169);
        } else {
            // Afficher un message d'erreur si tous les champs ne sont pas remplis
            // Vous pouvez implémenter cette partie selon vos besoins
            System.out.println("problem");
        }
    }


    private void clearFormFields() {
        // Effacer les champs du formulaire après la modification
        nomF.clear();
        teleF.clear();
        FaxF.clear();
        adressF.clear();
        comm.clear();
    }


    // Méthode pour gérer la modification d'un achat
    public void modifierAchat(Achat achat) {
        // Remplir les champs du formulaire avec les données de l'achat
        quantiteField.setText(String.valueOf(achat.getQuantiteAchat()));
        prixUnitaireField.setText(String.valueOf(achat.getPrixUnitaire()));
        PrixV.setText(String.valueOf(achat.getPrixVente()));
        dateAchatPicker.setValue(achat.getDateAchat().toLocalDate());

        // Afficher le formulaire
        formulaireAddAchat.setVisible(true);
        formulaireAddAchat.setLayoutY(255.0);

        // Changer la visibilité des boutons
        Add_Achat.setVisible(false); // Masquer le bouton "Ajouter"
        Modifier_Achat.setVisible(true); // Afficher le bouton "Modifier"

        // Ajouter un gestionnaire d'événements pour le bouton "Modifier"
        Modifier_Achat.setOnAction(event -> {
            // Récupérer les nouvelles données du formulaire
            int nouvelleQuantite = Integer.parseInt(quantiteField.getText());
            double nouveauPrixUnitaire = Double.parseDouble(prixUnitaireField.getText());
            double nouveauPrixVente = Double.parseDouble(PrixV.getText());
            LocalDate nouvelleDateAchat = dateAchatPicker.getValue();

            // Mettre à jour l'achat dans la base de données
            modifierAchatBDD(new Achat(
                    achat.getIdAchat(), // Utiliser l'ID de l'achat existant
                    achat.getArticle(), // Garder l'article existant
                    achat.getFournisseur(), // Garder le fournisseur existant
                    nouvelleQuantite,
                    nouveauPrixUnitaire,
                    nouvelleQuantite * nouveauPrixUnitaire, // Mettre à jour le prix total en fonction de la nouvelle quantité et du prix unitaire
                    nouveauPrixVente,
                    Date.valueOf(nouvelleDateAchat)
            ));

            // Mettre à jour la ligne dans la TableView
            achat.setQuantiteAchat(nouvelleQuantite);
            achat.setPrixUnitaire(nouveauPrixUnitaire);
            achat.setPrixTotal(nouvelleQuantite * nouveauPrixUnitaire);
            achat.setPrixVente(nouveauPrixVente);
            achat.setDateAchat(Date.valueOf(nouvelleDateAchat));
            tableView.refresh();

            // Masquer le formulaire
            formulaireAddAchat.setVisible(false);

            // Réinitialiser la visibilité des boutons
            Add_Achat.setVisible(true); // Afficher le bouton "Ajouter"
            Modifier_Achat.setVisible(false); // Masquer le bouton "Modifier"
        });
    }


    // Méthode pour remplir les champs avec les valeurs de l'achat sélectionné
    private void remplirChamps(Achat achat) {
        quantiteField.setText(String.valueOf(achat.getQuantiteAchat()));
        prixUnitaireField.setText(String.valueOf(achat.getPrixUnitaire()));
        PrixV.setText(String.valueOf(achat.getPrixVente()));
        dateAchatPicker.setValue(achat.getDateAchat().toLocalDate());

    }

    @FXML
    private void handleClose(ActionEvent event) {
        formulaireAddAchat.setVisible(!formulaireAddAchat.isVisible());
        if (formulaireAddAchat.isVisible()) {
            // Modifier la taille de la TableView lorsque le formulaire est visible
            tableView.setPrefHeight(220.0);
            //tableView.setLayoutY(380.0);
            formulaireAddAchat.setLayoutY(58.0);
        } else {
            // Rétablir la taille par défaut de la TableView lorsque le formulaire est masqué
            //tableView.setPrefHeight(458.0);
            tableView.setLayoutY(170.0);
        }
    }

    // Méthode pour supprimer un achat de la base de données
    public void supprimerAchatBDD(Achat achat) {
        try {
            DataBaseConnection connection = new DataBaseConnection();
            Connection conn = connection.getConnection();

            // Préparer la requête SQL pour supprimer l'achat de la table "achats"
            String query = "DELETE FROM achats WHERE idAchat=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, achat.getIdAchat());

            // Exécuter la requête
            stmt.executeUpdate();

            // Fermer la connexion et le statement
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'erreur de la suppression dans la base de données
        }
        afficherAchats();
    }


    // Méthode pour récupérer un objet Article à partir de son ID
    private Article getArticleById(int articleId) {
        Article article = null;
        try {
            DataBaseConnection connection = new DataBaseConnection();
            Connection conn = connection.getConnection();
            String query = "SELECT * FROM article WHERE reference=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, articleId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                article = new Article(
                        rs.getInt("reference"),
                        rs.getString("libelle"),
                        rs.getFloat("prix_unitaire"),
                        rs.getFloat("prix_vente"),
                        rs.getInt("quantite_stock")
                );
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }


    // Méthode pour récupérer un objet Fournisseur à partir de son ID
    private Fournisseur getFournisseurById(int fournisseurId) {
        Fournisseur fournisseur = null;
        try {
            DataBaseConnection connection = new DataBaseConnection();
            Connection conn = connection.getConnection();
            String query = "SELECT * FROM fournisseur WHERE id_fournisseur=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, fournisseurId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                fournisseur = new Fournisseur(
                        rs.getInt("id_fournisseur"),
                        rs.getString("nom"),
                        rs.getString("adresse"),
                        rs.getString("numero_telephone"),
                        rs.getString("fax"),
                        rs.getString("commentaire")
                );
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fournisseur;
    }

    public void showModificationForm(Fournisseur fournisseur) {
        teleF.setText(fournisseur.getTelephone());
        nomF.setText(fournisseur.getNomPrenom());
        FaxF.setText(fournisseur.getFax());
        comm.setText(fournisseur.getCommentaire());
        adressF.setText(fournisseur.getAdresse());
        formulaireFour.setVisible(true);

        formulaireFour.setLayoutY(170);
        tableau_fournisseur.setLayoutY(400);


        //when I click on the button update the data are taking from the form to the database to get updated
        btn_addF.setOnAction(event -> {
            String nouveauNomPrenom = nomF.getText();
            String nouvelleAdresse = adressF.getText();
            String nouveauTelephone = teleF.getText();
            String nouveauFax = FaxF.getText();
            String nouveauCommentaire = comm.getText();

            tableau_fournisseur.refresh();
            modifierFournisseur(fournisseur.getIdFournisseur(), nouveauNomPrenom, nouvelleAdresse, nouveauTelephone, nouveauFax, nouveauCommentaire);
            // Mettre à jour la ligne dans le Tableau
            fournisseur.setNomPrenom(nouveauNomPrenom);
            fournisseur.setTelephone(nouveauTelephone);
            fournisseur.setAdresse(nouvelleAdresse);
            fournisseur.setFax(nouveauFax);
            fournisseur.setCommentaire(nouveauCommentaire);
            tableau_fournisseur.refresh();
            formulaireFour.setVisible(false);
            tableau_fournisseur.setLayoutY(169);
        });


    }

    public void supprimerFournisseur(Fournisseur fournisseur) {
        try {
            // Code pour supprimer le commerçant de la base de données en utilisant son ID
            String query = "DELETE FROM fournisseur WHERE id_fournisseur = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, fournisseur.getIdFournisseur());
            // Exécuter la requête de suppression
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void modifierFournisseur(int idFournisseur, String nouveauNomPrenom, String nouvelleAdresse, String nouveauTelephone, String nouveauFax, String nouveauCommentaire) {
        // Mettre à jour les informations du fournisseur dans la base de données
        String update = "UPDATE fournisseur SET nom = ?, adresse = ?, numero_telephone = ?, fax = ?, commentaire = ? WHERE id_fournisseur = ?";
        try {
            PreparedStatement st = connection.prepareStatement(update);
            st.setString(1, nouveauNomPrenom);
            st.setString(2, nouvelleAdresse);
            st.setString(3, nouveauTelephone);
            st.setString(4, nouveauFax);
            st.setString(5, nouveauCommentaire);
            st.setInt(6, idFournisseur);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void ajouter_fournisseur(String nomFo, String teleFo, String FaxFo, String adrs, String com) {
        String insert = "INSERT INTO fournisseur (nom, adresse, numero_telephone, fax, commentaire) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(insert);
            st.setString(1, nomFo);
            st.setString(2, adrs);
            st.setString(3, teleFo);
            st.setString(4, FaxFo);
            st.setString(5, com);
            st.executeUpdate();
            showFournisseur();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void ajouter_fournisseur_BTN(ActionEvent event) {
        formulaireFour.setVisible(true);
        if (formulaireFour.isVisible()) {
            tableau_fournisseur.setLayoutY(380.0);
            formulaireFour.setLayoutY(169);
        } else {
            tableau_fournisseur.setLayoutY(170.0);
        }
    }

    @FXML
    private void fermerFormulaire(ActionEvent event) {

        formulaireFour.setVisible(!formulaireFour.isVisible());
        if (formulaireFour.isVisible()) {
            tableau_fournisseur.setLayoutY(380.0);
            formulaireFour.setLayoutY(58.0);
        } else {
            tableau_fournisseur.setLayoutY(170.0);
        }
    }


    public ObservableList<Fournisseur> getFournisseur() {
        ObservableList<Fournisseur> fournisseurs = FXCollections.observableArrayList();
        String requette = "select * from fournisseur";
        try {
            Statement st = connection.createStatement();
            //affecter le resultat de la requete a un variable
            ResultSet rs = st.executeQuery(requette);
            while (rs.next()) {
                Fournisseur fournisseur = new Fournisseur();
                fournisseur.setIdFournisseur(rs.getInt("id_fournisseur"));
                fournisseur.setNomPrenom(rs.getString("nom"));
                fournisseur.setTelephone(rs.getString("numero_telephone"));
                fournisseur.setAdresse(rs.getString("adresse"));
                fournisseur.setFax(rs.getString("fax"));
                fournisseur.setCommentaire(rs.getString("commentaire"));
                fournisseurs.add(fournisseur);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return fournisseurs;
    }

    //affecter la list des donnes qu'on a tire au tableau
    public void showFournisseur() {
        ObservableList<Fournisseur> list = getFournisseur();
        tableau_fournisseur.setItems(list);
        identi.setCellValueFactory(new PropertyValueFactory<>("idFournisseur"));
        nom_four.setCellValueFactory(new PropertyValueFactory<>("nomPrenom"));
        adr_four.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        num_four.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        fax_four.setCellValueFactory(new PropertyValueFactory<>("fax"));
        comm_four.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
    }


    private void afficherRapport(LocalDate dateDebut, LocalDate dateFin) {
        try {
            DataBaseConnection connection = new DataBaseConnection();
            Connection conn = connection.getConnection();
            String query = "SELECT * FROM achats WHERE dateAchat BETWEEN ? AND ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDate(1, java.sql.Date.valueOf(dateDebut));
            stmt.setDate(2, java.sql.Date.valueOf(dateFin));
            ResultSet rs = stmt.executeQuery();

            ObservableList<Achat> achatsList = FXCollections.observableArrayList();
            while (rs.next()) {
                Article article = getArticleById(rs.getInt("idArticle"));
                Fournisseur fournisseur = getFournisseurById(rs.getInt("idFournisseur"));
                Achat achat = new Achat(
                        rs.getInt("idAchat"),
                        article,
                        fournisseur,
                        rs.getInt("quantiteAchat"),
                        rs.getDouble("prixUnitaire"),
                        rs.getDouble("prixTotal"),
                        rs.getDouble("prixVente"),
                        rs.getDate("dateAchat")
                );
                achatsList.add(achat);
            }

            tableView.setItems(achatsList);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    //initialize the combox of clients by calling data from DB this function called from the initialize
    public void initialiserComboBoxClient(){
        String Selection="SELECT * FROM client;";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(Selection);

            ObservableList<Client> clients = FXCollections.observableArrayList();

            while (rs.next()) {
                Client client = new Client(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("numero_telephone"),
                        rs.getString("adresse"));

                clients.add(client);
            }

            ClientComboBox.setItems(clients);

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'erreur de récupération des fournisseurs depuis la base de données
        }

    }
    //initialize the combox of clients by calling data from DB this function called from the initialize
    public void initialiserComboBoxArticle(){
        String Selection="SELECT * FROM article;";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(Selection);

            ObservableList<Article> articles = FXCollections.observableArrayList();

            while (rs.next()) {
                Article article = new Article(
                        rs.getInt("reference"),
                        rs.getString("libelle"),
                        rs.getFloat("prix_unitaire"),
                        rs.getFloat("prix_vente"),
                        rs.getInt("quantite_stock"));
                articles.add(article);
            }

            articleComboBox_.setItems(articles);

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'erreur de récupération des articles depuis la base de données
        }

    }
    //methode pour afficher les ventes
    public void afficherVentes() {
        ObservableList<Vente> listVentes = FXCollections.observableArrayList();
        String select = "SELECT * FROM vente";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Client client = getClientById(rs.getInt("id_client"));
                Article article = getArticleById(rs.getInt("reference"));
                Vente vente = new Vente(
                        rs.getInt("id_vente"),
                        article,
                        client,
                        new Date(rs.getDate("date_vente").getTime()),
                        rs.getInt("quantite_vente")
                );
                listVentes.add(vente);

            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Set the items of the TableView to the list of sales data
        tableVente.setItems(listVentes);
    }

    //method to bring the details about a Client by it's id
    public Client getClientById(int idClient){
        String select ="SELECT * FROM client WHERE id=?";
        Client client=null;
        try {
            PreparedStatement st= connection.prepareStatement(select);
            st.setInt(1, idClient);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                client=new Client(
                        idClient,
                        rs.getString("nom"),
                        rs.getString("numero_telephone"),
                        rs.getString("adresse")
                );

            }
            rs.close();
            st.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return client;
    }
    //delete button action from the table
    public void supprimerVenteBDD(Vente vente){
        String query="delete from vente where id_vente =?";

        try {
            PreparedStatement st= connection.prepareStatement(query);
            st.setInt(1,vente.getId_vente());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableVente.getItems().remove(vente);
//        tableVente.refresh();
    }
    //update button action from the table
    public void modifierVente(Vente vente){
        //fill in the form of sell field
        quantiteVenteField.setText(String.valueOf(vente.getQuantityVente()));
        dateVEntePicker.setValue(vente.getDate_vente().toLocalDate());
        // Afficher le formulaire
        formulaireAddVent.setVisible(true);
        tableVente.setLayoutY(370.0);
        formulaireAddVent.setLayoutY(170.0);

        // Changer la visibilité des boutons
        Add_Vente.setVisible(false); // Masquer le bouton "Ajouter"
        Modifier_Vente.setVisible(true); // Afficher le bouton "Modifier"
        Modifier_Vente.setOnAction(event ->{
            //take the data from the fields and put theme in a new variables
            int newQtyVente=Integer.parseInt(quantiteVenteField.getText());
            LocalDate newDateVente=dateVEntePicker.getValue();
            // Check if the requested quantity is available
            if (vente.getArticle().getQuantiteDisponible() < newQtyVente) {
                // Show an alert indicating that the requested quantity is not available
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Insufficient Stock");
                alert.setContentText("la quantite demande n'est pas disponible.");
                alert.showAndWait();
                return; // Exit the method
            }
            else{
                modiferVenteBDD(new Vente(
                        vente.getId_vente(),
                        vente.getArticle(),
                        vente.getClient(),
                        Date.valueOf(newDateVente),
                        newQtyVente)
                );
                //affecter les nouveau valeurs a notre Vente object et refresh la table
                vente.setQuantityVente(newQtyVente);
                vente.setDate_vente(Date.valueOf(newDateVente));
                tableVente.refresh();

                formulaireAddVent.setVisible(false);
                tableVente.setLayoutY(170.0);
                formulaireAddVent.setLayoutY(370.0);

                Add_Vente.setVisible(true); // Masquer le bouton "Ajouter"
                Modifier_Vente.setVisible(false); // Afficher le bouton "Modifier"

            }});


    }
    //modifer les valeurs d'une vente dans la base de donnees
    public void modiferVenteBDD(Vente vente){
        String requete="UPDATE vente SET id = ?,reference=?,date_vente=?,quantite_vente=? WHERE id_vente=?";

        try {
            PreparedStatement st = connection.prepareStatement(requete);
            st.setInt(1,vente.getClient().getId());
            st.setInt(2,vente.getArticle().getId());
            st.setDate(3,vente.getDate_vente());
            st.setInt(4,vente.getQuantityVente());
            st.setInt(5,vente.getId_vente());
            st.executeUpdate();
            //pour update la quantity de l'article
            String updateQuery = "UPDATE article SET quantite_stock = quantite_stock + ? WHERE reference = ?";
            PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
            updateStmt.setInt(1, vente.getQuantityVente());
            updateStmt.setInt(2, vente.getArticle().getId());
            updateStmt.executeUpdate();

            st.close();
            updateStmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //pour ajouter une nouvelle vente
    @FXML
    public void handleAjouterNvVente(javafx.event.ActionEvent event){
        formulaireAddVent.setVisible(true);
        tableVente.setLayoutY(370.0);
        formulaireAddVent.setLayoutY(170.0);

        Add_Vente.setVisible(true); // Masquer le bouton "Ajouter"
        Modifier_Vente.setVisible(false); // Afficher le bouton "Modifier"

    }
    //loursqu'on click sur la button d'ajouter dans la form
    @FXML
    public void ajouterVente(javafx.event.ActionEvent event){
        //take the data that from the textfields in the form
        Article selectedArticle = articleComboBox_.getValue();
        Client selectedClient= ClientComboBox.getValue();
        int Qty= Integer.parseInt(quantiteVenteField.getText());
        Date dateVente=Date.valueOf(dateVEntePicker.getValue());
        if(selectedArticle!=null && selectedClient !=null && !quantiteVenteField.getText().isEmpty() && dateVEntePicker.getValue()!=null ) {
            //verifier si la quantite est dispo dans le stock
            if (selectedArticle.getQuantiteDisponible() < Qty) {
                // Show an alert indicating that the requested quantity is not available
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("hors stock");
                alert.setContentText("la quantite commande n'est disponible");
                alert.showAndWait();

                return; // Exit the method
            }
            else{
                Vente newvente = new Vente(
                        0,//auto increm in the database
                        selectedArticle,
                        selectedClient,
                        dateVente,
                        Qty
                );

                //ajouter l'element dans la base de donnees
                AjouterVenteBDD(newvente);
                clearFieldsV();
                formulaireAddVent.setVisible(false);
                tableVente.setLayoutY(170);
                //afficherVente();
                afficherVentes();}
        }
    }
    //fonction pur ajouter la nouvelle vente dans la base de donnees
    public void AjouterVenteBDD(Vente vente){
        String requete="Insert into vente(id_vente,id_client,reference,date_vente,quantite_vente) values (?,?,?,?,?); ";
        try {
            PreparedStatement st= connection.prepareStatement(requete);
            st.setInt(1,vente.getId_vente());
            st.setInt(2,vente.getIdClient());
            st.setInt(3,vente.getIdArticle());
            st.setDate(4,vente.getDate_vente());
            st.setInt(5,vente.getQuantityVente());
            st.executeUpdate();


            String updateQuery = "UPDATE article SET quantite_stock = quantite_stock - ? WHERE reference = ?";
            PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
            updateStmt.setInt(1, vente.getQuantityVente());
            updateStmt.setInt(2, vente.getIdArticle());
            updateStmt.executeUpdate();

            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void handleRechercheVente(String termeRecherche) {
        // Créer un FilteredList lié à la liste des ventes de votre TableView
        FilteredList<Vente> filteredListVente = new FilteredList<>(tableVente.getItems(), vente -> true);

        // Mettre à jour le filtre en fonction du texte de recherche
        filteredListVente.setPredicate(vente -> {
            // Si le champ de recherche est vide, afficher toutes les ventes
            if (termeRecherche == null || termeRecherche.trim().isEmpty()) {
                afficherVentes();
                return true;
            }

            // Comparer le texte de recherche avec les attributs de la vente (par exemple, ID client, ID article, ID vente)
            String lowerCaseFilter = termeRecherche.toLowerCase();
            return String.valueOf(vente.getClient().getId()).equals(lowerCaseFilter) ||
                    String.valueOf(vente.getArticle().getId()).equals(lowerCaseFilter) ||
                    String.valueOf(vente.getId_vente()).equals(lowerCaseFilter);
        });

        // Mettre à jour le TableView pour afficher les résultats filtrés
        tableVente.setItems(filteredListVente);
    }
    @FXML
    private void handleCloseV(ActionEvent event) {
        formulaireAddVent.setVisible(!formulaireAddVent.isVisible());
        if (formulaireAddVent.isVisible()) {
            // Modifier la taille de la TableView lorsque le formulaire est visible
            tableVente.setPrefHeight(220.0);
            //tableView.setLayoutY(380.0);
            formulaireAddVent.setLayoutY(58.0);
        } else {
            // Rétablir la taille par défaut de la TableView lorsque le formulaire est masqué
            //tableView.setPrefHeight(458.0);
            tableVente.setLayoutY(170.0);
        }
    }

    private void clearFieldsV() {
        quantiteVenteField.clear();
        articleComboBox_.setValue(null);
        ClientComboBox .setValue(null);
        dateVEntePicker.setValue(null);
    }



    //Articles
    @FXML
    private void handleAjouterArticle(ActionEvent event) {
        // Code pour ajouter le commerçant à la base de données
        String libArticle=libAr.getText();
        float prix_unArticle=Float.parseFloat(prix_unAr.getText());
        int qte_stockArticle=Integer.parseInt(qte_stockAr.getText());
        float prix_veArticle=Float.parseFloat(prix_veAr.getText());

//        System.out.println(nomFo+teleFo+FaxFo);


        // Vérification des champs non vides avant d'ajouter à la base de données
        if (!libArticle.isEmpty() && !prix_unAr.getText().isEmpty() && !qte_stockAr.getText().isEmpty() && !prix_veAr.getText().isEmpty()) {
            // Appel à la méthode pour ajouter le commerçant à la base de données

            ajouter_article(libArticle,prix_unArticle,qte_stockArticle,prix_veArticle);

            // Effacer les champs du formulaire après l'ajout
            clearFormFieldsA();
            formulaireAr.setVisible(false);
            tableau_article.setLayoutY(169);
        } else {
            // Afficher un message d'erreur si tous les champs ne sont pas remplis
            // Vous pouvez implémenter cette partie selon vos besoins
            System.out.println("problem");
        }
    }

    private void clearFormFieldsA() {
        // Effacer les champs du formulaire après la modification
        libAr.clear();
        prix_unAr.clear();
        qte_stockAr.clear();
        prix_veAr.clear();

    }


    public void showModificationForm(Article article) {
        libAr.setText(article.getLibelle());
        prix_unAr.setText(String.valueOf(article.getPrixUnitaire()));
        qte_stockAr.setText(String.valueOf(article.getQuantiteDisponible()));
        prix_veAr.setText(String.valueOf(article.getPrixVente()));
        formulaireAr.setVisible(true);

        formulaireAr.setLayoutY(170);
        tableau_article.setLayoutY(400);

        //when I click on the button update the data are taking from the form to the database to get updated
        btn_addA.setOnAction(event -> {
            String nouveauLibelle = libAr.getText();
            float nouveauPrixUnitaire= Float.parseFloat(prix_unAr.getText());
            int nouvelleQuantite = Integer.parseInt(qte_stockAr.getText());
            float nouveauPrixVente = Float.parseFloat(prix_veAr.getText());



            tableau_article.refresh();
            modifierArticle(article.getId(), nouveauLibelle, nouveauPrixUnitaire, nouvelleQuantite, nouveauPrixVente);
            // Mettre à jour la ligne dans le Tableau
            article.setLibelle(nouveauLibelle);
            article.setPrixUnitaire(Float.parseFloat(String.valueOf(nouveauPrixUnitaire)));
            article.setQuantiteDisponible(Integer.parseInt(String.valueOf(nouvelleQuantite)));
            article.setPrixVente(Float.parseFloat(String.valueOf(nouveauPrixVente)));

            tableau_article.refresh();
            formulaireAr.setVisible(false);
            tableau_article.setLayoutY(169);
        });


    }

    public void supprimerArticle(Article article){
        try {
            // Code pour supprimer le commerçant de la base de données en utilisant son ID
            String query = "DELETE FROM article WHERE reference = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, article.getId());
            // Exécuter la requête de suppression
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void modifierArticle(int id, String nouveauLibelle, float nouveauPrixUnitaire, int nouvelleQuantite, float nouveauPrixVente) {
        // Mettre à jour les informations du fournisseur dans la base de données
        String update = "UPDATE article SET libelle = ?, prix_unitaire = ?, quantite_stock = ?, prix_vente = ? WHERE reference = ?";
        try {
            PreparedStatement st = connection.prepareStatement(update);
            st.setString(1, nouveauLibelle);
            st.setFloat(2, nouveauPrixUnitaire);
            st.setInt(3, nouvelleQuantite);
            st.setFloat(4, nouveauPrixVente);
            st.setInt(5, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void ajouter_article(String libArt, Float prix_unArt, Integer qte_stockArt, Float prix_veArt) {
        String insert="INSERT INTO article (libelle, prix_unitaire, quantite_stock, prix_vente) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(insert);
            st.setString(1,libArt);
            st.setFloat(2,prix_unArt);
            st.setInt(3,qte_stockArt);
            st.setFloat(4,prix_veArt);

            st.executeUpdate();
            showArticle();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void ajouter_article_BTN(ActionEvent event){
        formulaireAr.setVisible(true);
        if (formulaireAr.isVisible()) {
            tableau_article.setLayoutY(380.0);
            formulaireAr.setLayoutY(169);
        } else {
            tableau_article.setLayoutY(170.0);
        }
    }


    @FXML
    private void fermerFormulaireA(ActionEvent event) {

        formulaireAr.setVisible(!formulaireAr.isVisible());
        if (formulaireAr.isVisible()) {
            tableau_article.setLayoutY(380.0);
            formulaireAr.setLayoutY(58.0);
        } else {
            tableau_article.setLayoutY(170.0);
        }
    }

    public ObservableList<Article> getArticle() {
        ObservableList<Article> articles=FXCollections.observableArrayList();
        String requette="select * from article";
        try {
            Statement st= connection.createStatement();
            //affecter le resultat de la requete a un variable
            ResultSet rs=st.executeQuery(requette);
            while(rs.next()){
                Article article=new Article();
                article.setId(rs.getInt("reference"));
                article.setLibelle(rs.getString("libelle"));
                article.setPrixUnitaire(Float.parseFloat(rs.getString("prix_unitaire")));
                article.setQuantiteDisponible(Integer.parseInt(rs.getString("quantite_stock")));
                article.setPrixVente(Float.parseFloat(rs.getString("prix_vente")));
                articles.add(article);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return articles;
    }
    //affecter la list des donnes qu'on a tire au tableau
    public void showArticle(){
        ObservableList<Article> list=getArticle();
        tableau_article.setItems(list);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        libArt.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        prix_unArt.setCellValueFactory(new PropertyValueFactory<>("prixUnitaire"));
        qte_stockArt.setCellValueFactory(new PropertyValueFactory<>("quantiteDisponible"));
        prix_veArt.setCellValueFactory(new PropertyValueFactory<>("prixVente"));

    }

    //Client
    @FXML
    private void handleAjouterClient(ActionEvent event) {
        // Code pour ajouter le commerçant à la base de données
        String nomC=nomCl.getText();
        String adrC=adrCl.getText();
        String numTC=numTCl.getText();

//        System.out.println(nomFo+teleFo+FaxFo);


        // Vérification des champs non vides avant d'ajouter à la base de données
        if (!nomC.isEmpty() && !adrC.isEmpty() && !numTC.isEmpty()) {
            // Appel à la méthode pour ajouter le commerçant à la base de données

            ajouter_client(nomC,adrC,numTC);

            // Effacer les champs du formulaire après l'ajout
            clearFormFieldsC();
            formulaireC.setVisible(false);
            tableau_client.setLayoutY(169);
        } else {
            // Afficher un message d'erreur si tous les champs ne sont pas remplis
            // Vous pouvez implémenter cette partie selon vos besoins
            System.out.println("problem");
        }
    }


    private void clearFormFieldsC() {
        // Effacer les champs du formulaire après la modification
        nomCl.clear();
        adrCl.clear();
        numTCl.clear();

    }


    public void showModificationForm(Client client) {
        nomCl.setText(client.getNom());
        adrCl.setText(client.getAdresse());
        numTCl.setText(client.getNumeroTelephone());

        formulaireC.setVisible(true);

        formulaireC.setLayoutY(170);
        tableau_client.setLayoutY(400);


        //when I click on the button update the data are taking from the form to the database to get updated
        btn_addC.setOnAction(event -> {
            String nouveauNom = nomCl.getText();
            String nouvelleAdresse = adrCl.getText();
            String nouveauTelephone = numTCl.getText();

            tableau_client.refresh();
            modifierClient(client.getId(), nouveauNom, nouvelleAdresse, nouveauTelephone);
            // Mettre à jour la ligne dans le Tableau
            client.setNom(nouveauNom);
            client.setNumeroTelephone(nouveauTelephone);
            client.setAdresse(nouvelleAdresse);

            tableau_client.refresh();
            formulaireC.setVisible(false);
            tableau_client.setLayoutY(169);
        });


    }

    public void supprimerClient(Client client){
        try {
            // Code pour supprimer le commerçant de la base de données en utilisant son ID
            String query = "DELETE FROM client WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, client.getId());
            // Exécuter la requête de suppression
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void modifierClient(int id, String nouveauNom, String nouvelleAdresse, String nouveauTelephone) {
        // Mettre à jour les informations du fournisseur dans la base de données
        String update = "UPDATE client SET nom = ?, adresse = ?, numero_telephone = ? WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(update);
            st.setString(1, nouveauNom);
            st.setString(2, nouvelleAdresse);
            st.setString(3, nouveauTelephone);
            st.setInt(4, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void ajouter_client(String nomC,String adrC,String numTC) {
        String insert="INSERT INTO client (nom, adresse, numero_telephone) VALUES (?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(insert);
            st.setString(1,nomC);
            st.setString(2,adrC);
            st.setString(3,numTC);
            st.executeUpdate();
            showClient();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void ajouter_client_BTN(ActionEvent event){
        formulaireC.setVisible(true);
        if (formulaireC.isVisible()) {
            tableau_client.setLayoutY(380.0);
            formulaireC.setLayoutY(169);
        } else {
            tableau_client.setLayoutY(170.0);
        }
    }

    @FXML
    private void fermerFormulaireC(ActionEvent event) {

        formulaireC.setVisible(!formulaireC.isVisible());
        if (formulaireC.isVisible()) {
            tableau_client.setLayoutY(380.0);
            formulaireC.setLayoutY(58.0);
        } else {
            tableau_client.setLayoutY(170.0);
        }
    }

    public ObservableList<Client> getClient() {
        ObservableList<Client> clients=FXCollections.observableArrayList();
        String requette="select * from client";
        try {
            Statement st= connection.createStatement();
            //affecter le resultat de la requete a un variable
            ResultSet rs=st.executeQuery(requette);
            while(rs.next()){
                Client client=new Client();
                client.setId(rs.getInt("id"));
                client.setNom(rs.getString("nom"));
                client.setAdresse(rs.getString("adresse"));
                client.setNumeroTelephone(rs.getString("numero_telephone"));

                clients.add(client);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }
    //affecter la list des donnes qu'on a tire au tableau
    public void showClient(){
        ObservableList<Client> list=getClient();
        tableau_client.setItems(list);
        idC.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomC.setCellValueFactory(new PropertyValueFactory<>("nom"));
        adrC.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        numTC.setCellValueFactory(new PropertyValueFactory<>("numeroTelephone"));
    }
    //Imprimer le fournisseur
    public void imprimerFournisseur(Fournisseur fournisseur) {
        // Générer un TextFlow avec les informations du fournisseur
        TextFlow textFlow = new TextFlow();
        textFlow.getChildren().addAll(
                boldText("Informations du Fournisseur : " + "\n" ),
                new Text("- Nom : " + fournisseur.getNomPrenom() + "\n"),
                new Text("- Adresse : " + fournisseur.getAdresse() + "\n"),
                new Text("- Téléphone : " + fournisseur.getTelephone() + "\n"),
                new Text("- Fax : " + fournisseur.getFax() + "\n"),
                new Text("- Commentaire : " + fournisseur.getCommentaire() + "\n")
        );

        // Imprimer le TextFlow
        printNode(textFlow);
    }
    private void printNode(Node node) {
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null && job.showPrintDialog(null)) { // Passer null pour afficher la boîte de dialogue d'impression par défaut
            boolean success = job.printPage(node);
            if (success) {
                job.endJob();
            }
        }}

    // Méthode utilitaire pour créer un Text en gras
    private Text boldText(String text) {
        Text boldText = new Text(text);
        boldText.setFont(Font.font("System", FontWeight.BOLD, 12)); // Changer la taille de police si nécessaire
        return boldText;
    }

}
