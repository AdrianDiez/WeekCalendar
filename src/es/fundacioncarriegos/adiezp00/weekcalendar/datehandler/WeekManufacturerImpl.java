package es.fundacioncarriegos.adiezp00.weekcalendar.datehandler;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 *
 * @author adrian
 * @version 0
 *          <p/>
 *          All right reserved.
 * @since 17/06/13 18:11
 */
public class WeekManufacturerImpl implements WeekManufacturerInterface {
    /**
     * The current week.
     *
     * @return Two dates just formatted.
     */
    @Override
    public String[] thisWeek() {
        Calendar calendar = new GregorianCalendar();
        String[] firstDay = this.takeTheSunday();
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        String[] result = {Integer.toString(year) + "-" + Integer.toString(month) + "-" + firstDay[0],
                Integer.toString(year) + "-" + Integer.toString(month) + "-" + firstDay[1]};
        return result;
    }

    /**
     * Give us the first day of the current week, we suppose that the first day is Sunday
     * and a week is Sunday to Sunday.
     *
     * @return Two dates.
     */
    private String[] takeTheSunday() {
        Calendar calendar = new GregorianCalendar();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int sunday = day - dayOfWeek + 1;
        String[] result = {Integer.toString(sunday), Integer.toString(sunday + 7)};
        return result;
    }

    /**
     * One week between two dates.
     *
     * @param initDate String
     * @param endDate  String
     * @return Two dates just formatted.
     */
    @Override
    public String[] weekBetween(String initDate, String endDate) {
        return new String[0];  //TODO Actualizar más adelante.
    }

    /**
     * Seven days starting in one defined date.
     *
     * @param initDate String
     * @return Two dates just formatted.
     */
    @Override
    public String[] oneWeekStartIn(String initDate) {
        return new String[0];  //TODO Actualizar más adelante.
    }
}
