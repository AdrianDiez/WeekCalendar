package es.fundacioncarriegos.adiezp00.weekcalendar.datehandler;

import es.fundacioncarriegos.adiezp00.weekcalendar.exceptions.NonValidDateException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author adrian
 * @version 0
 *          <p/>
 *          All right reserved.
 * @since 14/06/13 17:49
 */
public interface DateFormatInterface {

    /**
     * Take one date without format, and format it.
     *
     * @param dateWithoutFormat String
     * @return The date formated.
     */
    String changeDateFormat(String dateWithoutFormat) throws NonValidDateException;
}
