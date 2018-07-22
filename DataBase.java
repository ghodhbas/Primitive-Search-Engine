import java.util.*;
/**
 * this class is responsible for initilizing the website data base and storing them
 */
public class DataBase
{
    private ArrayList<Website> database; //the database of websites
    private String commonlist,input;
    /**
     * Constructor for objects of class DataBase
     * @param input - location of input file
     * @param commonlist - location of common words list
     */
    public DataBase(String input, String commonlist )
    {
        database=new ArrayList<Website>(); 
        this.input=input;
        this.commonlist = commonlist;
    }

    /** intitialize data base */
    public void init(){
        //initilize the database with websites
        InputReader inputReader = new InputReader(input,commonlist);
        inputReader.setupWebsites();
        database = inputReader.getWebsiteContainer();
    }
    
    /**check if the key word exists in a particular website in the data abse
     * @param keyword - check if the website in position "websitePos" in the database contain a specific keyword
     * @return true if the keyword exists
       */
    public boolean contains(String keyword, int websitePos){
        if(database.get(websitePos).contains(keyword)){
            return true;
        }
        return false;
    }
    
    /**gets the size of the data base*/
    public int getSize(){
        return database.size();
    }
    
    /**returns website in positioni*/
    public Website get(int i){
        return database.get(i);
    }
    
    
}
