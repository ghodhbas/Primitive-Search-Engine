import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DataBaseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DataBaseTest
{
    /**
     * Default constructor for test class DataBaseTest
     */
    public DataBaseTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void test(){
        DataBase database = new DataBase("input.txt","commonwords.txt");
        database.init();
        
        assertTrue(database.getSize()==6);
        assertTrue(database.get(0).getUrl().equals("www.elephants.com"));
        //verify input inright location with right data
        assertTrue(database.get(2).getLocation().equals("southerncuisine.txt"));
        assertTrue(database.get(1).getUrl().equals("www.riding.com"));
        assertTrue(database.get(0).getPriority() == 1);
        assertTrue(database.get(database.getSize()-1).getUrl().equals("www.japan.jp"));
    }
}
