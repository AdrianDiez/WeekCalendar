package es.fundacioncarriegos.adiezp00.weekcalendar.ddbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author adrian
 * @version 0
 *          <p/>
 *          All right reserved.
 * @since 11/06/13 18:06
 */
public class MySQLConnection {

    /** Driver of JDBC */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    /** Data of connection */
    static final String DDBB_CON = "jdbc:mysql://192.168.5.10/mydb";

    /** User of the DDBB */
    static final String USER = "Adrian";

    /** Password of the User */
    static final String PASSW = "71468213z";

    /** The connection to de DDBB */
    private Connection con;

    public boolean connect() {
        boolean result = false;
        try {
            Class.forName(JDBC_DRIVER);
            this.con = DriverManager.getConnection(DDBB_CON,USER,PASSW);
            if(this.con != null) {
                result = true;
            }
        } catch(Exception e) {
            System.out.println("Error de mysql");
        }
        return result;
    }

    /**
     * Getter of the connectio
     *
     * @return con Connection
     */
    public Connection getCon() {
        return con;
    }

    public boolean disconnect() {
        boolean result;
        try {
            this.con.close();
            result = true;
        } catch (SQLException e) {
            result = false;
        }
        return result;
    }
}
