

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WebsiteTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WebsiteTest
{
    /**
     * Default constructor for test class WebsiteTest
     */
    public WebsiteTest()
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
    public void testSetPriority(){
        //intital case
        Website web = new Website();
        assertTrue(web.getPriority()==0);
        
        //case of erronous priority    
        web = new Website("www.baba.com","","chigi.txt");
        assertTrue(web.getPriority()==0);
        
        //case correct priority
        web = new Website("www.baba.com","low","chigi.txt");
        assertTrue(web.getPriority() == 0);
        
        
        web = new Website("www.baba.com","medium","chigi.txt");
        assertTrue(web.getPriority() == 1);
        
        web = new Website("www.baba.com","high","chigi.txt");
        assertTrue(web.getPriority() == 2);
    }
}
