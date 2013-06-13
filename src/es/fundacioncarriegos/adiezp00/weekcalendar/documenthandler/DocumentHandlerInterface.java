package es.fundacioncarriegos.adiezp00.weekcalendar.documenthandler;

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
     * Write the content in the file.
     *
     * @param content String.
     * @return true if all is correct, false in other case.
     */
    public boolean write(String content);

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
    public String read();

    /**
     * Read all the document.
     *
     * @return the String
     */
    public String readAll();

    /**
     * Change the type of the file to PDF format.
     *
     * @return true if all is correct, false if not.
     */
    public boolean parseToPDF();
}
