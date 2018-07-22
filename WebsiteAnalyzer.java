import java.io.*;
import java.util.*;
/**
 * this website analyze the description of a website and build the filtered keywords
 */
public class WebsiteAnalyzer
{
    private Scanner reader;
    private TreeSet<String> keywords;
    String commonwords="";
    /**
     * Constructor for objects of class WebsiteAnalyzer
     * @param location - the lcoation of the website
     * @param commonlist - the location of commonwords list
     */
    public WebsiteAnalyzer(String location,String commonlist)
    {   try{
            keywords= new TreeSet<String>();
            reader = new Scanner(new FileReader(location));
            Scanner commonwordsReader =  new Scanner(new FileReader(commonlist));
            //build common word databse
            while(commonwordsReader.hasNext()){
               commonwords = commonwords + commonwordsReader.next().toUpperCase()+"\n";
            }
            //System.out.println(commonwords);
        }catch(Exception e){
            System.out.println("error reading website description or finding common words file");
        }
    }
    
    
    /**form keyword database
     * @return a filtered treeset of keywords
       */
    public TreeSet<String> filter(){
        
        while(reader.hasNext()){
            //transform words to upper case
            String word = reader.next().toUpperCase();
            if(!keywords.contains(word) && !commonwords.contains(word)){
                //remove punctuation
                while( !Character.isLetter(word.charAt(word.length()-1)) && !Character.isDigit(word.charAt(word.length()-1))){
                    word = word.substring(0,word.length()-1);
                }
                keywords.add(word);
            }
        }
        return keywords;
    }
    
    /**return the common words in a string*/
    public String getCommon(){
        return commonwords;
    }
    
    /** return the number of keywords of a website*/
    public int keywordsSize(){
        return keywords.size();
    }
    
    /** return and remove the first keyword*/
    public String pollFirst(){
        return keywords.pollFirst();
    }
    
    /**check if the website doesn't have any keywords*/
    public boolean isEmpty(){
        return keywords.isEmpty();
    }
    
    /** return the keywords of a website*/
    public TreeSet<String> getKeywords(){
        return keywords;
    }
}
