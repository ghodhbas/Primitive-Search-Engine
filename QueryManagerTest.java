

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class QueryManagerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class QueryManagerTest
{
    /**
     * Default constructor for test class QueryManagerTest
     */
    public QueryManagerTest()
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
        //irreleent location would display error messages
        DataBase database = new DataBase("input.txt","commonwords.txt");
        database.init();
        
        // website found
        QueryManager query = new QueryManager("Elephants and mammals or elephants",database);
        query.analyze();
        assertTrue(query.getSize() == 1);
        
        
        //0 websites found
        QueryManager query1 = new QueryManager("chmeta or kikouuu",database);
        query1.analyze();
        System.out.println(query1.getSize());
    }
}
