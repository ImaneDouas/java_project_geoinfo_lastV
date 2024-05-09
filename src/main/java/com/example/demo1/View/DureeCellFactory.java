package com.example.demo1.View;

import com.example.demo1.Model.Achat;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
public class DureeCellFactory implements Callback<TableColumn<Achat, Long>, TableCell<Achat, Long>> {

    @Override
    public TableCell<Achat, Long> call(TableColumn<Achat, Long> param) {
        return new TableCell<Achat, Long>() {
            @Override
            protected void updateItem(Long item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(String.valueOf(item));
                }
            }
        };
    }
}
