import java.io.*;
import java.util.*;
/**
 * Reads the input file and set up the database
 */
public class InputReader
{
    private Scanner reader;
    private ArrayList<Website> websiteContainer;
    private String commonlist; //contains common words to be ignored;
    private WebsiteAnalyzer analyzer;
    /**
     * Constructor for objects of class InputReader
     * @param input - location of the input file
     * @param commonlist - the location of common words list
     */
    public InputReader(String input,String commonlist)
    {
        try{
            reader = new Scanner(new FileReader(input));
            this.commonlist=commonlist;
            websiteContainer = new ArrayList<Website>();
        }catch(Exception e){
            System.out.println("error reading input file");
        }
    }

    /**setup the websites to be stored in the database*/
    public void setupWebsites(){
        //seperate using location
        reader.useDelimiter(".txt");
        try{
            //set up websites info
            while(reader.hasNext()){
                websiteContainer.add(intitInfo(reader.next()+" "));
            }
            reader.close();
        }catch(Exception e){
            System.out.println("Error setting up websites");
        }
    }

    /**intitilize the info of each website
     * @param site - the String containing website info
     * @return Website containing information initilized
       */
    private Website  intitInfo(String site){
        Website website = new Website();
        try{ 
            Scanner websiteReader = new Scanner(site);
            //*set url
            if(websiteReader.hasNext()){
                website.setUrl(websiteReader.next().toUpperCase());
            }
            //*set prio
            if(websiteReader.hasNext()){
                website.setPriority(websiteReader.next());
            }
            //set location & the keyword base
            if(websiteReader.hasNext()){
                //initialize location
                website.setLocation(websiteReader.next() + ".txt");
                
            }
            
            if(website.getLocation().length() != 0){
                //build keyword base
                analyzer = new WebsiteAnalyzer(website.getLocation(),commonlist);
                website.setKeywords(analyzer.filter());
            }
            
            
        }catch(Exception e){
            System.out.println("Error initilizing website info");
        }
        return website;
    }


    /**websiteCntainer getter*/
    public Website getWebsite(int i ){
        return websiteContainer.get(i);
    }
    
    
    /**websiteCntainer getter*/
    public ArrayList<Website> getWebsiteContainer(){
        return websiteContainer;
    }
}
