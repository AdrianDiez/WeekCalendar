package es.fundacioncarriegos.adiezp00.weekcalendar.documenthandler;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author adrian
 * @version 0
 *          <p/>
 *          All right reserved.
 * @since 18/06/13 17:53
 */
class MyHeader extends PdfPageEventHelper {

    /**
     * The text on the first page.
     *
     * @param writer PdfWriter
     * @param document Document
     */
    public void onOpenDocument(PdfWriter writer, Document document) {
        Paragraph p;
        try {
            p = new Paragraph("CALENDARIO DE PRODUCCIÓN",
                    FontFactory.getFont("times new roman",35,Font.UNDERLINE,new BaseColor(0,176,246)));
            p.setIndentationLeft(130);
            document.add(p);
            LineSeparator lineSeparator = new LineSeparator();
            document.add(new Chunk(lineSeparator));
        } catch (DocumentException e) {
            System.exit(0);
        }
    }

    /**
     * The header of all pages.
     *
     * @param writer PdfWriter
     * @param document Document
     */
    public void onStartPage(PdfWriter writer, Document document) {
        try {
            Image image = Image.getInstance(MyHeader.class.getClassLoader().getResource("LOGO.png"));
            image.scaleToFit(100, 100);
            image.setAbsolutePosition(50, 500);
            image.setAlignment(Element.ALIGN_TOP);
            document.add(image);
            Paragraph p = new Paragraph("");
            p.setSpacingAfter(70);
            document.add(p);
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
