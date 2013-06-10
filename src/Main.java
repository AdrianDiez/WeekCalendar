import com.itextpdf.text.DocumentException;
import es.fundacioncarriegos.adiezp00.weekcalendar.documenthandler.DocumentHandlerImpl;
import es.fundacioncarriegos.adiezp00.weekcalendar.documenthandler.DocumentHandlerInterface;
import es.fundacioncarriegos.adiezp00.weekcalendar.documenthandler.TextDocument;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author adrian
 * @version 0
 *          <p/>
 *          All right reserved.
 * @since 07/06/13 20:29
 */
public class Main {
    public static void main(String[] args) throws IOException, DocumentException {
        TextDocument td = new TextDocument("/Users/adrian/Desktop/","Esto es una prueba muy chachi.");
        DocumentHandlerInterface dh = new DocumentHandlerImpl(td);
        dh.parseToPDF();
    }
}
