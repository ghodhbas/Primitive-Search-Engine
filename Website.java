import java.util.*;
/**
 *Contains the information of a website: url, priority, location, keywords.
 */
public class Website
{
    private String url = ""; //contains website url
    private int priority = 0; //0=low, 1=medium, 2=high
    private String location = ""; //the location of the website decription in the folder
    private TreeSet<String> keywords; //contains keywords filtered 
    private int nbOfMatch = 0; //track  how many words will match with keywords
    /**
     * Constructor for objects of class Website
     */
    public Website()
    { this.keywords = new TreeSet<String>();
    }

    /**
     * Constructor for objects of class Website
     * @param url - the url of the website
     * @param priority - the degree of priority of the website
     * @param location - the location of the file containing details of the website
     */
    public Website(String url, String priority,String location)
    {
        this.url = url;
        setPriority(priority);
        this.location =location;
        this.keywords = new TreeSet<String>();
    }    
    
    
    /** setter for url 
     * @param url - The Url of the website
       */ 
    public void setUrl(String url){
        this.url = url;
    }
    
    /** setter for priority converts from string to degree (integer)
     * @param priority - the priority of the website
       */ 
    public void setPriority(String priority){
       
        if(priority.equals("medium")){
            this.priority=1;
        }else if(priority.equals("high")){
            this.priority=2;
        }
        
    }
    
    /** setter for Location*/ 
    public void setLocation(String location){
        this.location = location;
    } 
    
    /**adds a keyword to the keyword list*/
    public void setKeywords(TreeSet<String> keywords){
        this.keywords = keywords;
    }
    
    /**checks if a word is a keyword of the website*/
    public boolean contains(String word){
        return keywords.contains(word.toUpperCase());
    }
    
    /**getter for url*/
    public String getUrl(){
        return url.toLowerCase();
    }
    
    /**getter for location*/
    public String getLocation(){
        return location.toLowerCase();
    }
    
    /**getter for priority*/
    public int getPriority(){
        return priority;
    }
    
    /**getterfor keywords*/
    public String getKeywords(){
        return keywords.toString();
    }
    
    /**increase nb of match words*/
    public void increaseMatch(){
        nbOfMatch++;
    }
    
    /**reset nb of match words*/
    public void resetMatch(){
        nbOfMatch =0;
    }
    
    /**get nb of match words*/
    public int getMatch(){
        return nbOfMatch;
    }
}
