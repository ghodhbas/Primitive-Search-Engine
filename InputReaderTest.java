

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class InputReaderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class InputReaderTest
{
    /**
     * Default constructor for test class InputReaderTest
     */
    public InputReaderTest()
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
    /**tests constructor and setting up website*/
    public void testSetup(){
        //incorrect input  --> and error meesage will be shown
        
        //correct input
        InputReader reader = new InputReader("input.txt","commonwords.txt");
        
        reader.setupWebsites();
        
        //verify input inright location with right data
        assertTrue(reader.getWebsite(2).getLocation().equals("southerncuisine.txt"));
        assertTrue(reader.getWebsite(1).getUrl().equals("www.riding.com"));
        assertTrue(reader.getWebsite(0).getPriority() == 1);
        assertTrue(reader.getWebsite(reader.getWebsiteContainer().size()-1).getUrl().equals("www.japan.jp"));
    }
}
