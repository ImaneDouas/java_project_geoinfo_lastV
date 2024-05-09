package com.example.demo1.Model;

import javafx.print.PrinterJob;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.IOException;

public class PrinterPDFVentes {
    public static void printTableAchatToPDF(TableView<?> tableView, String pdfFileName) {
        PrinterJob printerJob = PrinterJob.createPrinterJob();

        if (printerJob != null && printerJob.showPrintDialog(tableView.getScene().getWindow())) {
            // Déterminer la largeur de la page PDF
            double pageWidth = printerJob.getJobSettings().getPageLayout().getPrintableWidth();

            // Ajuster la largeur de chaque colonne pour qu'elles s'adaptent à la largeur de la page
            for (TableColumn<?, ?> column : tableView.getColumns()) {
                column.setPrefWidth(pageWidth / tableView.getColumns().size());
            }

            // Créer une nouvelle taille de page avec la largeur de la page PDF
            PDRectangle pageSize = new PDRectangle((float) pageWidth, 792); // 792 est la hauteur de la page par défaut (11 pouces)

            try (PDDocument document = new PDDocument()) {
                PDPage page = new PDPage(pageSize);
                document.addPage(page);

                // Impression de la page
                boolean success = printerJob.printPage(tableView);

                if (success) {
                    printerJob.endJob();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
