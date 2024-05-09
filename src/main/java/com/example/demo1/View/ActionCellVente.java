package com.example.demo1.View;


import com.example.demo1.Controller.CommercantDashBoard;
import com.example.demo1.Model.Vente;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class ActionCellVente extends TableCell<Vente, Void> {
    private final Button updateButton = new Button("Modifier");
    private final Button deleteButton = new Button("Supprimer");
    private final CommercantDashBoard commercantDashBoard;


    public ActionCellVente(CommercantDashBoard commercantDashBoard) {
        this.commercantDashBoard = commercantDashBoard;

        // Définir le style des boutons
        updateButton.getStyleClass().add("update-button");
        deleteButton.getStyleClass().add("delete-button");

        updateButton.setOnAction(event -> {
            Vente rowData = getTableView().getItems().get(getIndex());
            commercantDashBoard.modifierVente(rowData); // Appeler la méthode du contrôleur
        });


        deleteButton.setOnAction(event -> {
            Vente rowData = getTableView().getItems().get(getIndex());
            // Appeler la méthode de suppression de l'achat dans le contrôleur
            commercantDashBoard.supprimerVenteBDD(rowData);
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
    public static Callback<TableColumn<Vente, Void>, TableCell<Vente, Void>> cellFactory(CommercantDashBoard commercantDashBoard) {
        return param -> new ActionCellVente(commercantDashBoard);
    }
}