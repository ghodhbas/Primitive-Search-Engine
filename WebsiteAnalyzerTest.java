

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WebsiteAnalyzerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WebsiteAnalyzerTest
{
    /**
     * Default constructor for test class WebsiteAnalyzerTest
     */
    public WebsiteAnalyzerTest()
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
    public void testCommonwords(){
        WebsiteAnalyzer analyzer = new WebsiteAnalyzer("chigi.txt","commonwords.txt");
        //System.out.println(analyzer.getCommon());
        
        //test non existing file
        WebsiteAnalyzer analyzer2 = new WebsiteAnalyzer("chigi.txt","bibi.txt");
        assertTrue(analyzer2.getCommon().equals(""));
    }
    
    @Test
    public void testFilter(){
        //printing tests
        /**System.out.println("web 1");
        WebsiteAnalyzer analyzer = new WebsiteAnalyzer("chigi.txt","commonwords.txt");
        analyzer.filter();
        while(!analyzer.isEmpty()){
            System.out.println(analyzer.pollFirst());
        }
        
        System.out.println("web 2");
        WebsiteAnalyzer analyzer1 = new WebsiteAnalyzer("SouthernCuisine.txt","commonwords.txt");
        analyzer1.filter();
        while(!analyzer1.isEmpty()){
            System.out.println(analyzer1.pollFirst());
        }
        
        System.out.println("web 3");
        WebsiteAnalyzer analyzer2 = new WebsiteAnalyzer("SurvivingTornadoes.txt","commonwords.txt");
        analyzer2.filter();
        while(!analyzer2.isEmpty()){
            System.out.println(analyzer2.pollFirst());
        }
        
        System.out.println("web 4");
        WebsiteAnalyzer analyzer3 = new WebsiteAnalyzer("TherapeuticEquestrianSport.txt","commonwords.txt");
        analyzer3.filter();
        while(!analyzer3.isEmpty()){
            System.out.println(analyzer3.pollFirst());
        }
        */
    }
}
