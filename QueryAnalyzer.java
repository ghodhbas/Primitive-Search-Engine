import java.util.*;
/**
 * this class is responsible for analazing the user's query and return the valid keywords to look for
 */
public class QueryAnalyzer
{

    Scanner queryReader;
    /**
     * Constructor for objects of class QueryAnalyzer
     * @param query - the query of the user
     */
    public QueryAnalyzer(String query)
    {
        queryReader = new Scanner(query);
    }


    /**disect "or"
     * @param orWords - arrayList to be filled with the expressions seperated by "or"
     * @return arraylist conaining expressions that were seperated by "or"
       */
    public ArrayList<String> orDisect(ArrayList<String> orWords){
        queryReader.useDelimiter(" or ");
        while(queryReader.hasNext()){
            String word = queryReader.next();
            while((word.length()!=0) && !Character.isLetter(word.charAt(word.length()-1))){
                word = word.substring(0,word.length()-1);
            }

            while((!Character.isLetter(word.charAt(0))&& (Character.compare(word.charAt(0),'-')!=0)) && (word.length()!=0)){
                word = word.substring(1,word.length());
            }
            orWords.add(word.toUpperCase());
        }
        return orWords;
    }

    /**disect "and"
     * @param orWord- String containing expression that potentially has "and" in it       
     * @return arralist containing individual keywords that were seperated by "and"
       */
    ArrayList<String> andDisect(String orWord){
        ArrayList<String> andWords = new ArrayList<String>();

        if(orWord.contains("AND")){
            Scanner read = new Scanner(orWord);
            read.useDelimiter(" AND ");
            while(read.hasNext()){
                String word = read.next();
                while((word.length()!=0) && !Character.isLetter(word.charAt(word.length()-1))){
                    word = word.substring(0,word.length()-1);
                }

                while((!Character.isLetter(word.charAt(0))&& (Character.compare(word.charAt(0),'-')!=0)) && (word.length()!=0)){
                    word = word.substring(1,word.length());
                }
                andWords.add(word.toUpperCase());                
            }
        }

        return andWords;
    }

    /**disect negation
     * @param word - String containing a negation
     * @return a String without the negation
       */
    public String disectNegation( String word){
        while(!Character.isLetter(word.charAt(0))){
            word = word.substring(1,word.length());
        }

        return word.toUpperCase();
    }

}
