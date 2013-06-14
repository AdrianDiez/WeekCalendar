package es.fundacioncarriegos.adiezp00.weekcalendar.datehandler.test;

import es.fundacioncarriegos.adiezp00.weekcalendar.datehandler.DateFormatImpl;
import es.fundacioncarriegos.adiezp00.weekcalendar.datehandler.DateFormatInterface;
import es.fundacioncarriegos.adiezp00.weekcalendar.exceptions.NonValidDateException;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 *
 * @author adrian
 * @version 0
 *          <p/>
 *          All right reserved.
 * @since 14/06/13 18:15
 */
public class DateFormatImplTest {

    @Test
    public void testChangeDateFormat() throws NonValidDateException {
        DateFormatInterface dfi = new DateFormatImpl();
        assertEquals(dfi.changeDateFormat("05/12/2013"), "2013-12-05");
    }

    @Test(expected = NonValidDateException.class)
    public void testNonValidDateException() throws NonValidDateException {
        DateFormatInterface dfi = new DateFormatImpl();
        dfi.changeDateFormat("05/12/2013/9");
    }
}
