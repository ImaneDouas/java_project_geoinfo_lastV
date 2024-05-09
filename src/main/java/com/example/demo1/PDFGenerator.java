package com.example.demo1;

import com.example.demo1.Model.Vente;
import javafx.collections.ObservableList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class PDFGenerator {

    public static void generatePDF(String filePath, ObservableList<Vente> listVentes) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(100, 700);
        contentStream.showText("Rapport des ventes");
        contentStream.endText();

        int y = 650;
        for (Vente vente : listVentes) {
            String data = vente.getId_vente() + ", " + vente.getArticle().getId() + ", " + vente.getClient().getId() + ", "
                    + vente.getDate_vente() + ", " + vente.getQuantityVente();
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 10);
            contentStream.newLineAtOffset(100, y);
            contentStream.showText(data);
            contentStream.endText();
            y -= 20;
        }

        contentStream.close();
        document.save(filePath);
        document.close();
    }
}
