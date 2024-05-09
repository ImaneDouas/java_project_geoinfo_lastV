package com.example.demo1.View;


import com.example.demo1.Controller.CommercantDashBoard;
import com.example.demo1.Model.Client;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class ActionsCellClient extends TableCell<Client,Void> {
    private final Button deleteButton = new Button("Supprimer");
    private final Button updateButton = new Button("Modifier");
    private CommercantDashBoard commercantDashBoard;

    public ActionsCellClient(CommercantDashBoard commercantDashBoard) {
        this.commercantDashBoard = commercantDashBoard;
        updateButton.getStyleClass().add("update-button");
        deleteButton.getStyleClass().add("delete-button");

        updateButton.setOnAction(event -> {
            Client rowData = getTableView().getItems().get(getIndex());
            commercantDashBoard.showModificationForm(rowData);
        });

        deleteButton.setOnAction(event -> {
            Client rowData = getTableView().getItems().get(getIndex());
            commercantDashBoard.supprimerClient(rowData);
            getTableView().getItems().remove(rowData);
        });
    }
    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            // Display buttons in an HBox
            setGraphic(new HBox(updateButton, deleteButton));
        }
    }

    public static Callback<TableColumn<Client, Void>, TableCell<Client, Void>> cellFactory(CommercantDashBoard commercantDashBoard) {
        return param -> new ActionsCellClient(commercantDashBoard);
    }
}
