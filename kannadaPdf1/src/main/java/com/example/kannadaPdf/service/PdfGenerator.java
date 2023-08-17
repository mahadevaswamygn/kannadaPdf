package com.example.kannadaPdf.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


import java.util.Collections;


@Service
public class PdfGenerator {

    ///home/mahadeva/Documents/kannada/kannadaPdf/src/main/resources/sampleReport.jrxml
//    /home/mahadeva/Documents/kannada/kannadaPdf/src/main/resources/sampleReport.jasperath/to/your/report.jasper
//    /home/mahadeva/Desktop/kannada.pdf
    public void generatePdf() throws JRException, IOException {

        //kannada

//        try {
//            // Compile the JasperReport design
//            JasperCompileManager.compileReportToFile("/home/mahadeva/Documents/kannada/kannadaPdf/src/main/resources/sampleReport.jrxml");
//
//            // Create a JasperPrint object
//            JasperPrint jasperPrint = JasperFillManager.fillReport("/home/mahadeva/Documents/kannada/kannadaPdf/src/main/resources/sampleReport.jasper", new HashMap<>());
//
//            // Export the report to PDF
//            JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/mahadeva/Desktop/kannada.pdf");
//
//            System.out.println("PDF generated successfully.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            // Load the compiled JasperReport template (.jasper)
//            JasperReport jasperReport = JasperCompileManager.compileReport("/home/mahadeva/Documents/kannada/kannadaPdf/src/main/resources/test1hindi.jasper");
//
//            // Create a data source (for example, a collection of objects)
////            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(yourDataList);
//
//            // Set up parameters if needed
//            Map<String, Object> parameters = new HashMap<>();
//            // Add parameters if needed
//
//            // Generate the report
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
//
//            // Export the report to desired format (PDF, HTML, etc.)
//            JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/mahadeva/Desktop/hindisample0002.pdf");
//        } catch (JRException e) {
//            e.printStackTrace();
//        }

//        JasperCompileManager.compileReportToFile("/home/mahadeva/Documents/kannada/kannadaPdf/src/main/resources/kannadaReport.jrxml");
//        System.out.println("compiled");
//
//        JasperReport jasperReport = JasperCompileManager.compileReport("/home/mahadeva/Documents/kannada/kannadaPdf/src/main/resources/newKannadaPdf.jrxml");
//
//        // Create a data source
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("kannadaText", "ಕನ್ನಡ ಪಠ್ಯ");
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singletonList(parameters));
//
//        // Fill the report and generate PDF
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//
//        // Export to PDF using PDFBox
//        ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
//        JasperExportManager.exportReportToPdfStream(jasperPrint, pdfStream);
//
//        // Save the PDF using PDFBox
//        try (PDDocument document = new PDDocument()) {
//            PDPage page = new PDPage();
//            document.addPage(page);
//
//            PDPageContentStream contentStream = new PDPageContentStream(document, page);
//            contentStream.drawImage(PDImageXObject.createFromByteArray(document, pdfStream.toByteArray(), ""), 0, 0);
//            contentStream.close();
//
//            document.save("/home/mahadeva/Desktop/kannadanewpdf.pdf");
//        }


//        JasperReport jasperReport = JasperCompileManager.compileReport("/home/mahadeva/Documents/kannada/kannadaPdf/src/main/resources/newKannadaPdf.jrxml");
//
//        // Create a data source
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("kannadaText", "ಕನ್ನಡ ಪಠ್ಯ");
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singletonList(parameters));
//
//        // Fill the report
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//
//        // Export to PDF using PDFBox
//        try (PDDocument document = new PDDocument()) {
//            PDPage page = new PDPage();
//            document.addPage(page);
//
//            PDPageContentStream contentStream = new PDPageContentStream(document, page);
//            ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
//            JasperExportManager.exportReportToPdfStream(jasperPrint, pdfStream);
//
//            contentStream.beginText();
//            contentStream.setFont(PDType1Font.HELVETICA, 12);
//            contentStream.newLineAtOffset(100, 700);
//            contentStream.showText(new String(pdfStream.toByteArray(), StandardCharsets.UTF_8));
//            contentStream.endText();
//            contentStream.close();
//
//            document.save("/home/mahadeva/Desktop/kannadanewpdf.pdf");
//        }


        JasperReport jasperReport = JasperCompileManager.compileReport("/home/mahadeva/Documents/kannada/kannadaPdf/src/main/resources/newKannadaPdf.jrxml");

        // Create a data source
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("kannadaText", "ಕನ್ನಡ ಪಠ್ಯ");
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singletonList(parameters));

        // Fill the report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        // Export to PDF using PDFBox
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Load a font that supports Kannada characters
//            PDType0Font kannadaFont = PDType0Font.load(document, PdfGenerator.class.getResourceAsStream("/home/mahadeva/Documents/kannada/kannadaPdf/src/main/resources/fonts/NotoSansKannada-Regular.ttf"));
            PDType0Font kannadaFont = PDType0Font.load(document, PdfGenerator.class.getResourceAsStream("/fonts/NotoSansKannada-Regular.ttf"));

            contentStream.setFont(kannadaFont, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("ಕನ್ನಡ ಪಠ್ಯ");
            contentStream.endText();
            contentStream.close();

            document.save("/home/mahadeva/Desktop/kannadanewpdf.pdf");
        }


    }
}
