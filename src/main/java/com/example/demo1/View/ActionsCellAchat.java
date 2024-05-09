package com.example.demo1.View;


import com.example.demo1.Controller.CommercantDashBoard;
import com.example.demo1.Model.Achat;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;

public class ActionsCellAchat extends TableCell<Achat, Void> {
    private final Button updateButton = new Button("Modifier");
    private final Button deleteButton = new Button("Supprimer");
    private final CommercantDashBoard commercantDashBoard;


    public ActionsCellAchat(CommercantDashBoard commercantDashBoard) {
        this.commercantDashBoard = commercantDashBoard;

        // Définir le style des boutons
        updateButton.getStyleClass().add("update-button");
        deleteButton.getStyleClass().add("delete-button");

        updateButton.setOnAction(event -> {
            Achat rowData = getTableView().getItems().get(getIndex());
            commercantDashBoard.modifierAchat(rowData); // Appeler la méthode du contrôleur
        });


        deleteButton.setOnAction(event -> {
            Achat rowData = getTableView().getItems().get(getIndex());
            // Appeler la méthode de suppression de l'achat dans le contrôleur
            commercantDashBoard.supprimerAchatBDD(rowData);
        });
    }

    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(new HBox(updateButton, deleteButton));
        }
    }
}
