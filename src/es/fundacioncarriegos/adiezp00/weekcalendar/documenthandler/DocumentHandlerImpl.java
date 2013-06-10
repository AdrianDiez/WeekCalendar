package es.fundacioncarriegos.adiezp00.weekcalendar.documenthandler;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author adrian
 * @version 0
 *          <p/>
 *          All right reserved.
 * @since 07/06/13 17:45
 */
public class DocumentHandlerImpl implements DocumentHandlerInterface {

    /** The document */
    private TextDocument doc;
    private Document PDFDocument;

    /**
     * Constructor of the class
     *
     * @param doc to set.
     */
    public DocumentHandlerImpl(TextDocument doc) {
        this.setDocument(doc);
        this.PDFDocument = new Document(PageSize.A4_LANDSCAPE);
    }

    /**
     * @return TextDocument.
     */
    @Override
    public TextDocument getDocument() {
        return this.doc;
    }

    /**
     * @param doc to set.
     */
    @Override
    public void setDocument(TextDocument doc) {
        this.doc = doc;
    }

    /**
     * Save the current document in the system.
     *
     * @return true if all is correct, false in other case.
     */
    @Override
    public boolean write() {
        boolean result = false;
        return result;
    }

    /**
     * Delete the current document in the system.
     *
     * @return true if all is correct, false in other case.
     */
    @Override
    public boolean delete() {
        return this.doc.delete();
    }

    /**
     * Close the current document safely.
     *
     * @return true if all is correct, false in other case.
     */
    @Override
    public boolean close() {
        return this.doc.close();
    }

    /**
     * Read the document.
     *
     * @return the String.
     */
    @Override
    public String read() throws IOException {
        String result = "";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.doc.getFile()));
        String line = "";
        while((line = bufferedReader.readLine()) != null) {
            result += line + "\n";
        }

        return result;
    }

    /**
     * Change the type of the file to PDF format.
     *
     * @return true if all is correct, false if not.
     */
    @Override
    public boolean parseToPDF() {
        boolean result;
        try {
            Document PDFDocument = new Document(PageSize.A4_LANDSCAPE);
            FileOutputStream ficheroPdf = new FileOutputStream(this.doc.getFile().getAbsolutePath());
            PdfWriter.getInstance(PDFDocument, ficheroPdf).setInitialLeading(10);
            PDFDocument.open();
            String text = this.read();
            String[] arrayText = text.split("\n");
            for(String oneLine : arrayText) {
                PDFDocument.add(new Paragraph(oneLine));
            }
            PDFDocument.close();
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }


    public Document getPDFDocument() {
        return PDFDocument;
    }

}
