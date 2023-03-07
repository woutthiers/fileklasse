import org.junit.Assert;
import org.junit.*;

import java.util.Date;


public class FileTest {


    /**
     * Simple test to see if the constructor works as expected.
     */
    @Test
    public void constructorTestLegal(){
        File newfile = new File("newfile", 55, true);
        Assert.assertEquals("newfile", newfile.getName());
        Assert.assertEquals(55, newfile.getSize());
        Assert.assertEquals(true, newfile.getWritable());
        Assert.assertTrue(newfile.getCreationtime().equals(new Date()));
        Assert.assertEquals(null, newfile.getChangeTime());

        File newfile1 = new File("new_file");
        Assert.assertEquals("new_file", newfile1.getName());
        Assert.assertEquals(0, newfile1.getSize());
        Assert.assertEquals(true, newfile1.getWritable());
        Assert.assertTrue(newfile.getCreationtime().equals(new Date()));
        Assert.assertEquals(null, newfile.getChangeTime());
    }

    /**
     * Tests if the characters in the name get ignored if they are illegal and if
     * the name is namelessfile when no legal characters are given.
     */

    @Test
    public void constructorTestIllegalName(){
        File newfile = new File("ne**56wf7//ile", 55, true);
        Assert.assertEquals("newfile", newfile.getName());
        newfile.setName("///*//*");
        Assert.assertEquals("namelessfile", newfile.getName());

    }

    /**
     * Checks if the enlarge and shorten method behave correctly.
     */
    @Test
    public void enlargeShortenTest(){
        File newfile = new File("ne**56wf7//ile", 55, true);
        newfile.enlarge(10);
        Assert.assertEquals(65, newfile.getSize());
        Assert.assertTrue(newfile.getChangeTime().equals(new Date()));
        newfile.shorten(15);
        Assert.assertEquals(50, newfile.getSize());
        Assert.assertTrue(newfile.getChangeTime().equals(new Date()));

    }

    /**
     * Tests if the exception gets thrown when the file is not writable.
     * @throws NotWritableException
     */
    @Test(expected=NotWritableException.class)
    public void testNotWritableName() throws NotWritableException {
        File newfile = new File("newfile", 55, false);
        newfile.setName("newerfile");
    }

    /**
     * Tests if the exception gets thrown when the file is not writable.
     * @throws NotWritableException
     */
    @Test(expected=NotWritableException.class)
    public void testNotWritableSize() throws NotWritableException {
        File newfile = new File("newfile", 55, false);
        newfile.setSize(20);
    }

    /**
     * This will pause the program for a certain amount of milliseconds.
     * @param ms
     */
    private static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    /**
     * Tests if the hasOverlappingUsePeriod method works as expected.
     */



    @Test
    public void testHasOverlappingUsePeriod(){
        File newfile1 = new File("newfile1", 55, true);
        File newfile2 = new File("newfile2", 55, true);
        Assert.assertFalse(newfile1.hasOverlappingUsePeriod(newfile2));
        newfile1.setSize(50);
        newfile2.setSize(50);
        Assert.assertTrue(newfile1.hasOverlappingUsePeriod(newfile2));
        pause(5000);
        File newfile3 = new File("newfile3", 55, true);
        newfile3.setSize(50);
        Assert.assertFalse(newfile1.hasOverlappingUsePeriod(newfile3));
        File newfile4 = new File("newfile4", 55, true);
        pause(2000);
        File newfile5 = new File("newfile5", 55, true);
        pause(2000);
        newfile4.setSize(50);
        pause(2000);
        newfile5.setSize(50);
        Assert.assertTrue(newfile5.hasOverlappingUsePeriod(newfile4));


    }



}