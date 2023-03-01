import java.util.Date;

/**
 *
 */
public class File {

    public String name;
    public int size;
    public boolean wr;
    public Date cd;
    public Date cc;


    public File(String name, int size, boolean writable){
        if(isValidName(name))
            this.name = name;
        else {
            this.name = new String("yeet");
        }

        this.size = size;
        this.wr = writable




    }

    public File(char[] name){

    }

    /**
     *
     * @param name
     *  The name of a file name
     *
     * @return returns True if the file name consists of acceptable characters (small letters, big letters, '.' '_' '-'.
     * It does this by checking the ascii value of every character.
     *
     */
    public boolean isValidName(String name){
        for(int i=0 ; i< name.length() ; i++){
            int ascii = name.charAt(i);
            if( ascii < 45)
                return false;
            else if( ascii >= 47 && ascii < 65)
                return false;
            else if( ascii >= 91 && ascii < 97)
                return false;
            else if(ascii > 122)
                return false;
        }
        return true;

    }


}
