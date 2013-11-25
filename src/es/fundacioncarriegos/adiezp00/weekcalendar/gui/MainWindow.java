package es.fundacioncarriegos.adiezp00.weekcalendar.gui;

import es.fundacioncarriegos.adiezp00.weekcalendar.ddbb.DataHandlerImpl;
import es.fundacioncarriegos.adiezp00.weekcalendar.ddbb.DataHandlerInterface;
import es.fundacioncarriegos.adiezp00.weekcalendar.ddbb.MySQLConnection;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static es.fundacioncarriegos.adiezp00.weekcalendar.MainRunner.run;


/**
 * Created with IntelliJ IDEA.
 *
 * @author adrian
 * @version 0
 *          <p/>
 *          All right reserved.
 * @since 25/06/13 19:26
 */

public class MainWindow {

    /** The general frame */
    private static JFrame frame;

    /** The date picker */
    private JDatePicker datePicker;

    /** The date picker */
    private JDatePicker datePicker_1;

    /** The list of names */
    private JList<String> list;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow mw = new MainWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 460);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SpringLayout springLayout = new SpringLayout();
        frame.getContentPane().setLayout(springLayout);

        this.list = new JList<String>();
        JScrollPane scroll = new JScrollPane(list);
        DefaultListModel<String> model = new DefaultListModel<String>();
        list.setModel(model);
        MySQLConnection con = new MySQLConnection();
        DataHandlerInterface dh = new DataHandlerImpl(con);
        String[] names;
        try {
            names = dh.getNamesOfWorkers();
            for(String name : names) {
                model.addElement(name);
            }
        } catch (SQLException e) {
            model.addElement("PROBLEM WITH DATABASE.");
        }
        dh.close();
        con.disconnect();

        springLayout.putConstraint(SpringLayout.NORTH, scroll, 169, SpringLayout.NORTH, frame.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, scroll, 10, SpringLayout.WEST, frame.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, scroll, -151, SpringLayout.SOUTH, frame.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, scroll, 255, SpringLayout.WEST, frame.getContentPane());
        frame.getContentPane().add(scroll);

        this.datePicker = new JDatePicker();
        frame.getContentPane().add(datePicker);

        this.datePicker_1 = new JDatePicker();
        springLayout.putConstraint(SpringLayout.SOUTH, datePicker_1, -122, SpringLayout.SOUTH, frame.getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, datePicker, 0, SpringLayout.NORTH, datePicker_1);
        springLayout.putConstraint(SpringLayout.EAST, datePicker, -71, SpringLayout.WEST, datePicker_1);
        springLayout.putConstraint(SpringLayout.EAST, datePicker_1, -10, SpringLayout.EAST, frame.getContentPane());
        frame.getContentPane().add(datePicker_1);

        JButton btnObtain = new JButton("Obtener");
        btnObtain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Date dateInit = datePicker.getDate();
                Date dateEnd = datePicker_1.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                chooser.setDialogTitle("Selecciona el destino");
                chooser.setMultiSelectionEnabled(false);
                int returnVal = chooser.showSaveDialog(frame);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    String path = chooser.getSelectedFile().getAbsolutePath();
                    String[] name = list.getModel().getElementAt(list.getSelectedIndex()).split(" ");
                    String[] args = {sdf.format(dateInit), sdf.format(dateEnd), name[0], path};
                    try {
                        run(args);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(frame,"Error en la ejecución del programa.",
                                "¡ERROR!",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        springLayout.putConstraint(SpringLayout.WEST, btnObtain, 299, SpringLayout.WEST, frame.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, btnObtain, -42, SpringLayout.SOUTH, frame.getContentPane());
        frame.getContentPane().add(btnObtain);

        JLabel lblDaDeInit = new JLabel("D\u00EDa de inicio");
        springLayout.putConstraint(SpringLayout.WEST, lblDaDeInit, 0, SpringLayout.WEST, datePicker);
        springLayout.putConstraint(SpringLayout.SOUTH, lblDaDeInit, -6, SpringLayout.NORTH, datePicker);
        frame.getContentPane().add(lblDaDeInit);

        JLabel lblDaDeFin = new JLabel("D\u00EDa de fin");
        springLayout.putConstraint(SpringLayout.WEST, lblDaDeFin, 0, SpringLayout.WEST, datePicker_1);
        springLayout.putConstraint(SpringLayout.SOUTH, lblDaDeFin, -6, SpringLayout.NORTH, datePicker_1);
        frame.getContentPane().add(lblDaDeFin);
    }

    /**
     * Obtain the main frame.
     *
     * @return the main frame
     */
    public static JFrame getFrame() {
        return frame;
    }
}
