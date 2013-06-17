import com.itextpdf.text.DocumentException;
import es.fundacioncarriegos.adiezp00.weekcalendar.datehandler.WeekManufacturerImpl;
import es.fundacioncarriegos.adiezp00.weekcalendar.datehandler.WeekManufacturerInterface;
import es.fundacioncarriegos.adiezp00.weekcalendar.ddbb.DataHandlerImpl;
import es.fundacioncarriegos.adiezp00.weekcalendar.ddbb.DataHandlerInterface;
import es.fundacioncarriegos.adiezp00.weekcalendar.ddbb.MySQLConnection;
import es.fundacioncarriegos.adiezp00.weekcalendar.documenthandler.DocumentHandlerImpl;
import es.fundacioncarriegos.adiezp00.weekcalendar.documenthandler.DocumentHandlerInterface;
import es.fundacioncarriegos.adiezp00.weekcalendar.documenthandler.TextDocument;

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
        MySQLConnection connection = new MySQLConnection();
        if(connection.connect()) {
            DataHandlerInterface dh = new DataHandlerImpl(connection);
            try {
                WeekManufacturerInterface wmi = new WeekManufacturerImpl();
                String[] currentWeek = wmi.thisWeek();
                String[] result = dh.getWeekCalendar(currentWeek[0],currentWeek[1],"NIRAVA");
                dh.close();
                TextDocument td = new TextDocument("/Users/adrian/Desktop/",result);
                DocumentHandlerInterface doc = new DocumentHandlerImpl(td);
                if(doc.parseToPDF() && doc.delete() && connection.disconnect()) {
                    System.exit(1);
                } else {
                    System.exit(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
