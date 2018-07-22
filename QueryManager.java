import java.util.*;
/**
 *Manages the user's requests and return and relevant websites
 */
public class QueryManager
{

    private DataBase database; //data base of websites
    private QueryAnalyzer qAnalyzer; //analyzes the queries
    private ArrayList<Website> tmp = new ArrayList<Website>(); //temporary result
    ArrayList<String> orWords;
    //contains result of search
    private PriorityQueue<Website> result ; //ordered result
    /**
     * Constructor for objects of class QueryManager
     * @param query - the query of the user
     * @param database - the database containing websites' infos
     */
    public QueryManager(String query, DataBase database)
    {   qAnalyzer = new QueryAnalyzer(query);
        this.database = database;
        result = new PriorityQueue<Website>(10,new WebsiteComparator());
    }
    
    /**analyze the query and disect it into elemental key words and relations and fills the temporary and final result*/
    public void analyze(){
        orWords = new ArrayList<String>();
        orWords = qAnalyzer.orDisect(orWords);
        //check every "or" option
        for(int i =0; i<orWords.size();i++){
            for(int j= 0; j< database.getSize();j++){
                //if there's a conjuction
                if(orWords.get(i).contains("AND")){
                    conjunc(database.get(j),orWords.get(i));
                }else{
                    //if ther's negation
                    if(orWords.get(i).contains("-")){
                        String word = qAnalyzer.disectNegation(orWords.get(i));
                        if(!database.get(j).contains(word)){
                            //add to result
                            database.get(j).increaseMatch();
                            if(!tmp.contains(database.get(j))){
                                tmp.add(database.get(j));
                            }
                        }
                     //no negation
                    }else if(database.get(j).contains(orWords.get(i))){
                        
                            //add to result
                            database.get(j).increaseMatch();
                            if(!tmp.contains(database.get(j))){
                                tmp.add(database.get(j));
                            }
                        
                    }
                }

            }

        }
        
        
        //build result queue
        for(int h=0; h<tmp.size();h++){
            result.add(tmp.get(h));
           
        }
    }
    
    /**handle cases where there's "and" 
     * @param web - the website to check
     * @param orWord - keyword or group of keywords containing "and" relation
       */
    private void conjunc(Website web ,String orWord){

        ArrayList<String> andWords = qAnalyzer.andDisect(orWord);
        //print and words
        //get two words at a time
        for(int j=0;j<andWords.size()-1;j++){
            for(int k=j+1;k<andWords.size();k++){
                //first word has negation and second doesnt
                if(andWords.get(j).contains("-") && (!andWords.get(k).contains("-"))){
                    String word = qAnalyzer.disectNegation(andWords.get(j));
                    //check webside
                    if(!web.contains(word) && web.contains(andWords.get(k))){
                        //add to result if it's not already there
                        web.increaseMatch();
                        if(!tmp.contains(web)){
                            tmp.add(web);
                        }

                    }
                }

                //first word no negation and second does have negation
                else if(!andWords.get(j).contains("-") && (andWords.get(k).contains("-"))){
                    String word = qAnalyzer.disectNegation(andWords.get(k));
                    //check webside
                    if(!web.contains(word) && web.contains(andWords.get(j))){
                        //add to result if it's not already there
                        web.increaseMatch();
                        if(!tmp.contains(web)){
                            tmp.add(web);
                        }
                    }
                }

                //both have negation
                else if(andWords.get(j).contains("-") && (andWords.get(k).contains("-"))){
                    String word1 = qAnalyzer.disectNegation(andWords.get(j));
                    String word2 = qAnalyzer.disectNegation(andWords.get(k));
                    //check webside
                    if(!web.contains(word1) && !web.contains(word2)){
                        //add to result if it's not already there
                        web.increaseMatch();
                        if(!tmp.contains(web)){
                            tmp.add(web);
                        }
                    }
                }
                
                //both no negation
                else{
                    if(web.contains(andWords.get(j)) && web.contains(andWords.get(k))){
                        //add to result if it's not already there
                        web.increaseMatch();
                        if(!tmp.contains(web)){
                            tmp.add(web);
                        }
                    }
                    
                }
            }
        }

    }
    
    /**return general keywords that are seperated by or*/
    public ArrayList<String> getKeywords(){
        return orWords;
    }
    
    /**return the size of the result of the search*/
    public int getSize(){
        return result.size();
    }
    
    /**print the first result and remove it
     * @param i - order of the resilt (1st, 2nd ...)
       */
    public void getResult(int i){
        Website web =result.poll();
        
        System.out.println("    Website "+i+": "+web.getUrl() +  "   " + web.getMatch());
    }
    
    /**reset the counter of matched keywords*/
    public void resetMatchCounter(){
        //build result queue
        for(int h=0; h<tmp.size();h++){
            tmp.get(h).resetMatch();
        }
    }
}

