package es.fundacioncarriegos.adiezp00.weekcalendar.ddbb;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author adrian
 * @version 0
 *          <p/>
 *          All right reserved.
 * @since 11/06/13 19:47
 */
public interface DataHandlerInterface {

    /**
     * Getter of all the worker's names in the ddbb.
     *
     * @return worker's names String[]
     */
    String[] getNamesOfWorkers() throws SQLException;

    /**
     * Return the week calendar between two dates
     *
     * @param dateInit String
     * @param dateEnd String
     * @param person String
     * @return week calendar String[]
     */
    String[] getWeekCalendar(String dateInit, String dateEnd, String person) throws SQLException;

    /**
     * Close the current connection
     *
     * @return true if all is correct, false in other case.
     */
    boolean close();
}
