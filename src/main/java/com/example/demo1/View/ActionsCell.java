package com.example.demo1.View;

import com.example.demo1.Controller.AdminController;
import com.example.demo1.Model.Commercant;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class ActionsCell extends TableCell<Commercant, Void> {
    private final Button updateButton = new Button("Modifier");
    private final Button deleteButton = new Button("Supprimer");
    private final AdminController adminController;


    public ActionsCell(AdminController adminController) {
            this.adminController = adminController;

            // Définir le style des boutons
            updateButton.getStyleClass().add("update-button");
            deleteButton.getStyleClass().add("delete-button");

            // Définir les actions des boutons
            updateButton.setOnAction(event -> {
                Commercant rowData = getTableView().getItems().get(getIndex());
                adminController.showModificationForm(rowData);
            });

            deleteButton.setOnAction(event -> {
                Commercant rowData = getTableView().getItems().get(getIndex());
                // Action à effectuer lors du clic sur le bouton de suppression
                // Supprimer la ligne du TableView
                getTableView().getItems().remove(rowData);
                // Supprimer le commerçant de la base de données en utilisant la méthode de AdminController
                adminController.supprimerCommercant(rowData);
            });
        }

        // Autres méthodes de la classe ActionsCell...


    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            // Afficher les boutons dans la cellule
            setGraphic(new HBox(updateButton, deleteButton));
        }
    }

    public static Callback<TableColumn<Commercant, Void>, TableCell<Commercant, Void>> cellFactory(AdminController adminController) {
        return param -> new ActionsCell(adminController);
    }

}