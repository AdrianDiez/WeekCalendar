package es.fundacioncarriegos.adiezp00.weekcalendar;

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
public class Run {

    public static void run(String[] args) throws IOException {
        MySQLConnection connection = new MySQLConnection();
        if(connection.connect()) {
            DataHandlerInterface dh = new DataHandlerImpl(connection);
            try {
                String[] result = dh.getWeekCalendar(args[0],args[1],args[2]);
                dh.close();
                TextDocument td = new TextDocument("/Users/adrian/Desktop/",result);
                DocumentHandlerInterface doc = new DocumentHandlerImpl(td);
                if(doc.parseToPDF() && doc.delete() && connection.disconnect()) {
                    System.exit(1);
                    //TODO cambiar por un dialog
                } else {
                    System.exit(0);
                    //TODO cambiar por un dialog.
                }
            } catch (SQLException e) {
                //TODO cambiar por un dialog.
            }
        }
    }
}
