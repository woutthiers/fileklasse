import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;
import be.kuleuven.cs.som.annotate.Raw;

import java.util.Date;

/**
 * A class of files with a name and a size that is writable or not.
 * @invar The size of each file
 *        must be a valid file size
 *        | isValidSize(getSize())
 * @author Wout Thiers, Bram Oreel
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
     * @effect  The given name is set as the name of this
     *          file.
     *          | setname(name)
     * @effect  The given size is set as the size of the file.
     *          | setsize(size)
     * @effect  The writable is set as the writable of the file.
     *          | setwritable(writable)
     * @post    The creationTime will be set to the current date and time.
     *
     */
    @Raw
    public File(String name, int size, boolean writable) {
        setWritable(true);
        setName(name);
        this.size = 0;
        setSize(size);
        setWritable(writable);
        this.creationTime = new Date();
        this.changeTime = null;
    }

    /**
     *
     * @param  name
     *         the name of the file
     * @effect This new file is initialized with the given name
     *         the size set as 0 and the writable as True.
     */
    @Raw
    public File(String name) {
        this(name,0,true);
    }

    /**
     *
     * @param   name
     *          The name of the file.
     * @post    If the name contains any characters that are
     *          not capital or non-capital letters, periods (.)
     *          , hyphens (-) or underscores (_) then these characters
     *          will not be in the name of the file.
     *          |this.name = "";
     *          |for character in name:
     *          |         if character is invalid:
     *          |         else: this.name += character
     *          If the name contains no characters, the name
     *          will be namelessfile.
     *          | this.name = "namelessfile"
     *          The name is capitalsensitive.
     * @throws  NotWritableException
     *          The file isn't writable.
     *          | this.writable == false
     *
     *
     *
     */
    @Raw
    public void setName(String name) throws NotWritableException{
        if(!getWritable())
            throw new NotWritableException(getName(), this);
        this.name = "";
        for(int i=0 ; i< name.length() ; i++) {
            int ascii = name.charAt(i);
            if (ascii < 45 || ascii >= 47 && ascii < 65 || ascii >= 91 && ascii < 95|| ascii == 96 || ascii > 122)
            {}
            else{
                this.name += name.charAt(i);
            }
        }
        if (this.name.length() == 0){
            this.name = "namelessfile";
        }
        setChangeTime();
    }

    /**
     * @param writable
     *        Whether the user can change certain properties of the file.
     */
    @Raw
    public void setWritable(boolean writable) {
        this.writable = writable;
    }

    /**
     * Sets the size to the given value.
     * @param size
     *        size of the file in bytes.
     * @pre   The size must be valid.
     *        | assert(isValidSize(size))
     * @post  The size gets changed and the changedate get set to the current date.
     *        |this.size = size;
     *        |setChangeTime();
     * @throws  NotWritableException
     *          The file isn't writable.
     *          | this.writable == false
     */
    @Raw
    public void setSize(int size) throws NotWritableException {
        if(!getWritable())
            throw new NotWritableException(getName(), this);
        assert(isValidSize(size));
        this.size = size;
        setChangeTime();
    }

    /**
     *
     * @param  size
     *         the size of a file
     * @return True if the size is a positive integer
     *         that is smaller than the maximum size.
     *         | return ( 0 <= size) && (size <= maxsize)
     */
    @Raw
    private boolean isValidSize(int size){
        return ( 0 <= size) && (size <= maxsize);
        }

    /**
     * Return the size of the file.
     */
    @Basic
    @Immutable
    public int getSize() {
        return size;
    }
    /**
     * Return the name of the file.
     */
    @Basic
    @Immutable
    public String getName() {
        return name;
    }
    /**
     * Return the writability of the file.
     */
    @Basic
    @Immutable
    public boolean getWritable() {
        return writable;
    }


    /**
     * Return the creation time of the file.
     */
    @Basic
    @Immutable
    public Date getCreationtime() {
        return this.creationTime;
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
    private boolean writable = true;

    /**
     * A variable stating the time of creation.
     */
    private Date creationTime;

    /**
     * A variable stating the time of the last change.
     */
    private Date changeTime;

    /**
     * Adds a certain amount of bytes to size of the file.
     * @param amount
     *        the amount of bytes you want to enlarge the file with.
     * @pre   The amount must be a valid size.
     *        |isValidSize(amount)
     * @pre   The size of the file after the amount has been added
     *        must also be valid.
     *        |isValidSize(getSize())
     * @post  The size is changed and the changedate is set as the current date.
     *        |setSize(getSize() + amount);
     *        |setChangeTime();
     * @throws NotWritableException
     *         The file isn't writable.
     *         | this.writable == false
     */
    public void enlarge(int amount) throws NotWritableException{
        if(!getWritable())
            throw new NotWritableException(getName(), this);
        assert(isValidSize(amount));
        setSize(getSize() + amount);
        setChangeTime();
        assert(isValidSize(getSize()));
    }



    /**
     * Subtracts a certain amount of bytes to size of the file.
     * @param amount
     *        the amount of bytes you want to shorten the file with.
     * @pre   The amount must be a valid size.
     *        |isValidSize(amount)
     * @pre   The size of the file after the amount has been subtracted
     *        must also be valid.
     *        |isValidSize(getSize())
     * @post  The size is changed and the changedate is set as the current date.
     *        |setSize(getSize() - amount);
     *        |setChangeTime();
     * @throws  NotWritableException
     *          The file isn't writable.
     *          | this.writable == false
     */
    public void shorten(int amount) throws NotWritableException{
        if(!getWritable())
            throw new NotWritableException(getName(), this);
        assert(isValidSize(amount));
        setSize(getSize() - amount);
        setChangeTime();
        assert(isValidSize(getSize()));
    }

    /**
     * Sets the time of the last change to the current time.
     */
    private void setChangeTime(){
        this.changeTime = new Date();
    }

    /**
     * Returns the time of creating the file.
     */
    @Basic
    @Immutable
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * Returns the time of the last change to the file.
     */
    @Raw
    @Basic
    @Immutable
    public Date getChangeTime() {
        return changeTime;
    }

    /**
     * Checks if the time between creation and the last change of the file
     * overlaps with the time between creation and the last change of the
     * given file.
     * @return true if the times overlap and false otherwise.
     *         | if(getCreationtime().before(givenFile.creationTime))
     *         |    if(getChangeTime().after(givenFile.creationTime))
     *         |       return true;
     *         |   else return false
     *         | else
     *         |    if(getCreationtime().before(givenFile.changeTime))
     *         |        return true
     *         |    else return false;
     *
     *         If any of the four times are equal, then true will be returned.
     *         |if(getCreationtime().equals(givenFile.getCreationtime()) || getChangeTime().equals(givenFile.getChangeTime())
     *         |    || getChangeTime().equals(givenFile.getCreationTime()) || getChangeTime().equals(givenFile.getCreationTime())
     *         |    return true;
     *
     *         If one of the two file has never been changed after creation it will return false.
     *         | if(getChangeTime() == null || givenFile.getChangeTime() == null)
     *         |       return false;
     *
     *
     */
    @Immutable

    public boolean hasOverlappingUsePeriod(File givenFile){
        if(getChangeTime() == null || givenFile.getChangeTime() == null)
            return false;
        if(getCreationtime().equals(givenFile.getCreationtime()) || getChangeTime().equals(givenFile.getChangeTime()) || getChangeTime().equals(givenFile.getCreationtime()) || getCreationtime().equals(givenFile.getChangeTime()))
            return true;
        if(getCreationtime().before(givenFile.getCreationtime())){
            if(getChangeTime().after(givenFile.getCreationTime())){
                return true;
            }
            else return false;
        }
        else{
            if(getCreationtime().before(givenFile.getChangeTime())){
                return true;
            }
            else return false;
        }
    }
}
