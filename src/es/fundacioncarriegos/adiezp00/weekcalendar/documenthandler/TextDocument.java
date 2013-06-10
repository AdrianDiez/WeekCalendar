package es.fundacioncarriegos.adiezp00.weekcalendar.documenthandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author adrian
 * @version 0
 *          <p/>
 *          All right reserved.
 * @since 07/06/13 17:49
 */
public class TextDocument {

    /** The file */
    private File file;

    /** The buffer to write */
    private BufferedWriter bufferedWriter;

    /**
     * Complex constructor
     *
     * @param path to set
     * @param content to set
     * @throws IOException
     */
    public TextDocument(String path, String content) throws IOException {
        this.file = new File(path + "name.txt");
        if(this.file.exists()) {
            this.bufferedWriter = new BufferedWriter(new FileWriter(this.file));
            //TODO comprobar porque no lo escribe si paso por write. Reabrir el fichero!!!
            System.out.println(content);
            this.writeAndClose(content);
        } else {
            this.bufferedWriter = null;
        }
    }

    /**
     * Medium constructor.
     *
     * @param path to set.
     * @throws IOException
     */
    public TextDocument(String path) throws IOException {
        this.file = new File(path);
        if(this.file.exists()) {
            this.bufferedWriter = new BufferedWriter(new FileWriter(this.file));
        } else {
            this.bufferedWriter = null;
        }
    }

    /**
     * Simply constructor.
     *
     * @throws IOException
     */
    public TextDocument() throws IOException {
        this.file = new File("WeekCalendar.doc");
        if(this.file.exists()) {
            this.bufferedWriter = new BufferedWriter(new FileWriter(this.file));
        } else {
            this.bufferedWriter = null;
        }
    }

    /**
     * You must call it after write in the document.
     *
     * @return true if all is correct, false in other case.
     */
    public boolean close() {
        boolean result;
        try {
            this.bufferedWriter.close();
            result = true;
        } catch (IOException e) {
            result = false;
        }
        return result;
    }

    /**
     * Write some words on your document.
     *
     * @param content to write.
     * @return true if all is correct, false in other case.
     */
    public boolean write(String content) {
        boolean result;
        try {
            this.bufferedWriter.write(content);
            result = true;
        } catch (IOException e) {
            result = false;
        }
        return result;
    }

    /**
     * Write some words and close the document.
     *
     * @param content to write
     * @return true if all is correct, false in other case.
     */
    public boolean writeAndClose(String content) {
        return(this.write(content) && this.close());
    }
    /**
     * Delete the document
     *
     * @return true if all is correct, false in other case.
     */
    public boolean delete() {
        return this.file.delete();
    }

    /**
     * Getter of File
     *
     * @return the file
     */
    public File getFile() {
        return this.file;
    }
}
