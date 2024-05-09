package com.example.demo1.View;
import com.example.demo1.Controller.CommercantDashBoard;
import com.example.demo1.Model.Article;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class ActionsCellArticle extends TableCell<Article,Void> {
    private final Button deleteButton = new Button("Supprimer");
    private final Button updateButton = new Button("Modifier");


    private CommercantDashBoard commercantDashBoard;

    public ActionsCellArticle(CommercantDashBoard commercantDashBoard) {
        this.commercantDashBoard = commercantDashBoard;
        updateButton.getStyleClass().add("update-button");
        deleteButton.getStyleClass().add("delete-button");

        updateButton.setOnAction(event -> {
            Article rowData = getTableView().getItems().get(getIndex());
            commercantDashBoard.showModificationForm(rowData);
        });

        deleteButton.setOnAction(event -> {
            Article rowData = getTableView().getItems().get(getIndex());
            commercantDashBoard.supprimerArticle(rowData);
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

    public static Callback<TableColumn<Article, Void>, TableCell<Article, Void>> cellFactory(CommercantDashBoard commercantDashBoard) {
        return param -> new ActionsCellArticle(commercantDashBoard);
}
}

