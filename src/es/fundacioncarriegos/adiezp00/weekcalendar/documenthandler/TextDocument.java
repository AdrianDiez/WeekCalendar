package es.fundacioncarriegos.adiezp00.weekcalendar.documenthandler;

import java.io.*;

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
    private PrintWriter printWritter;


    /**
     * Complex constructor
     *
     * @param path to set
     * @param content to set
     * @throws IOException
     */
    public TextDocument(String path, String content) throws IOException {
        this.file = new File(path + "name.txt");
        if(!this.file.exists()) {
            if(this.file.createNewFile()) {
                System.exit(1);
            }
        }
        this.printWritter = new PrintWriter(new FileWriter(this.file));
        this.writeAndClose(content);
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
            this.printWritter = new PrintWriter(new FileWriter(this.file));
        } else {
            this.printWritter = null;
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
            this.printWritter = new PrintWriter(new FileWriter(this.file));
        } else {
            this.printWritter = null;
        }
    }

    /**
     * You must call it after write in the document.
     *
     * @return true if all is correct, false in other case.
     */
    public boolean close() {
        boolean result;
        this.printWritter.close();
        result = true;
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
        this.printWritter.write(content);
        result = true;
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

    public String readLine() {
        String result;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(this.file));
            if((result = bufferedReader.readLine()) == null) {
                result = "";
            }
        } catch (Exception e) {
            result = "readAllException";
        }
        return result;
    }

    /**
     * Read all the lines in the file.
     *
     * @return the lines separated by "/n".
     */
    public String readAll(){
        String result = "";
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(this.file));
            String line;
            while((line = bufferedReader.readLine()) != null) {
                result += line + "\n";
            }
        } catch (Exception e) {
            result = "readAllException";
        }

        return result;
    }
}
