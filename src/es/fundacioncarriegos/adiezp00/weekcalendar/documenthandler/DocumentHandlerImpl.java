package es.fundacioncarriegos.adiezp00.weekcalendar.documenthandler;


import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.*;

import java.awt.*;
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

    /** The PDF document */
    private Document PDFDocument;

    /** The current date */
    private String currentDate = "";

    /** The current hour */
    private String currentInitHour = "";

    /** Format value */
    private final String SPACE = "       ";

    /**
     * Constructor of the class
     *
     * @param doc to set.
     */
    public DocumentHandlerImpl(TextDocument doc) {
        this.setDocument(doc);
        this.PDFDocument = new Document(PageSize.A4_LANDSCAPE.rotate());
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
     * Write the content in the file.
     *
     * @param content String.
     * @return true if all is correct, false in other case.
     */
    @Override
    public boolean write(String content) {
        return this.doc.write(content);
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
    public String read() {
        return this.doc.readLine();
    }

    /**
     * Read all the document.
     *
     * @return the String
     */
    @Override
    public String readAll() {
        return this.doc.readAll();
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
            String[] arrayText = this.parseToArray();
            OutputStream PDFFile = new FileOutputStream(new File(this.doc.getPath() + ".pdf"));
            PdfWriter writer = PdfWriter.getInstance(this.PDFDocument, PDFFile);
            MyHeader event = new MyHeader();
            writer.setPageEvent(event);
            // The document must be open too!
            this.PDFDocument.open();
            PdfPTable table = new PdfPTable(7);
            float[] cellSize = {2.5f, 4.00f, 8.00f, 2.25f, 2.25f, 3f, 5.00f};
            table.setWidths(cellSize);
            PdfPCell cell;
            Paragraph p;
            for(String oneLine : arrayText) {
                String[] fields = oneLine.split(",");
                if(this.currentDate.compareTo(fields[0]) != 0) {
                    p = new Paragraph(fields[0],FontFactory.getFont("arial",9));
                    this.currentDate = fields[0];
                    cell = new PdfPCell(p);
                } else {
                    p = new Paragraph(this.SPACE,FontFactory.getFont("arial", 9));
                    cell = new PdfPCell(p);
                    cell.setBorder(0);
                }
                cell.setMinimumHeight(40);
                table.addCell(cell);
                if(this.currentInitHour.compareTo(fields[1]) != 0) {
                    p = new Paragraph(fields[1] + ":" + fields[2],FontFactory.getFont("arial",9));
                    this.currentInitHour = fields[1];
                    cell = new PdfPCell(p);
                } else {
                    p = new Paragraph(this.SPACE,FontFactory.getFont("arial", 9));
                    cell = new PdfPCell(p);
                    cell.setBorder(0);
                }
                table.addCell(cell);
                table.addCell(new PdfPCell(new Paragraph(fields[3],FontFactory.getFont("arial",9, Font.BOLD))));
                table.addCell(new PdfPCell(new Paragraph(fields[4],FontFactory.getFont("arial",9))));
                table.addCell(new PdfPCell(new Paragraph(fields[5],FontFactory.getFont("arial",9))));
                table.addCell(new PdfPCell(new Paragraph(fields[6],FontFactory.getFont("arial",9))));
                table.addCell(new PdfPCell(new Paragraph(fields[7] + this.SPACE,FontFactory.getFont("arial",9, Font.ITALIC))));
            }
            this.PDFDocument.add(table);
            this.PDFDocument.close();
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    /**
     * Change the format of one text flow separated by "\n".
     *
     * @return the correspondant array.
     */
    private String[] parseToArray() {
        return this.readAll().split("\n");
    }
}
