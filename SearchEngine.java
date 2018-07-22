import java.util.*;
/**
 * this class is the main controller of the program
 */
public class SearchEngine
{
    private boolean quit = false;
    private DataBase database;
    /**
     * Constructor for objects of class SearchEngine
     * @param input - the location of the input fila
     * @param commonlist - the location of the commonwords list
     */
    public SearchEngine(String input, String commonlist)
    {   
       //build database
       database = new DataBase(input,commonlist);
       database.init();
    }
    
    /** run the search engine*/
    public void run(){
        //get query from user
        while(!quit){
            System.out.print("What would you like to Koogle?: ");
            //get query
            String query = getQuery();
            
            long start = System.currentTimeMillis();
            //display results
            QueryManager qManager = new QueryManager(query,database);
            qManager.analyze(); //analyze query and build result
            
            int i = 1;
            
            System.out.println();
            System.out.println("keywords you are looking for: "+qManager.getKeywords());
            System.out.println();
            
            if(qManager.getSize()==0){
                System.out.println("awwww we couldn't find any matching websites    ");
            }else{
                System.out.println("here are some relevant websites: ");
            }
            
            //print 5 first results
            while(qManager.getSize()!=0 && i<=5){
                qManager.getResult(i); 
                i++;
            }
            
            long end = System.currentTimeMillis();
            
            qManager.resetMatchCounter(); //reset
            
            System.out.println("\nTime elapsed: "+ (end - start)+ " ms"); //print time
            
            //section for making a new research or quitting
            System.out.print("\nwould you like to make another search?");
            query = getQuery();
            if(!query.equals("y")){
                break;
            }
            System.out.println();
        }
        
    }
    
    /** build the query*/
    public String getQuery(){
        Scanner query = new Scanner(System.in);
        return query.nextLine();
    }
}
