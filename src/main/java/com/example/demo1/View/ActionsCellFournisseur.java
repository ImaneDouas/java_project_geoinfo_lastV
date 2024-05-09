package com.example.demo1.View;

import com.example.demo1.Controller.CommercantDashBoard;
import com.example.demo1.Model.Fournisseur;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class ActionsCellFournisseur extends TableCell<Fournisseur,Void> {
    private final Button deleteButton = new Button("Supprimer");
    private final Button updateButton = new Button("Modifier");
    private final Button printButton = new Button("Imprimer");
    private CommercantDashBoard commercantDashBoard;

    public ActionsCellFournisseur(CommercantDashBoard commercantDashBoard) {
        this.commercantDashBoard = commercantDashBoard;
        updateButton.getStyleClass().add("update-button");
        deleteButton.getStyleClass().add("delete-button");
        printButton.getStyleClass().add("print-button");

        updateButton.setOnAction(event -> {
            Fournisseur rowData = getTableView().getItems().get(getIndex());
            commercantDashBoard.showModificationForm(rowData);
        });

        deleteButton.setOnAction(event -> {
            Fournisseur rowData = getTableView().getItems().get(getIndex());
            commercantDashBoard.supprimerFournisseur(rowData);
            getTableView().getItems().remove(rowData);
        });

        printButton.setOnAction(event -> {
            Fournisseur fournisseur = getTableView().getItems().get(getIndex());
            commercantDashBoard.imprimerFournisseur(fournisseur);
        });
    }

    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            // Display buttons in an HBox
            setGraphic(new HBox(updateButton, deleteButton, printButton));
        }
    }

    public static Callback<TableColumn<Fournisseur, Void>, TableCell<Fournisseur, Void>> cellFactory(CommercantDashBoard commercantDashBoard) {
        return param -> new ActionsCellFournisseur(commercantDashBoard);
    }
}