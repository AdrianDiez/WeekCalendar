package es.fundacioncarriegos.adiezp00.weekcalendar.ddbb.test;

import es.fundacioncarriegos.adiezp00.weekcalendar.ddbb.DataHandlerImpl;
import es.fundacioncarriegos.adiezp00.weekcalendar.ddbb.DataHandlerInterface;
import es.fundacioncarriegos.adiezp00.weekcalendar.ddbb.MySQLConnection;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author adrian
 * @version 0
 *          <p/>
 *          All right reserved.
 * @since 14/06/13 18:30
 */
public class DataHandlerImplTest {
    // Take care if the DDBB or the port or the host changes.
    private DataHandlerInterface dh;

    @Before
    public void setUp() {
        MySQLConnection connection = new MySQLConnection();
        if(connection.connect()) {
            this.dh = new DataHandlerImpl(connection);
        }
    }

    @Test
    public void testGetNotNullNamesOfWorkers() throws Exception {
        String[] result = this.dh.getNamesOfWorkers();
        assertNotNull(result);
        assertTrue(this.dh.close());
    }

    @Test
    public void testGetNotNullWeekCalendar() throws Exception {
        String[] result = this.dh.getWeekCalendar("2013-06-01","2013-06-03","MONICA");
        assertNotNull(result);
        assertTrue(this.dh.close());
    }

    @Test
    public void testCloseOneOpenConnection() throws Exception {
        assertTrue(this.dh.close());
    }

    @Test
    public void testCloseOneClosedConnection() throws Exception {
        assertTrue(this.dh.close());
        assertTrue(this.dh.close());
    }
}
