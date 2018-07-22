
/**
 *lunches the search engine
 */
public class Launcher
{
   public static void main(String[] args){
       //build database
       SearchEngine engine = new SearchEngine(args[0],args[1]);
       // the search engine
       engine.run();
       
   }
}
