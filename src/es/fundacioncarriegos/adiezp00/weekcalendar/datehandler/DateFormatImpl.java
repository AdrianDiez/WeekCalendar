package es.fundacioncarriegos.adiezp00.weekcalendar.datehandler;

import es.fundacioncarriegos.adiezp00.weekcalendar.exceptions.NonValidDateException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author adrian
 * @version 0
 *          <p/>
 *          All right reserved.
 * @since 14/06/13 18:05
 */
public class DateFormatImpl implements DateFormatInterface {
    /**
     * Take one date without format, and format it.
     *
     * @param dateWithoutFormat String
     * @return The date formated.
     */
    @Override
    public String changeDateFormat(String dateWithoutFormat) throws NonValidDateException {
        String[] result = dateWithoutFormat.split("/");
        if(result.length > 3) {
            throw new NonValidDateException();
        }
        return result[2] + "-" + result[1] + "-" + result[0];
    }
}
