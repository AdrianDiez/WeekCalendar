package es.fundacioncarriegos.adiezp00.weekcalendar.datehandler;

/**
 * Created with IntelliJ IDEA.
 *
 * @author adrian
 * @version 0
 *          <p/>
 *          All right reserved.
 * @since 14/06/13 17:55
 */
public interface WeekManufacturerInterface {

    /**
     * The current week.
     *
     * @return Two dates just formatted.
     */
    String[] thisWeek();

    /**
     * One week between two dates.
     * @param initDate String
     * @param endDate String
     * @return Two dates just formatted.
     */
    String[] weekBetween(String initDate, String endDate);

    /**
     * Seven days starting in one defined date.
     *
     * @param initDate String
     * @return Two dates just formatted.
     */
    String[] oneWeekStartIn(String initDate);
}
