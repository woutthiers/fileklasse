/**
 * A class of exceptions signaling that the file isn't writable.
 * Each NotWritableException contains the file and it's name.
 */

public class NotWritableException extends RuntimeException{
    /**
     * Initialize this new Writable exception with a given name, size
     * creation time, writable.
     *
     * @param   name
     *          The name of the file that isn't writable.
     * @param   file
     *          The file this exception applies to.
     * @post    The number for this exception is equal to the given name.
     *          | this.name == name
     * @post    The file for this exception is equal to the given file.
     *          | this.file == file
     * @effect  This new NotWritable exception is further
     *          initialized as a new runtime exception involving
     *          no diagnostic message and no cause.
     *          | super()
     */
    public NotWritableException(String name, File file){
        this.name = name;
        this.file = file;
    }

    /**
     * The file this exception applies to.
     */
    private final File file;

    /**
     * Variable containing the name of the file that is not writable.
     */
    private final String name;

    /**
     * Return the name of the file that is not writable.
     */
    public String getName() {
        return name;
    }
}
