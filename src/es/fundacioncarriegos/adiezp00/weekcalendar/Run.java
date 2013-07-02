package es.fundacioncarriegos.adiezp00.weekcalendar;

import es.fundacioncarriegos.adiezp00.weekcalendar.ddbb.DataHandlerImpl;
import es.fundacioncarriegos.adiezp00.weekcalendar.ddbb.DataHandlerInterface;
import es.fundacioncarriegos.adiezp00.weekcalendar.ddbb.MySQLConnection;
import es.fundacioncarriegos.adiezp00.weekcalendar.documenthandler.DocumentHandlerImpl;
import es.fundacioncarriegos.adiezp00.weekcalendar.documenthandler.DocumentHandlerInterface;
import es.fundacioncarriegos.adiezp00.weekcalendar.documenthandler.TextDocument;
import es.fundacioncarriegos.adiezp00.weekcalendar.gui.MainWindow;

import javax.swing.*;
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
                //TODO ¡Valorar si no ha introducido ninguna fecha, o nombre!
                String[] result = dh.getWeekCalendar(args[0],args[1],args[2]);
                dh.close();
                TextDocument td = new TextDocument(args[3],result);
                DocumentHandlerInterface doc = new DocumentHandlerImpl(td);
                if(doc.parseToPDF() && doc.delete() && connection.disconnect()) {
                    JOptionPane.showMessageDialog(MainWindow.getFrame(), "Se ha creado el calendario de " + args[2] + " correctamente.");
                } else {
                    JOptionPane.showMessageDialog(MainWindow.getFrame(), "Error en la ejecución del programa.");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(MainWindow.getFrame(), "Problema con la base de datos, comprobar el servidor.");
            }
        }
    }
}
