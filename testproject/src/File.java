import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;

import java.util.Date;

/**
 * A class of files with a name, ...
 */

public class File {
    /**
     * Initialize this new file with a given name, size
     * creation time, writable.
     *
     * @param   name
     *          The name of the file.
     * @param   size
     *          The size of the file in bytes.
     * @param   writable
     *          The state of writability of the file.
     * @post    If the name contains any characters that are
     *          not capital or non-capital letters, periods (.)
     *          , hyphens (-) or underscores (_) then these characters
     *          will not be in the name of the file.
     *          If the name contains no characters, the name
     *          will be namelessfile. The name is capitalsensitive.
     *
     *
     */
    public File(String name, int size, boolean writable) {

    }



    public File(String name) {

    }

    /**
     * Variable registering the maximum size of all files.
     */
    private static final int maxsize = Integer.MAX_VALUE;

    /**
     * Return the max size of all files.
     * @return The maximum size.
     */
    @Basic
    @Immutable
    public static final int getMaxsize(){ return maxsize;}

    /**
     * A variable registering the size of the file in bytes.
     */
    private int size = 0;
    /**
     * A variable stating the name of the file.
     */
    private String name = "namelessfile";

    /**
     * A variable stating if the users change certain properties of the file.
     */
    private boolean writable = True;

    /**
     * A variable stating the time of creation.
     */
    private Date creationtime = new Date;












}
