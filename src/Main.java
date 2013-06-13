import com.itextpdf.text.DocumentException;
import es.fundacioncarriegos.adiezp00.weekcalendar.ddbb.DataHandlerImpl;
import es.fundacioncarriegos.adiezp00.weekcalendar.ddbb.DataHandlerInterface;
import es.fundacioncarriegos.adiezp00.weekcalendar.ddbb.MySQLConnection;

import java.io.IOException;
import java.sql.SQLException;

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
        /*
        TextDocument td = new TextDocument("/Users/adrian/Desktop/","Prueba del calendario de producción.");
        DocumentHandlerInterface dh = new DocumentHandlerImpl(td);
        if(dh.parseToPDF() && dh.delete()) {
            System.exit(1);
        } else {
            System.exit(0);
        }*/
        MySQLConnection connection = new MySQLConnection();
        if(connection.connect()) {
            DataHandlerInterface dh = new DataHandlerImpl(connection);
            try {
                String[] result = dh.getNamesOfWorkers();
                System.out.println(result[0]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
