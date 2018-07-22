import java.util.*;
/**
 * compare websites in order of matching keywords
 * priority
 * alphabetically
 */
public class WebsiteComparator implements Comparator<Website>
{

    /**
     * Constructor for objects of class WebsiteComparator
     */
    public WebsiteComparator()
    {
        
    }
    
    /** comapres to websites in order of matching keywords, priority and alphabetically
     * @param web1 - the first website to compare
     * @param web2 - the 2nd websiteto compare
       */
    public int compare(Website web1,Website web2){
        //comapre by number of matching keywords
        if(web1.getMatch()<web2.getMatch()){
            return 1;
        }else if (web1.getMatch()>web2.getMatch()){
            return -1;
        }else{
            //compare by priority
            if(web1.getPriority()<web2.getPriority()){
                return 1;
            }else if(web1.getPriority()>web2.getPriority()){
                return -1;
            }else{
                //compare by URL alphabetically
                if(web1.getUrl().compareTo(web2.getUrl())>0){
                    return 1;
                }else if (web1.getUrl().compareTo(web2.getUrl())<0){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }
}
