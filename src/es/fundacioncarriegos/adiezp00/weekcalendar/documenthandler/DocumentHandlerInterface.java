package es.fundacioncarriegos.adiezp00.weekcalendar.documenthandler;


import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * @author adrian
 * @since 07/06/13 17:25
 * @version 0
 *
 * All right reserved.
 */
public interface DocumentHandlerInterface {
    /**
     *
     * @return TextDocument.
     */
    public TextDocument getDocument();

    /**
     *
     * @param doc to set.
     */
    public void setDocument(TextDocument doc);

    /**
     * Save the current document in the system.
     *
     * @return true if all is correct, false in other case.
     */
    public boolean write();

    /**
     * Delete the current document in the system.
     *
     * @return true if all is correct, false in other case.
     */
    public boolean delete();

    /**
     * Close the current document safely.
     *
     * @return true if all is correct, false in other case.
     */
    public boolean close();

    /**
     * Read the document.
     *
     * @return the String.
     */
    public String read() throws IOException;

    /**
     * Change the type of the file to PDF format.
     *
     * @return true if all is correct, false if not.
     */
    public boolean parseToPDF() throws FileNotFoundException, DocumentException;
}
