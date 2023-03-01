import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class kloktest {
    @Before
    public void createklok(){
        klok =new klok();
    }
    @BeforeClass
    public void testtijd(){
        klok testklok = new klok(14, 15 , 17);


    }

}
